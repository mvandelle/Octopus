import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RegistreCompte {
	private ArrayList<Compte> c;
	private ArrayList<AdmDoc>doc;
	

	public RegistreCompte()
	{
		this.c = new ArrayList<>();
		this.doc = new ArrayList<>();
	}
	
	public ArrayList<Compte> getC()
	{
		return c;
	}
	
	public void storeCompte() throws IOException
	{
		FileInputStream fichier = new FileInputStream("RegistreProspect.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		XSSFSheet sheet = wb.getSheetAt(0);
		DataFormatter stri = new DataFormatter();
		
		
		
		
		
		
		
		
		for (Row ligne : sheet) {
			Compte co = new Compte();
			if (ligne.getRowNum() >= 4) {
				
				
				co.setIntitule(stri.formatCellValue(ligne.getCell(0)));
				co.setType(stri.formatCellValue(ligne.getCell(1)));
				co.setnCompte(stri.formatCellValue(ligne.getCell(2)));
				co.setBanque(stri.formatCellValue(ligne.getCell(3)));
				co.setADEPrenom(stri.formatCellValue(ligne.getCell(4)));
				co.setADENom(stri.formatCellValue(ligne.getCell(5)));
				co.setAUM(stri.formatCellValue(ligne.getCell(6)));
				co.setOrigineRelation(stri.formatCellValue(ligne.getCell(7)));
				co.setToDO(stri.formatCellValue(ligne.getCell(8)));
				co.setNote(stri.formatCellValue(ligne.getCell(9)));
				co.setState(stri.formatCellValue(ligne.getCell(10)));
				this.addStoreCompte(co);
				
				
				
				
				
					
		    
				
			}
		}
		fichier.close();
		
	}
	
	public void storeDoc() throws IOException
	{
		FileInputStream fichier = new FileInputStream("RecapitulatifProspect.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int indexDoc = 6;
		
		
		while ( sheet.getRow(3).getLastCellNum() > indexDoc)
		{
			this.storeD(sheet.getRow(3).getCell(indexDoc).getStringCellValue());
			++indexDoc;
		}
		
		for ( int i = 0; i < doc.size(); ++i)
		{
			for ( int j = 0; j < c.size(); ++j)
			{
				if ( sheet.getRow(j+4).getCell(6+i).getBooleanCellValue())
				{
					c.get(j).HasDoc(doc.get(i).getName());
				}
			}
		}
		
		fichier.close();
		
	}
	
	
	public void writeFile()
	{
		Collections.sort(c);
		
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet feuille = wb.createSheet("new sheet");
		
		XSSFCellStyle st1 = wb.createCellStyle();
		XSSFFont f1 = wb.createFont();
		f1.setBold(true);
		f1.setFontHeightInPoints((short) 25);
		st1.setFont(f1);
		st1.setAlignment(HorizontalAlignment.CENTER);
		
		XSSFCellStyle st2 = wb.createCellStyle();
		XSSFFont f2 = wb.createFont();
		f2.setBold(true);
		f2.setFontHeightInPoints((short) 15);
		st2.setFont(f2);
		st2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		st2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		st2.setAlignment(HorizontalAlignment.CENTER);
		
		feuille.setColumnWidth(0, 20 * 256);
		feuille.setColumnWidth(1, 20 * 256);
		feuille.setColumnWidth(2, 20 * 256);
		feuille.setColumnWidth(3, 20 * 256);
		feuille.setColumnWidth(4, 20 * 256);
		feuille.setColumnWidth(5, 20 * 256);
		feuille.setColumnWidth(6, 30 * 256);
		feuille.setColumnWidth(7, 20 * 256);
		feuille.setColumnWidth(8, 20 * 256);
		feuille.setColumnWidth(9, 20 * 256);
		feuille.setColumnWidth(10, 20 * 256);
		
		Row row_0 = feuille.createRow((short) 0);
		Cell cell0_5 = row_0.createCell(5);
		cell0_5.setCellStyle(st1);
		cell0_5.setCellValue("Listing des comptes à l'ouverture");
		
		Row row_3 = feuille.createRow((short) 3); 
		
		Cell cell3_0 = row_3.createCell(0);
		cell3_0.setCellStyle(st2);
		cell3_0.setCellValue("Intitulé");
		
		Cell cell3_1 = row_3.createCell(1);
		cell3_1.setCellStyle(st2);
		cell3_1.setCellValue("Type");
		
		Cell cell3_2 = row_3.createCell(2);
		cell3_2.setCellStyle(st2);
		cell3_2.setCellValue("n°Compte");
		
		Cell cell3_3 = row_3.createCell(3);
		cell3_3.setCellStyle(st2);
		cell3_3.setCellValue("Banque");
		
		Cell cell3_4 = row_3.createCell(4);
		cell3_4.setCellStyle(st2);
		cell3_4.setCellValue("Prenom ADE");
		
		Cell cell3_5 = row_3.createCell(5);
		cell3_5.setCellStyle(st2);
		cell3_5.setCellValue("Nom ADE");
		
		Cell cell3_6 = row_3.createCell(6);
		cell3_6.setCellStyle(st2);
		cell3_6.setCellValue("AUM");
		
		Cell cell3_7 = row_3.createCell(7);
		cell3_7.setCellStyle(st2);
		cell3_7.setCellValue("Origine de la relation");
		
		Cell cell3_8 = row_3.createCell(8);
		cell3_8.setCellStyle(st2);
		cell3_8.setCellValue("To Do");
		
		Cell cell3_9 = row_3.createCell(9);
		cell3_9.setCellStyle(st2);
		cell3_9.setCellValue("Note");
		
		Cell cell3_10 = row_3.createCell(10);
		cell3_10.setCellStyle(st2);
		cell3_10.setCellValue("Etat");
		
		for ( int i = 4; i < c.size()+4; ++i)
		{
			Row row = feuille.createRow(i);
			row.createCell(0).setCellValue(c.get(i-4).getIntitule());
			row.createCell(1).setCellValue(c.get(i-4).getType());
			row.createCell(2).setCellValue(c.get(i-4).getnCompte());
			row.createCell(3).setCellValue(c.get(i-4).getBanque());
			row.createCell(4).setCellValue(c.get(i-4).getADEPrenom());
			row.createCell(5).setCellValue(c.get(i-4).getADENom());
			row.createCell(6).setCellValue(c.get(i-4).getAUM());
			row.createCell(7).setCellValue(c.get(i-4).getOrigineRelation());
			row.createCell(8).setCellValue(c.get(i-4).getToDO());
			row.createCell(9).setCellValue(c.get(i-4).getNote());
			row.createCell(10).setCellValue(c.get(i-4).getState());
		}
		
		FileOutputStream fileOut;
	       try {
	         fileOut = new FileOutputStream("RegistreProspect.xlsx");
	         wb.write(fileOut);
	         fileOut.close();
	       } catch (FileNotFoundException e) {
	           e.printStackTrace();
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	}
	
	public void addCompte(Compte newCompte)
	{
		newCompte.addDoc(doc);
		c.add(newCompte);
		this.writeFile();
		
	}
	
	public void addStoreCompte(Compte newCompte)
	{
		newCompte.addDoc(doc);
		c.add(newCompte);
		
		
	}
	
	public void removeCompte(String in) throws IOException
	{
		for ( int i = 0; i < c.size(); ++i)
		{
			if ( c.get(i).getIntitule().equals(in))
			{
				c.remove(i);
				i = i-1;
			}
		}
		this.writeFile();
		this.writeRecap();
	}
	
	public void creatRecap() throws IOException
	{
		
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet feuille = wb.createSheet("Recapitulatif");
		
		feuille.setColumnWidth(0, 20 * 256);
		feuille.setColumnWidth(1, 20 * 256);
		feuille.setColumnWidth(2, 20 * 256);
		feuille.setColumnWidth(3, 20 * 256);
		feuille.setColumnWidth(4, 20 * 256);
		feuille.setColumnWidth(5, 20 * 256);
		
		XSSFCellStyle st1 = wb.createCellStyle();
		XSSFFont f1 = wb.createFont();
		f1.setBold(true);
		f1.setFontHeightInPoints((short) 25);
		st1.setFont(f1);
		st1.setAlignment(HorizontalAlignment.CENTER);
		
		XSSFCellStyle st2 = wb.createCellStyle();
		XSSFFont f2 = wb.createFont();
		f2.setBold(true);
		f2.setFontHeightInPoints((short) 15);
		st2.setFont(f2);
		st2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
		st2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		st2.setAlignment(HorizontalAlignment.CENTER);
		
		XSSFCellStyle st3 = wb.createCellStyle();
		XSSFFont f3 = wb.createFont();
		f3.setBold(true);
		f3.setFontHeightInPoints((short) 15);
		st3.setFont(f3);
		st3.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		st3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		st3.setAlignment(HorizontalAlignment.CENTER);
		
		
		Row row_0 = feuille.createRow((short) 0);
		Cell cell0_5 = row_0.createCell(5);
		cell0_5.setCellStyle(st1);
		cell0_5.setCellValue("Recapitulatif des prospects");
		
		Row row_3 = feuille.createRow((short) 3);
		
		Cell cell3_0 = row_3.createCell(0);
		cell3_0.setCellStyle(st2);
		cell3_0.setCellValue("Gestionnaire");
		Cell cell3_1 = row_3.createCell(1);
		cell3_1.setCellStyle(st2);
		cell3_1.setCellValue("Client Prenom");
		Cell cell3_2 = row_3.createCell(2);
		cell3_2.setCellStyle(st2);
		cell3_2.setCellValue("Client Nom");
		Cell cell3_3 = row_3.createCell(3);
		cell3_3.setCellStyle(st2);
		cell3_3.setCellValue("Compte");
		Cell cell3_4 = row_3.createCell(4);
		cell3_4.setCellStyle(st2);
		cell3_4.setCellValue("No Police");
		Cell cell3_5 = row_3.createCell(5);
		cell3_5.setCellStyle(st2);
		cell3_5.setCellValue("Banque");
		
		for ( int i = 0; i < doc.size(); ++i)
		{
			feuille.setColumnWidth(6+i, 20 * 256);
			Cell cellI = row_3.createCell(6+i);
			cellI.setCellStyle(st3);
			cellI.setCellValue(doc.get(i).getName());
		}
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("Recapitulatif.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		wb.close();
		
	}
	
	public void writeRecap() throws IOException
	{
		creatRecap();
		Collections.sort(c);
		
		FileInputStream fichier = new FileInputStream("RecapitulatifProspect.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		
		for ( int i = 0; i < c.size(); ++i)
		{
			Row row = sheet.createRow( 4 + i);
			row.createCell(0).setCellValue(c.get(i).getOrigineRelation());
			row.createCell(1).setCellValue(c.get(i).getADEPrenom());
			row.createCell(2).setCellValue(c.get(i).getADENom());
			row.createCell(3).setCellValue(c.get(i).getnCompte());
			row.createCell(5).setCellValue(c.get(i).getBanque());
			
			
			
			for ( int j = 0; j < c.get(i).getDoc().size(); ++j)
			{
				
				row.createCell(6+j).setCellValue(c.get(i).getDoc().get(j).isHaveIt());
			}
			
		}
		
		fichier.close();

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("RecapitulatifProspect.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addDoc(String name) throws IOException
	{
		
		
		doc.add(new AdmDoc(name, false));
		for ( int i = 0; i < c.size(); ++ i)
		{
			c.get(i).addDoc(name);
		}
		this.writeRecap();
	}
	
	public void storeD(String name)
	{
		doc.add(new AdmDoc(name, false));
		for ( int i = 0; i < c.size(); ++ i)
		{
			c.get(i).addDoc(name);
		}
	}
	
	public ArrayList<String> getListC()
	{
		ArrayList<String> sC = new ArrayList<>();
		for ( int i = 0; i < c.size(); ++i)
		{
			sC.add(c.get(i).toString());
		}
		return sC;
	}
	
	public ArrayList<String> getListDoc()
	{
		ArrayList<String> sDoc = new ArrayList<>();
		for ( int i = 0; i < doc.size(); ++i)
		{
			sDoc.add(doc.get(i).toString());
		}
		return sDoc;
	}
	
	public void removeDoc(AdmDoc doc) throws IOException
	{
		this.doc.remove(doc);
		for ( int i = 0; i < c.size(); ++i)
		{
			c.get(i).removeDoc(doc);
		}
		this.writeRecap();
	}
	
	public ArrayList<AdmDoc> getDoc()
	{
		return doc;
	}
	
	
}
