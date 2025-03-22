package readPDF;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;

public class ReadSpecificData {
	public static void main(String[] args) {
		// Load the PDF document
		String pdfPath = "C:\\Users\\Admin\\Downloads\\c4611_sample_explain.pdf"; // Update with your actual PDF path
		Document pdfDocument = new Document(pdfPath);

		// Extract text from the PDF
		TextAbsorber textAbsorber = new TextAbsorber();
		pdfDocument.getPages().accept(textAbsorber);
		String extractedText = textAbsorber.getText();

		// Print extracted text (Optional)
		System.out.println("Extracted PDF Text: \n" + extractedText);

		// Define the key-value pair to verify
		String key = "ap_bookmark"; // Replace with actual key from your PDF
		String expectedValue = "IFD"; // Replace with expected value

		// Search for the key and extract its value
		String actualValue = extractValueForKey(extractedText, key);

		// Verify the extracted value
		if (actualValue != null && actualValue.equals(expectedValue)) {
			System.out
					.println("Verification Passed: Key '" + key + "' has the expected value '" + expectedValue + "'.");
		} else {
			System.out
					.println("Verification Failed: Expected '" + expectedValue + "' but found '" + actualValue + "'.");
		}

		// Close the document
		pdfDocument.close();
	}

	// Method to extract the value for a given key from the extracted text
	private static String extractValueForKey(String text, String key) {
		String[] lines = text.split("\n"); // Split text into lines

		for (String line : lines) {
			if (line.contains(key)) { // Check if the line has the key
				String[] parts = line.split("."); // Assuming key and value are separated by ":"
				if (parts.length > 1) {
					return parts[1].trim(); // Return the value after the key
				}
			}
		}
		return null; // Return null if key is not found
	}
}
