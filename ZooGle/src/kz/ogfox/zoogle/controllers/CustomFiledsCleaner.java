package kz.ogfox.zoogle.controllers;

import java.lang.reflect.Method;

import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;

import javafx.beans.property.ObjectProperty;
import javafx.scene.control.TextField;

public class CustomFiledsCleaner  {
	public void setupClearButtonField(CustomTextField customTextField) {
    	try {
			Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class,ObjectProperty.class);
			m.setAccessible(true);
			m.invoke(null, customTextField, customTextField.rightProperty());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
