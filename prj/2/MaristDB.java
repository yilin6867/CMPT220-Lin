import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MaristDB extends Database{
	private long tuition;
	private long roomAndBoard;
	private long bookAndSupplies;
	private long personalMiscellaneous;
	private double minGPA;
	
	public MaristDB() throws SQLException {
		Connection maristDBConnection = this.connect();
		this.pullData(maristDBConnection);
		maristDBConnection.close();
	}
	@Override
	public void pullData(Connection conn) {
		try {
			Statement maristDBstatement = conn.createStatement();
			ResultSet maristResultSet = maristDBstatement.executeQuery("SELECT * FROM [MaristData]");
			while (maristResultSet.next()) {
				this.tuition = maristResultSet.getLong("TUITION");
				this.roomAndBoard = maristResultSet.getLong("ROOM_AND_BOARD");
				this.bookAndSupplies = maristResultSet.getLong("BOOK_AND_SUPPLIES");
				this.personalMiscellaneous = maristResultSet.getLong("PERSONAL_AND_MISCELLANEOUS");
				this.minGPA = maristResultSet.getDouble("MINIMUM_GPA");
			}
		}
	    catch(SQLException sqlex) {
	        sqlex.getMessage();
	        sqlex.getCause();
	        sqlex.printStackTrace();
	    }
	}
	public long getTuition() {
		return tuition;
	}
	public long getRoomAndBoard() {
		return roomAndBoard;
	}
	public long getBookAndSupplies() {
		return bookAndSupplies;
	}
	public long getPersonalMiscellaneous() {
		return personalMiscellaneous;
	}
	public double getMinGPA() {
		return minGPA;
	}
}