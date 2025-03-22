package readPDF;
	import com.aspose.pdf.*;

	public class AsposeReadPDF {
	    public static void main(String[] args) {
	        // Load the PDF document
	        String pdfPath = "C:\\Users\\Admin\\Downloads\\c4611_sample_explain.pdf"; // Replace with your PDF file path
	        Document pdfDocument = new Document(pdfPath);

	        // Extract text from the PDF
	        TextAbsorber textAbsorber = new TextAbsorber();
	        pdfDocument.getPages().accept(textAbsorber);
	        String extractedText = textAbsorber.getText();

	        // Print extracted text
	        System.out.println("Extracted Text: \n" + extractedText);

	        // Verify the extracted content
	        String expectedText = "The template design"; // Replace with actual expected content
	        if (extractedText.contains(expectedText)) {
	            System.out.println("Verification Passed: Expected content is present.");
	        } else {
	            System.out.println("Verification Failed: Expected content not found.");
	        }

	        // Close the document
	        pdfDocument.close();
	    }
	}

