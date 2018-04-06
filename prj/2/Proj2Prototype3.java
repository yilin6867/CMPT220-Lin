import java.sql.*;

public class Proj2Prototype3 {
	public static void main(String[] args) throws SQLException {
		double preditGPA;
		double sumGPA;
		double sumCredit;
		double preditGPARound;
		double preditGPAThisSemester;
		double fourScalecourse1GPA;
		double fourScalecourse2GPA;
		double fourScalecourse3GPA;
		double fourScalecourse4GPA;
		double fourScalecourse5GPA;
		double requireGPA;
		double requireGPARound;
		CollegeGrade studentGrade = new CollegeGrade();
		
		MaristDB marist = new MaristDB();
		Connection maristDBConnection = marist.connect();
		marist.pullData(maristDBConnection);
		maristDBConnection.close();
		
		LocationDB location = new LocationDB();
		Connection locationConnection = location.connect();
		
		StudentDB student = new StudentDB();
		Connection studentDBConnection = student.connect();
		student.pullData(studentDBConnection);
		int numStudent = student.getIds().size();
		
		for (int i = 0; i < numStudent; i++) {
			location.pullData(locationConnection, student.getHome().get(i));
			long studentMoney = student.getAwardSch().get(i) + student.getThirdSch().get(i)
					+ student.getFamCont().get(i);
			long costOfAttanance = marist.getTuition() + marist.getRoomAndBoard() +
					marist.getBookAndSupplies() + marist.getPersonalMiscellaneous();
			System.out.println("ID: " + student.getIds().get(i) + "\n" + "Name: " + 
			student.getFirstName().get(i) + " " + student.getLastName().get(i) + 
					"\n" + "GPA: " + student.getGpa().get(i));
			System.out.println(student.getFirstName().get(i) + " " + 
					student.getLastName().get(i) + " lives in " + location.getCity() + "\n");
			if (studentMoney < costOfAttanance) {
				long moneyNeed = costOfAttanance - studentMoney;
				System.out.println("The student need " + moneyNeed + " dollar to continue"
						+ " school\n");
			}
			fourScalecourse1GPA = studentGrade.getGrade(student.getCourse1Grade().get(i));
			fourScalecourse2GPA = studentGrade.getGrade(student.getCourse2Grade().get(i));
			fourScalecourse3GPA = studentGrade.getGrade(student.getCourse3Grade().get(i));
			fourScalecourse4GPA = studentGrade.getGrade(student.getCourse4Grade().get(i));
			fourScalecourse5GPA = studentGrade.getGrade(student.getCourse5Grade().get(i));
			sumGPA = (fourScalecourse1GPA * student.getCourse1Credit().get(i)) +
					(fourScalecourse2GPA * student.getCourse2Credit().get(i)) +
					(fourScalecourse3GPA * student.getCourse3Credit().get(i)) +
					(fourScalecourse4GPA * student.getCourse4Credit().get(i)) +
					(fourScalecourse5GPA * student.getCourse5Credit().get(i));
			sumCredit = (student.getCourse1Credit().get(i) + student.getCourse2Credit().get(i) +
					student.getCourse3Credit().get(i) + student.getCourse4Credit().get(i) +
					student.getCourse5Credit().get(i));
			preditGPAThisSemester =  sumGPA / sumCredit; 
			preditGPA = (student.getGpa().get(i) + preditGPAThisSemester) / 2;
			preditGPARound = Math.round(preditGPA * 100.0) / 100.0;
			if (preditGPARound <= marist.getMinGPA()) {
				requireGPA = marist.getMinGPA() - preditGPARound;
				requireGPARound = Math.round(requireGPA * 100.0) / 100.0;
				System.out.println("The student need to increase the GPA by " + requireGPARound +
						" to avoid academic probation");
				System.out.println();
			}
			else {
				System.out.println("By the end of semestet, the student may have gpa: " +
									preditGPARound);
				System.out.println();
			}
		}
			// use amount of money student need to compare to student's hometown average income to 
			// determine the likelihood student can continue.
		studentDBConnection.close();
	}
}
