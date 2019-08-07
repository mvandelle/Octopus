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
        but.setLayoutY(250);
        but.setText("Ajouter un compte");
        but.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	
            	Stage stageACom = new Stage();
            	stageACom.setTitle("Nouveau compte");
            	Group rootACom = new Group();
    	        Scene sceneACom= new Scene(rootACom, 700, 200, Color.CADETBLUE);
            	
            	Button Val = new Button();
    	        Val.setLayoutX(100);
    	        Val.setLayoutY(100);
    	        Val.setText("Ajouter");
    	        
    	        TextField inti = new TextField();
		    	inti.setMaxWidth(100);
		    	inti.setPromptText("Intitulé");
		    	rootACom.getChildren().add(inti);
    	        
    	        Val.setOnAction(new EventHandler<ActionEvent>() {
    	        
					@Override
					public void handle(ActionEvent event) {
						
						
		    	        
		    	        
						
						
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
