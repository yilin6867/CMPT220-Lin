package code;
import java.sql.*;
import java.util.ArrayList;

public class StudentDB extends Database{
	private ArrayList<Integer> ids = new ArrayList<Integer>();
	private ArrayList<String> firstName = new ArrayList<String>();
	private ArrayList<String> lastName = new ArrayList<String>();
	private ArrayList<Double> gpa = new ArrayList<Double>();
	private ArrayList<Integer> course1Grade = new ArrayList<Integer>();
	private ArrayList<Integer> course2Grade = new ArrayList<Integer>();
	private ArrayList<Integer> course3Grade = new ArrayList<Integer>();
	private ArrayList<Integer> course4Grade = new ArrayList<Integer>();
	private ArrayList<Integer> course5Grade = new ArrayList<Integer>();
	private ArrayList<Integer> course1Credit = new ArrayList<Integer>();
	private ArrayList<Integer> course2Credit = new ArrayList<Integer>();
	private ArrayList<Integer> course3Credit = new ArrayList<Integer>();
	private ArrayList<Integer> course4Credit = new ArrayList<Integer>();
	private ArrayList<Integer> course5Credit = new ArrayList<Integer>();
	private ArrayList<Integer> awardSch = new ArrayList<Integer>();
	private ArrayList<Integer> thirdSch = new ArrayList<Integer>();
	private ArrayList<Integer> famCont = new ArrayList<Integer>();
	private ArrayList<String> home = new ArrayList<String>();
	private ArrayList<String> familyStatus = new ArrayList<String>();
	public StudentDB() throws SQLException {
		Connection studentDBConnection = this.connect();
		this.pullData(studentDBConnection);
		studentDBConnection.close();
	}
	@Override
	public void pullData(Connection conn) {
		try {
			Statement studentDBstatement = conn.createStatement();
			ResultSet studentResultSet = studentDBstatement.executeQuery("SELECT * "
					+ "FROM [StudentData]");
			while(studentResultSet.next()) {
				this.ids.add(studentResultSet.getInt("ID"));
				this.firstName.add(studentResultSet.getString("FIRST_NAME"));
				this.lastName.add(studentResultSet.getString("LAST_NAME"));
				this.gpa.add(studentResultSet.getDouble("GPA"));	
				this.course1Grade.add(studentResultSet.getInt("COURSE1_GRADE"));
				this.course2Grade.add(studentResultSet.getInt("COURSE2_GRADE"));
				this.course3Grade.add(studentResultSet.getInt("COURSE3_GRADE"));
				this.course4Grade.add(studentResultSet.getInt("COURSE4_GRADE"));
				this.course5Grade.add(studentResultSet.getInt("CORUSE5_GRADE"));
				this.course1Credit.add(studentResultSet.getInt("COURSE1_CREDIT"));
				this.course2Credit.add(studentResultSet.getInt("COURSE2_CREDIT"));
				this.course3Credit.add(studentResultSet.getInt("COURSE3_CREDIT"));
				this.course4Credit.add(studentResultSet.getInt("COURSE4_CREDIT"));
				this.course5Credit.add(studentResultSet.getInt("COURSE5_CREDIT"));
				this.awardSch.add(studentResultSet.getInt("AWARD_SCHOLARSHIP"));
				this.thirdSch.add(studentResultSet.getInt("THIRD_PARTY_SCHOLARSHIP"));
				this.famCont.add(studentResultSet.getInt("FAMILY_CONTRIBUTION"));
				this.home.add(studentResultSet.getString("CITY"));
				this.familyStatus.add(studentResultSet.getString("FAMILY_STATUS"));
			}
		}
	    catch(SQLException sqlex) {
	        sqlex.getMessage();
	        sqlex.getCause();
	        sqlex.printStackTrace();
	    }
	}
	public ArrayList<Integer> getIds() {
		return ids;
	}
	public ArrayList<String> getFirstName() {
		return firstName;
	}
	public ArrayList<String> getLastName() {
		return lastName;
	}
	public ArrayList<Double> getGpa() {
		return gpa;
	}
	public ArrayList<Integer> getCourse1Grade() {
		return course1Grade;
	}
	public ArrayList<Integer> getCourse2Grade() {
		return course2Grade;
	}
	public ArrayList<Integer> getCourse3Grade() {
		return course3Grade;
	}
	public ArrayList<Integer> getCourse4Grade() {
		return course4Grade;
	}
	public ArrayList<Integer> getCourse5Grade() {
		return course5Grade;
	}
	public ArrayList<Integer> getCourse1Credit() {
		return course1Credit;
	}
	public ArrayList<Integer> getCourse2Credit() {
		return course2Credit;
	}
	public ArrayList<Integer> getCourse3Credit() {
		return course3Credit;
	}
	public ArrayList<Integer> getCourse4Credit() {
		return course4Credit;
	}
	public ArrayList<Integer> getCourse5Credit() {
		return course5Credit;
	}
	public ArrayList<Integer> getAwardSch() {
		return awardSch;
	}
	public ArrayList<Integer> getThirdSch() {
		return thirdSch;
	}
	public ArrayList<Integer> getFamCont() {
		return famCont;
	}
	public ArrayList<String> getHome() {
		return home;
	}
	public ArrayList<String> getFamilyStatus() {
		return familyStatus;
	}
	public String newToString(int i) {
		return ("|  " 
				+ String.format("%s",this.getIds().get(i)) + "\t|" 
				+ String.format("%s",this.getFirstName().get(i) + this.getLastName().get(i)) + "\t\t|" 
				+ String.format("%7s|",this.getGpa().get(i))
				+ String.format("%s",this.getHome().get(i)) + "\t\t|" 
				+ String.format("%10s",this.getFamilyStatus().get(i)) + "\t\t|");
	}
}