import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WindowLinkDocCom {
	private RegistreCompte c;
	
	public WindowLinkDocCom(RegistreCompte c)
	{
		this.c = c;
	}
	
	public Button creatButton()
	{
		Button but = new Button();
        but.setLayoutX(750);
        but.setLayoutY(570);
        but.setText("Ajouter un lien \n"
        		+ "document/compte");
        but.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	
            	Stage stageL = new Stage();
            	stageL.setTitle("Nouveau lien");
            	Group rootL = new Group();
    	        Scene sceneL= new Scene(rootL, 700, 200, Color.WHITE);
    	        
    	        Button Val = new Button();
    	        Val.setLayoutX(500);
    	        Val.setLayoutY(80);
    	        Val.setText("Ajouter");
    	        
    	        ObservableList<String> options = 
       	        	    FXCollections.observableArrayList(
       	        	        c.getListDoc()
       	        	        );
         	    ComboBox docu = new ComboBox(options);
         	    docu.setMinWidth(200);
         	    docu.setLayoutY(80);
         	    docu.setLayoutX(300);
         	    docu.setPromptText("Documents");
         	    rootL.getChildren().add(docu);
         	    
         	   ObservableList<String> options2 = 
      	        	    FXCollections.observableArrayList(
      	        	        c.getListC()
      	        	        );
        	    ComboBox com = new ComboBox(options2);
        	    com.setMinWidth(200);
        	    com.setLayoutY(80);
        	    com.setLayoutX(100);
        	    com.setPromptText("Comptes");
        	    rootL.getChildren().add(com);
    	        
    	        
            	Val.setOnAction(new EventHandler<ActionEvent>() {
        	        
					@Override
					public void handle(ActionEvent event) {
						
						int indexD = docu.getSelectionModel().getSelectedIndex();
						int indexC = com.getSelectionModel().getSelectedIndex();
						
						if ( indexD == -1 || indexC == -1)
						{
							stageL.close();
						} else
						{
							c.getC().get(indexC).HasDoc(options.get(indexD).toString());
							stageL.close();
						}
						
						
					}
            	});
    	        
    	        
    	        rootL.getChildren().add(Val);
    	        
    	        stageL.setScene(sceneL);
     	        stageL.show();
            }
        });
        
        return but;
	}

}
