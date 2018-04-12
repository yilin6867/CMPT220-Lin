import java.util.*;

public class AlterProblem8_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("enter a number ");
		int num = input.nextInt();
		String binaryString = convertToBinary(num);
		printMatrix(binaryString);
	}
	public static void printMatrix(String binaryString) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; ) {
			System.out.print((binaryString.charAt(i) == '0' ? "H" : "T") + " " );
			i++;
			if (i % 3 == 0) {
				System.out.println();
			}
		}
	}
	public static String convertToBinary(int num) {
		String binaryNum = "";
		while (num > 0) {
			if (num % 2 == 0) {
				binaryNum = "0" + binaryNum;
			}
			else {
				binaryNum = "1" + binaryNum;
			}
			num = num / 2;
		}
		int limit = 9 - binaryNum.length();
		for (int i = 0; i < limit; i++) {
			binaryNum = "0" + binaryNum;
		}
		return binaryNum;
	}
}