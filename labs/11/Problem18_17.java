import java.util.ArrayList;
import java.util.Scanner;

public class Problem18_17 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an array of  8 character to be search "
				+ "(Enter 'end' to stop): ");
		ArrayList<String> list = new ArrayList();
		for (int i = 0; i < 8; i++) {
			list.add(input.next());
		}
		char[] characterList = list.toString().toCharArray();
		System.out.print("Enter a letter to search for: ");
		char a = input.next().charAt(0);
		String stringCharacter = "";
		for (int i = 0; i < 8; i++) {
			stringCharacter = stringCharacter + list.get(i) + " ";
		}
		System.out.println("In array, " + stringCharacter + "there is " 
							+ count(characterList, a) + " occured");
	}
	public static int count(char[] characterList, char a) {
		if (characterList.length == 0) {
			System.out.println("This is an empty string");
			return 0;
		}
		else {
			int high = 0;
			return count(characterList, a, high);
		}
	}
	public static int count(char[] characterList, char a, int high) {
		String stringCharacterList = String.valueOf(characterList);
		if (stringCharacterList.indexOf(a) == -1) {
			return high;
		}
		else {
			stringCharacterList = 
					stringCharacterList.substring(stringCharacterList.indexOf(a) + 1);
			char[] newCharacterList = stringCharacterList.toCharArray();
			return count(newCharacterList, a, high +1);
		}
	}
}
