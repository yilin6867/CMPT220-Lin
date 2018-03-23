import java.util.ArrayList;
import java.util.Arrays;

public class Course {
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	public void addStudent(String student) {
		if (this.numberOfStudents >= this.students.length) {
			ArrayList<String> newStudentsList = new ArrayList<>(Arrays.asList(this.students));
			newStudentsList.add(student);
			this.students = new String[newStudentsList.size()];
			this.students = newStudentsList.toArray(this.students);
		}
		students[numberOfStudents] = student;
		numberOfStudents++;
	}
	public String[] getStudents() {
		String[] newStudents = new String[numberOfStudents];
		System.arraycopy( this.students, 0, newStudents, 0, newStudents.length );
		this.students = newStudents;
		return students;
	}
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	public String getCourseName() {
		return courseName;
	}
	public void dropStudent(String student) {
		ArrayList<String> newStudents = new ArrayList<>(Arrays.asList(this.students));
		newStudents.remove(student);
		this.students = new String[newStudents.size()];
		this.students = newStudents.toArray(this.students);
		numberOfStudents--;
	}
	public void clear() {
		ArrayList<String> newStudents = new ArrayList<>(Arrays.asList(students));
		newStudents.removeAll(newStudents);
		this.students = new String[newStudents.size()];
		this.students = newStudents.toArray(this.students);
		this.numberOfStudents = 0;
	}
}