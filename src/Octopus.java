import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

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
import javafx.stage.*;
import javafx.stage.Modality;


public class Octopus extends Application{
	
	private static RegistreRelation regRel;
	private static RegistreCompte regCom;
	
	public void start(Stage primaryStage) throws IOException {
		 primaryStage.setTitle("Octopus 1.0");
		
	        Group root = new Group();
	        Scene scene = new Scene(root, 1000, 750, Color.WHITE);
	        
	        
	        File pict = new File("picsou.gif");
	        String p = pict.toURI().toURL().toString();
	        ImageView pic = new ImageView();
	        pic.setImage(new Image(p));
	        pic.setLayoutX(350);
	        pic.setLayoutY(200);
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
	        //rel.setStyle(" -fx-font-family: \"monospace\"");
	        rel.setLayoutX(100);
	        rel.setLayoutY(200);
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
	        oc.setLayoutX(60);
	        oc.setLayoutY(450);
	        oc.setText("Accès aux Ouvertures/Clotures");
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
	        mc.setLayoutX(400);
	        mc.setLayoutY(600);
	        mc.setText("Accès aux mouvement cash");
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
	        dc.setLayoutY(200);
	        dc.setText("Accès au détail \n des comptes");
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
	        rec.setLayoutY(450);
	        rec.setText("Accès au récapitulatif \n des comptes");
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
	        root.getChildren().add(test.creatButton());
	        
	        DeleteWindowRelation test2 = new DeleteWindowRelation(regRel);
	        root.getChildren().add(test2.creatButton());
	        
	        AjoutMC test3 = new AjoutMC(regRel);
	        root.getChildren().add(test3.creatButton());
	        
	        AjoutWindowCompte test4 = new AjoutWindowCompte(regCom);
	        root.getChildren().add(test4.creatButton());
	        
	        DeleteWindowCompte test5 = new DeleteWindowCompte(regCom);
	        root.getChildren().add(test5.creatButton());
	        
	        AjoutWindowAdmDoc test6 = new AjoutWindowAdmDoc(regCom);
	        root.getChildren().add(test6.creatButton());
	        
	        DeleteWindowAdmDoc test7 = new DeleteWindowAdmDoc(regCom);
	        root.getChildren().add(test7.creatButton());
	        
	        WindowLinkDocCom test8 = new WindowLinkDocCom(regCom);
	        root.getChildren().add(test8.creatButton());
	        
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
