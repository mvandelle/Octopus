import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.stage.Modality;


public class Octopus extends Application{
	
	private static RegistreRelation regRel;
	private static RegistreCompte regCom;
	
	public void start(Stage primaryStage) throws IOException {
		 	primaryStage.setTitle("Octopus 1.0");
		 
		 
		
	        Group root = new Group();
	        
	        Scene scene = new Scene(root, 1000, 750, Color.WHITE);
	        
	        
	        File pict = new File("o.png");
	        String p = pict.toURI().toURL().toString();
	        ImageView pic = new ImageView();
	        pic.setImage(new Image(p));
	        pic.setFitHeight(450);
	        pic.setFitWidth(450);
	        pic.setLayoutX(275);
	        pic.setLayoutY(150);
	        
	        root.getChildren().add(pic);
	        
	        File ath = new File("athenee.png");
	        String at = ath.toURI().toURL().toString();
	        ImageView path = new ImageView();
	        path.setImage(new Image(at));
	        path.setLayoutX(-30);
	        path.setLayoutY(-40);
	        path.setScaleX(0.7);
	        path.setScaleY(0.7);
	        root.getChildren().add(path);
	        
	        
	        Button rel = new Button();
	        File berna = new File("ARCOVERD.ttf");
	        String bern = berna.toURI().toURL().toString();
	        Font police = Font.loadFont(bern,15);
	        rel.setFont(police);
	        
	        rel.setLayoutX(80);
	        rel.setLayoutY(291);
	        rel.setText("Accès au registre \n des relations");
	        rel.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                try {
						Desktop.getDesktop().open(new File("Registre relation.xlsx"));
					
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            }
	        });
	        root.getChildren().add(rel);
	        
	        Button oc = new Button();
	        oc.setLayoutX(90);
	        oc.setLayoutY(550);
	        oc.setText("Accès aux Ouvertures/Clotures");
	        oc.setFont(police);
	        oc.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                try {
						Desktop.getDesktop().open(new File("OC.xlsx"));
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            }
	        });
	        root.getChildren().add(oc);
	        
	        Button mc = new Button();
	        mc.setLayoutX(380);
	        mc.setLayoutY(620);
	        mc.setText("Accès aux mouvement cash");
	        mc.setFont(police);
	        mc.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                try {
						Desktop.getDesktop().open(new File("MC.xlsx"));
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            }
	        });
	        root.getChildren().add(mc);
	        
	        Button dc = new Button();
	        dc.setLayoutX(770);
	        dc.setLayoutY(300);
	        dc.setText("Accès au détail \n des comptes");
	        dc.setFont(police);
	        dc.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                try {
						Desktop.getDesktop().open(new File("RegistreCompte.xlsx"));
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            }
	        });
	        root.getChildren().add(dc);
	        
	        Button rec = new Button();
	        rec.setLayoutX(750);
	        rec.setLayoutY(481);
	        rec.setText("Accès au récapitulatif \n des comptes");
	        rec.setFont(police);
	        rec.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	            	
	            	try {
						regCom.writeRecap();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                try {
						Desktop.getDesktop().open(new File("Recapitulatif.xlsx"));
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            }
	        });
	        root.getChildren().add(rec);
	        
	        
	        //boutton d'ajout et de delete
	        
	        AjoutWindowRelation test = new AjoutWindowRelation(regRel, regCom);
	        Button awr = test.creatButton();
	        awr.setFont(police);
	        root.getChildren().add(awr);
	        
	        DeleteWindowRelation test2 = new DeleteWindowRelation(regRel);
	        Button dwr = test2.creatButton();
	        dwr.setFont(police);
	        root.getChildren().add(dwr);
	        
	        AjoutMC test3 = new AjoutMC(regRel);
	        Button amc = test3.creatButton();
	        amc.setFont(police);
	        root.getChildren().add(amc);
	        
	        AjoutWindowCompte test4 = new AjoutWindowCompte(regCom);
	        Button awc = test4.creatButton();
	        awc.setFont(police);
	        root.getChildren().add(awc);
	        
	        DeleteWindowCompte test5 = new DeleteWindowCompte(regCom);
	        Button dwc = test5.creatButton();
	        dwc.setFont(police);
	        root.getChildren().add(dwc);
	        
	        AjoutWindowAdmDoc test6 = new AjoutWindowAdmDoc(regCom);
	        Button ado = test6.creatButton();
	        ado.setFont(police);
	        root.getChildren().add(ado);
	        
	        DeleteWindowAdmDoc test7 = new DeleteWindowAdmDoc(regCom);
	        Button ddo = test7.creatButton();
	        ddo.setFont(police);
	        root.getChildren().add(ddo);
	        
	        WindowLinkDocCom test8 = new WindowLinkDocCom(regCom);
	        Button lcd = test8.creatButton();
	        lcd.setFont(police);
	        root.getChildren().add(lcd);
	        
	        SecurityButton sauv = new SecurityButton();
	        Button s = sauv.creatButton();
	        s.setFont(police);
	        root.getChildren().add(s);
	        
	        
	        
	        primaryStage.setScene(scene);
	        primaryStage.show();

        
    }
	
	public static void main(String[] args) throws InvalidFormatException, IOException
	{
		regRel = new RegistreRelation();
		regCom = new RegistreCompte();
		
		
		regCom.storeCompte();
		regCom.storeDoc();
		regRel.storeRelation();
		
	
		
		regCom.writeRecap();
		regCom.writeFile();
		
		if ( regRel.storeMC())
		{
		regRel.creatMC();
		}
		if ( regRel.storeOC())
		{
		regRel.creatOc();
		}
		
		
		regRel.writeNewFile();
		
		
		launch(args);
	}
	
	

}
