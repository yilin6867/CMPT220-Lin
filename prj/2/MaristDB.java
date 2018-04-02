import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MaristDB {
	
	public MaristDB() {
	}
	public Connection connect() {
		try {
			Connection maristDBconnection = 
					DriverManager.getConnection("jdbc:ucanaccess://"
							+ "C://Users\\Admin\\Desktop\\CompSci\\CMPT220-Lin\\prj\\2\\Marist.accdb");
			return maristDBconnection;
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
			Statement maristDBstatement = conn.createStatement();
			ResultSet maristResultSet = maristDBstatement.executeQuery("SELECT * FROM [MaristData]");
			return maristResultSet;
		}
	    catch(SQLException sqlex) {
	        sqlex.getMessage();
	        sqlex.getCause();
	        sqlex.printStackTrace();
	        return null;
	    }
	}
}