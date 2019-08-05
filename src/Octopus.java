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
	        Scene scene = new Scene(root, 1000, 750, Color.CADETBLUE);
	        
	        
	        Button rel = new Button();
	        rel.setLayoutX(100);
	        rel.setLayoutY(200);
	        rel.setText("Accès au registre \n des relations");
	        rel.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                try {
						Desktop.getDesktop().open(new File("/Users/marcvandelle/eclipse-workspace/Octopus/wut.xlsx"));
					
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
						Desktop.getDesktop().open(new File("/Users/marcvandelle/eclipse-workspace/Octopus/OC.xlsx"));
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
						Desktop.getDesktop().open(new File("/Users/marcvandelle/eclipse-workspace/Octopus/MC.xlsx"));
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
						Desktop.getDesktop().open(new File("/Users/marcvandelle/eclipse-workspace/Octopus/RegistreCompte.xlsx"));
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
						Desktop.getDesktop().open(new File("/Users/marcvandelle/eclipse-workspace/Octopus/Recapitulatif.xlsx"));
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            }
	        });
	        root.getChildren().add(rec);
	        
	        
	        //boutton d'ajout
	        
	        AjoutWindowRelation test = new AjoutWindowRelation(regRel);
	        root.getChildren().add(test.creatButton());
	        
	        DeleteWindowRelation test2 = new DeleteWindowRelation(regRel);
	        root.getChildren().add(test2.creatButton());
	        
	        AjoutMC test3 = new AjoutMC(regRel);
	        root.getChildren().add(test3.creatButton());
	        
	        primaryStage.setScene(scene);
	        primaryStage.show();

        
    }
	
	public static void main(String[] args) throws InvalidFormatException, IOException
	{
		regRel = new RegistreRelation();
		regCom = new RegistreCompte();
		regRel.storeRelation();
		regRel.writeNewFile();
		launch(args);
	}
	
	

}
