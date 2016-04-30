/**
 * This class is generated by jOOQ
 */
package org.sao.aoa.migrator.model;

import org.jooq.impl.SchemaImpl;
import org.sao.aoa.migrator.model.tables.*;

import java.io.IOException;
import java.util.Properties;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AnuarioSchema extends SchemaImpl {

	private static final long serialVersionUID = -1726152261;

	private static String schemaName;
    private static String tablePrefix;
	private static String databaseUrl;
    private static String user;
    private static String password;
    private static String driver;

	static {
		// Load cita fields mapping properties
		Properties fieldsMapping = new Properties();
		try {
			fieldsMapping.load(AnuarioSchema.class.getResourceAsStream("/database.properties"));
            schemaName = fieldsMapping.getProperty("jdbc.database.name");
            tablePrefix = fieldsMapping.getProperty("jdbc.database.tables.prefix");
			databaseUrl = fieldsMapping.getProperty("jdbc.url");
            user = fieldsMapping.getProperty("jdbc.user");
            password = fieldsMapping.getProperty("jdbc.password");
            driver = fieldsMapping.getProperty("jdbc.driver");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The singleton instance of the database schema
	 */
	public static final AnuarioSchema ANUARIO_SCHEMA = new AnuarioSchema();

    /**
     * Get tables prefix
     *
     * @return String
     */
    public static String getTablePrefix() {
        return tablePrefix;
    }

	/**
	 * Get database url
	 *
	 * @return String
     */
	public static String getDatabaseUrl() {
		return databaseUrl;
	}

    /**
     * Get databse user
     *
     * @return String
     */
    public static String getUser() {
        return user;
    }

    /**
     * Get database password
     * @return String
     */
    public static String getPassword() {
        return password;
    }

    /**
     * Get database driver
     * @return String
     */
    public static String getDriver() {
        return driver;
    }

	/**
	 * No further instances allowed
	 */
	private AnuarioSchema() {
		super(schemaName);
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			AsoCitaClaseEdadSexo.ASO_CITA_CLASE_EDAD_SEXO,
			AsoCitaObservador.ASO_CITA_OBSERVADOR,
			Cita.CITA,
			CitaHistorico.CITA_HISTORICO);
	}
}