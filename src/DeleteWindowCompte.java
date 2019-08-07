import java.io.IOException;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class DeleteWindowCompte {
	RegistreCompte c;
	
	public DeleteWindowCompte(RegistreCompte c)
	{
		this.c = c;
	}
	
	public Button creatButton()
	{
		Button but = new Button();
        but.setLayoutX(770);
        but.setLayoutY(285);
        but.setText("Supprimer un compte");
        but.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	
            	Stage stageDCom = new Stage();
            	stageDCom.setTitle("Supprimer compte");
            	Group rootDCom = new Group();
    	        Scene sceneDCom= new Scene(rootDCom, 700, 200, Color.CADETBLUE);
            	
            	 ObservableList<String> options = 
     	        	    FXCollections.observableArrayList(
     	        	        c.getListC()
     	        	        );
     	        ComboBox com = new ComboBox(options);
     	        com.setMinWidth(200);
     	        com.setLayoutY(80);
     	        com.setLayoutX(100);
     	        com.setPromptText("n°Compte Intitulé");
     	        rootDCom.getChildren().add(com);
            	
            	Button Val = new Button();
    	        Val.setLayoutX(500);
    	        Val.setLayoutY(80);
    	        Val.setText("Supprimer");
    	        Val.setOnAction(new EventHandler<ActionEvent>() {
    	        
					@Override
					public void handle(ActionEvent event) {
						
						int index = com.getSelectionModel().getSelectedIndex();
						
						if ( index == -1)
						{
							stageDCom.close();
						} else
						{
							try {
								c.removeCompte(c.getC().get(index).getIntitule() );
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						stageDCom.close();
						
						
					}
    	        });
    	        rootDCom.getChildren().add(Val);
    	        
    	        stageDCom.setScene(sceneDCom);
    	        stageDCom.show();
            	
            }
        });
        
        return but;
	}

}
