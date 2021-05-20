public class Main {

	public static void main(String[] args) throws Exception {
		generate.all();
		
		Person John = new Person("John", 30);
		John.hire("High School Teacher");
		System.out.println(John.bankAccount.Balance);
		John.bankAccount.loan(John, 10000);
		System.out.println(John.bankAccount.Balance);
	}
}
