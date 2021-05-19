public class Time {

    public static void advanceYear() throws InvalidDepositAmount, BankAccountLimitSurpassed, ImpossibleUpgrade {
        for (Person p : Person.people) {
            p.bankAccount.deposit(p.job.income);
            p.bankAccount.interest();
            p.job.raise(1);
            p.age += 1;
        }
    }

    public static void advanceYear(int years) throws InvalidDepositAmount, BankAccountLimitSurpassed, ImpossibleUpgrade {
        for (Person p : Person.people) {
            for (int i = 0; i < years; i++) {
                p.bankAccount.deposit(p.job.income);
                p.bankAccount.interest();
                p.job.raise(0.5);
                p.age += 1;
            }
        }
    }

}
