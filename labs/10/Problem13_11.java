
public class Problem13_11 {
	public static void main(String[] args) {
		Octagon octagon = new Octagon(5);
		Octagon octagonClone = (Octagon) octagon.clone();
		System.out.println("Octagon 1:");
		System.out.println(octagon.toString());
		if (octagon.compareTo(octagonClone) == 0) {
			System.out.println("Octagon 2:");
			System.out.println(octagonClone.toString());
		}
	}
}
