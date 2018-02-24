import java.util.*;

public class Problem8_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter matrix1 : ");
		double[][] matrixA = new double[3][3];
		double[][] matrixB = new double[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrixA[i][j] = input.nextDouble();
			}
		}
		System.out.print("Enter matrix2 : ");
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				matrixB[k][l] = input.nextDouble();
			}
		}
		String[] matrixAString = new String[matrixA.length];
		String[] matrixBString = new String[matrixB.length];
		double[][] matrixC =  addMatrix((double[][])matrixA, (double[][]) matrixB);
		String[] matrixCString = new String[matrixC.length];
		for (int j = 0; j < matrixA.length; j++) {
			matrixAString[j] = Arrays.toString(matrixA[j]);
			matrixAString[j].replace("[", "").replace("]", "").replace(",", "");
		}
		for (int l = 0; l < matrixA.length; l++) {
			matrixBString[l] = Arrays.toString(matrixB[l]);
			matrixBString[l].replace("[", "").replace("]", "").replace(",", "");
		}
		for (int n = 0; n < matrixC.length; n++) {
			matrixCString[n] = Arrays.toString(matrixC[n]);
			matrixCString[n].replace("[", "").replace("]", "").replace(",", "");
		}
		System.out.println("The matrices are added as follows");
		for (int m = 0; m < matrixC.length; m++) {
			System.out.print(matrixAString[m].replace("[", "").replace("]", "").replace(",", ""));
			if (m == 1) {
				System.out.print(" + ");
			}
			else {
				System.out.print("   ");
			}
			System.out.print(matrixBString[m].replace("[", "").replace("]", "").replace(",", ""));
			if (m == 1) {
				System.out.print(" = ");
			}
			else {
				System.out.print("   ");
			}
			System.out.println(matrixCString[m].replace("[", "").replace("]", "").replace(",", ""));
		}
	}
	public static double[][] addMatrix(double[][] a, double[][] b) {
		double[][] matrixC = new double[3][3];
		for(int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				matrixC[i][j] = a[i][j] + b[i][j];
			}
		}
		return matrixC;
	}
}
