import java.util.Scanner;

public class LetterGrades {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number grade: ");
		int grade = input.nextInt();
		
		if (grade >= 90) {
			System.out.println("The letter grade is a A");
			System.out.println("Congratulation!");
		}
		else if (grade >= 80) {
			System.out.println("The letter grade is a B");
		}
		else if (grade >= 70) {
			System.out.println("The letter grade is a C");
		}
		else if (grade >= 60) {
			System.out.println("The letter grade is a D");
		}
		else {
			System.out.println("The letter grade is a F");
		}
	}
}
	