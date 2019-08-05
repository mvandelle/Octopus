import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MainTestEcriture {
	
	public static void main(String[] args) throws IOException
	{
		/*FileInputStream fichier = new FileInputStream(new File("test.xlsx"));
	       //créer une instance workbook qui fait référence au fichier xlsx 
	       XSSFWorkbook wb = new XSSFWorkbook(fichier);
	       XSSFSheet sheet = wb.getSheetAt(0);
	       
	       Row row = sheet.createRow((short)14);
	       Cell cell = row.createCell(0);
	       
	       
	       FileOutputStream fileOut;
	       try {
	         fileOut = new FileOutputStream("test.xlsx");
	         wb.write(fileOut);
	         fileOut.close();
	       } catch (FileNotFoundException e) {
	           e.printStackTrace();
	       } catch (IOException e) {
	           e.printStackTrace();
	       }*/
	}

}
