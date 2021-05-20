@SuppressWarnings("serial")
public class AccountLimitSurpassed extends Exception{
	public AccountLimitSurpassed(double var, Long limit) {
		super(var + "/" + limit);
	}
}
