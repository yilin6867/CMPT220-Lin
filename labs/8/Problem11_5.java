import java.util.Arrays;

public class Problem11_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course cmpt220 = new Course("Software Development I");
		cmpt220.addStudent("Alex");
		cmpt220.addStudent("Brown");
		cmpt220.addStudent("Cameron");
		System.out.println(cmpt220.getCourseName() + " has " + cmpt220.getNumberOfStudents() +
				" students");
		System.out.println(Arrays.toString(cmpt220.getStudents()));
		cmpt220.dropStudent("Alex");
		System.out.println("Alex drop " + cmpt220.getCourseName());
		System.out.println(cmpt220.getCourseName() + " has " + cmpt220.getNumberOfStudents() 
		+ " students");
		System.out.println(Arrays.toString(cmpt220.getStudents()));
		cmpt220.clear();
		System.out.println("At the end of the semester, " + cmpt220.getCourseName() + " has " 
		+ cmpt220.getNumberOfStudents() + " students");
		System.out.println(Arrays.toString(cmpt220.getStudents()));
	}

}
