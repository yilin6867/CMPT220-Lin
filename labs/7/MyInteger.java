
public class MyInteger {
	private int value;
	
	public MyInteger(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public boolean isEven() {
		if(value % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isOdd() {
		if(value % 2 != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isPrime() {
		boolean yes = false;
		for(int i = 2; i < value/2; i++) {
			if (value % i == 0) {
				yes = false;
				break;
			}
			else {
				yes = true;
			}
		}
		return yes;
	}
	public static boolean isEven(int integer) {
		if (integer % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isOdd(int integer) {
		if(integer % 2 != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isPrime(int integer) {
		boolean yes = false;
		for(int i = 2; i < integer/2; i++) {
			if (integer % i == 0) {
				yes = false;
				break;
			}
			else {
				yes = true;
			}
		}
		return yes;
	}
	public static boolean isEven(MyInteger integer) {
		if (integer.value % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isOdd(MyInteger integer) {
		if (integer.value % 2 != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isPrime(MyInteger integer) {
		boolean yes = false;
		for(int i = 2; i < integer.value/2; i++) {
			if (integer.value % i == 0 || integer.value / i == integer.value) {
				yes = false;
				break;
			}
			else {
				yes = true;
			}
		}
		return yes;
	}
	public boolean equals(int integer) {
		if (this.value == integer) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean equals(MyInteger integer) {
		if (integer.getValue() == this.getValue()) {
			return true;
		}
		else {
			return false;
		}
	}
	public static int parseInt(char [] character) {
		String chara = new String(character);
		int integer = Integer.parseInt(chara);
		return integer;
	}
	public static int parseInt(String character) {
		int integer = Integer.parseInt(character);
		return integer;
	}
}