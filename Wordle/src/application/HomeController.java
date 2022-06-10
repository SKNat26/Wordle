package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import scene.SceneController;

//event methods
public class HomeController {
	
	public void play(ActionEvent e) throws IOException {
		SceneController scene = new SceneController();
		scene.switchToGame(e);
	}
	
	public void settings(ActionEvent e) throws IOException {
		SceneController scene = new SceneController();
		scene.switchToSettings(e);
	}
	
}
