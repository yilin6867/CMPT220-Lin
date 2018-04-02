import java.sql.*;

public class StudentDB {
	
	public StudentDB() {
	}
	public Connection connect() {
		try {
			Connection studentDBconnection = 
					DriverManager.getConnection("jdbc:ucanaccess://"
							+ "C://Users\\Admin\\Desktop\\CompSci\\CMPT220-Lin\\prj\\2\\Student.accdb");
			return studentDBconnection;
		}
        catch(SQLException sqlex){
        	sqlex.getMessage();
        	sqlex.getCause();
            sqlex.printStackTrace();
            return null;
        }
	}
	public void close(Connection conn) {
		try {
			conn.close();
		}
	    catch(SQLException sqlex) {
	        sqlex.getMessage();
	        sqlex.getCause();
	        sqlex.printStackTrace();
	    }
	}
	public ResultSet getData(Connection conn) {
		try {
			Statement studentDBstatement = conn.createStatement();
			ResultSet studentResultSet = studentDBstatement.executeQuery("SELECT * FROM [StudentData]");
			return studentResultSet;
		}
	    catch(SQLException sqlex) {
	        sqlex.getMessage();
	        sqlex.getCause();
	        sqlex.printStackTrace();
	        return null;
	    }
	}
}