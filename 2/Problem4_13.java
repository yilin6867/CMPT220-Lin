import java.util.*;

public class Problem4_13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a letter: ");
		char character = input.next().charAt(0);
		if (((int)character >= 65 && (int)character <= 90) || character >= 97 && character <= 122) 
		{
			if (character != 'a' && character != 'A' && character != 'e' && character != 'E' &&
					character != 'i' && character != 'I' && character != 'o' && character != 'O' &&
					character != 'u' && character != 'U') {
				System.out.print(character + " is a consonant.");
			}
			else {
				System.out.print(character + " is a vowel.");
			}
		}
		else {
			System.out.print(character + " is  an invalid input.");
		}
	}
}