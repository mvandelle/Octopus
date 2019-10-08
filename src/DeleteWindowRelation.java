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
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class DeleteWindowRelation {
	RegistreRelation r;
	
	public DeleteWindowRelation(RegistreRelation r)
	{
		this.r = r;
	}
	
	public Button creatButton()
	{
		Button but = new Button();
        but.setLayoutX(80);
        but.setLayoutY(370);
        but.setText("Supprimer une relation");
        but.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            
            	Stage stageDRel = new Stage();
            	stageDRel.setTitle("Supprimer relation");
            	Group rootDRel = new Group();
    	        Scene sceneDRel= new Scene(rootDRel, 700, 200, Color.WHITE);
    	        
    	        ObservableList<String> options = 
    	        	    FXCollections.observableArrayList(
    	        	        r.listNCompte()
    	        	        );
    	        ComboBox c = new ComboBox(options);
    	        c.setMaxWidth(200);
    	        c.setLayoutY(80);
    	        c.setLayoutX(100);
    	        c.setPromptText("n°Compte Intitulé");
    	        rootDRel.getChildren().add(c);
    	        
    	        TextField date = new TextField();
    	        date.setMaxWidth(100);
    	        date.setLayoutX(300);
    	        date.setLayoutY(80);
    	        date.setPromptText("jj/mm/aaaa");
    	        rootDRel.getChildren().add(date);
    	        
    	        Button Val = new Button();
    	        Val.setLayoutX(500);
    	        Val.setLayoutY(80);
    	        Val.setText("Supprimer");
    	        Val.setOnAction(new EventHandler<ActionEvent>() {
    	        
					@Override
					public void handle(ActionEvent event) {
						
						int index = c.getSelectionModel().getSelectedIndex();
					
						if ( date.getCharacters().toString().equals(""))
						{
							Text error = new Text (300, 130, "Date manquante");
							error.setFill(Color.RED);
							rootDRel.getChildren().add(error);
							return;
						}
						
						if ( index == -1)
						{
							stageDRel.close();
						} else
						{
							try {
								String selectedRelation = options.get(index);
								int index2 = r.findRelationIndex(selectedRelation)
;								r.removeRelation(r.getR().get(index2).getnCompte(), date.getCharacters().toString());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						stageDRel.close();
						
					}
    	        });
    	        rootDRel.getChildren().add(Val);	
    	        
    	        stageDRel.setScene(sceneDRel);
    	        stageDRel.show();
            	
            }
        });
            
        
        return but;
	}

}
