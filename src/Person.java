import java.util.*;

public class Person {
	
	String name;
	int age;
	BankAccount bankAccount;
	Job job;
	Person marriedto;
	ArrayList<Person> children = new ArrayList<>();
	public static ArrayList<Person> people = new ArrayList<>();
	
	public Person(String name, int age) throws InvalidJobType {
		this.name = name;
		this.age = age;
		this.bankAccount = new BankAccount();
		this.job = new Job("Unemployed");
		people.add(this);
	}
	
	public void hire(String jobname) throws InvalidJobType {
		this.job = new Job(jobname);
	}
	
	public void fire() throws InvalidJobType {
		this.job = new Job("Unemployed");
	}
	
	public void quit() throws InvalidJobType {
		this.job = new Job("Unemployed");
	}
	
	public void marry(Person person) {
		person.marriedto = this;
		this.marriedto = person;
	}
	
	public void haveChild(String name) throws NoPartner, InvalidJobType {
		if (!(this.marriedto == null)) throw new NoPartner();
		this.children.add(new Person(name, 0));
	}
	
	public Person adopt(String name) throws InvalidJobType {
		Person Kid = new Person(name, 0);
		this.children.add(Kid);
		return Kid;
	}

}
