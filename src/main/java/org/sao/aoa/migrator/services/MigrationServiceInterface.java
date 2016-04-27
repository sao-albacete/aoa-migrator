package org.sao.aoa.migrator.services;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Interface MigrationServiceInterface
 *
 * @author Wonnova
 * @link http://www.wonnova.com
 */
public interface MigrationServiceInterface {

    void run(String recordsFilename, String agesAndGendersFilename, String collaboratorsFilename)
            throws IOException, IllegalAccessException, NoSuchFieldException, SQLException, ClassNotFoundException, InstantiationException;
}
