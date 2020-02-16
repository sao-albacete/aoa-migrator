package org.sao.aoa.migrator.readers;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.*;

/**
 * Class ExcelReader
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class ExcelReader implements ExcelReaderInterface {

    @Override
    public List<Map<String, Object>> read(String filename) throws IOException {

        System.out.println("Leyendo fichero " + filename + "...");

        List<Map<String, Object>> content = new ArrayList<>();

        try (InputStream file = new FileInputStream(filename)) {

            // Create Workbook instance holding reference to .xls file
            POIFSFileSystem fs = new POIFSFileSystem(file);
            Workbook wb = new HSSFWorkbook(fs);

            // Get first/desired sheet from the workbook
            Sheet sheet = wb.getSheetAt(0);
            List<String> headerValues = null;

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            for (int i = 0; rowIterator.hasNext(); i++) {

                Row row = rowIterator.next();

                // Header row
                if (i == 0) {
                    headerValues = readHeader(row);
                    continue;
                }

                content.add(readBody(row, headerValues));
            }
        }

        return content;
    }

    /**
     * Read header row values and return a list
     *
     * @param row Row
     * @return List<String>
     */
    private List<String> readHeader(Row row) {

        List<String> headerValues = new ArrayList<>();

        // For each row, iterate through all the columns
        Iterator<Cell> cellIterator = row.cellIterator();

        while (cellIterator.hasNext())
        {
            Cell cell = cellIterator.next();
            headerValues.add(cell.getStringCellValue());
        }

        return headerValues;
    }

    /**
     * Read body row and return a map with header values as a key
     *
     * @param row Row
     * @param header List<String>
     * @return Map
     */
    private Map<String, Object> readBody(Row row, List<String> header) {

        Map<String, Object> values = new HashMap<>();

        // For each row, iterate through all the columns
        int firstCellNum = row.getFirstCellNum();
        int lastCellNum = row.getLastCellNum();
        for (int i = firstCellNum; i < lastCellNum; i++)
        {
            Cell cell = row.getCell(i);
            String cellValue = null;
            if (cell != null) {
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_BOOLEAN:
                        cellValue = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        double cellDoubleValue = cell.getNumericCellValue();
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            // Format in form of M/D/YY
                            Timestamp date = new Timestamp(HSSFDateUtil.getJavaDate(cellDoubleValue).getTime());
                            cellValue = date.toString();
                        } else {
                            cellValue = String.valueOf(cellDoubleValue);
                        }
                        break;
                    case Cell.CELL_TYPE_BLANK:
                    case Cell.CELL_TYPE_STRING:
                    default:
                        cellValue = cell.getStringCellValue();
                }
            }

            // TODO Trim String value and remove bad characters
            values.put(header.get(i), cellValue);
        }

        return values;
    }
}
