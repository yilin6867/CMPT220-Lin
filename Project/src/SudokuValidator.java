import java.util.*;

public class SudokuValidator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the solution");
		int[][] board = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = input.nextInt();
			}
		}
		System.out.println(isValid(board) ? "Valid solution" : "Invalid solution");
		
	}

	private static boolean isValid(int[][] board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] < 1 || board[i][j] >9 || !isValid(i,j, board)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(int i, int j, int[][] board) {
		// Check all row in the column j
		for (int row = 0; row < 9; row++) {
			if (row != i && board[row][j] == board[i][j]) {
				return false;
			}
		}
		// Check all column in the row j
		for (int col = 0; col < 9; col++) {
			if (col != j && board[i][col] == board[i][j]) {
				return false;
			}
		}
		// check three by three square
		for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
			for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
				if ((col != j && row != i) && board[row][col] == board[i][j]) {
					return false;
				}
			}
			
		}
		return true;
	}
}