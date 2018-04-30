package code;
import java.sql.*;

public class Proj2Prototype3 {
	public static void main(String[] args) throws SQLException {
		//initialize variable
		double preditGPARound;
		long studentMoney;
		long costOfAttanance;
		long moneyNeed;
		
		//create instance of marist data table
		MaristDB marist = new MaristDB();
		
		//create instance of location data table
		LocationDB location = new LocationDB();
		//built connection to location data table
		Connection locationConnection = location.connect();
		
		//create instance of student data table
		StudentDB student = new StudentDB();
		
		//use for loop to print the information and prediction for each student
		for (int i = 0; i < student.getIds().size(); i++) {
			//print the table
			System.out.println(String.format("|ID\t\t| Name\t\t\t| GPA\t| Where Student is From | %s\t"	+ 
					"| Amount Need | Contribute Possibility" + " | GPA Need | " + "Predicted GPA |" + 
					"\n" +
					"|-----------------------------------------------------------------------------" +
					"------------------------------------------------------------------------------" +
					"------|",
					"Student Status"));
			location.pullData(locationConnection, student.getHome().get(i));
			studentMoney = student.getAwardSch().get(i) + student.getThirdSch().get(i)
					+ student.getFamCont().get(i);
			costOfAttanance = marist.getTuition() + marist.getRoomAndBoard() +
					marist.getBookAndSupplies() + marist.getPersonalMiscellaneous();
			// override toString to print each student data
			System.out.print(student.newToString(i));
			moneyNeed = costOfAttanance - studentMoney;
			preditGPARound = predictGPA(i, student);
			//conduct prediction
			if (studentMoney < costOfAttanance) {
				System.out.print(String.format("$%12s|", moneyNeed));
				checkFamilyStatus(student, i, location, costOfAttanance, moneyNeed, preditGPARound,
						marist);
			}
			System.out.println();
		}
	}
	// check whether the student is dependent, married, single
	static void checkFamilyStatus(StudentDB student, int i, LocationDB location, long costOfAttanance, 
								long moneyNeed, double preditGPARound, MaristDB marist) {
		if (student.getFamilyStatus().get(i).equals("Dependent")) {
			dependentFamilyContribution(student, location, costOfAttanance, moneyNeed, i,
					preditGPARound, marist);
		}
		else if (student.getFamilyStatus().get(i).equals("Married")) {
			marriedFamilyContribution(student, location, costOfAttanance, moneyNeed, i,
					preditGPARound, marist);
		}
		else {
			singleFamilyContriubution(student, location, costOfAttanance, moneyNeed, i,
					preditGPARound, marist);
		}
	}
	//for student who is dependent
	static void dependentFamilyContribution(StudentDB student, LocationDB location, 
			long costOfAttanance, long moneyNeed, int i, double preditGPARound, MaristDB marist) {
		double possibilityRound;
		double possibility = 0;
		double moneyContribute;
		//for family income less that 10000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") + 
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 15000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") + 
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 25000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 35000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 50000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 75000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents")+
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 100000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 150000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 200000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 200000+
		else {
			double[] possibilityList = 
				{location.getMore200kFamiliesPer(),
					};
			double[] moneyLevel = {(location.getFamilyCostOfLiving() + costOfAttanance)};
			for (int k = 0; k < possibilityList.length; k++) {
				possibility = possibility + possibilityList[k];
			}
			possibilityRound = Math.round(possibility * 100); 
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}		
	}
	//for student who is married
	static void marriedFamilyContribution(StudentDB student, LocationDB location, long costOfAttanance,
			long moneyNeed, int i, double preditGPARound, MaristDB marist) {
		double possibilityRound;
		double possibility = 0;
		double moneyContribute;
		//for family income less that 10000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 15000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 25000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 35000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 50000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 75000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 100000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 150000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 200000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 200000+
		else {
			double[] possibilityList = 
				{location.getMore200kMarriedCouplePer()
					};
			double[] moneyLevel = {(location.getFamilyCostOfLiving() + costOfAttanance)};
			for (int k = 0; k < possibilityList.length; k++) {
				possibility = possibility + possibilityList[k];
			}
			possibilityRound = Math.round(possibility * 100); 
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
	}
	//for student who is single
	static void singleFamilyContriubution(StudentDB student, LocationDB location, long costOfAttanance,
			long moneyNeed, int i, double preditGPARound, MaristDB marist) {
		double possibilityRound;
		double possibility = 0;
		double moneyContribute;
		//for family income less that 10000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 15000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 25000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 35000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") + 
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 50000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less that 75000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less than 100000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less than 150000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less than 200000
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
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
		//for family income less than 200000+
		else {
			double[] possibilityList = 
				{location.getMore200kNonfamilyPer()
					};
			double[] moneyLevel = {(location.getFamilyCostOfLiving() + costOfAttanance)};
			for (int k = 0; k < possibilityList.length; k++) {
				possibility = possibility + possibilityList[k];
			}
			possibilityRound = Math.round(possibility * 100); 
			System.out.print(String.format("%24s|",possibilityRound + "%"));
			checkGPA(preditGPARound, marist);
			System.out.println(String.format("|%9s|", "Income Range      ") + String.format("%10s|", "Percents") +
					String.format("%15s|", "Ammount Contribute"));
			System.out.println("|------------------------------------------------|");
			for (int j = 0 ; j < possibilityList.length; j++) {
				moneyContribute = moneyLevel[j] - location.getFamilyCostOfLiving();
				if (moneyContribute > moneyNeed) {
					moneyContribute = moneyNeed;
				}
				System.out.print(String.format("|Less Than %8s|", moneyLevel[j]) + 
						String.format("%10s|", Math.round((possibilityList[j]* 100) * 10) / 10.0));
				System.out.println(String.format("$%17s|", moneyContribute));
			}
		}
	}
	//calculate the gpa at the end of the semester
	static double predictGPA(int i, StudentDB student) {
		double fourScalecourse1GPA;
		double fourScalecourse2GPA;
		double fourScalecourse3GPA;
		double fourScalecourse4GPA;
		double fourScalecourse5GPA;
		double sumGPA;
		double sumCredit;
		double preditGPA;
		double preditGPARound;
		double preditGPAThisSemester;
		fourScalecourse1GPA = getGrade(student.getCourse1Grade().get(i));
		fourScalecourse2GPA = getGrade(student.getCourse2Grade().get(i));
		fourScalecourse3GPA = getGrade(student.getCourse3Grade().get(i));
		fourScalecourse4GPA = getGrade(student.getCourse4Grade().get(i));
		fourScalecourse5GPA = getGrade(student.getCourse5Grade().get(i));
		sumGPA = (fourScalecourse1GPA * student.getCourse1Credit().get(i)) +
				(fourScalecourse2GPA * student.getCourse2Credit().get(i)) +
				(fourScalecourse3GPA * student.getCourse3Credit().get(i)) +
				(fourScalecourse4GPA * student.getCourse4Credit().get(i)) +
				(fourScalecourse5GPA * student.getCourse5Credit().get(i));
		sumCredit = (student.getCourse1Credit().get(i) + student.getCourse2Credit().get(i) +
				student.getCourse3Credit().get(i) + student.getCourse4Credit().get(i) +
				student.getCourse5Credit().get(i));
		preditGPAThisSemester =  sumGPA / sumCredit;
		if (student.getGpa().get(i) == 0) {
			preditGPA = preditGPAThisSemester;
		}
		else {
			preditGPA = (student.getGpa().get(i) + preditGPAThisSemester) / 2;
		}
		preditGPARound = Math.round(preditGPA * 100.0) / 100.0;
		return preditGPARound;
	}
	//check if gpa is below C
	public static void checkGPA(double preditGPARound, MaristDB marist) {
		double requireGPA;
		double requireGPARound;
		if (preditGPARound <= marist.getMinGPA()) {
			requireGPA = marist.getMinGPA() - preditGPARound;
			requireGPARound = Math.round(requireGPA * 100.0) / 100.0;
			System.out.print(String.format("%10s|", requireGPARound));
			System.out.println(String.format("%15s|", preditGPARound));
			System.out.println();
		}
		else {
			requireGPARound = 0;
			System.out.print(String.format("%10s|", requireGPARound));
			System.out.println(String.format("%15s|", preditGPARound));
			System.out.println();
		}
	}
	//grade 100 scale to 4 point scale
	public static double getGrade(int grade) {
		if (grade >= 94 && grade <= 100) {
			return 4.0;
		}
		else if (grade >= 90 && grade <= 93) {
			return 3.7;
		}
		else if (grade >= 87 && grade <= 89) {
			return 3.3;
		}
		else if (grade >= 83 && grade <= 86) {
			return 3.0;
		}
		else if (grade >= 80 && grade <= 82) {
			return 2.7;
		}
		else if (grade >= 77 && grade <= 79) {
			return 2.3;
		}
		else if (grade >= 73 && grade <= 76) {
			return 2.0;
		}
		else if (grade >= 70 && grade <= 72) {
			return 1.7;
		}
		else if (grade >= 67 && grade <= 69) {
			return 1.3;
		}
		else if (grade >= 65 && grade <= 66) {
			return 1.0;
		}
		else {
			return 0.0;
		}
	}
}
