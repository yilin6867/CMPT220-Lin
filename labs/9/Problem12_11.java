import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Problem12_11 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("Usage: java Problem12_11 deleteString targetFile");
			System.exit(0);
		}
		String deleteWord = args[0];
		File targetFile = new File(args[1]);
		if (!targetFile.exists()) {
			System.out.println("Target file " + args[1] + " does not exists");
			System.exit(2);
		}
		try {
			Scanner inputFile = new Scanner(targetFile);
			ArrayList<String> fileStringArray = new ArrayList<>();
			while (inputFile.hasNext()) {
				String fileString = inputFile.nextLine();
				String newFileString = fileString.replace(deleteWord, "");
				fileStringArray.add(newFileString);
			}
			targetFile.delete();
			File newFile = new File(args[1]);
			PrintWriter output = new PrintWriter(newFile);
			for (String line: fileStringArray) {
				output.println(line);
			}
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}
		
	}

}
