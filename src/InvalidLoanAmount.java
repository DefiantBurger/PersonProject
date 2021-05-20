@SuppressWarnings("serial")
public class InvalidLoanAmount extends Exception {

	public InvalidLoanAmount(double amount) {
		super(String.valueOf(amount));
	}

}
