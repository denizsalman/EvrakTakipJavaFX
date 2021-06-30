package application.util;

import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Window;
import javafx.util.Duration;

public class Notification {
	
	private static String msg;
	private static ImageView imageView;
	private static final String URL_ERROR = "file:src/resources/icons/error.png";
	private static final String URL_SUCCESS = "file:src/resources/icons/success.png";
	private static Notifications notificationBuilder;
	
	static {
		imageView = new ImageView();
		imageView.setFitHeight(50);
	    imageView.setFitWidth(50);
	    notificationBuilder = Notifications.create()
                .graphic(imageView)
                .position(Pos.BOTTOM_RIGHT);
	}
    
    public static void showError(String title, String msg, Window window) {
    	notificationBuilder
        .title(title);
    	showError(msg, window);
	}

    public static void showError(String msg, Window window) {
    	imageView.setImage(new Image(URL_ERROR));
        notificationBuilder
                .text(msg)
                .hideAfter(Duration.seconds(10))
                .owner(window).show();
	}
    
    public static void showSuccess(String title, String msg, Window window) {
        notificationBuilder
        .title(title);
        showSuccess(msg, window);
	}
    
    public static void showSuccess(String msg, Window window) {
    	 imageView.setImage(new Image(URL_SUCCESS));
         notificationBuilder
         .text(msg)
         .hideAfter(Duration.seconds(5))
         .owner(window).show();
	}
    
}
