package application.home;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button btnEvrak;

    @FXML
    private Button btnKasa;

    @FXML
    void openEvrakModul(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnEvrak.getScene().getWindow();
		stage.close();
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../evrak/Home.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
    }

    @FXML
    void openKasaModul(ActionEvent event) {

    }

}
