import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;



public class MainTest {
	
	public static void main(String[] args) {
		
		String m = "Marc Vandelle";
		
		
	}
	
	/*public static void main(String[] args) throws IOException {
	       FileInputStream fichier = new FileInputStream(new File("Registre Relations copie.xlsx"));
	       
	       XSSFWorkbook wb = new XSSFWorkbook(fichier);
	       XSSFSheet sheet = wb.getSheetAt(0);
	  
	       ArrayList<Relation> r = new ArrayList<>();
	       DataFormatter stri = new DataFormatter();
	       
	       for (Row ligne : sheet) {//parcourir les lignes
	    	   	Relation t = new Relation();
	    	   	if (ligne.getRowNum() >= 4)
	    	   		{
	    	   			
	    	   			t.setGestionnaire(stri.formatCellValue(ligne.getCell(3)));
	    	   			t.setIntitule(stri.formatCellValue(ligne.getCell(4)));
	    	   			t.setnCompte(stri.formatCellValue(ligne.getCell(5)));
	    	   			t.setBanque(stri.formatCellValue(ligne.getCell(6)));
	    	   			t.setNom(stri.formatCellValue(ligne.getCell(7)));
	    	   			t.setPrenom(stri.formatCellValue(ligne.getCell(8)));
	    	   			t.setDate(stri.formatCellValue(ligne.getCell(9)));
	    	   			t.setLegitimation(stri.formatCellValue(ligne.getCell(11)));
	    	   			t.setNationalite(stri.formatCellValue(ligne.getCell(12)));
	    	   			t.setResidence(stri.formatCellValue(ligne.getCell(13)));
	    	   			if (stri.formatCellValue(ligne.getCell(14)).equals("NON"))
	    	   			{
	    	   				t.setRisque(false);
	    	   			} else
	    	   			{
	    	   				t.setRisque(true);
	    	   			}
	    	   			t.setEntre((int) ligne.getCell(15).getNumericCellValue());
	    	   			t.setDernier((int) ligne.getCell(16).getNumericCellValue());
	    	   			t.setProfil(stri.formatCellValue(ligne.getCell(17)));
	    	   			t.setComGest(ligne.getCell(18).getNumericCellValue());
	    	   			t.setComPerf((int) ligne.getCell(19).getNumericCellValue());
	    	   			t.setMonnaie(stri.formatCellValue(ligne.getCell(20)));
	    	   			t.setSoldeDeb((int) ligne.getCell(21).getNumericCellValue());
	    	   			t.setSoldeFin((int) ligne.getCell(22).getNumericCellValue());
	    	   			r.add(t);
	    	   		    
	    	   		}
	           
	         
	   
	       }
	       fichier.close();
	       System.out.println(r);
	    }*/

}
