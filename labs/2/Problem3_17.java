import java.util.*;
public class Problem3_17 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Scissor (0), Rock(1), Paper(2): ");
		int playerMove = input.nextInt();
		int cpuMove = (int)(Math.random()*3);
		if (playerMove == 0 && cpuMove == 0) {
			System.out.println("The computer is scissor. You are scissor. It is a draw.");
		}
		else if (playerMove == 0 && cpuMove == 1) {
			System.out.println("The computer is rock. You are scissor. You loss.");
		}
		else if (playerMove == 0 && cpuMove == 2) {
			System.out.println("The computer is paper. You are scissor. You won.");
		}
		else if (playerMove == 1 && cpuMove == 0) {
			System.out.println("The computer is scissor. You are rock. You won.");
		}
		else if (playerMove == 1 && cpuMove == 1) {
			System.out.println("The computer is rock. You are rock. It is a draw.");
		}
		else if (playerMove == 1 && cpuMove == 2) {
			System.out.println("The computer is paper. You are rock. You loss.");
		}
		else if (playerMove == 2 && cpuMove == 0) {
			System.out.println("The computer is scissor. You are paper. You loss.");
		}
		else if (playerMove == 2 && cpuMove == 1) {
			System.out.println("The computer is rock. You are paper. You won.");
		}
		else if (playerMove == 2 && cpuMove == 2) {
			System.out.println("The computer is paper. You are paper. It is a draw.");
		}
	}
}