package application;
	
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import application.util.Notification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Parent root;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Thread.setDefaultUncaughtExceptionHandler(Main::showError);
			
			root = FXMLLoader.load(getClass().getResource("evrak/Home.fxml"));
			
			Scene scene = new Scene(root);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private static void showError(Thread t, Throwable e) {
		StringWriter errorMsg = new StringWriter();
		e.printStackTrace(new PrintWriter(errorMsg));
		System.out.println("test");
		
		System.out.println("Beklenmedik hata: " + e.getClass().getName());

		
		Notification.showError("Hata", "Beklenmedik hata!", root.getScene().getWindow());
		
		
	}
}
