package application.login;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


import application.entity.User;
import application.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController implements Initializable {

	@FXML
    private TextField tfUsername;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btnLogin;
    
    @FXML
    private Label lblHataliGiris;


    @FXML
    void login(ActionEvent event) throws IOException {
    	
    	try {
			User user = UserRepository.getUser(1);
			System.out.println(user);
			
			if (user.getUserName().equals(tfUsername.getText()) && user.getPassword().equals(tfPassword.getText())) {
	    		System.out.println("login");
	    		lblHataliGiris.setVisible(false);
	    		Stage stage = (Stage) tfUsername.getScene().getWindow();
	    		stage.close();
	    		Stage primaryStage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("../home/Home.fxml"));
	    		primaryStage.setScene(new Scene(root));
	    		primaryStage.show();
	    		
			} else {
				lblHataliGiris.setVisible(true);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setDefaultButton(true);
	}
}
