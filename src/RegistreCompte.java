import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.ss.usermodel.Cell;
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
	
	public void writeFile()
	{
		Collections.sort(c);
		
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet feuille = wb.createSheet("new sheet");
		
		for ( int i = 0; i < c.size(); ++i)
		{
			Row row = feuille.createRow(i);
			row.createCell(3).setCellValue(c.get(i).getIntitule());
			row.createCell(4).setCellValue(c.get(i).getType());
			row.createCell(5).setCellValue(c.get(i).getnCompte());
			row.createCell(6).setCellValue(c.get(i).getBanque());
			row.createCell(7).setCellValue(c.get(i).getADE());
			row.createCell(8).setCellValue(c.get(i).getAUM());
			row.createCell(9).setCellValue(c.get(i).getOrigineRelation());
			row.createCell(10).setCellValue(c.get(i).getToDO());
			row.createCell(11).setCellValue(c.get(i).getNote());
			row.createCell(12).setCellValue(c.get(i).getState());
		}
		
		FileOutputStream fileOut;
	       try {
	         fileOut = new FileOutputStream("RegistreCompte.xlsx");
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
		c.add(newCompte);
		this.writeFile();
		
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
		cell0_5.setCellValue("Recapitulatif des comptes");
		
		Row row_3 = feuille.createRow((short) 3);
		
		Cell cell3_0 = row_3.createCell(0);
		cell3_0.setCellStyle(st2);
		cell3_0.setCellValue("Gestionnaire");
		Cell cell3_1 = row_3.createCell(1);
		cell3_1.setCellStyle(st2);
		cell3_1.setCellValue("Client");
		Cell cell3_2 = row_3.createCell(2);
		cell3_2.setCellStyle(st2);
		cell3_2.setCellValue("Compte");
		Cell cell3_3 = row_3.createCell(3);
		cell3_3.setCellStyle(st2);
		cell3_3.setCellValue("No Police");
		Cell cell3_4 = row_3.createCell(4);
		cell3_4.setCellStyle(st2);
		cell3_4.setCellValue("Banque");
		
		for ( int i = 0; i < doc.size(); ++i)
		{
			feuille.setColumnWidth(5+i, 20 * 256);
			Cell cellI = row_3.createCell(5+i);
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
		
		FileInputStream fichier = new FileInputStream("Recapitulatif.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		for ( int i = 0; i < c.size(); ++i)
		{
			Row row = sheet.createRow( 4 + i);
			row.createCell(0).setCellValue(c.get(i).getOrigineRelation());
			row.createCell(1).setCellValue(c.get(i).getADE());
			row.createCell(2).setCellValue(c.get(i).getnCompte());
			row.createCell(4).setCellValue(c.get(i).getBanque());
			
			for ( int j = 0; j < c.get(i).getDoc().size(); ++j)
			{
				row.createCell(5+j).setCellValue(c.get(i).getDoc().get(j).isHaveIt());
			}
			
		}
		
		fichier.close();

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
	}
	
	public void addDoc(String name)
	{
		doc.add(new AdmDoc(name, false));
		for ( int i = 0; i < c.size(); ++ i)
		{
			c.get(i).addDoc(name);
		}
	}
}
