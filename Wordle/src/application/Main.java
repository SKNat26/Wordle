package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import java.util.Scanner;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {				
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene currentScene = new Scene(root);
			primaryStage.setScene(currentScene);			
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
//		Words wordGame = new Words(path, true);
//		String solution = wordGame.getSolution();
//		//System.out.println(solution);
//		for(int i = 0; i<6; i++) {
//			Scanner scan = new Scanner(System.in);
//			String input = scan.nextLine();
//			if(wordGame.checkValidWord(input)) {
//				if(input.toLowerCase().equals(solution.toLowerCase())) {
//					System.out.println("SOLUTION FOUND!");
//					break;
//				}
//				System.out.println(wordGame.getClues(input));
//			}
//			else {
//				System.out.println("INVALID WORD");
//				i -= 1;
//			}
//		}
//		System.out.println("THE SOLUTION WAS " + solution);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
