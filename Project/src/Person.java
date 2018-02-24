import java.util.Date;

public class Person {
	private String name;
	private Date dob;
	private String ssn;
	private static int numberOfPeople;
	//no arg constructor
	Person() {
		dob = new Date(1970, 12, 2);
		numberOfPeople++;
	}
	
	Person(String name, Date dob, String ssn) {
		this();
		this.name = name;
		this.dob = dob;
		this.ssn = ssn;
	}

	public int getAge() {
		long ageInMillis = new Date().getTime() - dob.getTime();
		
		Date age = new Date(ageInMillis);
		
		return age.getYear() + 1900;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getDob() {
		return (Date) dob.clone();
	}
	public static int getNumberOfPeople() {
		return numberOfPeople;
	}
}