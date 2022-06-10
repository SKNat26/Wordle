package gameUtil;

import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Words {
	private String solution;
	private boolean difficult;
	private String path;
	
	public Words(String path, boolean difficult){
		WordFileMaker fileMaker = new WordFileMaker(path);
		fileMaker.createWordFile(5, "FiveLetterWords");
		fileMaker.createWordFile(6, "SixLetterWords");
		this.difficult = difficult;
		this.path = path;
		this.solution = createSolution();
	}
	
	private String createSolution() {		
		try {
			File LetterWords;
			if(this.difficult) {
				LetterWords = new File(this.path + "\\src\\gameUtil\\SixLetterWords.txt");
			}
			else {
				LetterWords = new File(this.path + "\\src\\gameUtil\\FiveLetterWords.txt");
			}
			Scanner scan = new Scanner(LetterWords);
			int length = lengthOfFile(LetterWords);
			int random = (int)(Math.random()*length+1);
			int count = 0;
			while(scan.hasNextLine()) {
				String match = scan.nextLine();
				if(count == random) {
					return match;
				}
				count++;
			}
			scan.close();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int lengthOfFile(File file) {
		try {
			Scanner scan = new Scanner(file);
			int length = 0;
			while(scan.hasNextLine()) {
				scan.nextLine();
				length++;
			}
			scan.close();
			return length;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean checkValidWord(String word) {		
		try {
			File LetterWords;
			if(this.difficult) {
				LetterWords = new File(this.path + "\\src\\gameUtil\\SixLetterWords.txt");
			}
			else {
				LetterWords = new File(this.path + "\\src\\gameUtil\\FiveLetterWords.txt");
			}
			Scanner scan = new Scanner(LetterWords);
			while(scan.hasNextLine()) {
				if(word.equals(scan.nextLine())) {
					return true;
				}
			}
			scan.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public String getClues(String answer) {
		String clues = "";
		for(int i = 0; i<answer.length(); i++) {
			if(answer.substring(i,i+1).equals(solution.substring(i,i+1))) {
				clues+="X";
			}
			else if(solution.indexOf(answer.substring(i,i+1))!=-1){
				clues+="O";
			}
			else {
				clues+="-";
			}
		}
		return clues;
	}
	
	public String getSolution() {
		return solution;
	}
}


