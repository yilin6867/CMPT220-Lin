import java.sql.*;

public class Proj2Prototype3 {
	public static void main(String[] args) throws SQLException {
		double preditGPA;
		double sumGPA;
		double sumCredit;
		double preditGPARound;
		double preditGPAThisSemester;
		double fourScalecourse1GPA;
		double fourScalecourse2GPA;
		double fourScalecourse3GPA;
		double fourScalecourse4GPA;
		double fourScalecourse5GPA;
		double requireGPA;
		double requireGPARound;
		double possibility = 0;
		String familyStatus;
		double moneyContribute;
		double possibilityRound;
		CollegeGrade studentGrade = new CollegeGrade();
		
		MaristDB marist = new MaristDB();
		Connection maristDBConnection = marist.connect();
		marist.pullData(maristDBConnection);
		maristDBConnection.close();
		
		LocationDB location = new LocationDB();
		Connection locationConnection = location.connect();
		
		StudentDB student = new StudentDB();
		Connection studentDBConnection = student.connect();
		student.pullData(studentDBConnection);
		int numStudent = student.getIds().size();
		
		for (int i = 0; i < numStudent; i++) {
			location.pullData(locationConnection, student.getHome().get(i));
			long studentMoney = student.getAwardSch().get(i) + student.getThirdSch().get(i)
					+ student.getFamCont().get(i);
			long costOfAttanance = marist.getTuition() + marist.getRoomAndBoard() +
					marist.getBookAndSupplies() + marist.getPersonalMiscellaneous();
			System.out.println("ID: " + student.getIds().get(i) + "\n" + "Name: " + 
			student.getFirstName().get(i) + " " + student.getLastName().get(i) + 
					"\n" + "GPA: " + student.getGpa().get(i));
			System.out.println(student.getFirstName().get(i) + " " + 
					student.getLastName().get(i) + " lives in " + location.getCity() + "\n");
			System.out.println(student.getFirstName().get(i) + student.getLastName().get(i) + 
					" is " + student.getFamilyStatus().get(i));
			long moneyNeed = costOfAttanance - studentMoney;
			if (studentMoney < costOfAttanance) {
				familyStatus = student.getFamilyStatus().get(i);
				if (familyStatus.equals("Dependent")) {
					if (location.getFamilyCostOfLiving() < 10000) {
						double[] possibilityList = 
							{location.getLess10kFamiliesPer(), location.getLess15kFamiliesPer(), 
							 location.getLess25kFamiliesPer(), location.getLess35kFamiliesPer(),
							 location.getLess50kFamiliesPer(), location.getLess75kFamiliesPer(), 
							 location.getLess100kFamiliesPer(), location.getLess150kFamiliesPer(),
							 location.getLess200kFamiliesPer(), location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {10000, 15000, 25000, 35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() + 
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 15000) {
						double[] possibilityList = 
							{location.getLess15kFamiliesPer(), 
							 location.getLess25kFamiliesPer(), location.getLess35kFamiliesPer(),
							 location.getLess50kFamiliesPer(), location.getLess75kFamiliesPer(), 
							 location.getLess100kFamiliesPer(), location.getLess150kFamiliesPer(),
							 location.getLess200kFamiliesPer(), location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {15000, 25000, 35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() 
														+ costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 25000) {
						double[] possibilityList = 
							{location.getLess25kFamiliesPer(), location.getLess35kFamiliesPer(),
							 location.getLess50kFamiliesPer(), location.getLess75kFamiliesPer(), 
							 location.getLess100kFamiliesPer(), location.getLess150kFamiliesPer(),
							 location.getLess200kFamiliesPer(), location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {25000, 35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 35000) {
						double[] possibilityList = 
							{location.getLess35kFamiliesPer(),
							 location.getLess50kFamiliesPer(), location.getLess75kFamiliesPer(), 
							 location.getLess100kFamiliesPer(), location.getLess150kFamiliesPer(),
							 location.getLess200kFamiliesPer(), location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 50000) {
						double[] possibilityList = 
							{location.getLess50kFamiliesPer(), location.getLess75kFamiliesPer(), 
							 location.getLess100kFamiliesPer(), location.getLess150kFamiliesPer(),
							 location.getLess200kFamiliesPer(), location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 75000) {
						double[] possibilityList = 
							{location.getLess75kFamiliesPer(), 
							 location.getLess100kFamiliesPer(), location.getLess150kFamiliesPer(),
							 location.getLess200kFamiliesPer(), location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 100000) {
						double[] possibilityList = 
							{location.getLess100kFamiliesPer(), location.getLess150kFamiliesPer(),
							 location.getLess200kFamiliesPer(), location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 150000) { 
						double[] possibilityList = 
							{location.getLess150kFamiliesPer(),
							 location.getLess200kFamiliesPer(), location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {150000, 200000, (location.getFamilyCostOfLiving() +
								costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 200000) {
						double[] possibilityList = 
							{location.getLess200kFamiliesPer(), location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {200000, (location.getFamilyCostOfLiving() + 
								costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else {
						double[] possibilityList = 
							{location.getMore200kFamiliesPer(),
								};
						double[] moneyLevel = {(location.getFamilyCostOfLiving() + costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
				}
				else if (student.getFamilyStatus().get(i).equals("Married")) {
					if (location.getFamilyCostOfLiving() < 10000) {
						double[] possibilityList = 
							{location.getLess10kMarriedCouplePer(), location.getLess15kMarriedCouplePer(), 
							 location.getLess25kMarriedCouplePer(), location.getLess35kMarriedCouplePer(),
							 location.getLess50kMarriedCouplePer(), location.getLess75kMarriedCouplePer(), 
							 location.getLess100kMarriedCouplePer(),location.getLess150kMarriedCouplePer(),
							 location.getLess200kMarriedCouplePer(), location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {10000, 15000, 25000, 35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() + 
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 15000) {
						double[] possibilityList = 
							{location.getLess15kMarriedCouplePer(), 
							 location.getLess25kMarriedCouplePer(), location.getLess35kMarriedCouplePer(),
							 location.getLess50kMarriedCouplePer(), location.getLess75kMarriedCouplePer(), 
							 location.getLess100kMarriedCouplePer(),location.getLess150kMarriedCouplePer(),
							 location.getLess200kMarriedCouplePer(), location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {15000, 25000, 35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() 
														+ costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 25000) {
						double[] possibilityList = 
							{location.getLess25kMarriedCouplePer(), location.getLess35kMarriedCouplePer(),
							 location.getLess50kMarriedCouplePer(), location.getLess75kMarriedCouplePer(), 
							 location.getLess100kMarriedCouplePer(),location.getLess150kMarriedCouplePer(),
							 location.getLess200kMarriedCouplePer(), location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {25000, 35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 35000) {
						double[] possibilityList = 
							{location.getLess35kMarriedCouplePer(),
							 location.getLess50kMarriedCouplePer(), location.getLess75kMarriedCouplePer(), 
							 location.getLess100kMarriedCouplePer(),location.getLess150kMarriedCouplePer(),
							 location.getLess200kMarriedCouplePer(), location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 50000) {
						double[] possibilityList = 
							{ location.getLess50kMarriedCouplePer(), location.getLess75kMarriedCouplePer(), 
							 location.getLess100kMarriedCouplePer(), location.getLess150kMarriedCouplePer(),
							 location.getLess200kMarriedCouplePer(), location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 75000) {
						double[] possibilityList = 
							{location.getLess75kMarriedCouplePer(), 
							 location.getLess100kMarriedCouplePer(), location.getLess150kMarriedCouplePer(),
							 location.getLess200kMarriedCouplePer(), location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 100000) {
						double[] possibilityList = 
							{location.getLess100kMarriedCouplePer(), location.getLess150kMarriedCouplePer(),
							 location.getLess200kMarriedCouplePer(), location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 150000) { 
						double[] possibilityList = 
							{location.getLess150kMarriedCouplePer(),
							 location.getLess200kMarriedCouplePer(), location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {150000, 200000, (location.getFamilyCostOfLiving() +
								costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 200000) {
						double[] possibilityList = 
							{location.getLess200kMarriedCouplePer(), location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {200000, (location.getFamilyCostOfLiving() + 
								costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else {
						double[] possibilityList = 
							{location.getMore200kMarriedCouplePer()
								};
						double[] moneyLevel = {(location.getFamilyCostOfLiving() + costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
				}
				else {
					if (location.getFamilyCostOfLiving() < 10000) {
						double[] possibilityList = 
							{location.getLess10kNonfamilyPer(), location.getLess15kNonfamilyPer(), 
							 location.getLess25kNonfamilyPer(), location.getLess35kNonfamilyPer(),
							 location.getLess50kNonfamilyPer(), location.getLess75kNonfamilyPer(), 
							 location.getLess100kNonfamilyPer(),location.getLess150kNonfamilyPer(),
							 location.getLess200kNonfamilyPer(), location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {10000, 15000, 25000, 35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() + 
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 15000) {
						double[] possibilityList = 
							{location.getLess15kNonfamilyPer(), 
							 location.getLess25kNonfamilyPer(), location.getLess35kNonfamilyPer(),
							 location.getLess50kNonfamilyPer(), location.getLess75kNonfamilyPer(), 
							 location.getLess100kNonfamilyPer(),location.getLess150kNonfamilyPer(),
							 location.getLess200kNonfamilyPer(), location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {15000, 25000, 35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() 
														+ costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 25000) {
						double[] possibilityList = 
							{location.getLess25kNonfamilyPer(), location.getLess35kNonfamilyPer(),
							 location.getLess50kNonfamilyPer(), location.getLess75kNonfamilyPer(), 
							 location.getLess100kNonfamilyPer(),location.getLess150kNonfamilyPer(),
							 location.getLess200kNonfamilyPer(), location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {25000, 35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 35000) {
						double[] possibilityList = 
							{location.getLess35kNonfamilyPer(),
							 location.getLess50kNonfamilyPer(), location.getLess75kNonfamilyPer(), 
							 location.getLess100kNonfamilyPer(),location.getLess150kNonfamilyPer(),
							 location.getLess200kNonfamilyPer(), location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {35000, 50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 50000) {
						double[] possibilityList = 
							{location.getLess50kNonfamilyPer(), location.getLess75kNonfamilyPer(), 
							 location.getLess100kNonfamilyPer(),location.getLess150kNonfamilyPer(),
							 location.getLess200kNonfamilyPer(), location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {50000, 75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 75000) {
						double[] possibilityList = 
							{location.getLess75kNonfamilyPer(), 
							 location.getLess100kNonfamilyPer(),location.getLess150kNonfamilyPer(),
							 location.getLess200kNonfamilyPer(), location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {75000, 100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 100000) {
						double[] possibilityList = 
							{location.getLess100kNonfamilyPer(),location.getLess150kNonfamilyPer(),
							 location.getLess200kNonfamilyPer(), location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {100000,
												150000, 200000, (location.getFamilyCostOfLiving() +
														costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 150000) { 
						double[] possibilityList = 
							{location.getLess150kNonfamilyPer(),
							 location.getLess200kNonfamilyPer(), location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {150000, 200000, (location.getFamilyCostOfLiving() +
								costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else if (location.getFamilyCostOfLiving() < 200000) {
						double[] possibilityList = 
							{ location.getLess200kNonfamilyPer(), location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {200000, (location.getFamilyCostOfLiving() + 
								costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
					else {
						double[] possibilityList = 
							{location.getMore200kNonfamilyPer()
								};
						double[] moneyLevel = {(location.getFamilyCostOfLiving() + costOfAttanance)};
						for (int k = 0; k < possibilityList.length; k++) {
							possibility = possibility + possibilityList[k];
						}
						possibilityRound = Math.round(possibility * 100); 
						System.out.println("For student living in " + student.getHome().get(i) + 
								" there is " + possibilityRound + " percent that the family will "
										+ "contribute");
						for (int j = 0 ; j < possibilityList.length; j++) {
							moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
							if (moneyContribute > moneyNeed) {
								moneyContribute = moneyNeed;
							}
							System.out.println("Of the " + possibilityRound + " there is " + 
									possibilityList[j] + " for family to contribut " +
									"at most " + moneyContribute);
						}
					}
				}
				possibility = 0;
				System.out.println("The student need " + moneyNeed + " dollar to continue"
						+ " school\n");
			}
			fourScalecourse1GPA = studentGrade.getGrade(student.getCourse1Grade().get(i));
			fourScalecourse2GPA = studentGrade.getGrade(student.getCourse2Grade().get(i));
			fourScalecourse3GPA = studentGrade.getGrade(student.getCourse3Grade().get(i));
			fourScalecourse4GPA = studentGrade.getGrade(student.getCourse4Grade().get(i));
			fourScalecourse5GPA = studentGrade.getGrade(student.getCourse5Grade().get(i));
			sumGPA = (fourScalecourse1GPA * student.getCourse1Credit().get(i)) +
					(fourScalecourse2GPA * student.getCourse2Credit().get(i)) +
					(fourScalecourse3GPA * student.getCourse3Credit().get(i)) +
					(fourScalecourse4GPA * student.getCourse4Credit().get(i)) +
					(fourScalecourse5GPA * student.getCourse5Credit().get(i));
			sumCredit = (student.getCourse1Credit().get(i) + student.getCourse2Credit().get(i) +
					student.getCourse3Credit().get(i) + student.getCourse4Credit().get(i) +
					student.getCourse5Credit().get(i));
			preditGPAThisSemester =  sumGPA / sumCredit; 
			preditGPA = (student.getGpa().get(i) + preditGPAThisSemester) / 2;
			preditGPARound = Math.round(preditGPA * 100.0) / 100.0;
			
			if (preditGPARound <= marist.getMinGPA()) {
				requireGPA = marist.getMinGPA() - preditGPARound;
				requireGPARound = Math.round(requireGPA * 100.0) / 100.0;
				System.out.println("The student need to increase the GPA by " + requireGPARound +
						" to avoid academic probation");
				System.out.println();
			}
			else {
				System.out.println("By the end of semester, the student may have gpa: " +
									preditGPARound);
				System.out.println();
			}
			
		}
			// use amount of money student need to compare to student's hometown average income to 
			// determine the likelihood student can continue.
		studentDBConnection.close();
	}
}
