import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationDB {
	public LocationDB() {
	}
	public Connection connect() {
		try {
			Connection locationDBconnection = 
					DriverManager.getConnection("jdbc:ucanaccess://"
					+ "C://Users\\Admin\\Desktop\\CompSci\\CMPT220-Lin\\prj\\2\\LocationData.accdb");
			return locationDBconnection;
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
	public ResultSet getData(Connection conn, String location) {
		try {
			Statement locationDBstatement = conn.createStatement();
			ResultSet locationResultSet = locationDBstatement.executeQuery("SELECT * FROM [LocationData]"
					+ " WHERE [CITY]=" + location);
			return locationResultSet;
		}
	    catch(SQLException sqlex) {
	        sqlex.getMessage();
	        sqlex.getCause();
	        sqlex.printStackTrace();
	        return null;
	    }
	}
}