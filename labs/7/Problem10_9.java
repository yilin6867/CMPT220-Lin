import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem10_9 {
	public static void main(String[] args) {
		Course cmpt220 = new Course("Software Development I");
		cmpt220.addStudent("Yi Lin");
		cmpt220.addStudent("Rocco");
		cmpt220.addStudent("Ethan");
		String[] students = cmpt220.getStudents();
		System.out.println(cmpt220.getCourseName() + " has " + cmpt220.getNumberOfStudents() +" student");
		for (int i = 0; i < cmpt220.getStudents().length; i++) {
			System.out.print(students[i] + ", ");
		}
		System.out.println();
		System.out.print("Enter the student who dropout: ");
		Scanner input = new Scanner(System.in);
		String dropOut = input.next();
		cmpt220.dropStudent(dropOut);
		System.out.println(cmpt220.getCourseName() + " has " + cmpt220.getNumberOfStudents() + " student");
		for (int i = 0; i < cmpt220.getNumberOfStudents(); i++) {
			System.out.print(students[i] + ", ");
		}
		System.out.println();
		cmpt220.clear();
		if (cmpt220.getNumberOfStudents() == 0)
			System.out.println("At the end of the semester, there is 0 student left in the "
					+ "class.");
	}
}