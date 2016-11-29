package kz.ogfox.zoogle.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
			//stage.setTitle(parent.getstr);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
