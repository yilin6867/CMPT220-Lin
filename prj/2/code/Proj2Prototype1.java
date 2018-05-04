package code;
import java.sql.*;

public class Proj2Prototype1 {
	public static void main(String[] args) {
		//Scanner input = new Scanner(System.in);
		//System.out.print("Please enter the student's name to be calculate for retention rate: ");
		//String studentName = input.next();
		msAccessDatabaseConnectionInJava8();
	}
	public static void msAccessDatabaseConnectionInJava8() {
		Connection maristDBconnection = null;
		Connection studentDBconnection = null;
		Statement maristDBstatement = null;
		Statement studentDBstatement = null;
		ResultSet maristResultSet = null;
		ResultSet studentResultSet = null;
        // Step 1: Loading or registering Oracle JDBC driver class
        try {
        	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {

            //String maristDB = "C:/Users/Admin/Desktop/CompSci/CMPT220-Lin/prj/2/Marist.accdb";
            String studentDB = "C:/Users/Admin/Desktop/CompSci/CMPT220-Lin/prj/2/Student.accdb";
            //String maristDBurl = "jdbc:ucanaccess://" + maristDB;
            String studentDBurl = "jdbc:ucanaccess://" + studentDB;

            // Step 2.A: Create and get connection using DriverManager class
            //maristDBconnection = DriverManager.getConnection(maristDBurl);
            studentDBconnection = DriverManager.getConnection(studentDBurl);

            // Step 2.B: Creating JDBC Statement 
            //maristDBstatement = maristDBconnection.createStatement();
            studentDBstatement = studentDBconnection.createStatement();

            // Step 2.C: Executing SQL & retrieve data into ResultSet
            //maristResultSet = maristDBstatement.executeQuery("SELECT * FROM MARIST");
            studentResultSet = studentDBstatement.executeQuery("SELECT * FROM STUDENT");
            
            // processing returned data and printing into console
            while(studentResultSet.next()) {
                System.out.println(studentResultSet.getInt(1) + "\t" + 
                		studentResultSet.getString(2) + "\t" + 
                		studentResultSet.getString(3) + "\t" +
                		studentResultSet.getInt(4) + "\t" +
                		studentResultSet.getInt(5) + "\t" +
                		studentResultSet.getInt(6) + "\t" +
                		studentResultSet.getInt(7) + "\t" +
                		studentResultSet.getInt(8));
            }
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
        finally {

            // Step 3: Closing database connection
            try {
				if(studentDBconnection != null) {

                    // cleanup resources, once after processing
					//maristResultSet.close();
					studentResultSet.close();
                    //maristDBstatement.close();
                    studentDBstatement.close();

                    // and then finally close connection
                    //maristDBconnection.close();
                    studentDBconnection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
    }

} 
