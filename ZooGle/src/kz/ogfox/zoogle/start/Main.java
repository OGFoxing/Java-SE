package kz.ogfox.zoogle.start;
	
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("../fxml/autorization.fxml"));
			fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Locale",new Locale("en")));
			
			Parent fxmlMain = fxmlLoader.load();
			
			primaryStage.setResizable(false);
			primaryStage.setTitle(fxmlLoader.getResources().getString("title"));
			primaryStage.setScene(new Scene(fxmlMain,400,300));
			primaryStage.getIcons().add(new Image("file:icon/fabric-letter-z-black.jpg"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
