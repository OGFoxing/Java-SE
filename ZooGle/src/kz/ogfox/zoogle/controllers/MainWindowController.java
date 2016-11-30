package kz.ogfox.zoogle.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.CustomTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.MotionBlur;
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
	private Slider boxBlurSlider;
	@FXML
	private Slider gaussianBlurSlider;
	@FXML
	private Slider motionBlurSlider;
	
	@FXML
	private Label opacityValue;
	@FXML
	private Label sepiaValue;
	@FXML
	private Label sizeValue;
	@FXML
	private Label boxBlurValue;
	@FXML
	private Label gaussianBlurValue;
	@FXML
	private Label motionBlurValue;
	
	/*for test*/
	@FXML
	private Button btnTest;
	@FXML
	private Button btnBlur;
	
	@FXML
	private ImageView imageView;
	@FXML
	private CheckBox cBoxSepia;
	@FXML
	private CheckBox cBoxBlur;
	@FXML
	private CheckBox cGaussianBlur;
	@FXML
	private CheckBox cMotionBlur;
	
	@FXML
	private Button btnAddUrl;
	@FXML
	private CustomTextField txtUrl;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CustomFiledsCleaner cleaner = new CustomFiledsCleaner();
		cleaner.setupClearButtonField(txtUrl);
		
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
	
	@FXML
	private void addFromUrl() {
		try {
			Image image = new Image(txtUrl.getText());
			imageView.setImage(image);	
		} catch (Exception e) {
			System.out.println("No internet connection or URL not validate");
		}	
	}
	
	@FXML
	private void testDataUrl() {
		txtUrl.setText("https://cs7057.vk.me/c636522/v636522002/3d4db/eG56pQtGxB4.jpg");
	}

	
	private void imageProperty() {
		SepiaTone sepiaEffect = new SepiaTone();
		BoxBlur blur = new BoxBlur();
		GaussianBlur gaussianBlur = new GaussianBlur();
		MotionBlur motionBlur = new MotionBlur();
		
		/*set value from sliders to labels*/
		opacityValue.setText(Double.toString(opacitySlider.getValue()));
		sepiaValue.setText(Double.toString(sepiaSlider.getValue()));
		sizeValue.setText(Double.toString(sizeSlider.getValue()));
		boxBlurValue.setText(Double.toString(boxBlurSlider.getValue()));
		gaussianBlurValue.setText(Double.toString(gaussianBlurSlider.getValue()));
		motionBlurValue.setText(Double.toString(motionBlurSlider.getValue()));
		
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
		
		/*Blurs*/
		boxBlurSlider.valueProperty().addListener((ov,old_value,new_value) ->{
			blur.setHeight(new_value.doubleValue());
			blur.setWidth(new_value.doubleValue());
			boxBlurValue.setText(String.format("%.2f", new_value));
		});
		gaussianBlurSlider.valueProperty().addListener((ov,old_value,new_value) ->{
			gaussianBlur.setRadius(new_value.doubleValue());
			gaussianBlurValue.setText(String.format("%.2f", new_value));
		});
		motionBlurSlider.valueProperty().addListener((ov,old_value,new_value) ->{
			motionBlur.setAngle(new_value.doubleValue());
			motionBlurValue.setText(String.format("%.2f", new_value));
		});
		/*end of Blurs*/
		cBoxSepia.selectedProperty().addListener((ov,old_value,new_value) -> {
			if(cBoxSepia.isSelected()) {
				imageView.setEffect(sepiaEffect);
			}
			else {
				imageView.setEffect(null);
			}
		});		
		cBoxBlur.selectedProperty().addListener((ov,old_value,new_value) -> {
			if(cBoxBlur.isSelected()) {
				imageView.setEffect(blur);
			}
			else {
				imageView.setEffect(null);
			}
		});		
		cGaussianBlur.selectedProperty().addListener((ov,old_value,new_value) -> {
			if(cGaussianBlur.isSelected()) {
				imageView.setEffect(gaussianBlur);
			}
			else {
				imageView.setEffect(null);
			}
		});		
		cMotionBlur.selectedProperty().addListener((ov,old_value,new_value) -> {
			if(cMotionBlur.isSelected()) {
				imageView.setEffect(motionBlur);
			}
			else {
				imageView.setEffect(null);
			}
		});		
	}

}
