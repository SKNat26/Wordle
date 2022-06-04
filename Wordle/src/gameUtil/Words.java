package gameUtil;

import gameUtil.WordFileMaker;
import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Words {
	private String solution;
	private boolean dificult;
	private String path;
	
	public Words(String path, boolean dificult){
		WordFileMaker fileMaker = new WordFileMaker(path);
		fileMaker.createWordFile(5, "FiveLetterWords");
		fileMaker.createWordFile(6, "SixLetterWords");
		this.dificult = dificult;
		this.path = path;
		this.solution = createSolution(this.dificult);
	}
	
	private String createSolution(boolean dificult) {
		if(dificult) {
			try {
				File SixLetterWords = new File(this.path + "\\src\\gameUtil\\SixLetterWords.txt");
				Scanner scan = new Scanner(SixLetterWords);
				int length = lengthOfFile(SixLetterWords);
				int random = (int)(Math.random()*length+1);
				int count = 0;
				while(scan.hasNextLine()) {
					String match = scan.nextLine();
					if(count==random) {
						return match;
					}
					count++;
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		try {
			File FiveLetterWords = new File(this.path + "\\src\\gameUtil\\FiveLetterWords.txt");
			Scanner scan = new Scanner(FiveLetterWords);
			int length = lengthOfFile(FiveLetterWords);
			int random = (int)(Math.random()*length+1);
			int count = 0;
			while(scan.hasNextLine()) {
				String match = scan.nextLine();
				if(count==random) {
					return match;
				}
				count++;
			}
		}
		catch(FileNotFoundException e) {
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
			return length;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean checkValidWord(String word) {
		if(this.dificult) {
			try {
				File SixLetterWords = new File(this.path + "\\src\\gameUtil\\SixLetterWords.txt");
				Scanner scan = new Scanner(SixLetterWords);
				int length = lengthOfFile(SixLetterWords);
				while(scan.hasNextLine()) {
					if(word.equals(scan.nextLine())) {
						return true;
					}
				}
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		try {
			File FiveLetterWords = new File(this.path + "\\src\\gameUtil\\FiveLetterWords.txt");
			Scanner scan = new Scanner(FiveLetterWords);
			int length = lengthOfFile(FiveLetterWords);
			while(scan.hasNextLine()) {
				if(word.equals(scan.nextLine())) {
					return true;
				}
			}
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


