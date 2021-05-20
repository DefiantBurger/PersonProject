public class Main {

	public static void main(String[] args) throws Exception {
		generate.all();
		
		Person John = new Person("John", 30);
		John.hire("High School Teacher");
		Time.advanceYear(10);
	}
}
