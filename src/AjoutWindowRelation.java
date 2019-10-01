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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AjoutWindowRelation {
	RegistreRelation r;
	RegistreCompte c;
	
	public AjoutWindowRelation(RegistreRelation r, RegistreCompte c)
	{
		this.r = r;
		this.c = c;
	}
	
	public Button creatButton()
	{
		  	Button but = new Button();
	        but.setLayoutX(80);
	        but.setLayoutY(340);
	        but.setText("Ajouter une relation");
	        but.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	            	Stage stageARel = new Stage();
	            	stageARel.setTitle("Nouvelle relation");
	            	Group rootARel = new Group();
	    	        Scene sceneARel= new Scene(rootARel, 700, 200, Color.WHITE);
	    	        
	    	        
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
	    	        date.setPromptText("Date naissance");
	    	        rootARel.getChildren().add(date);
	    	        
	    	        TextField adr = new TextField();
	    	        adr.setMaxWidth(100);
	    	        adr.setLayoutY(30);
	    	        adr.setLayoutX(0);
	    	        adr.setPromptText("Adresse");
	    	        rootARel.getChildren().add(adr);
	    	        
	    	        TextField leg = new TextField();
	    	        leg.setMaxWidth(100);
	    	        leg.setLayoutY(30);
	    	        leg.setLayoutX(100);
	    	        leg.setPromptText("Legitimation");
	    	        rootARel.getChildren().add(leg);
	    	        
	    	        TextField sieg = new TextField();
	    	        sieg.setMaxWidth(100);
	    	        sieg.setLayoutY(30);
	    	        sieg.setLayoutX(200);
	    	        sieg.setPromptText("Siège social");
	    	        rootARel.getChildren().add(sieg);
	    	        
	    	        TextField reg = new TextField();
	    	        reg.setMaxWidth(100);
	    	        reg.setLayoutY(30);
	    	        reg.setLayoutX(300);
	    	        reg.setPromptText("Reg act.");
	    	        rootARel.getChildren().add(reg);
	    	        
	    	        TextField nat = new TextField();
	    	        nat.setMaxWidth(100);
	    	        nat.setLayoutY(30);
	    	        nat.setLayoutX(400);
	    	        nat.setPromptText("Nationalité");
	    	        rootARel.getChildren().add(nat);
	    	        
	    	        TextField resi = new TextField();
	    	        resi.setMaxWidth(100);
	    	        resi.setLayoutY(30);
	    	        resi.setLayoutX(500);
	    	        resi.setPromptText("Résidence");
	    	        rootARel.getChildren().add(resi);
	    	        
	    	        TextField det = new TextField();
	    	        det.setMaxWidth(100);
	    	        det.setLayoutY(30);
	    	        det.setLayoutX(600);
	    	        det.setPromptText("Detenteur compte");
	    	        rootARel.getChildren().add(det);
	    	        
	    	        TextField eu = new TextField();
	    	        eu.setMaxWidth(100);
	    	        eu.setLayoutY(60);
	    	        eu.setLayoutX(0);
	    	        eu.setPromptText("Client Europ");
	    	        rootARel.getChildren().add(eu);
	    	        
	    	        ObservableList<String> options = 
	    	        	    FXCollections.observableArrayList(
	    	        	        "Oui",
	    	        	        "Non"
	    	        	        );
	    	        ComboBox risk = new ComboBox(options);
	    	        risk.setMinWidth(100);
	    	        risk.setLayoutY(60);
	    	        risk.setLayoutX(100);
	    	        risk.setPromptText("Risque");
	    	        rootARel.getChildren().add(risk);
	    	        
	    	        TextField entre = new TextField();
	    	        entre.setMaxWidth(100);
	    	        entre.setLayoutY(60);
	    	        entre.setLayoutX(200);
	    	        entre.setPromptText("Entré en relation");
	    	        rootARel.getChildren().add(entre);
	    	        
	    	        TextField dernier = new TextField();
	    	        dernier.setMaxWidth(100);
	    	        dernier.setLayoutY(60);
	    	        dernier.setLayoutX(300);
	    	        dernier.setPromptText("Dernier contact");
	    	        rootARel.getChildren().add(dernier);
	    	        
	    	        TextField profil = new TextField();
	    	        profil.setMaxWidth(100);
	    	        profil.setLayoutY(60);
	    	        profil.setLayoutX(400);
	    	        profil.setPromptText("Profil");
	    	        rootARel.getChildren().add(profil);
	    	        
	    	        TextField comG = new TextField();
	    	        comG.setMaxWidth(100);
	    	        comG.setLayoutY(60);
	    	        comG.setLayoutX(500);
	    	        comG.setPromptText("% Com Gest");
	    	        rootARel.getChildren().add(comG);
	    	        
	    	        TextField comP = new TextField();
	    	        comP.setMaxWidth(100);
	    	        comP.setLayoutY(60);
	    	        comP.setLayoutX(600);
	    	        comP.setPromptText("% Com Perf");
	    	        rootARel.getChildren().add(comP);
	    	        
	    	        TextField devise = new TextField();
	    	        devise.setMaxWidth(100);
	    	        devise.setLayoutY(90);
	    	        devise.setLayoutX(0);
	    	        devise.setPromptText("Devise");
	    	        rootARel.getChildren().add(devise);
	    	        
	    	        TextField soldeD = new TextField();
	    	        soldeD.setMaxWidth(100);
	    	        soldeD.setLayoutY(90);
	    	        soldeD.setLayoutX(100);
	    	        soldeD.setPromptText("Solde début");
	    	        rootARel.getChildren().add(soldeD);
	    	        
	    	        TextField soldeF = new TextField();
	    	        soldeF.setMaxWidth(100);
	    	        soldeF.setLayoutY(90);
	    	        soldeF.setLayoutX(200);
	    	        soldeF.setPromptText("Solde fin");
	    	        rootARel.getChildren().add(soldeF);
	    	        
	    	        TextField dateO = new TextField();
	    	        dateO.setMaxWidth(100);
	    	        dateO.setLayoutY(90);
	    	        dateO.setLayoutX(300);
	    	        dateO.setPromptText("Date ouverture");
	    	        rootARel.getChildren().add(dateO);
	    	        
	    	        ObservableList<String> optionsCom = 
	     	        	    FXCollections.observableArrayList(
	     	        	        c.getListC()
	     	        	        );
	     	        ComboBox<String> com = new ComboBox<String>(optionsCom);
	     	        com.setMinWidth(200);
	     	        com.setLayoutY(150);
	     	        com.setLayoutX(100);
	     	        com.setPromptText("Prospects preexistants");
	     	        
	     	        com.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							int indexC = com.getSelectionModel().getSelectedIndex();
							
							inti.setText(c.getC().get(indexC).getIntitule());
							nC.setText(c.getC().get(indexC).getnCompte());
							bank.setText(c.getC().get(indexC).getBanque());
							prenom.setText(c.getC().get(indexC).getADEPrenom());
							nom.setText(c.getC().get(indexC).getADENom());
							soldeD.setText(c.getC().get(indexC).getAUM());
							gest.setText(c.getC().get(indexC).getOrigineRelation());
							
							}
	     	        	
	     	        	});
	     	        
	     	        rootARel.getChildren().add(com);
	    	        
	    	        
	    	        
	    	        Button Val = new Button();
	    	        Val.setLayoutX(600);
	    	        Val.setLayoutY(150);
	    	        Val.setText("Ajouter");
	    	        Val.setOnAction(new EventHandler<ActionEvent>() {
	    	        
						@Override
						public void handle(ActionEvent event) {
							
							if ( dateO.getCharacters().toString().equals(""))
							{
								Text error = new Text (400, 165, "Date d'ouverture manquante");
								error.setFill(Color.RED);
								rootARel.getChildren().add(error);
								return;
							}
							
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
								snC = "Non Renseigné";
							
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
							
							String sAd;
							if ( adr.getCharacters().toString().equals(""))
							{
								sAd = "Non renseigné";
							} else
							{
								sAd = adr.getCharacters().toString();
							}
							
							String sleg;
							if (leg.getCharacters().toString().equals(""))
							{
								sleg = "Non rensigné";
							
							} else
							{
								sleg = leg.getCharacters().toString();
							}
							
							String sSieg;
							if ( sieg.getCharacters().toString().equals(""))
							{
								sSieg = "Non renseigné";
							} else
							{
								sSieg = sieg.getCharacters().toString();
							}
							
							String sReg;
							if ( reg.getCharacters().toString().equals(""))
							{
								sReg = "Non renseigné";
							} else
							{
								sReg = reg.getCharacters().toString();
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
							
							String sdet;
							if (det.getCharacters().toString().equals(""))
							{
								sdet = "Non rensigné";
							
							} else
							{
								sdet = det.getCharacters().toString();
							}
							
							String seu;
							if (eu.getCharacters().toString().equals(""))
							{
								seu = "Non rensigné";
							
							} else
							{
								seu = eu.getCharacters().toString();
							}
							
							
							String sentre;
							if (entre.getCharacters().toString().equals(""))
							{
								sentre = "Non renseigné";
							
							} else
							{
								sentre = entre.getCharacters().toString();
							}
							
							String sdernier;
							if (dernier.getCharacters().toString().equals(""))
							{
								sdernier = "Non renseigné";
							
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
								scomG = "Non renseigné";
							
							} else
							{
								scomG = comG.getCharacters().toString();
							}
							
							String scomP;
							if (comP.getCharacters().toString().equals(""))
							{
								scomP = "Non renseigné";
							
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
								ssoldeD = "Non renseigné";
							
							} else
							{
								ssoldeD = soldeD.getCharacters().toString();
							}
							
							String ssoldeF;
							if (soldeF.getCharacters().toString().equals(""))
							{
								ssoldeF = "Non renseigné";
							
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
							
							if ( com.getSelectionModel().getSelectedIndex() != -1)
							{
								try {
									c.removeCompte(c.getC().get(com.getSelectionModel().getSelectedIndex()).getIntitule());
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
							Relation newR = new Relation(sgest, sinti, snC, sbank, snom, sprenom, sdate, sAd, sleg, sSieg, sReg, snat, sresi, sdet, seu, brisk, sentre, sdernier, sprofil, scomG, scomP, sdevise, ssoldeD, ssoldeF, true);
							try {
								r.addRelation(newR, dateO.getCharacters().toString());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							stageARel.close();
						}
	    	        });
	    	        rootARel.getChildren().add(Val);
	    	        
	    	       
	    	        
	    	        stageARel.setScene(sceneARel);
	    	        stageARel.show();
	               
	            }
	        });
	        return but;
	}
	

}
