import java.io.IOException;



import org.apache.commons.math3.analysis.solvers.RiddersSolver;

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
import javafx.stage.Stage;


public class AjoutWindowCompte {
	RegistreCompte c;
	
	public AjoutWindowCompte(RegistreCompte c)
	{
		this.c = c;
	}
	
	public Button creatButton()
	{
		Button but = new Button();
        but.setLayoutX(770);
        but.setLayoutY(349);
        but.setText("Ajouter un prospect");
        but.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	
            	Stage stageACom = new Stage();
            	stageACom.setTitle("Nouveau prospect");
            	Group rootACom = new Group();
    	        Scene sceneACom= new Scene(rootACom, 700, 200, Color.WHITE);
            	
            	Button Val = new Button();
    	        Val.setLayoutX(100);
    	        Val.setLayoutY(100);
    	        Val.setText("Ajouter");
    	        
    	        TextField inti = new TextField();
		    	inti.setMaxWidth(100);
		    	inti.setPromptText("Intitulé");
		    	rootACom.getChildren().add(inti);
    	        
		    	TextField type = new TextField();
		    	type.setMaxWidth(100);
		    	type.setLayoutX(100);
		    	type.setPromptText("Type");
		    	rootACom.getChildren().add(type);
		    	
		    	TextField nC = new TextField();
		    	nC.setMaxWidth(100);
		    	nC.setLayoutX(200);
		    	nC.setPromptText("n°Compte");
		    	rootACom.getChildren().add(nC);
		    	
		    	TextField bank = new TextField();
		    	bank.setMaxWidth(100);
		    	bank.setLayoutX(300);
		    	bank.setPromptText("Banque");
		    	rootACom.getChildren().add(bank);
		    	
		    	TextField adeP = new TextField();
		    	adeP.setMaxWidth(100);
		    	adeP.setLayoutX(400);
		    	adeP.setPromptText("Prenom ADE");
		    	rootACom.getChildren().add(adeP);
		    	
		    	TextField adeN = new TextField();
		    	adeN.setMaxWidth(100);
		    	adeN.setLayoutX(500);
		    	adeN.setPromptText("Nom ADE");
		    	rootACom.getChildren().add(adeN);
		    	
		    	TextField aum = new TextField();
		    	aum.setMaxWidth(100);
		    	aum.setLayoutX(600);
		        aum.setPromptText("AUM");
		    	rootACom.getChildren().add(aum);
		    	
		    	TextField gest = new TextField();
		    	gest.setMaxWidth(100);
		        gest.setLayoutX(0);
		        gest.setLayoutY(30);
		    	gest.setPromptText("Origine relation");
		    	rootACom.getChildren().add(gest);
		    	
		    	TextField toDo = new TextField();
		    	toDo.setMaxWidth(100);
		        toDo.setLayoutX(100);
		        toDo.setLayoutY(30);
		    	toDo.setPromptText("To do");
		    	rootACom.getChildren().add(toDo);
		    	
		    	TextField note = new TextField();
		    	note.setMaxWidth(100);
		        note.setLayoutX(200);
		        note.setLayoutY(30);
		    	note.setPromptText("Note");
		    	rootACom.getChildren().add(note);
		    	
		    	TextField state = new TextField();
		    	state.setMaxWidth(100);
		        state.setLayoutX(300);
		        state.setLayoutY(30);
		    	state.setPromptText("State");
		    	rootACom.getChildren().add(state);
		    	
		    	
		    	
    	        Val.setOnAction(new EventHandler<ActionEvent>() {
    	        
					@Override
					public void handle(ActionEvent event) {
						
						String sinti;
						if (inti.getCharacters().toString().equals(""))
						{
							sinti = "Non renseigné";
						
						} else
						{
							sinti = inti.getCharacters().toString();
						}
						
						String stype;
						if (type.getCharacters().toString().equals(""))
						{
							stype = "Non renseigné";
						
						} else
						{
							stype = type.getCharacters().toString();
						}
						
						String snC;
						if (nC.getCharacters().toString().equals(""))
						{
							snC = "Non renseigné";
						
						} else
						{
							snC = nC.getCharacters().toString();
						}
						
						String sbank;
						if (bank.getCharacters().toString().equals(""))
						{
							sbank = "Non renseigné";
						
						} else
						{
							sbank = bank.getCharacters().toString();
						}
						
						String sadeP;
						if (adeP.getCharacters().toString().equals(""))
						{
							sadeP = "Non renseigné";
						
						} else
						{
							sadeP = adeP.getCharacters().toString();
						}
						
						String sadeN;
						if (adeN.getCharacters().toString().equals(""))
						{
							sadeN = "Non renseigné";
						
						} else
						{
							sadeN = adeN.getCharacters().toString();
						}
						
						String saum;
						if (aum.getCharacters().toString().equals(""))
						{
							saum = "Non renseigné";
						
						} else
						{
							saum = aum.getCharacters().toString();
						}
						
						String sgest;
						if (gest.getCharacters().toString().equals(""))
						{
							sgest = "Non renseigné";
						
						} else
						{
							sgest = gest.getCharacters().toString();
						}
						
						String stodo;
						if (toDo.getCharacters().toString().equals(""))
						{
							stodo = "Non renseigné";
						
						} else
						{
							stodo = toDo.getCharacters().toString();
						}
						
						String snote;
						if (note.getCharacters().toString().equals(""))
						{
							snote = "Non renseigné";
						
						} else
						{
							snote = note.getCharacters().toString();
						}
						
						String sstate;
						if (state.getCharacters().toString().equals(""))
						{
							sstate = "Non renseigné";
						
						} else
						{
							sstate = state.getCharacters().toString();
						}
						
						Compte newC = new Compte(sinti, stype, snC, sbank, sadeN,sadeP, saum, sgest, stodo, snote, sstate);
						c.addCompte(newC);
						stageACom.close();
						
						
						
		    	        
		    	        
						
						
            }
    	        });
    	        
    	        rootACom.getChildren().add(Val);
    	        
    	        stageACom.setScene(sceneACom);
    	        stageACom.show();
	}
        });
        
        return but;
	}

}
