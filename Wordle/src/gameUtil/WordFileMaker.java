package gameUtil;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/*
 * This class is used to make the word files from the original file.
 * The original txt file is obtained from http://app.aspell.net/create?defaults=en_US
 */
public class WordFileMaker {
	private String path;
	
	public WordFileMaker(String path) {
		this.path = path;
	}
	
	public void createWordFile(int letters, String name) {
		try {
			File AllWords = new File(path + "\\src\\gameUtil\\AllWords.txt");
			File FiveLetters = new File(path + "\\src\\gameUtil\\" + name + ".txt");
			FileWriter writer = new FileWriter(FiveLetters);
			
			Scanner scan = new Scanner(AllWords);
			
			if(FiveLetters.createNewFile()) {
				System.out.println("File Created");
			}
			else {
				System.out.println("File Exists");
				//return;
			}
			
			while(scan.hasNextLine()) {
				String copy = scan.nextLine();
				if(copy.length() == letters && !copy.substring(copy.length()-2,copy.length()-1).equals("\'")) {
					writer.write(copy.toLowerCase() + "\n");
				}
			}
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
