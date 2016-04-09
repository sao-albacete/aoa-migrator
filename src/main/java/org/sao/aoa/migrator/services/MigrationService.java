package org.sao.aoa.migrator.services;

import com.google.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.sao.aoa.migrator.readers.ExcelReaderInterface;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    public void run(String citasFilename, String edadSexoCantidadFilename, String colaboradoresFilename)
            throws IOException {

        /*
         * Read files
         */
        // Read citas file
        List<Map> citasData = reader.read(citasFilename);
        // Read edad-sexo file
        List<Map> edadSexoData = reader.read(edadSexoCantidadFilename);
        // Read colaboradores file
        List<Map> colaboradoresData = reader.read(colaboradoresFilename);

        // Define database connection
        // Create it from ad-hoc arguments
        DSLContext create = DSL.using(connection, dialect);

        // Add a new field called "id_98" to the table Cita

        // Loop citas data

            // Constructs beans using files data

            // Insert data in cita table

        // Get citas with "id_98" field not empty and save in a Map object using "id_98" as key and "id" as value

        // Loop edad-sexo data

            // Constructs beans using files data

            // Replace "id_98" id using value of "id"

            // Insert data in aso_cita_clase_edad_sexo table

        // Loop colaboradores data

            // Constructs beans using files data

            // Replace "id_98" id using value of "id"

            // Insert data in aso_cita_observador table

    }
}
