
import java.io.IOException;
import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.collections.FXCollections.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class AjoutWindowAdmDoc {
	private RegistreCompte c;
	
	public AjoutWindowAdmDoc(RegistreCompte c)
	{
		this.c = c;
	}
	
	public Button creatButton()
	{
		Button but = new Button();
        but.setLayoutX(750);
        but.setLayoutY(500);
        but.setText("Ajouter un document");
        but.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	Stage stageADoc = new Stage();
            	stageADoc.setTitle("Nouveau document");
            	Group rootADoc = new Group();
    	        Scene sceneADoc= new Scene(rootADoc, 700, 200, Color.CADETBLUE);
    	        
    	        TextField doc = new TextField();
    	        doc.setMinWidth(200);
    	        doc.setLayoutX(150);
    	        doc.setLayoutY(80);
    	        doc.setPromptText("Nom du document");
    	        rootADoc.getChildren().add(doc);
            	
            	Button Val = new Button();
    	        Val.setLayoutX(500);
    	        Val.setLayoutY(80);
    	        Val.setText("Ajouter");
    	        
    	        ListView docu = new ListView();
    	        docu.setLayoutX(350);
    	        docu.setLayoutY(80);
    	        docu.setMaxWidth(150);
    	        docu.setMaxHeight(80);
    	        
    	        docu.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	        
    	        for ( int i = 0; i < c.getC().size(); ++i)
    	        {
    	        	docu.getItems().add(c.getC().get(i));
    	        }
    	        
    	       
    	        docu.addEventFilter(MouseEvent.MOUSE_PRESSED, evt -> {
    	            Node node = evt.getPickResult().getIntersectedNode();

    	            // go up from the target node until a list cell is found or it's clear
    	            // it was not a cell that was clicked
    	            while (node != null && node != docu && !(node instanceof ListCell)) {
    	                node = node.getParent();
    	            }

    	            // if is part of a cell or the cell,
    	            // handle event instead of using standard handling
    	            if (node instanceof ListCell) {
    	                // prevent further handling
    	                evt.consume();

    	                ListCell cell = (ListCell) node;
    	                ListView lv = cell.getListView();

    	                // focus the listview
    	                lv.requestFocus();

    	                if (!cell.isEmpty()) {
    	                    // handle selection for non-empty cells
    	                    int index = cell.getIndex();
    	                    if (cell.isSelected()) {
    	                        lv.getSelectionModel().clearSelection(index);
    	                    } else {
    	                        lv.getSelectionModel().select(index);
    	                    }
    	                }
    	            }
    	        });
    	        
    	        
    	        
    	        rootADoc.getChildren().add(docu);
    	        
    	        
    	        
    	        
    	       
    	       
    	        
    	       
    	        
            	Val.setOnAction(new EventHandler<ActionEvent>() {
        	        
					@Override
					public void handle(ActionEvent event) {
						
						if ( doc.getCharacters().toString().equals(""))
						{
							
							Text error = new Text (150, 150, "Nom du document manquant");
							error.setFill(Color.RED);
							rootADoc.getChildren().add(error);
							return;
						}
						
						ObservableList selectedIndices =
							    docu.getSelectionModel().getSelectedIndices();
						
						
						try {
							c.addDoc(doc.getCharacters().toString());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						for ( int i = 0; i < selectedIndices.size(); ++i)
						{
							c.getC().get(Integer.parseInt(selectedIndices.get(i).toString())).HasDoc(doc.getCharacters().toString());
						}
						stageADoc.close();
						
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
