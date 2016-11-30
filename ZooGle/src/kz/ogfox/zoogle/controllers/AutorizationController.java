package kz.ogfox.zoogle.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.CustomTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AutorizationController implements Initializable {

	@FXML
	private Button btnLogin;
	@FXML
	private CustomTextField txtLogin;
	@FXML
	private CustomTextField txtPasswd;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		CustomFiledsCleaner cleaner = new CustomFiledsCleaner();
		cleaner.setupClearButtonField(txtLogin);
		cleaner.setupClearButtonField(txtPasswd);
		
	}
	public void iLogin(ActionEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide();
		mainWindow();
		System.out.println("Pressed");
	}
	private void mainWindow() {
		try {
			Parent parent =  FXMLLoader.load(getClass().getResource("../fxml/MainWindow.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.getIcons().add(new Image("file:icon/fabric-letter-z-black.jpg"));
			stage.setMinWidth(1000);
			stage.setMinHeight(600);
			//stage.setTitle(parent.getstr);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
