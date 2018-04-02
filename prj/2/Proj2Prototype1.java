import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// http://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html

public class Proj2Prototype1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//System.out.print("Please enter the student's name to be calculate for retention rate: ");
		//String studentName = input.next();
		csvReaderInJava();
	}
	private static void csvReaderInJava() {
		List<Student> students = readStudentFromCSV("Student.csv");
		List<Marist> maristData = readMaristFromCSV("Marist.csv");
		// let's print all the person read from CSV file 
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			Marist marist = maristData.get(0);
			if (student.totalScholarship() < marist.costOfAttendent()) {
				int moneyNeed = marist.costOfAttendent() - student.totalScholarship();
				System.out.println("The student need " + moneyNeed + " dollar to continue"
						+ "school");
			}
			if (student.getGPA() <= marist.requireGPAMeritScholarship()) {
				double requireGPA = marist.requireGPAMeritScholarship() - student.getGPA();
				System.out.println("The student need to increase the GPA by" + requireGPA);
			}
		}
	}
	
	private static List<Student> readStudentFromCSV(String studentFileName) { 
		List<Student> students = new ArrayList<>();
		Path pathToStudentFile = FileSystems.getDefault().getPath("2", studentFileName);
		// create an instance of BufferedReader 
		// using try with resource, Java 7 feature to close resources 
		try {
			BufferedReader studentfile = Files.newBufferedReader(pathToStudentFile,
					StandardCharsets.US_ASCII);
			// read the first line from the text file 
			String studentFileLine = studentfile.readLine();
			// loop until all lines are read
			while (studentFileLine != null) { 
				// use string.split to load a string array with the values from 
				// each line of // the file, using a comma as the delimiter
				String[] attributes = studentFileLine.split(",");
				Student student = createStudent(attributes);
				// adding book into ArrayList
				students.add(student); 
				// read next line before looping 
				// if end of file reached, line would be null
				studentFileLine = studentfile.readLine(); 
				}
			} 
		catch (IOException ioe) { 
			ioe.printStackTrace(); 
		}
		return students; 
	}
	private static List<Marist> readMaristFromCSV(String maristFileName) {
		List<Marist> maristData = new ArrayList<>();	
		Path pathToMaristFile = FileSystems.getDefault().getPath("2", maristFileName);
		try {
			BufferedReader maristCollegeFile = Files.newBufferedReader(pathToMaristFile,
					StandardCharsets.US_ASCII);
			String maristFileLine = maristCollegeFile.readLine();
			while (maristFileLine != null) {
				String[] attributes = maristFileLine.split(",");
				Marist marist = createMarist(attributes);
				maristData.add(marist);
			}
		}
		catch (IOException ioe) { 
			ioe.printStackTrace(); 
		}
		return maristData; 
	}
	private static Student createStudent(String[] metadata){
		String name = metadata[0]; 
		int ID = Integer.parseInt(metadata[1]);
		double GPA = Double.parseDouble(metadata[2]);
		int awardScholarship = Integer.parseInt(metadata[3]);
		int thirdPartyScholarship = Integer.parseInt(metadata[4]);
		int classPerformance = Integer.parseInt(metadata[5]);
		int familyContribution = Integer.parseInt(metadata[6]);
		return new Student(name, ID, GPA, awardScholarship, thirdPartyScholarship, classPerformance,
				familyContribution); 
		}
	private static Marist createMarist(String[] metadata){
		int tuition = Integer.parseInt(metadata[0]);
		int roomAndBoard = Integer.parseInt(metadata[1]);
		int bookAndSupplies = Integer.parseInt(metadata[2]);
		int personalMiscellaneous = Integer.parseInt(metadata[3]);
		return new Marist(tuition, roomAndBoard, bookAndSupplies, personalMiscellaneous);
		}
} 
