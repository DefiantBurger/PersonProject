import java.util.*;

public class Job {
	
	//https://www.shmoop.com/careers/career-salaries.html
	
	String name;
	double income;
	double initIncome;
	public static Map<String, String> jobs = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

	public Job(String name) throws InvalidJobType {
		String j = jobs.get(name);
		if (j == null) throw new InvalidJobType(name);
		this.income = Double.parseDouble(j);
		this.initIncome = income;
		this.name = name;
	}
	
	public void raise(double r) {
		this.income += 0.001 * initIncome;
		this.income = Math.floor(this.income * 100) / 100;
	}
	
}
