public class SavingsAccount1 extends BankAcc1{
    private static final double INTEREST_RATE = 0.20;
    private static final double LIMIT_WITHDRAWN = 10000;

    public SavingsAccount1(String holderName, String gender, String nationality, int age, int accNum, int passcode){
        super(holderName, gender, nationality, age, accNum, passcode);
    }

    public void applyInterest(){
    double interest = getBalance() * INTEREST_RATE;
    deposit(interest);
    }

    @Override
    public boolean withdraw(double amount){
        if (amount > LIMIT_WITHDRAWN){
            System.out.println("Sorry, the amount you withdraw is exceeds above " + LIMIT_WITHDRAWN);
            return false;
        }
        return super.withdraw(amount);
    }


}
