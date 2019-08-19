import java.io.IOException;

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

public class DeleteWindowAdmDoc {
	
	
	RegistreCompte co;
	
	
	
	public DeleteWindowAdmDoc(RegistreCompte c)
	{
		this.co = c;
	}
	
	public Button creatButton()
	{

		Button but = new Button();
        but.setLayoutX(750);
        but.setLayoutY(535);
        but.setText("Supprimer un document");
        
        but.setOnAction(new EventHandler<ActionEvent>() {
        	 public void handle(ActionEvent event) {
        		 
        		Stage stageADoc = new Stage();
             	stageADoc.setTitle("Supprimer un document");
             	Group rootADoc = new Group();
     	        Scene sceneADoc= new Scene(rootADoc, 700, 200, Color.CADETBLUE);
     	        
     	       ObservableList<String> options = 
   	        	    FXCollections.observableArrayList(
   	        	        co.getListDoc()
   	        	        );
     	       ComboBox c = new ComboBox(options);
     	       c.setMinWidth(200);
     	       c.setLayoutY(80);
     	       c.setLayoutX(100);
     	       c.setPromptText("Documents");
     	       rootADoc.getChildren().add(c);
     	        
     	        Button Val = new Button();
     	        Val.setLayoutX(500);
     	        Val.setLayoutY(80);
     	        Val.setText("Supprimer");
     	        
     	        Val.setOnAction(new EventHandler<ActionEvent>() {
       	        
   					@Override
   					public void handle(ActionEvent event) {
   						
   						int index = c.getSelectionModel().getSelectedIndex();
   						
   						if ( index == -1)
						{
							stageADoc.close();
						} else
						{
							try {
								co.removeDoc(co.getDoc().get(index));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							stageADoc.close();
						}
   						
   					}
     	       
     	        });
     	        
     	        rootADoc.getChildren().add(Val);
     	        stageADoc.setScene(sceneADoc);
     	        stageADoc.show();
        	
        	 }	
        });
        
        return but;
	}
		
}
