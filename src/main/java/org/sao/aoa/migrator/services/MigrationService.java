package org.sao.aoa.migrator.services;

import com.google.inject.Inject;
import org.apache.commons.lang3.BooleanUtils;
import org.jooq.*;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.sao.aoa.migrator.beans.Cita;
import org.sao.aoa.migrator.beans.Colaborador;
import org.sao.aoa.migrator.beans.EdadSexo;
import org.sao.aoa.migrator.readers.ExcelReaderInterface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.sao.aoa.migrator.model.tables.AsoCitaClaseEdadSexo.ASO_CITA_CLASE_EDAD_SEXO;
import static org.sao.aoa.migrator.model.tables.AsoCitaObservador.ASO_CITA_OBSERVADOR;
import static org.sao.aoa.migrator.model.tables.Cita.CITA;

/**
 * Class MigrationService
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class MigrationService implements MigrationServiceInterface {

    private ExcelReaderInterface reader;

    @Inject
    public MigrationService(ExcelReaderInterface reader) {
        this.reader = reader;
    }

    @Override
    public void run(String recordsFilename, String agesAndGendersFilename, String collaboratorsFilename)
            throws IOException, IllegalAccessException, NoSuchFieldException, SQLException, ClassNotFoundException, InstantiationException {

        /*
         * Read files
         */
        // Read records file
        final List<Map<String, Object>> recordsData = reader.read(recordsFilename);
        // Read ages and genders file
        final List<Map<String, Object>> agesAndGendersData = reader.read(agesAndGendersFilename);
        // Read collaborators file
        final List<Map<String, Object>> collaboratorsData = reader.read(collaboratorsFilename);


        // Get connection
        Connection conn = getConnection(false);

        // Initialize DSLContext
        DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

        try {
            // Add a new field called "id_98" to the table "cita"
            try {
                create.alterTable(CITA).add("id98", SQLDataType.INTEGER.nullable(true)).execute();
            } catch (DataAccessException e) {
                if (!e.getMessage().contains("Duplicate column name")) {
                    throw e;
                }
            }


            // Insert records
            insertRecords(create, recordsData);

            // Get records with "id_98" field not empty and save in a Map object using "id_98" as key and "id" as value
            Result<Record2<Integer, Integer>> recordsIds = create.select(CITA.ID, CITA.ID98).from(CITA).where(CITA.ID98.isNotNull()).fetch();
            // Loop results and store the value of the field "id98" as key and the value of the field "id" as a
            // value in a Map object
            Map<Integer, Integer> recordIdsMap = new HashMap<>();
            for (Record2 rec : recordsIds) {
                recordIdsMap.put((Integer)rec.value1(), (Integer)rec.value2());
            }
            // Insert ages and genders
            insertAgeGender(create, agesAndGendersData, recordIdsMap);
            // Insert collaborators
            insertCollaborators(create, collaboratorsData, recordIdsMap);
            // Insert historic records
            // TODO Implement

            conn.commit();

        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            conn.close();
        }
    }

    /**
     * Insert records
     *
     * @param recordsData List of records data
     * @param create DSLContext
     * @throws IOException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    private void insertRecords(DSLContext create, List<Map<String, Object>> recordsData)
            throws IOException, IllegalAccessException, NoSuchFieldException {

        // Loop citas data
        for (Map<String, Object> citaData : recordsData) {

            // Constructs beans using files data
            Cita cita = new Cita(citaData);

            System.out.println("Fuente: " + cita.getFuente());

            // Insert data in "cita" table
            create.insertInto(CITA,
                    CITA.ID98,
                    CITA.FECHAALTA,
                    CITA.CANTIDAD,
                    CITA.OBSERVACIONES,
                    CITA.INDSELECCIONADA,
                    CITA.LUGAR_ID,
                    CITA.OBSERVADOR_PRINCIPAL_ID,
                    CITA.CLASE_REPRODUCCION_ID,
                    CITA.FUENTE_ID,
                    CITA.INDHABITATRARO,
                    CITA.INDCRIAHABITATRARO,
                    CITA.INDHERIDO,
                    CITA.INDCOMPORTAMIENTO,
                    CITA.ESPECIE_ID,
                    CITA.CRITERIO_SELECCION_CITA_ID,
                    CITA.INDACTIVO,
                    CITA.IMPORTANCIA_CITA_ID,
                    CITA.ESTUDIO_ID,
                    CITA.INDPRIVACIDAD,
                    CITA.INDFOTO)
                    .values(
                            cita.getId98(),
                            cita.getFecha(),
                            cita.getCantidad(),
                            cita.getObservaciones(),
                            (byte)(cita.isSeleccionada() ? 1 : 0),
                            cita.getLugarId(),
                            cita.getObservadorId(),
                            cita.getClaseReproduccionId(),
                            cita.getFuente(),
                            (byte)(BooleanUtils.isTrue(cita.isHabitatRaro()) ? 1 : 0),
                            (byte)(BooleanUtils.isTrue(cita.isCriaEnHabitatRaro()) ? 1 : 0),
                            (byte)(BooleanUtils.isTrue(cita.isHerido()) ? 1 : 0),
                            (byte)(BooleanUtils.isTrue(cita.isComportamientoRaro()) ? 1 : 0),
                            cita.getEspecieId(),
                            cita.getCriterioSeleccionId(),
                            (byte)(BooleanUtils.isTrue(cita.isActivo()) ? 1 : 0),
                            cita.getImportanciaCitaId(),
                            cita.getEstudioId(),
                            (byte)cita.getPrivacidadId().intValue(),
                            (byte)(BooleanUtils.isTrue(cita.isFoto()) ? 1 : 0)
                    ).execute();
        }
    }

    /**
     * Insert age and sex
     *
     * @param ageAndGenderData List of age-sex data
     * @param create DSLContext
     * @param recordIdsMap Map with old and new record id
     * @throws IOException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    private void insertAgeGender(DSLContext create, List<Map<String, Object>> ageAndGenderData, Map<Integer, Integer> recordIdsMap)
            throws IOException, IllegalAccessException, NoSuchFieldException {

        // Loop edad-sexo data
        for (Map<String, Object> ageAndGender: ageAndGenderData) {

            // Constructs beans using files data
            EdadSexo edadSexo = new EdadSexo(ageAndGender);

            // Replace "id_98" id using value of "id"
            edadSexo.replaceCitaId(recordIdsMap.get(edadSexo.getId98()));

            // Insert data in aso_cita_clase_edad_sexo table
            create.insertInto(ASO_CITA_CLASE_EDAD_SEXO,
                    ASO_CITA_CLASE_EDAD_SEXO.CITA_ID,
                    ASO_CITA_CLASE_EDAD_SEXO.CANTIDAD,
                    ASO_CITA_CLASE_EDAD_SEXO.CLASE_EDAD_SEXO_ID
            ).values(
                    edadSexo.getId98(),
                    edadSexo.getCantidad(),
                    edadSexo.getClaseId()
            ).execute();
        }
    }

    /**
     * Insert collaborators
     *
     * @param collaboratorsData List of collaborators data
     * @param create DSLContext
     * @param recordIdsMap Map with old and new record id
     * @throws IOException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    private void insertCollaborators(DSLContext create, List<Map<String, Object>> collaboratorsData, Map<Integer, Integer> recordIdsMap)
            throws IOException, IllegalAccessException, NoSuchFieldException {

        // Loop collaborators data
        for (Map<String, Object> collaboratorData : collaboratorsData) {

            // Constructs beans using files data
            Colaborador colaborador = new Colaborador(collaboratorData);

            // Replace "id_98" id using value of "id"
            colaborador.replaceCitaId(recordIdsMap.get(colaborador.getId98()));

            // Insert data in "aso_cita_observador" table
            create.insertInto(ASO_CITA_OBSERVADOR,
                    ASO_CITA_OBSERVADOR.CITA_ID,
                    ASO_CITA_OBSERVADOR.OBSERVADOR_SECUNDARIO_ID
            ).values(
                    colaborador.getId98(),
                    colaborador.getColaboradorId()
            ).execute();
        }
    }

    /**
     * Get database connection
     *
     * @param autocommit boolean
     * @return Connection
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getConnection(boolean autocommit) throws
            InstantiationException,
            IllegalAccessException,
            ClassNotFoundException,
            SQLException {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/anuario_bbdd",
                "root",
                "");
        conn.setAutoCommit(autocommit);
        return conn;
    }
}
