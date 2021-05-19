@SuppressWarnings("serial")
public class BankAccountLimitSurpassed extends Exception{
	public BankAccountLimitSurpassed(double var, Long limit) {
		super(var + "/" + limit);
	}
}
