public class Main {

	public static void main(String[] args) throws Exception {
		generate.all();
		
		Person John = new Person("John", 30);
		John.hire("Mob Boss");
		Person Jack = John.adopt("Jack");
		Time.advanceYear(30);
		Person Cathy = Jack.adopt("Cathy");
		Time.advanceYear(31);
		Person Liam = Cathy.adopt("Liam");
		System.out.println(John.bankAccount.Balance);
	}
}
