public class CurrentAccount1 extends BankAcc1{
    private static final double INTEREST_RATE = 0.10;

    public CurrentAccount1(String holderName, String gender, String nationality, int age, int accNum, int passcode){
        super(holderName, gender, nationality, age, accNum, passcode);
    }

    public void applyInterest(){
        double interest = getBalance() * INTEREST_RATE;
        deposit(interest);
    }

}
