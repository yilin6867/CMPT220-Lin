import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Course implements Cloneable{
	private String courseName;
	private ArrayList<String> students = new ArrayList<String>(100);
	private int numberOfStudents;
	
	public Course(String courseName) {
		this.courseName = courseName;	
	}
	public void addStudent(String student) {
		if (this.numberOfStudents >= this.students.size()) {
			ArrayList<String> newStudentsList = new ArrayList<>(students);
			newStudentsList.add(student);
			this.students = newStudentsList;
		}
		numberOfStudents++;
	}
	public String[] getStudents() {
		String[] newStudents = new String[numberOfStudents];
		students.toArray(newStudents);
		return newStudents;
	}
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	public String getCourseName() {
		return courseName;
	}
	public void dropStudent(String student) {
		ArrayList<String> newStudentsList = new ArrayList<>(students);
		newStudentsList.remove(student);
		this.students = newStudentsList;
		numberOfStudents--;
	}
	public void clear() {
		ArrayList<String> newStudentsList = new ArrayList<>(this.numberOfStudents);
		newStudentsList.removeAll(this.students);
		this.students = newStudentsList;
		this.numberOfStudents = 0;
	}
	public Object clone() {
		try {
			Course courseClone = (Course)super.clone();
			courseClone.students = (ArrayList<String>)this.students;
			return courseClone;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}