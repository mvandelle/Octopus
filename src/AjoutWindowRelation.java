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

public class AjoutWindowRelation {
	RegistreRelation r;
	
	public AjoutWindowRelation(RegistreRelation r)
	{
		this.r = r;
	}
	
	public Button creatButton()
	{
		  	Button but = new Button();
	        but.setLayoutX(100);
	        but.setLayoutY(250);
	        but.setText("Ajouter une relation");
	        but.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	            	Stage stageARel = new Stage();
	            	stageARel.setTitle("Nouvelle relation");
	            	Group rootARel = new Group();
	    	        Scene sceneARel= new Scene(rootARel, 700, 200, Color.CADETBLUE);
	    	        
	    	        
	    	        TextField gest = new TextField();
	    	        gest.setMaxWidth(100);
	    	        gest.setPromptText("Gestionnaire");
	    	        rootARel.getChildren().add(gest);
	    	        
	    	        TextField inti = new TextField();
	    	        inti.setMaxWidth(100);
	    	        inti.setLayoutX(100);
	    	        inti.setPromptText("Intitule");
	    	        rootARel.getChildren().add(inti);
	    	        
	    	        TextField nC = new TextField();
	    	        nC.setMaxWidth(100);
	    	        nC.setLayoutX(200);
	    	        nC.setPromptText("N° Compte");
	    	        rootARel.getChildren().add(nC);
	    	        
	    	        TextField bank = new TextField();
	    	        bank.setMaxWidth(100);
	    	        bank.setLayoutX(300);
	    	        bank.setPromptText("Banque");
	    	        rootARel.getChildren().add(bank);
	    	        
	    	        TextField nom = new TextField();
	    	        nom.setMaxWidth(100);
	    	        nom.setLayoutX(400);
	    	        nom.setPromptText("Nom");
	    	        rootARel.getChildren().add(nom);
	    	        
	    	        TextField prenom = new TextField();
	    	        prenom.setMaxWidth(100);
	    	        prenom.setLayoutX(500);
	    	        prenom.setPromptText("Prenom");
	    	        rootARel.getChildren().add(prenom);
	    	        
	    	        TextField date = new TextField();
	    	        date.setMaxWidth(100);
	    	        date.setLayoutX(600);
	    	        date.setPromptText("Date");
	    	        rootARel.getChildren().add(date);
	    	        
	    	        TextField leg = new TextField();
	    	        leg.setMaxWidth(100);
	    	        leg.setLayoutY(30);
	    	        leg.setLayoutX(0);
	    	        leg.setPromptText("Legitimation");
	    	        rootARel.getChildren().add(leg);
	    	        
	    	        TextField nat = new TextField();
	    	        nat.setMaxWidth(100);
	    	        nat.setLayoutY(30);
	    	        nat.setLayoutX(100);
	    	        nat.setPromptText("Nationalité");
	    	        rootARel.getChildren().add(nat);
	    	        
	    	        TextField resi = new TextField();
	    	        resi.setMaxWidth(100);
	    	        resi.setLayoutY(30);
	    	        resi.setLayoutX(200);
	    	        resi.setPromptText("Résidence");
	    	        rootARel.getChildren().add(resi);
	    	        
	    	        ObservableList<String> options = 
	    	        	    FXCollections.observableArrayList(
	    	        	        "Oui",
	    	        	        "Non"
	    	        	        );
	    	        ComboBox risk = new ComboBox(options);
	    	        risk.setMinWidth(100);
	    	        risk.setLayoutY(30);
	    	        risk.setLayoutX(300);
	    	        risk.setPromptText("Risque");
	    	        rootARel.getChildren().add(risk);
	    	        
	    	        TextField entre = new TextField();
	    	        entre.setMaxWidth(100);
	    	        entre.setLayoutY(30);
	    	        entre.setLayoutX(400);
	    	        entre.setPromptText("Entré en relation");
	    	        rootARel.getChildren().add(entre);
	    	        
	    	        TextField dernier = new TextField();
	    	        dernier.setMaxWidth(100);
	    	        dernier.setLayoutY(30);
	    	        dernier.setLayoutX(500);
	    	        dernier.setPromptText("Dernier contact");
	    	        rootARel.getChildren().add(dernier);
	    	        
	    	        TextField profil = new TextField();
	    	        profil.setMaxWidth(100);
	    	        profil.setLayoutY(30);
	    	        profil.setLayoutX(600);
	    	        profil.setPromptText("Profil");
	    	        rootARel.getChildren().add(profil);
	    	        
	    	        TextField comG = new TextField();
	    	        comG.setMaxWidth(100);
	    	        comG.setLayoutY(60);
	    	        comG.setLayoutX(0);
	    	        comG.setPromptText("% Com Gest");
	    	        rootARel.getChildren().add(comG);
	    	        
	    	        TextField comP = new TextField();
	    	        comP.setMaxWidth(100);
	    	        comP.setLayoutY(60);
	    	        comP.setLayoutX(100);
	    	        comP.setPromptText("% Com Perf");
	    	        rootARel.getChildren().add(comP);
	    	        
	    	        TextField devise = new TextField();
	    	        devise.setMaxWidth(100);
	    	        devise.setLayoutY(60);
	    	        devise.setLayoutX(200);
	    	        devise.setPromptText("Devise");
	    	        rootARel.getChildren().add(devise);
	    	        
	    	        TextField soldeD = new TextField();
	    	        soldeD.setMaxWidth(100);
	    	        soldeD.setLayoutY(60);
	    	        soldeD.setLayoutX(300);
	    	        soldeD.setPromptText("Solde début");
	    	        rootARel.getChildren().add(soldeD);
	    	        
	    	        TextField soldeF = new TextField();
	    	        soldeF.setMaxWidth(100);
	    	        soldeF.setLayoutY(60);
	    	        soldeF.setLayoutX(400);
	    	        soldeF.setPromptText("Solde fin");
	    	        rootARel.getChildren().add(soldeF);
	    	        
	    	        
	    	        
	    	        Button Val = new Button();
	    	        Val.setLayoutX(100);
	    	        Val.setLayoutY(100);
	    	        Val.setText("Ajouter");
	    	        Val.setOnAction(new EventHandler<ActionEvent>() {
	    	        
						@Override
						public void handle(ActionEvent event) {
							String sgest;
							if (gest.getCharacters().toString().equals(""))
							{
								sgest = "Non rensigné";
							
							} else
							{
								sgest = gest.getCharacters().toString();
							}
							
							String sinti;
							if (inti.getCharacters().toString().equals(""))
							{
								sinti = "Non rensigné";
							
							} else
							{
								sinti = inti.getCharacters().toString();
							}
							
							String snC;
							if (nC.getCharacters().toString().equals(""))
							{
								snC = "-1";
							
							} else
							{
								snC = nC.getCharacters().toString();
							}
							
							String sbank;
							if (bank.getCharacters().toString().equals(""))
							{
								sbank = "Non rensigné";
							
							} else
							{
								sbank = bank.getCharacters().toString();
							}
							
							String snom;
							if (nom.getCharacters().toString().equals(""))
							{
								snom = "Non rensigné";
							
							} else
							{
								snom = nom.getCharacters().toString();
							}
							
							String sprenom;
							if (prenom.getCharacters().toString().equals(""))
							{
								sprenom = "Non rensigné";
							
							} else
							{
								sprenom = prenom.getCharacters().toString();
							}
							
							String sdate;
							if (date.getCharacters().toString().equals(""))
							{
								sdate = "Non rensigné";
							
							} else
							{
								sdate = date.getCharacters().toString();
							}
							
							String sleg;
							if (leg.getCharacters().toString().equals(""))
							{
								sleg = "Non rensigné";
							
							} else
							{
								sleg = leg.getCharacters().toString();
							}
							
							String snat;
							if (nat.getCharacters().toString().equals(""))
							{
								snat = "Non rensigné";
							
							} else
							{
								snat = nat.getCharacters().toString();
							}
							
							String sresi;
							if (resi.getCharacters().toString().equals(""))
							{
								sresi = "Non rensigné";
							
							} else
							{
								sresi = resi.getCharacters().toString();
							}
							
							String sentre;
							if (entre.getCharacters().toString().equals(""))
							{
								sentre = "-1";
							
							} else
							{
								sentre = entre.getCharacters().toString();
							}
							
							String sdernier;
							if (dernier.getCharacters().toString().equals(""))
							{
								sdernier = "-1";
							
							} else
							{
								sdernier = dernier.getCharacters().toString();
							}
							
							String sprofil;
							if (profil.getCharacters().toString().equals(""))
							{
								sprofil = "Non rensigné";
							
							} else
							{
								sprofil = profil.getCharacters().toString();
							}
							
							String scomG;
							if (comG.getCharacters().toString().equals(""))
							{
								scomG = "-1";
							
							} else
							{
								scomG = comG.getCharacters().toString();
							}
							
							String scomP;
							if (comP.getCharacters().toString().equals(""))
							{
								scomP = "-1";
							
							} else
							{
								scomP = comP.getCharacters().toString();
							}
							
							String sdevise;
							if (devise.getCharacters().toString().equals(""))
							{
								sdevise = "Non rensigné";
							
							} else
							{
								sdevise = devise.getCharacters().toString();
							}
							
							String ssoldeD;
							if (soldeD.getCharacters().toString().equals(""))
							{
								ssoldeD = "0";
							
							} else
							{
								ssoldeD = soldeD.getCharacters().toString();
							}
							
							String ssoldeF;
							if (soldeF.getCharacters().toString().equals(""))
							{
								ssoldeF = "0";
							
							} else
							{
								ssoldeF = soldeF.getCharacters().toString();
							}
							
							String srisk;
							if ( risk.getSelectionModel().getSelectedIndex() == -1)
							{
								srisk = "Non renseigné";
							} else
							{
								srisk = options.get(risk.getSelectionModel().getSelectedIndex());
							}
							boolean brisk = false;
							if ( srisk.equals("Oui"))
							{
								brisk = true;
							}
							
							Relation newR = new Relation(sgest, sinti, Integer.parseInt(snC), sbank, snom, sprenom, sdate, sleg, snat, sresi, brisk, Integer.parseInt(sentre), Integer.parseInt(sdernier), sprofil, Double.parseDouble(scomG), Integer.parseInt(scomP), sdevise, Integer.parseInt(ssoldeD), Integer.parseInt(ssoldeF));
							try {
								r.addRelation(newR);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							stageARel.close();
						}
	    	        });
	    	        rootARel.getChildren().add(Val);
	    	        
	    	        //TextField textArel2 = new TextField("test");
	    	       // textArel2.setMinWidth(100);
	    	       // textArel2.setLayoutX(120);
	    	        //rootARel.getChildren().add(textArel2);
	    	        
	    	        stageARel.setScene(sceneARel);
	    	        stageARel.show();
	               
	            }
	        });
	        return but;
	}
	

}
