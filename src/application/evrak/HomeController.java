package application.evrak;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeController implements Initializable {

    @FXML
    private BorderPane borderPane;
    
    @FXML
    private VBox leftSideVBox;
    
    @FXML
    private Button btnGelenEvrak;
    
    @FXML
    private Button btnGidenEvrak;

    @FXML
    void gelenEvrakAction(ActionEvent event) {
    	borderPane.setCenter(null);
    	loadGelenEvrak();
    	removeLeftBorder();
    	addBorder(btnGelenEvrak);
    }
    
    @FXML
    void gidenEvrakAction(ActionEvent event) {
    	borderPane.setCenter(null);
    	removeLeftBorder();
    	addBorder(btnGidenEvrak);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadGelenEvrak();
		addBorder(btnGelenEvrak);
	}
	
	private void loadGelenEvrak() {
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("GelenEvrakTable.fxml"));
			borderPane.setCenter(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void removeLeftBorder() {
		for (Node node : leftSideVBox.getChildren()) {
			node.getStyleClass().remove("leftSideButtonBorder");
		}
	}
	
	private void addBorder(Control control) {
		control.getStyleClass().add("leftSideButtonBorder");
	}
}
