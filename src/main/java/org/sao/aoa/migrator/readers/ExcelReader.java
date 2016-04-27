package org.sao.aoa.migrator.readers;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDate;
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

        List<Map<String, Object>> content = new ArrayList<>();

        try (InputStream citasInputStream = this.getClass().getResourceAsStream(filename)) {

            // Create Workbook instance holding reference to .xls file
            POIFSFileSystem fs = new POIFSFileSystem(citasInputStream);
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
        row.getPhysicalNumberOfCells();
        Iterator<Cell> cellIterator = row.iterator();

        for (int i = 0; cellIterator.hasNext(); i++)
        {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    values.put(header.get(i), String.valueOf(cell.getBooleanCellValue()));
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    double cellValue = cell.getNumericCellValue();
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // Format in form of M/D/YY
                        Timestamp date = new Timestamp(HSSFDateUtil.getJavaDate(cellValue).getTime());
                        values.put(header.get(i), date.toString());
                    } else {
                        values.put(header.get(i), String.valueOf(cellValue));
                    }
                    break;
                case Cell.CELL_TYPE_BLANK:
                case Cell.CELL_TYPE_STRING:
                default:
                    values.put(header.get(i), cell.getStringCellValue());
            }
        }

        return values;
    }
}
