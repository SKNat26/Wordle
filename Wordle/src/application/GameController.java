package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import scene.SceneController;

//event methods
public class GameController {
	@FXML	
	
	public void returnHome(ActionEvent e) throws IOException {
		SceneController scene = new SceneController();
		scene.switchToHome(e);
	}
	
}
