package kz.ogfox.zoogle.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AutorizationController implements Initializable {

	@FXML
	private Button btnLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public void iLogin() {
		System.out.println("Pressed");
	}
}
