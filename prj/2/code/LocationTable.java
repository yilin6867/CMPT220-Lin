package code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationTable extends Database{
	private String city;
	private String state;
	private int totalHousehold;
	private int families;
	private int marriedCouple;
	private int nonfamily;
	private int totalHouseholdMedianIncome;
	private int familiesMedianIncome;
	private int marriedCoupleMedianIncome;
	private int nonfamilyMedianIncome;
	private int totalHouseholdMeanIncome;
	private int familiesMeanIncome;
	private int marriedCoupleMeanIncome;
	private int nonfamilyMeanIncome;
	private double less10kHouseholdPer;
	private double less10kFamiliesPer;
	private double less10kMarriedCouplePer;
	private double less10kNonfamilyPer;
	private double less15kHouseholdPer;
	private double less15kFamiliesPer;
	private double less15kMarriedCouplePer;
	private double less15kNonfamilyPer;
	private double less25kHouseholdPer;
	private double less25kFamiliesPer;
	private double less25kMarriedCouplePer;
	private double less25kNonfamilyPer;
	private double less35kHouseholdPer;
	private double less35kFamiliesPer;
	private double less35kMarriedCouplePer;
	private double less35kNonfamilyPer;
	private double less50kHouseholdPer;
	private double less50kFamiliesPer;
	private double less50kMarriedCouplePer;
	private double less50kNonfamilyPer;
	private double less75kHouseholdPer;
	private double less75kFamiliesPer;
	private double less75kMarriedCouplePer;
	private double less75kNonfamilyPer;
	private double less100kHouseholdPer;
	private double less100kFamiliesPer;
	private double less100kMarriedCouplePer;
	private double less100kNonfamilyPer;
	private double less150kHouseholdPer;
	private double less150kFamiliesPer;
	private double less150kMarriedCouplePer;
	private double less150kNonfamilyPer;
	private double less200kHouseholdPer;
	private double less200kFamiliesPer;
	private double less200kMarriedCouplePer;
	private double less200kNonfamilyPer;
	private double more200kHouseholdPer;
	private double more200kFamiliesPer;
	private double more200kMarriedCouplePer;
	private double more200kNonfamilyPer;
	private int familyCostOfLiving;
	public LocationTable() {
	}
	public void pullData(Connection conn, String home) {
		try {
			Statement locationDBstatement = conn.createStatement();
			ResultSet locationResultSet = locationDBstatement.executeQuery("SELECT * FROM"
					+ " [LocationData] WHERE CITY = '" + home + "'");
			while (locationResultSet.next()) {
				this.city = locationResultSet.getString("CITY");
				this.state = locationResultSet.getString("STATE");
				this.totalHousehold = locationResultSet.getInt("Households; Estimate; Total");
				this.families = locationResultSet.getInt("Families; Estimate; Total");
				this.marriedCouple = locationResultSet.getInt("Married-couple families; Estimate; Total");
				this.nonfamily = locationResultSet.getInt("Nonfamily households; Estimate; Total");
				this.totalHouseholdMedianIncome = locationResultSet.getInt("Households; Estimate; Median income (dollars)");
				this.familiesMedianIncome = locationResultSet.getInt("Families; Estimate; Median income (dollars)");
				this.marriedCoupleMedianIncome = locationResultSet.getInt("Married-couple families; Estimate; Median income (dollars)");
				this.nonfamilyMedianIncome = locationResultSet.getInt("Nonfamily households; Estimate; Median income (dollars)");
				this.totalHouseholdMeanIncome = locationResultSet.getInt("Households; Estimate; Mean income (dollars)");
				this.familiesMeanIncome = locationResultSet.getInt("Families; Estimate; Mean income (dollars)");
				this.marriedCoupleMeanIncome = locationResultSet.getInt("Married-couple families; Estimate; Mean income (dollars)");
				this.nonfamilyMeanIncome = locationResultSet.getInt("Nonfamily households; Estimate; Mean income (dollars)");
				this.less10kHouseholdPer = locationResultSet.getInt("Households; Estimate; Less than $10,000");
				this.less10kFamiliesPer = locationResultSet.getDouble("Families; Estimate; Less than $10,000");
				this.less10kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; Less than $10,000");
				this.less10kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; Less than $10,000");
				this.less15kHouseholdPer = locationResultSet.getDouble("Households; Estimate; $10,000 to $14,999");
				this.less15kFamiliesPer = locationResultSet.getDouble("Families; Estimate; $10,000 to $14,999");
				this.less15kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; $10,000 to $14,999");
				this.less15kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; $10,000 to $14,999");
				this.less25kHouseholdPer = locationResultSet.getDouble("Households; Estimate; $15,000 to $24,999");
				this.less25kFamiliesPer = locationResultSet.getDouble("Families; Estimate; $15,000 to $24,999");
				this.less25kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; $15,000 to $24,999");
				this.less25kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; $15,000 to $24,999");
				this.less35kHouseholdPer = locationResultSet.getDouble("Households; Estimate; $25,000 to $34,999");
				this.less35kFamiliesPer = locationResultSet.getDouble("Families; Estimate; $25,000 to $34,999");
				this.less35kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; $25,000 to $34,999");
				this.less35kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; $25,000 to $34,999");
				this.less50kHouseholdPer = locationResultSet.getDouble("Households; Estimate; $35,000 to $49,999");
				this.less50kFamiliesPer = locationResultSet.getDouble("Families; Estimate; $35,000 to $49,999");
				this.less50kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; $35,000 to $49,999");
				this.less50kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; $35,000 to $49,999");
				this.less75kHouseholdPer = locationResultSet.getDouble("Households; Estimate; $50,000 to $74,999");
				this.less75kFamiliesPer = locationResultSet.getDouble("Families; Estimate; $50,000 to $74,999");
				this.less75kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; $50,000 to $74,999");
				this.less75kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; $50,000 to $74,999");
				this.less100kHouseholdPer = locationResultSet.getDouble("Households; Estimate; $75,000 to $99,999");
				this.less100kFamiliesPer = locationResultSet.getDouble("Families; Estimate; $75,000 to $99,999");
				this.less100kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; $75,000 to $99,999");
				this.less100kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; $75,000 to $99,999");
				this.less150kHouseholdPer = locationResultSet.getDouble("Households; Estimate; $100,000 to $149,999");
				this.less150kFamiliesPer = locationResultSet.getDouble("Families; Estimate; $100,000 to $149,999");
				this.less150kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; $100,000 to $149,999");
				this.less150kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; $100,000 to $149,999");
				this.less200kHouseholdPer = locationResultSet.getDouble("Households; Estimate; $150,000 to $199,999");
				this.less200kFamiliesPer = locationResultSet.getDouble("Families; Estimate; $150,000 to $199,999");
				this.less200kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; $150,000 to $199,999");
				this.less200kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; $150,000 to $199,999");
				this.more200kHouseholdPer = locationResultSet.getDouble("Households; Estimate; $200,000 or more");
				this.more200kFamiliesPer = locationResultSet.getDouble("Families; Estimate; $200,000 or more");
				this.more200kMarriedCouplePer = locationResultSet.getDouble("Married-couple families; Estimate; $200,000 or more");
				this.more200kNonfamilyPer = locationResultSet.getDouble("Nonfamily households; Estimate; $200,000 or more");
				this.familyCostOfLiving = locationResultSet.getInt("FAMILY_COST_OF_LIVING");
			}
		}
	    catch(SQLException sqlex) {
	        sqlex.getMessage();
	        sqlex.getCause();
	        sqlex.printStackTrace();
	    }
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getTotalHousehold() {
		return totalHousehold;
	}
	public int getFamilies() {
		return families;
	}
	public int getMarriedCouple() {
		return marriedCouple;
	}
	public int getNonfamily() {
		return nonfamily;
	}
	public int getTotalHouseholdMedianIncome() {
		return totalHouseholdMedianIncome;
	}
	public int getFamiliesMedianIncome() {
		return familiesMedianIncome;
	}
	public int getMarriedCoupleMedianIncome() {
		return marriedCoupleMedianIncome;
	}
	public int getNonfamilyMedianIncome() {
		return nonfamilyMedianIncome;
	}
	public int getTotalHouseholdMeanIncome() {
		return totalHouseholdMeanIncome;
	}
	public int getFamiliesMeanIncome() {
		return familiesMeanIncome;
	}
	public int getMarriedCoupleMeanIncome() {
		return marriedCoupleMeanIncome;
	}
	public int getNonfamilyMeanIncome() {
		return nonfamilyMeanIncome;
	}
	public double getLess10kHouseholdPer() {
		return less10kHouseholdPer;
	}
	public double getLess10kFamiliesPer() {
		return less10kFamiliesPer;
	}
	public double getLess10kMarriedCouplePer() {
		return less10kMarriedCouplePer;
	}
	public double getLess10kNonfamilyPer() {
		return less10kNonfamilyPer;
	}
	public double getLess15kHouseholdPer() {
		return less15kHouseholdPer;
	}
	public double getLess15kFamiliesPer() {
		return less15kFamiliesPer;
	}
	public double getLess15kMarriedCouplePer() {
		return less15kMarriedCouplePer;
	}
	public double getLess15kNonfamilyPer() {
		return less15kNonfamilyPer;
	}
	public double getLess25kHouseholdPer() {
		return less25kHouseholdPer;
	}
	public double getLess25kFamiliesPer() {
		return less25kFamiliesPer;
	}
	public double getLess25kMarriedCouplePer() {
		return less25kMarriedCouplePer;
	}
	public double getLess25kNonfamilyPer() {
		return less25kNonfamilyPer;
	}
	public double getLess35kHouseholdPer() {
		return less35kHouseholdPer;
	}
	public double getLess35kFamiliesPer() {
		return less35kFamiliesPer;
	}
	public double getLess35kMarriedCouplePer() {
		return less35kMarriedCouplePer;
	}
	public double getLess35kNonfamilyPer() {
		return less35kNonfamilyPer;
	}
	public double getLess50kHouseholdPer() {
		return less50kHouseholdPer;
	}
	public double getLess50kFamiliesPer() {
		return less50kFamiliesPer;
	}
	public double getLess50kMarriedCouplePer() {
		return less50kMarriedCouplePer;
	}
	public double getLess50kNonfamilyPer() {
		return less50kNonfamilyPer;
	}
	public double getLess75kHouseholdPer() {
		return less75kHouseholdPer;
	}
	public double getLess75kFamiliesPer() {
		return less75kFamiliesPer;
	}
	public double getLess75kMarriedCouplePer() {
		return less75kMarriedCouplePer;
	}
	public double getLess75kNonfamilyPer() {
		return less75kNonfamilyPer;
	}
	public double getLess100kHouseholdPer() {
		return less100kHouseholdPer;
	}
	public double getLess100kFamiliesPer() {
		return less100kFamiliesPer;
	}
	public double getLess100kMarriedCouplePer() {
		return less100kMarriedCouplePer;
	}
	public double getLess100kNonfamilyPer() {
		return less100kNonfamilyPer;
	}
	public double getLess150kHouseholdPer() {
		return less150kHouseholdPer;
	}
	public double getLess150kFamiliesPer() {
		return less150kFamiliesPer;
	}
	public double getLess150kMarriedCouplePer() {
		return less150kMarriedCouplePer;
	}
	public double getLess150kNonfamilyPer() {
		return less150kNonfamilyPer;
	}
	public double getLess200kHouseholdPer() {
		return less200kHouseholdPer;
	}
	public double getLess200kFamiliesPer() {
		return less200kFamiliesPer;
	}
	public double getLess200kMarriedCouplePer() {
		return less200kMarriedCouplePer;
	}
	public double getLess200kNonfamilyPer() {
		return less200kNonfamilyPer;
	}
	public double getMore200kHouseholdPer() {
		return more200kHouseholdPer;
	}
	public double getMore200kFamiliesPer() {
		return more200kFamiliesPer;
	}
	public double getMore200kMarriedCouplePer() {
		return more200kMarriedCouplePer;
	}
	public double getMore200kNonfamilyPer() {
		return more200kNonfamilyPer;
	}
	public int getFamilyCostOfLiving() {
		return familyCostOfLiving;
	}
	
}