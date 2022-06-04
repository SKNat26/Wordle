package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.File;

import gameUtil.*;

import java.util.Scanner;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		String path = new File("").getAbsolutePath();
		Words wordGame = new Words(path, false);
		String solution = wordGame.getSolution();
		//System.out.println(solution);
		for(int i = 0; i<6; i++) {
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			if(wordGame.checkValidWord(input)) {
				if(input.toLowerCase().equals(solution.toLowerCase())) {
					System.out.println("SOLUTION FOUND!");
					break;
				}
				System.out.println(wordGame.getClues(input));
			}
			else {
				System.out.println("INVALID WORD");
				i -= 1;
			}
		}
		System.out.println("THE SOLUTION WAS " + solution);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
