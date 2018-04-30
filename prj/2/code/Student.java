package code;
class Student {
	private String name;
	private int ID;
	private double GPA;
	private int awardScholarship;
	private int thirdPartyScholarship;
	private int classPerformance;
	private int familyContribution;
	public Student(String name, int ID, double GPA, int awardScholarship, int thirdPartyScholarship,
			int classPerformance, int familyContribution) {
		this.name = name;
		this.ID = ID;
		this.GPA = GPA;
		this.awardScholarship = awardScholarship;
		this.thirdPartyScholarship = thirdPartyScholarship;
		this.classPerformance = classPerformance;
		this.familyContribution = familyContribution;
		}
	Student() {
		}
	public int getClassPerformance() {
		return classPerformance;
		}
	public String getName()	{ 
		return name; 
		}
	public int getID() { 
		return ID; 
		} 
	public double getGPA() {
		return GPA; 
		} 
	public String convertToString() {
		return "Student [name=" + name + ", ID=" + ID + ", GPA=" + GPA + ", awardScholarship=" +
				awardScholarship + ", thirdPartyScholarship=" + thirdPartyScholarship +
				", classPerformance=" + classPerformance + ", familyContribution=" + 
				familyContribution + "]"; 
		}
	public int totalScholarship() {
		return awardScholarship + thirdPartyScholarship + familyContribution;
		}
	}