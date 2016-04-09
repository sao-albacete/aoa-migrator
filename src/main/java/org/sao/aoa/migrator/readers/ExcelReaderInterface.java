package org.sao.aoa.migrator.readers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Interface ExcelReaderInterface
 *
 * @author Wonnova
 * @link http://www.wonnova.com
 */
public interface ExcelReaderInterface {

    /**
     * Read an excel file and return a list of mapped rows
     *
     * @param filename String
     * @return List
     * @throws IOException
     */
    List<Map> read(String filename) throws IOException;
}
