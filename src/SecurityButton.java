import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SecurityButton {
	
	
	public SecurityButton()
	{
		
	}
	
	public Button creatButton()
	{
		Button but = new Button();
        but.setLayoutX(450);
        but.setLayoutY(80);
        but.setText("Sauvegarder");
        
        but.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	
        		try {
					copyFile("Registre relation.xlsx");
					copyFile("MouvementCash.xlsx");
					copyFile("OuvertureCloture.xlsx");
					copyFile("RecapitulatifProspect.xlsx");
					copyFile("RegistreProspect.xlsx");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
            }
            
        });
        
        return but;
	}
	
	public void copyFile (String old) throws IOException
	{
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dat = dateFormat.format(actuelle);
		 
		
		
		FileInputStream fichier = new FileInputStream(old);
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		
		XSSFWorkbook sauvegarde = new XSSFWorkbook();
		
		
		for ( Sheet sheet : wb)
		{
			XSSFSheet sh = sauvegarde.createSheet();
			for ( int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum(); ++i)
			{
				Row rw = sh.createRow(i);
				
			
				
				if (sheet.getRow(i) != null) {
				for ( int j = sheet.getRow(i).getFirstCellNum(); j < sheet.getRow(i).getLastCellNum(); ++j)
				{
					
					
					if ( sheet.getRow(i).getCell(j) != null)
					{
					CellStyle origStyle = sheet.getRow(i).getCell(j).getCellStyle();
					Cell c = rw.createCell(j);
					CellStyle newStyle = sauvegarde.createCellStyle();
					newStyle.cloneStyleFrom(origStyle);
					c.setCellStyle(newStyle);
					c = sheet.getRow(i).getCell(j);
					}
					
					
					
				}
				}
				
			}
		}
		String s = "Sauvegarde-"+dat+"-";
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(s+old);
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
