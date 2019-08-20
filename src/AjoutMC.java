import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AjoutMC {
	RegistreRelation r;
	
	public AjoutMC(RegistreRelation r)
	{
		this.r = r;
	}
	
	public Button creatButton()
	{
		Button but = new Button();
        but.setLayoutX(420);
        but.setLayoutY(635);
        but.setText("Ajouter un mouvement");
        but.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            
            	Stage stageNM = new Stage();
            	stageNM.setTitle("Ajouter un mouvement");
            	Group rootNM = new Group();
    	        Scene sceneNM= new Scene(rootNM, 700, 200, Color.WHITE);
    	        
    	        
    	        TextField dev = new TextField();
    	        dev.setMaxWidth(100);
    	        dev.setLayoutX(100);
    	        dev.setPromptText("Devise");
    	        rootNM.getChildren().add(dev);
    	        
    	        TextField mont = new TextField();
    	        mont.setMaxWidth(100);
    	        mont.setPromptText("Montant");
    	        rootNM.getChildren().add(mont);
    	        
    	        TextField mode = new TextField();
    	        mode.setMaxWidth(100);
    	        mode.setLayoutX(200);
    	        mode.setPromptText("Mode");
    	        rootNM.getChildren().add(mode);
    	        
    	        TextField mot = new TextField();
    	        mot.setMinWidth(500);
    	        mot.setLayoutX(0);
    	        mot.setLayoutY(30);
    	        mot.setPromptText("Motif");
    	        rootNM.getChildren().add(mot);
    	        
    	        TextField dat = new TextField();
    	        dat.setMaxWidth(100);
    	        dat.setLayoutX(600);
    	        dat.setPromptText("JJ/MM/AAAA");
    	        rootNM.getChildren().add(dat);
    	        
    	        ObservableList<String> options = 
    	        	    FXCollections.observableArrayList(
    	        	        r.listNCompte()
    	        	        );
    	        ComboBox c = new ComboBox(options);
    	        c.setMinWidth(200);
    	        c.setLayoutX(300);
    	        c.setPromptText("n°Compte Intitulé");
    	        rootNM.getChildren().add(c);
    	        
    	        ObservableList<String> options2 = 
    	        	    FXCollections.observableArrayList(
    	        	        "IN","OUT"
    	        	        );
    	        ComboBox sens = new ComboBox(options2);
    	        sens.setMinWidth(100);
    	        sens.setLayoutX(500);
    	        sens.setPromptText("IN/OUT");
    	        rootNM.getChildren().add(sens);
    	        
    	        
    	        Button Val = new Button();
    	        Val.setLayoutX(500);
    	        Val.setLayoutY(80);
    	        Val.setText("Ajouter");
    	        Val.setOnAction(new EventHandler<ActionEvent>() {
    	        
					@Override
					public void handle(ActionEvent event) {
						
						
						String sMontant;
						sMontant = mont.getCharacters().toString();
						
						
						
						String sDevise;
						sDevise = dev.getCharacters().toString();
						
						
						
						String sDat;
						sDat = dat.getCharacters().toString();
						
						
						
						String sMotif;
						if (mot.getCharacters().toString().equals(""))
						{
							sMotif = "Non renseigné";
						} else
						{
							sMotif = mot.getCharacters().toString();
						}
						
						
						String sMode;
						sMode = mode.getCharacters().toString();
						
						int index;
						index = c.getSelectionModel().getSelectedIndex();
						
						String sSens;
						if (sens.getSelectionModel().getSelectedIndex() == -1)
						{
							sSens = "null";
						}else {
						sSens = options2.get(sens.getSelectionModel().getSelectedIndex());
						}
						boolean inOrOut = false;
						if ( sSens.equals("IN"))
						{
							inOrOut = true;
						}
						
						
						
						
						if ( !sMontant.isEmpty() && !sDevise.isEmpty() && !sDat.isEmpty() && 
								!sMode.isEmpty() && index != -1 && sens.getSelectionModel().getSelectedIndex() != -1)
						{
							
							try {
								r.MouvementCash(sDat, sDevise, inOrOut, Double.parseDouble(sMontant), sMode, sMotif, r.getR().get(index));
							} catch (NumberFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							stageNM.close();
						}
						else
						{
							Text error = new Text (200, 100, "Information manquante");
							error.setFill(Color.RED);
							rootNM.getChildren().add(error);
							return;
						}
						
						
						
					}
    	        });
    	        rootNM.getChildren().add(Val);	
    	        
    	        stageNM.setScene(sceneNM);
    	        stageNM.show();
            	
            }
        });
            
        
        return but;
	}

}
