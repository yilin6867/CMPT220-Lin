import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem12_13 {

	public static void main(String[] args) {
		File targetFile = new File(args[0]);
		if (!targetFile.exists()) {
			System.out.println("Target file " + args[1] + " does not exists");
			System.exit(2);
		}
		try {
			System.out.println("File " + args[0] + " has");
			String characters = "";
			ArrayList<String> words = new ArrayList<String>();
			int lines = 0;
			Scanner inputWord = new Scanner(targetFile);
			while (inputWord.hasNext()) {
				String fileWord = inputWord.next();
				words.add(fileWord);
			}
			Scanner inputLine = new Scanner(targetFile);
			while (inputLine.hasNextLine()) {
				String fileLine = inputLine.nextLine();
				characters = characters + fileLine.replace(" ", "");
				lines = lines + 1;
			}
			System.out.println(characters.length() + " characters");
			System.out.println(words.size() + " words");
			System.out.println(lines + " lines");
			inputWord.close();
			inputLine.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}
	}

}
