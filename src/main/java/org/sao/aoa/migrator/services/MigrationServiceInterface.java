package org.sao.aoa.migrator.services;

import java.io.IOException;

/**
 * Interface MigrationServiceInterface
 *
 * @author Wonnova
 * @link http://www.wonnova.com
 */
public interface MigrationServiceInterface {

    void run(String citasFilename, String edadSexoCantidadFilename, String colaboradoresFilename)
            throws IOException;
}
