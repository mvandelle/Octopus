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
public class DeleteWindowRelation {
	RegistreRelation r;
	
	public DeleteWindowRelation(RegistreRelation r)
	{
		this.r = r;
	}
	
	public Button creatButton()
	{
		Button but = new Button();
        but.setLayoutX(100);
        but.setLayoutY(285);
        but.setText("Supprimer une relation");
        but.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            
            	Stage stageDRel = new Stage();
            	stageDRel.setTitle("Supprimer relation");
            	Group rootDRel = new Group();
    	        Scene sceneDRel= new Scene(rootDRel, 700, 200, Color.CADETBLUE);
    	        
    	        ObservableList<String> options = 
    	        	    FXCollections.observableArrayList(
    	        	        r.listNCompte()
    	        	        );
    	        ComboBox c = new ComboBox(options);
    	        c.setMinWidth(200);
    	        c.setLayoutY(80);
    	        c.setLayoutX(100);
    	        c.setPromptText("n°Compte Intitulé");
    	        rootDRel.getChildren().add(c);
    	        
    	        Button Val = new Button();
    	        Val.setLayoutX(500);
    	        Val.setLayoutY(80);
    	        Val.setText("Supprimer");
    	        Val.setOnAction(new EventHandler<ActionEvent>() {
    	        
					@Override
					public void handle(ActionEvent event) {
						
						int index = c.getSelectionModel().getSelectedIndex();
						DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						Date date = new Date();
						
						if ( index == -1)
						{
							stageDRel.close();
						} else
						{
							try {
								r.removeRelation(r.getR().get(index).getnCompte(), format.format(date));
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
