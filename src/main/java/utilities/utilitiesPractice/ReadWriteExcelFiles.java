package utilities.utilitiesPractice;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelFiles {
	public static void main(String[] args) {
		// Workbook object represents the Excel file
		Workbook workbook = new XSSFWorkbook();

		// Create a sheet in the workbook
		Sheet sheet = workbook.createSheet("SampleSheet");

		// Create sample data for the sheet
		String[][] data = { { "ID", "Name", "Age" }, { "1", "Alice", "30" }, { "2", "Bob", "25" },
				{ "3", "Charlie", "35" } };

		// Populate data into rows and cells
		for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
			Row row = sheet.createRow(rowIndex);
			for (int colIndex = 0; colIndex < data[rowIndex].length; colIndex++) {
				Cell cell = row.createCell(colIndex);
				cell.setCellValue(data[rowIndex][colIndex]);
			}
		}

		// Adjust column widths to fit content
		for (int i = 0; i < data[0].length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the workbook to a file
		try (FileOutputStream fos = new FileOutputStream("SampleExcel.xlsx")) {
			workbook.write(fos);
			System.out.println("Excel file created successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Close the workbook
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
