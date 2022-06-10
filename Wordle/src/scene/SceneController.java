package scene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	private Stage mainWindow;
	private Scene currentScene;
	private Parent currentNode;
	
	public void switchToHome(ActionEvent event) throws IOException {
		currentNode = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
		mainWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		currentScene = new Scene(currentNode);
		mainWindow.setScene(currentScene);
		mainWindow.show();
	}
	
	public void switchToSettings(ActionEvent event) throws IOException {
		currentNode = FXMLLoader.load(getClass().getResource("/application/Settings.fxml"));
		mainWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		currentScene = new Scene(currentNode);
		mainWindow.setScene(currentScene);
		mainWindow.show();
	}
	
	public void switchToGame(ActionEvent event) throws IOException {
		currentNode = FXMLLoader.load(getClass().getResource("/application/Game.fxml"));
		mainWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		currentScene = new Scene(currentNode);
		mainWindow.setScene(currentScene);
		mainWindow.show();
	}
}
