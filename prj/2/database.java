import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
	public database() {
	}
	public Connection connect() {
		try {
			Connection dbConnection = 
					DriverManager.getConnection("jdbc:ucanaccess://"
					+ "C:\\Users\\Admin\\Desktop\\CompSci\\CMPT220-Lin\\prj\\2\\database.accdb");
			return dbConnection;
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
	public void pullData(Connection conn) {
		try {
			Statement dbStatement = conn.createStatement();
			ResultSet dbResultSet = dbStatement.executeQuery("SELECT * FROM [MaristData]");
			while (dbResultSet.next()) {
			}
		}
		catch(SQLException sqlex) {
		        sqlex.getMessage();
		        sqlex.getCause();
		        sqlex.printStackTrace();
		    }
		}
}
