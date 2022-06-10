package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import scene.SceneController;

//event methods
public class SettingsController {
	@FXML
	private AnchorPane aPane;		
	
	public void darkMode(ActionEvent e) throws IOException {
		aPane.setStyle("-fx-background-color: #000000");
	}
	
	public void lightMode(ActionEvent e) throws IOException {
		aPane.setStyle("-fx-background-color: #FFFFFF");
	}
	
	public void returnHome(ActionEvent e) throws IOException {
		SceneController scene = new SceneController();
		scene.switchToHome(e);
	}
	
}
