package org.sao.aoa.migrator.services;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.Iterator;

/**
 * Class MigrationService
 *
 * @author viktorKhan
 * @link http://www.sao.albacete.org
 */
public class MigrationService implements MigrationServiceInterface {

    @Override
    public void run(String citasFilename, String edadSexoCantidadFilename, String colaboradoresFilename)
            throws IOException {

        try (InputStream citasInputStream = new FileInputStream(new File(citasFilename))) {

            // Create Workbook instance holding reference to .xls file
            POIFSFileSystem fs = new POIFSFileSystem(citasInputStream);
            Workbook wb = new HSSFWorkbook(fs);

            // Get first/desired sheet from the workbook
            Sheet sheet = wb.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType())
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "t");
                            break;
                    }
                }
                System.out.println("");
            }
        }
    }
}
