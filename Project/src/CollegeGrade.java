package code;
import java.util.Scanner;

public class CollegeGrade {
	CollegeGrade() {
	}
	public double getGrade(int grade) {
		if (grade >= 94 && grade <= 100) {
			return 4.0;
		}
		else if (grade >= 90 && grade <= 93) {
			return 3.7;
		}
		else if (grade >= 87 && grade <= 89) {
			return 3.3;
		}
		else if (grade >= 86 && grade <= 83) {
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
	