import java.awt.Color;
import java.io.File;

import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.record.cf.PatternFormatting;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RegistreRelation {
	private ArrayList<Relation> r;
	private File oc;

	public RegistreRelation() throws InvalidFormatException, IOException {
		r = new ArrayList<Relation>();

	}
	
	public ArrayList<String> listNCompte()
	{
		ArrayList<String> l = new ArrayList<>();
		for ( int i = 0; i < r.size(); ++i)
		{
			if ( r.get(i).getAlive())
			{
				l.add(r.get(i).toString());
			}
		}
		return l;
	}

	public void creatOc() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();

		XSSFCellStyle st1 = wb.createCellStyle();
		XSSFFont f1 = wb.createFont();
		f1.setBold(true);
		f1.setFontHeightInPoints((short) 20);
		st1.setFont(f1);

		Sheet feuille = wb.createSheet("Ouverture");

		Sheet feuille2 = wb.createSheet("Cloture");

		feuille.setColumnWidth(2, 20 * 256);
		feuille.setColumnWidth(6, 15 * 256);
		feuille.setColumnWidth(7, 15 * 256);
		feuille.setColumnWidth(8, 13 * 256);
		feuille.setColumnWidth(10, 15 * 256);

		feuille2.setColumnWidth(2, 20 * 256);
		feuille2.setColumnWidth(6, 15 * 256);
		feuille2.setColumnWidth(7, 15 * 256);
		feuille2.setColumnWidth(8, 13 * 256);
		feuille2.setColumnWidth(10, 15 * 256);

		Row row = feuille.createRow((short) 0);
		Cell cell5 = row.createCell(5);
		cell5.setCellStyle(st1);
		cell5.setCellValue("Ouverture 2019");

		Row ligne = feuille2.createRow((short) 0);
		Cell cellu5 = ligne.createCell(5);
		cellu5.setCellStyle(st1);
		cellu5.setCellValue("Cloture 2019");

		Row row2 = feuille.createRow((short) 3);
		Row ligne2 = feuille2.createRow((short) 3);
		XSSFCellStyle st2 = wb.createCellStyle();
		XSSFFont f2 = wb.createFont();
		f2.setBold(true);
		f2.setFontHeightInPoints((short) 15);
		st2.setFont(f2);
		st2.setFillForegroundColor(IndexedColors.GOLD.index);
		st2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		st2.setAlignment(HorizontalAlignment.CENTER);

		Cell cell2_0 = row2.createCell(0);
		cell2_0.setCellStyle(st2);
		cell2_0.setCellValue("NO");
		Cell cell2_1 = row2.createCell(1);
		cell2_1.setCellStyle(st2);
		cell2_1.setCellValue("LIBELLE");
		Cell cell2_2 = row2.createCell(2);
		cell2_2.setCellStyle(st2);
		cell2_2.setCellValue("NO CONTRAT");
		Cell cell2_3 = row2.createCell(3);
		cell2_3.setCellStyle(st2);
		cell2_3.setCellValue("ADE");
		Cell cell2_4 = row2.createCell(4);
		cell2_4.setCellStyle(st2);
		cell2_4.setCellValue("GEST");
		Cell cell2_5 = row2.createCell(5);
		cell2_5.setCellStyle(st2);
		cell2_5.setCellValue("DATE");
		Cell cell2_6 = row2.createCell(6);
		cell2_6.setCellStyle(st2);
		cell2_6.setCellValue("NUMERO");
		Cell cell2_7 = row2.createCell(7);
		cell2_7.setCellStyle(st2);
		cell2_7.setCellValue("BANQUE");
		Cell cell2_8 = row2.createCell(8);
		cell2_8.setCellStyle(st2);
		cell2_8.setCellValue("STATUT");
		Cell cell2_9 = row2.createCell(9);
		cell2_9.setCellStyle(st2);
		cell2_9.setCellValue("MOTIF");
		Cell cell2_10 = row2.createCell(10);
		cell2_10.setCellStyle(st2);
		cell2_10.setCellValue("MONTANT");

		Cell cellu2_0 = ligne2.createCell(0);
		cellu2_0.setCellStyle(st2);
		cellu2_0.setCellValue("NO");
		Cell cellu2_1 = ligne2.createCell(1);
		cellu2_1.setCellStyle(st2);
		cellu2_1.setCellValue("LIBELLE");
		Cell cellu2_2 = ligne2.createCell(2);
		cellu2_2.setCellStyle(st2);
		cellu2_2.setCellValue("NO CONTRAT");
		Cell cellu2_3 = ligne2.createCell(3);
		cellu2_3.setCellStyle(st2);
		cellu2_3.setCellValue("ADE");
		Cell cellu2_4 = ligne2.createCell(4);
		cellu2_4.setCellStyle(st2);
		cellu2_4.setCellValue("GEST");
		Cell cellu2_5 = ligne2.createCell(5);
		cellu2_5.setCellStyle(st2);
		cellu2_5.setCellValue("DATE");
		Cell cellu2_6 = ligne2.createCell(6);
		cellu2_6.setCellStyle(st2);
		cellu2_6.setCellValue("NUMERO");
		Cell cellu2_7 = ligne2.createCell(7);
		cellu2_7.setCellStyle(st2);
		cellu2_7.setCellValue("BANQUE");
		Cell cellu2_8 = ligne2.createCell(8);
		cellu2_8.setCellStyle(st2);
		cellu2_8.setCellValue("STATUT");
		Cell cellu2_9 = ligne2.createCell(9);
		cellu2_9.setCellStyle(st2);
		cellu2_9.setCellValue("MOTIF");
		Cell cellu2_10 = ligne2.createCell(10);
		cellu2_10.setCellStyle(st2);
		cellu2_10.setCellValue("MONTANT");

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("OuvertureCloture.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		wb.close();

	}
	
	public boolean storeOC() throws IOException
	{
		FileInputStream fichier = new FileInputStream("OuvertureCloture.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFSheet sheet1 = wb.getSheetAt(1);
		boolean OCDexist = false;
		
	
		if ( sheet.getLastRowNum()<=3 && sheet1.getLastRowNum()<=3)
		{
			OCDexist = true;
		} 
		
		fichier.close();
		return OCDexist;
	}
	
	public boolean storeMC() throws IOException
	{
		FileInputStream fichier = new FileInputStream("MouvementCash.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		XSSFSheet sheet = wb.getSheetAt(0);
		boolean MCDexist = false;
		
		if ( sheet.getLastRowNum()<=3)
		{
			MCDexist = true;
		} 
		
		fichier.close();
		return MCDexist;
	}
	

	public void storeRelation() throws InvalidFormatException, IOException {

		FileInputStream fichier = new FileInputStream("RegistreRelation.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		XSSFSheet sheet = wb.getSheetAt(0);
		DataFormatter stri = new DataFormatter();
		
		for (Row ligne : sheet) {
			Relation t = new Relation();
			if (ligne.getRowNum() >= 3 && !ligne.getCell(4).getStringCellValue().equals("")) {
				
				t.setGestionnaire(stri.formatCellValue(ligne.getCell(0)));
				t.setIntitule(stri.formatCellValue(ligne.getCell(1)));
				t.setnCompte(stri.formatCellValue(ligne.getCell(2)));
				t.setBanque(stri.formatCellValue(ligne.getCell(3)));
				t.setNom(stri.formatCellValue(ligne.getCell(4)));
				t.setPrenom(stri.formatCellValue(ligne.getCell(5)));
				t.setDate(stri.formatCellValue(ligne.getCell(6)));
				t.setAdresse(stri.formatCellValue(ligne.getCell(7)));
				t.setLegitimation(stri.formatCellValue(ligne.getCell(8)));
				t.setSiege(stri.formatCellValue(ligne.getCell(9)));
				t.setReg(stri.formatCellValue(ligne.getCell(10)));
				t.setNationalite(stri.formatCellValue(ligne.getCell(11)));
				t.setResidence(stri.formatCellValue(ligne.getCell(12)));
				t.setDet(stri.formatCellValue(ligne.getCell(13)));
				t.setEu(stri.formatCellValue(ligne.getCell(14)));
				
				if(ligne.getCell(15) != null)
				{
				if (ligne.getCell(15).getBooleanCellValue() == false) {
					t.setRisque(false);
				} else {
					t.setRisque(true);
				}
				}
				 
				t.setEntre(stri.formatCellValue(ligne.getCell(16)));
				t.setDernier(stri.formatCellValue(ligne.getCell(17)));
				t.setProfil(stri.formatCellValue(ligne.getCell(18)));
				t.setComGest(stri.formatCellValue(ligne.getCell(19)));
				t.setComPerf(stri.formatCellValue(ligne.getCell(20)));
				t.setMonnaie(stri.formatCellValue(ligne.getCell(21)));
				t.setSoldeDeb(stri.formatCellValue(ligne.getCell(22)));
				t.setSoldeFin(stri.formatCellValue(ligne.getCell(23)));
				
				if(ligne.getCell(24) != null)
				{
				if ( ligne.getCell(24).getStringCellValue().equals("cloturé"))
				{
					t.setAlive(false);
				} else
				{
					t.setAlive(true);
				}
				} else
				{
					t.setAlive(true);
				}
				
				//t.setAlive(true);
				r.add(t);

			}
			fichier.close();
			Collections.sort(r);

		}
	}

	public ArrayList<Relation> getR() {
		return r;
	}

	public void writeNewFile() throws IOException {
		Collections.sort(r);

		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet feuille = wb.createSheet("Registre des relations");
		
		XSSFCellStyle st1 = wb.createCellStyle();
		XSSFFont f1 = wb.createFont();
		f1.setBold(true);
		f1.setFontHeightInPoints((short) 20);
		st1.setFont(f1);
		
		XSSFCellStyle st2 = wb.createCellStyle();
		XSSFFont f2 = wb.createFont();
		f2.setBold(true);
		f2.setFontHeightInPoints((short) 15);
		st2.setFont(f2);
		st2.setFillForegroundColor(IndexedColors.GOLD.index);
		st2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		st2.setAlignment(HorizontalAlignment.CENTER);
		
		XSSFCellStyle st3 = wb.createCellStyle();
		XSSFFont f3 = wb.createFont();
		f3.setBold(true);
		f3.setFontHeightInPoints((short) 12);
		f3.setColor(IndexedColors.RED.index);
		st3.setFont(f3);
		st3.setAlignment(HorizontalAlignment.CENTER);
		
		
		Row rowT = feuille.createRow((short) 0);
		Cell cell5 = rowT.createCell(5);
		cell5.setCellStyle(st1);
		cell5.setCellValue("Registre des relations");
		
		Row row2 = feuille.createRow((short) 2);
		
		Cell cell2_0 = row2.createCell(0);
		cell2_0.setCellStyle(st2);
		cell2_0.setCellValue("Gestionnaire");
		Cell cell2_1 = row2.createCell(1);
		cell2_1.setCellStyle(st2);
		cell2_1.setCellValue("Intitulé");
		Cell cell2_2 = row2.createCell(2);
		cell2_2.setCellStyle(st2);
		cell2_2.setCellValue("n°Compte");
		Cell cell2_3 = row2.createCell(3);
		cell2_3.setCellStyle(st2);
		cell2_3.setCellValue("Banque");
		Cell cell2_4 = row2.createCell(4);
		cell2_4.setCellStyle(st2);
		cell2_4.setCellValue("Nom");
		Cell cell2_5 = row2.createCell(5);
		cell2_5.setCellStyle(st2);
		cell2_5.setCellValue("Prenom");
		Cell cell2_6 = row2.createCell(6);
		cell2_6.setCellStyle(st2);
		cell2_6.setCellValue("Date naissance");
		Cell cell2_7 = row2.createCell(7);
		cell2_7.setCellStyle(st2);
		cell2_7.setCellValue("Adresse");
		Cell cell2_8 = row2.createCell(8);
		cell2_8.setCellStyle(st2);
		cell2_8.setCellValue("Légitimation");
		
		Cell cell2_9 = row2.createCell(9);
		cell2_9.setCellStyle(st2);
		cell2_9.setCellValue("Siège social");
		
		Cell cell2_10 = row2.createCell(10);
		cell2_10.setCellStyle(st2);
		cell2_10.setCellValue("Reg. act");
		
		Cell cell2_11 = row2.createCell(11);
		cell2_11.setCellStyle(st2);
		cell2_11.setCellValue("Nationalité");
		Cell cell2_12 = row2.createCell(12);
		cell2_12.setCellStyle(st2);
		cell2_12.setCellValue("Résidence");
		
		Cell cell2_13 = row2.createCell(13);
		cell2_13.setCellStyle(st2);
		cell2_13.setCellValue("Détenteur compte");
		
		Cell cell2_14 = row2.createCell(14);
		cell2_14.setCellStyle(st2);
		cell2_14.setCellValue("Client Europe");
		
		Cell cell2_15 = row2.createCell(15);
		cell2_15.setCellStyle(st2);
		cell2_15.setCellValue("Risque");
		Cell cell2_16 = row2.createCell(16);
		cell2_16.setCellStyle(st2);
		cell2_16.setCellValue("Entrée en relation");
		Cell cell2_17 = row2.createCell(17);
		cell2_17.setCellStyle(st2);
		cell2_17.setCellValue("Dernier contact");
		Cell cell2_18 = row2.createCell(18);
		cell2_18.setCellStyle(st2);
		cell2_18.setCellValue("Profil");
		Cell cell2_19 = row2.createCell(19);
		cell2_19.setCellStyle(st2);
		cell2_19.setCellValue("% ComGest");
		Cell cell2_20 = row2.createCell(20);
		cell2_20.setCellStyle(st2);
		cell2_20.setCellValue("% ComPerf");
		Cell cell2_21 = row2.createCell(21);
		cell2_21.setCellStyle(st2);
		cell2_21.setCellValue("Monnaie ref.");
		Cell cell2_22 = row2.createCell(22);
		cell2_22.setCellStyle(st2);
		cell2_22.setCellValue("Solde initial");
		Cell cell2_23 = row2.createCell(23);
		cell2_23.setCellStyle(st2);
		cell2_23.setCellValue("Solde final");
		
		
		
		
		for (int i = 0; i <= 23; ++i)
		{
			feuille.setColumnWidth(i, 20 * 256);
		}
		
		for (int i = 0; i < r.size(); ++i) {
			

			
			Row row = feuille.createRow(i+3);
			if (r.get(i).getAlive() == false)
			{
				Cell cellred_0 = row.createCell(0);
				cellred_0.setCellStyle(st3);
				cellred_0.setCellValue(r.get(i).getGestionnaire());
				Cell cellred_1 = row.createCell(1);
				cellred_1.setCellStyle(st3);
				cellred_1.setCellValue(r.get(i).getIntitule());
				Cell cellred_2 = row.createCell(2);
				cellred_2.setCellStyle(st3);
				cellred_2.setCellValue(r.get(i).getnCompte());
				Cell cellred_3 = row.createCell(3);
				cellred_3.setCellStyle(st3);
				cellred_3.setCellValue(r.get(i).getBanque());
				Cell cellred_4 = row.createCell(4);
				cellred_4.setCellStyle(st3);
				cellred_4.setCellValue(r.get(i).getNom());
				Cell cellred_5 = row.createCell(5);
				cellred_5.setCellStyle(st3);
				cellred_5.setCellValue(r.get(i).getPrenom());
				Cell cellred_6 = row.createCell(6);
				cellred_6.setCellStyle(st3);
				cellred_6.setCellValue(r.get(i).getDate());
				Cell cellred_7 = row.createCell(7);
				cellred_7.setCellStyle(st3);
				cellred_7.setCellValue(r.get(i).getAdresse());
				Cell cellred_8 = row.createCell(8);
				cellred_8.setCellStyle(st3);
				cellred_8.setCellValue(r.get(i).getLegitimation());
				
				Cell cellred_9 = row.createCell(9);
				cellred_9.setCellStyle(st3);
				cellred_9.setCellValue(r.get(i).getSiege());
				
				Cell cellred_10 = row.createCell(10);
				cellred_10.setCellStyle(st3);
				cellred_10.setCellValue(r.get(i).getReg());
				
				Cell cellred_11 = row.createCell(11);
				cellred_11.setCellStyle(st3);
				cellred_11.setCellValue(r.get(i).getNationalite());
				Cell cellred_12 = row.createCell(12);
				cellred_12.setCellStyle(st3);
				cellred_12.setCellValue(r.get(i).getResidence());
				
				Cell cellred_13 = row.createCell(13);
				cellred_13.setCellStyle(st3);
				cellred_13.setCellValue(r.get(i).getDet());
				
				Cell cellred_14 = row.createCell(14);
				cellred_14.setCellStyle(st3);
				cellred_14.setCellValue(r.get(i).getEu());
				
				Cell cellred_15 = row.createCell(15);
				cellred_15.setCellStyle(st3);
				cellred_15.setCellValue(r.get(i).isRisque());
				Cell cellred_16 = row.createCell(16);
				cellred_16.setCellStyle(st3);
				cellred_16.setCellValue(r.get(i).getEntre());
				Cell cellred_17 = row.createCell(17);
				cellred_17.setCellStyle(st3);
				cellred_17.setCellValue(r.get(i).getDernier());
				Cell cellred_18 = row.createCell(18);
				cellred_18.setCellStyle(st3);
				cellred_18.setCellValue(r.get(i).getProfil());
				Cell cellred_19 = row.createCell(19);
				cellred_19.setCellStyle(st3);
				cellred_19.setCellValue(r.get(i).getComGest());
				Cell cellred_20 = row.createCell(20);
				cellred_20.setCellStyle(st3);
				cellred_20.setCellValue(r.get(i).getComPerf());
				Cell cellred_21 = row.createCell(21);
				cellred_21.setCellStyle(st3);
				cellred_21.setCellValue(r.get(i).getMonnaie());
				Cell cellred_22 = row.createCell(22);
				cellred_22.setCellStyle(st3);
				cellred_22.setCellValue(r.get(i).getSoldeDeb());
				Cell cellred_23 = row.createCell(23);
				cellred_23.setCellStyle(st3);
				cellred_23.setCellValue(r.get(i).getSoldeFin());
				Cell cellred_24 = row.createCell(24);
				cellred_24.setCellStyle(st3);
				cellred_24.setCellValue("cloturé");
				
			}else
			{
			row.createCell(0).setCellValue(r.get(i).getGestionnaire());
			row.createCell(1).setCellValue(r.get(i).getIntitule());
			row.createCell(2).setCellValue(r.get(i).getnCompte());
			row.createCell(3).setCellValue(r.get(i).getBanque());
			row.createCell(4).setCellValue(r.get(i).getNom());
			row.createCell(5).setCellValue(r.get(i).getPrenom());
			row.createCell(6).setCellValue(r.get(i).getDate());
			row.createCell(7).setCellValue(r.get(i).getAdresse());
			row.createCell(8).setCellValue(r.get(i).getLegitimation());
			
			row.createCell(9).setCellValue(r.get(i).getSiege());
			row.createCell(10).setCellValue(r.get(i).getReg());
			
			row.createCell(11).setCellValue(r.get(i).getNationalite());
			row.createCell(12).setCellValue(r.get(i).getResidence());
			
			row.createCell(13).setCellValue(r.get(i).getDet());
			row.createCell(14).setCellValue(r.get(i).getEu());
			
			row.createCell(15).setCellValue(r.get(i).isRisque());
			row.createCell(16).setCellValue(r.get(i).getEntre());
			row.createCell(17).setCellValue(r.get(i).getDernier());
			row.createCell(18).setCellValue(r.get(i).getProfil());
			row.createCell(19).setCellValue(r.get(i).getComGest());
			row.createCell(20).setCellValue(r.get(i).getComPerf());
			row.createCell(21).setCellValue(r.get(i).getMonnaie());
			row.createCell(22).setCellValue(r.get(i).getSoldeDeb());
			row.createCell(23).setCellValue(r.get(i).getSoldeFin());
			}
		}

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("RegistreRelation.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addRelation(Relation relation, String date) throws IOException {
		r.add(relation);
		this.writeNewFile();

		FileInputStream fichier = new FileInputStream("OuvertureCloture.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		XSSFSheet sheet = wb.getSheetAt(0);

		Row row = sheet.createRow(sheet.getLastRowNum() + 1);
		row.createCell(0).setCellValue(sheet.getLastRowNum() - 3);
		row.createCell(1).setCellValue(relation.getIntitule());
		row.createCell(3).setCellValue(relation.getNom() + " " + relation.getPrenom());
		row.createCell(4).setCellValue(relation.getGestionnaire());
		row.createCell(5).setCellValue(date);
		row.createCell(6).setCellValue(relation.getnCompte());
		row.createCell(7).setCellValue(relation.getBanque());

		fichier.close();

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("OuvertureCloture.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeRelation(String nCompte, String date) throws IOException {
		for (int i = 0; i < r.size(); ++i) {
			if (r.get(i).getnCompte().equals(nCompte)) {
				FileInputStream fichier = new FileInputStream("OuvertureCloture.xlsx");
				XSSFWorkbook wb = new XSSFWorkbook(fichier);
				XSSFSheet sheet = wb.getSheetAt(1);

				Row row = sheet.createRow(sheet.getLastRowNum() + 1);
				row.createCell(0).setCellValue(sheet.getLastRowNum() - 3);
				row.createCell(1).setCellValue(r.get(i).getIntitule());
				row.createCell(3).setCellValue(r.get(i).getNom() + " " + r.get(i).getPrenom());
				row.createCell(4).setCellValue(r.get(i).getGestionnaire());
				row.createCell(5).setCellValue(date);
				row.createCell(6).setCellValue(r.get(i).getnCompte());
				row.createCell(7).setCellValue(r.get(i).getBanque());

				fichier.close();

				FileOutputStream fileOut;
				try {
					fileOut = new FileOutputStream("OuvertureCloture.xlsx");
					wb.write(fileOut);
					fileOut.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				r.get(i).setAlive(false);
			}

		}

		this.writeNewFile();
	}
	
	public void creatMC() throws IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet feuille = wb.createSheet("Mouvement Cash");
		
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
		
		
		Row row_0 = feuille.createRow((short) 0);
		Cell cell0_5 = row_0.createCell(5);
		cell0_5.setCellStyle(st1);
		cell0_5.setCellValue("Mouvement Cash");
		
		feuille.setColumnWidth(1, 20 * 256);
		feuille.setColumnWidth(2, 20 * 256);
		feuille.setColumnWidth(3, 20 * 256);
		feuille.setColumnWidth(4, 15 * 256);
		feuille.setColumnWidth(7, 20 * 256);
		feuille.setColumnWidth(8, 20 * 256);
		feuille.setColumnWidth(10, 40 * 256);
		
		
		
		Row row_3 = feuille.createRow((short) 3);
		
		Cell cell3_0 = row_3.createCell(0);
		cell3_0.setCellStyle(st2);
		cell3_0.setCellValue("DATE");
		Cell cell3_1 = row_3.createCell(1);
		cell3_1.setCellStyle(st2);
		cell3_1.setCellValue("BANQUE");
		Cell cell3_2 = row_3.createCell(2);
		cell3_2.setCellStyle(st2);
		cell3_2.setCellValue("TITULAIRE");
		Cell cell3_3 = row_3.createCell(3);
		cell3_3.setCellStyle(st2);
		cell3_3.setCellValue("ADE");
		Cell cell3_4 = row_3.createCell(4);
		cell3_4.setCellStyle(st2);
		cell3_4.setCellValue("COMPTE");
		Cell cell3_5 = row_3.createCell(5);
		cell3_5.setCellStyle(st2);
		cell3_5.setCellValue("GEST");
		Cell cell3_6 = row_3.createCell(6);
		cell3_6.setCellStyle(st2);
		cell3_6.setCellValue("DEVISE");
		Cell cell3_7 = row_3.createCell(7);
		cell3_7.setCellStyle(st2);
		cell3_7.setCellValue("MONTANT IN");
		Cell cell3_8 = row_3.createCell(8);
		cell3_8.setCellStyle(st2);
		cell3_8.setCellValue("MONTANT OUT");
		Cell cell3_9 = row_3.createCell(9);
		cell3_9.setCellStyle(st2);
		cell3_9.setCellValue("MODE");
		Cell cell3_10 = row_3.createCell(10);
		cell3_10.setCellStyle(st2);
		cell3_10.setCellValue("MOTIF");
		
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("MouvementCash.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		wb.close();
		
		
	}
	
	public void MouvementCash(String date, String devise, boolean in, double montant, String mode, String motif, Relation rel) throws IOException
	{
		FileInputStream fichier = new FileInputStream("MouvementCash.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fichier);
		XSSFSheet sheet = wb.getSheetAt(0);

		Row row = sheet.createRow(sheet.getLastRowNum() + 1);
		row.createCell(0).setCellValue(date);
		row.createCell(1).setCellValue(rel.getBanque());
		row.createCell(2).setCellValue(rel.getIntitule());
		row.createCell(3).setCellValue(rel.getPrenom() + " "+ rel.getNom());
		row.createCell(4).setCellValue(rel.getnCompte());
		row.createCell(5).setCellValue(rel.getGestionnaire());
		row.createCell(6).setCellValue(devise);
		if ( in )
		{
			row.createCell(7).setCellValue(montant);
		} else
		{
			row.createCell(8).setCellValue(montant);
		}
		row.createCell(9).setCellValue(mode);
		row.createCell(10).setCellValue(motif);

		fichier.close();

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("MouvementCash.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
