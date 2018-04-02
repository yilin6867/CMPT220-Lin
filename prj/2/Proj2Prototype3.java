import java.sql.*;

public class Proj2Prototype3 {
	public static void main(String[] args) throws SQLException {
		int ID;
		String firstName;
		String lastName;
		double gpa;
		int classPerform;
		int awardSch;
		int thirdSch;
		int famCont;
		String home;
		long tuition = 0;
		long roomAndBoard = 0;
		long bookAndSupplies = 0;
		long personalMiscellaneous = 0;
		double minGPA = 0;
		CollegeGrade studentGrade = new CollegeGrade();
		MaristDB marist = new MaristDB();
		Connection maristDBConnection = marist.connect();
		ResultSet maristData = marist.getData(maristDBConnection);
		if (maristData.next()) {
			tuition = maristData.getLong("TUITION");
			roomAndBoard = maristData.getLong("ROOM_AND_BOARD");
			bookAndSupplies = maristData.getLong("BOOK_AND_SUPPLIES");
			personalMiscellaneous = maristData.getLong("PERSONAL_AND_MISCELLANEOUS");
			minGPA = maristData.getDouble("MINIMUM_GPA");
		}
		maristDBConnection.close();
		
		LocationDB location = new LocationDB();
		Connection locationConnection = location.connect();
		
		StudentDB student = new StudentDB();
		Connection studentDBConnection = student.connect();
		ResultSet studentData = student.getData(studentDBConnection);
		
		while(studentData.next()) {
			ID = studentData.getInt("ID");
			firstName = studentData.getString("FIRST_NAME");
			lastName = studentData.getString("LAST_NAME");
			gpa = studentData.getDouble("GPA");	
			classPerform = studentData.getInt("CLASS_PERFORMANCE");
			awardSch = studentData.getInt("AWARD_SCHOLARSHIP");
			thirdSch = studentData.getInt("THIRD_PARTY_SCHOLARSHIP");
			famCont = studentData.getInt("FAMILY_CONTRIBUTION");
			home = studentData.getString("CITY");
			ResultSet locationData = location.getData(locationConnection, home);
			long studentMoney = awardSch + thirdSch + famCont;
			long needMoney = tuition + roomAndBoard + bookAndSupplies + personalMiscellaneous;
			System.out.println(ID + "\n" + firstName + " " + lastName + "\n" + gpa + "\n");
			if (home == locationData.getString("CITY")) {
				System.out.println("Home: " + home + " is " + locationData.getString("CITY"));
			}
			if (studentMoney < needMoney) {
				long moneyNeed = needMoney - studentMoney;
				System.out.println("The student need " + moneyNeed + " dollar to continue"
						+ " school");
			}
			gpa = ((gpa + studentGrade.getGrade(classPerform)) / 2);
			if (gpa <= minGPA) {
				double requireGPA = minGPA - gpa;
				System.out.println("The student need to increase the GPA by " + requireGPA);
			}
			// use amount of money student need to compare to student's hometown average income to 
			// determine the likelihood student can continue.
		}
		studentDBConnection.close();
	}
}
