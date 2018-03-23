import java.util.Scanner;

public class Problem10_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number to be check: ");
		MyInteger num = new MyInteger(input.nextInt());
		System.out.println("Is " + num.getValue() + " a prime number? " + num.isPrime());
		System.out.println("Is " + num.getValue() + " a even number? " + num.isEven());
		System.out.println("Is " + num.getValue() + " a odd number? " + num.isOdd());
		System.out.println("Is " + num.getValue() + " a even number? " + num.isEven());
		
		int numCheck;
		System.out.print("Please enter an array of 5 numeric character to be "
				+ "check: ");
		char[] charNum = new char[5];
		String character = "";
		for (int i = 0; i <charNum.length; i++) {
			character = character + input.next();
		}
		charNum = character.toCharArray();
		numCheck = num.parseInt(charNum);
		if (num.isEven(numCheck)) {
			System.out.println(numCheck + " is a even number.");
		}
		else if (num.isOdd(numCheck)) {
			System.out.println(numCheck + " is a odd number.");
		}
		else if (num.isPrime(numCheck)) {
			System.out.println(numCheck + " is a prime number.");
		}
		System.out.printf("Is " + num.getValue() + " and "+ numCheck + " equal? " 
		+ num.equals(numCheck) + "\n");
		System.out.print("Enter a string numeric character to be check: ");
		String stringNum = input.next();
		int newNumCheck = num.parseInt(stringNum);
		System.out.println(num.getValue());
		MyInteger newNum = new MyInteger(newNumCheck);
		System.out.println(num.getValue());
		System.out.println("Is " + newNum.getValue() + " a prime number? " +
		newNum.isPrime(newNum));
		System.out.println("Is " + newNum.getValue() + " a even number? " + 
		newNum.isEven(newNum));
		System.out.println("Is " + newNum.getValue() + " a odd number? " + 
		newNum.isOdd(newNum));
		System.out.println("Is " + newNum.getValue() + " a even number? " + 
		newNum.isEven(newNum));
		System.out.printf("Is " + newNum.getValue() + " and "+ num.getValue() + " equal? " 
		+ num.equals(newNum));
	}
}