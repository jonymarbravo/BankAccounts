public class BankAcc1 {
    private String holderName;
    private String gender;
    private String nationality;
    private int age;
    private int accNum;
    private int passcode;
    private double totaldep;
    private double totalwid;
    private double balance;

    public BankAcc1(String holderName, String gender, String nationality, int age, int accNum, int passcode) {
        this.holderName = holderName;
        this.gender = gender;
        this.nationality = nationality;
        this.age = age;
        this.accNum = accNum;
        this.passcode = passcode;
        this.totaldep = 0;
        this.totalwid = 0;
        this.balance = 0;
    }

        public String getHolderName(){
        return holderName;
        }
        public void setHolderName(String holderName){
        this.holderName = holderName;
        }

        public String getGender(){
        return gender;
        }
        public void setGender(String gender){
        this.gender = gender;
        }

        public String getNationality(){
        return nationality;
        }
        public void setNationality(String nationality){
        this.nationality = nationality;
        }

        public int getAge(){
        return age;
        }
        public void setAge(int age){
        this.age = age;
        }

        public int getAccNum(){
        return accNum;
        }

        public int getPasscode(){
        return passcode;
        }
        public void setPasscode(int passcode){
        this.passcode = passcode;
        }

        public double getTotaldep(){
        return totaldep;
        }

        public double getTotalwid(){
        return totalwid;
        }

        public double getBalance(){
        return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                this.totaldep += amount;
                this.balance += amount;
            }
        }

        public boolean withdraw(double amount){
        if (amount > 0 && amount <= balance){
            this.totalwid += amount;
            this.balance -= amount;
            return true;
        }
        return false;
        }

        @Override
       public String toString(){
        return "Name: " + holderName + "\n" +
                "Gender: " + gender + "\n" +
                "Nationality: " + nationality + "\n" +
                    "Age: " + age + "\n" +
                    "Account Number: " + accNum + "\n" +
                    "Password: " + passcode + "\n" +
                    "Total Deposit: " + totaldep + "\n" +
                    "Total Withdrawn: " + totalwid + "\n" +
                    "Balance: " + balance;
        }

}
