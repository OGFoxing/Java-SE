package kz.ogfox.zoogle.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.w3c.dom.events.EventException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class MainWindowController implements Initializable {

	@FXML
	private Slider opacitySlider;
	@FXML 
	private Slider sepiaSlider;
	@FXML
	private Slider sizeSlider;
	@FXML
	private Label opacityValue;
	@FXML
	private Label sepiaValue;
	@FXML
	private Label sizeValue;
	@FXML
	private Button btnTest;
	@FXML
	private ImageView imageView;
	@FXML
	private CheckBox cBox;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageProperty();
	}
	
	@FXML
	private void showImg() {
		Image image = new Image("file:res/3hPjOXjTgOM.jpg");
		imageView.setImage(image);
	}
	
	@FXML
	private void handleDragOver(DragEvent event) {
		if(event.getDragboard().hasFiles()) {
			event.acceptTransferModes(TransferMode.ANY);
		}
	}
	
	@FXML
	private void handleDragDropped(DragEvent event) throws FileNotFoundException {
		List <File> files = event.getDragboard().getFiles();
		Image img = new Image(new FileInputStream(files.get(0)));
		imageView.setImage(img);
	}
	
	private void imageProperty() {
		SepiaTone sepiaEffect = new SepiaTone();
		
		/*get value from sliders to labels*/
		opacityValue.setText(Double.toString(opacitySlider.getValue()));
		sepiaValue.setText(Double.toString(sepiaSlider.getValue()));
		sizeValue.setText(Double.toString(sizeSlider.getValue()));
		
		opacitySlider.valueProperty().addListener((ov, old_value, new_value) -> {
			imageView.setOpacity(new_value.doubleValue());
			opacityValue.setText(String.format("%.2f", new_value));
		});

		sepiaSlider.valueProperty().addListener((ov, old_value, new_value) -> {
			sepiaEffect.setLevel(new_value.doubleValue());
			sepiaValue.setText(String.format("%.2f", new_value));
		});

		sizeSlider.valueProperty().addListener((ov, old_value, new_value) -> {
			imageView.setScaleX(new_value.doubleValue());
			imageView.setScaleY(new_value.doubleValue());
			sizeValue.setText(String.format("%.2f", new_value));
		});
		
		cBox.selectedProperty().addListener((ov,old_value,new_value) -> {
			if(cBox.isSelected()) {
				imageView.setEffect(sepiaEffect);
			}
			else {
				imageView.setEffect(null);
			}
		});		
	}

}
