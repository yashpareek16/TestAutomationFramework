package readPDF;

import com.aspose.pdf.AbsorbedCell;
import com.aspose.pdf.AbsorbedRow;
import com.aspose.pdf.AbsorbedTable;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.TextFragment;

public class ReadTable {
	public static void main(String[] args) {
		// Load the PDF document
		String pdfPath = "C:\\Users\\Admin\\Downloads\\c4611_sample_explain.pdf"; // Update with your actual PDF path
		Document pdfDocument = new Document(pdfPath);

		// Iterate through each page of the document
		for (int pageIndex = 1; pageIndex <= pdfDocument.getPages().size(); pageIndex++) {
			Page page = pdfDocument.getPages().get_Item(pageIndex);

			// Create TableAbsorber to detect tables
			TableAbsorber tableAbsorber = new TableAbsorber();
			tableAbsorber.visit(page);

			// Iterate through each table found on the page
			for (int tableIndex = 0; tableIndex < tableAbsorber.getTableList().size(); tableIndex++) {
				AbsorbedTable table = tableAbsorber.getTableList().get(tableIndex);
				System.out.println("Table " + (tableIndex + 1) + " on Page " + pageIndex);

				// Iterate through the rows of the table
				for (int rowIndex = 0; rowIndex < table.getRowList().size(); rowIndex++) {
					AbsorbedRow row = table.getRowList().get(rowIndex);
					System.out.print("Row " + (rowIndex + 1) + ": ");

					// Iterate through the cells of the row
					for (int cellIndex = 0; cellIndex < row.getCellList().size(); cellIndex++) {
						AbsorbedCell cell = row.getCellList().get(cellIndex);

						// Extract text from all text fragments in the cell
						StringBuilder cellText = new StringBuilder();
						for (TextFragment fragment : cell.getTextFragments()) {
							cellText.append(fragment.getText()).append(" ");
						}

						System.out.print(cellText.toString().trim() + " | ");
					}
					System.out.println(); // Move to the next row
				}
				System.out.println("-----------------------------------");
			}
		}

		// Close the document
		pdfDocument.close();
	}
}
