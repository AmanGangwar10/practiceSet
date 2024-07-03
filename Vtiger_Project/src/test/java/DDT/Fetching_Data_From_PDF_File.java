package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Fetching_Data_From_PDF_File {

	public static void main(String[] args) throws Throwable {
		
	 File file = new File("./src\\test\\resources\\Summary Report sush.pdf");
	 PDDocument doc = PDDocument.load(file);
    
	 int pages = doc.getNumberOfPages();
	 System.out.println(pages);
		
	 PDFTextStripper pdfData = new PDFTextStripper();
    // String Data = pdfData.getText(doc);
    // System.out.println(Data);
	 
	 pdfData.setStartPage(3);
//	 String pageData = pdfData.getText(doc);
//	 System.out.println(pageData);
	 
	 pdfData.setStartPage(2);
	 pdfData.setEndPage(3);
	 String pdfData1 = pdfData.getText(doc);
	 System.out.println(pdfData1);
	 
	}
}