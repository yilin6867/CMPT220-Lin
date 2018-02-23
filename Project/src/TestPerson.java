import java.util.Date;

public class TestPerson {
	
	public static void main(String[] args) {
		Person bob = new Person();
		bob.setName("Bob Jackson");
		bob.setSsn("123-45-6789");
		System.out.println(bob.getName() + " age is " + bob.getAge());
		
		Person kate = new Person("Kate Hudson", new Date(1980, 9, 23), "243-65-8765");
		System.out.print("Number of person objects created is " + Person.getNumberOfPeople());
		
		Date kateDob = kate.getDob();
		kateDob.setYear(1985);
		
	}
}