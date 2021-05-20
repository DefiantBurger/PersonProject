public class Time {

    public static void advanceYear() throws InvalidDepositAmount, BankAccountLimitSurpassed, ImpossibleUpgrade {
        for (Person p : Person.people) {
            p.bankAccount.deposit(p.job.income);
            p.bankAccount.interest();
            p.job.raise(1);
            p.age += 1;
            if (Math.random() <= 0.0008 * Math.pow(1.06, p.age)) p.die();
        }
    }

    public static void advanceYear(int years) throws InvalidDepositAmount, BankAccountLimitSurpassed, ImpossibleUpgrade {
        for (int i = 0; i < years; i++) {
            advanceYear();
        }
    }

}
