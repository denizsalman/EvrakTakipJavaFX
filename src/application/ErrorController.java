package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ErrorController {

	@FXML
    private Label lblErrorMessage;
	
	public void setErrorText(String text) {
		lblErrorMessage.setText(text);
	}

    @FXML
    void close(ActionEvent event) {
    	lblErrorMessage.getScene().getWindow().hide();
    }
}
