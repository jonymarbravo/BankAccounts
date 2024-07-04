import java.util.Scanner;

public class PracticeBank1 {
    static BankAcc1 [] bankaccs = new BankAcc1[100];
    static int ClientCount = 0;
    static int generatedAccNum = 2024001;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[]args){
        int choice;

        do{
            System.out.println("\nMENU:");
            System.out.println("1. Create Bank Account.");
            System.out.println("2. Savings Account.");
            System.out.println("3. Current Account.");
            System.out.println("4. Check Bank Account Data/Details.");
            System.out.println("5. Update Bank Account.");
            System.out.println("6. Delete Bank Account.");
            System.out.println("7. Exit. \n");
            System.out.println("Please input your choice from 1-7: ");
            choice = scan.nextInt();

            switch (choice){
                case 1:
                    createAcc();
                    break;
                case 2:
                    savingsAcc();
                    break;
                case 3:
                    currentAcc();
                    break;
                case 4:
                    checkAcc();
                    break;
                case 5:
                    updateAcc();
                    break;
                case 6:
                    deleteAcc();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("\nInvalid choice. Hay nako..!! 1-7 gani..BOGO..!! usba...");

            }
        }while (choice != 7);
    }

    static void createAcc(){
        System.out.println("Enter your name: ");
        scan.nextLine();
        String holderName = scan.nextLine();
        System.out.println("Gender: ");
        String gender = scan.nextLine();
        System.out.println("Nationality: ");
        String nationality = scan.nextLine();
        System.out.println("Age: ");
        int age = scan.nextInt();
        scan.nextLine();

        int accNum = generatedNum();
        System.out.println("Account Number: " + accNum);

        System.out.println("Create Your Password/Numbers only: ");
        int passcode = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter account type. Type Savings/Current.");
        String accType = scan.nextLine();

        BankAcc1 clientAcc;
        if (accType.equalsIgnoreCase("Savings")){
            clientAcc = new SavingsAccount1(holderName, gender, nationality, age, accNum, passcode);
        } else if (accType.equalsIgnoreCase("Current")) {
            clientAcc = new CurrentAccount1(holderName, gender, nationality, age, accNum, passcode);
        }
        else {
            System.out.println("\nInvalid input. Please Try Again...\n");
            return;
        }

        bankaccs[ClientCount] = clientAcc;
        ClientCount++;

        System.out.println("\nCongratulations, you are now have a Bank Account.");
    }

    static int generatedNum(){
        return generatedAccNum++;
    }

    static void savingsAcc() {
        System.out.println("Enter your Account Number: ");
        int accNum = scan.nextInt();
        System.out.println("Password: ");
        int passcode = scan.nextInt();

        BankAcc1 account = validateNum(accNum, passcode);

        if (account != null && account instanceof SavingsAccount1) {
            SavingsAccount1 savingsAccount = (SavingsAccount1) account;
            System.out.println("\nWell hello client, this is your savings account.\nHere you may deposit with no amount limits of money.\nHowever, " +
                    "there's an amount limit when it comes to withdrawals.\nBelow ₱10,000.00 is allowed for all to withdraw.");
            System.out.println("Bank Offer: 20% Interest.\n");

            System.out.println("Deposit Money: ");
            scan.nextLine();
            double depMon = scan.nextDouble();

            savingsAccount.deposit(depMon);
            System.out.println("\nYou deposit a money with an amount of ₱" + depMon + "0");
            System.out.println("Your current balance: ₱" + savingsAccount.getBalance() + "0");

            System.out.println("\nType 'Yes/No' if you like to withdraw or not.");
            scan.nextLine();
            String decide = scan.nextLine();

            if (decide.equalsIgnoreCase("Yes")){
                System.out.println("How much: ");
                double withD = scan.nextDouble();

                if (withD > 10000){
                    System.out.println("\nSorry, the amount you withdraw exceeds to the amount limit (₱10,000.00). Please try again.\n");
                } else if (savingsAccount.withdraw(withD)) {
                    System.out.println("\nYou withdraw an amount of ₱" + withD + "0");
                    System.out.println("Your current balance: ₱" + savingsAccount.getBalance() + "0 \n");
                }
                else {
                    System.out.println("Insufficient balance. Your current balance is only ₱" + savingsAccount.getBalance() + "0");
                }
            } else if (decide.equalsIgnoreCase("No")) {
                System.out.println("Exiting...");
            }else {
                System.out.println("\nInvalid input. Please Try Again.");
            }
        } else {
            System.out.println("\nInvalid account number/password or not a Savings Account. Please Try Again...");
        }
    }

    static void currentAcc(){
        System.out.println("Enter your Account Number: ");
        int accNum = scan.nextInt();
        System.out.println("Password: ");
        int passcode = scan.nextInt();

        BankAcc1 account = validateNum(accNum, passcode);

        if (account != null && account instanceof CurrentAccount1){
            CurrentAccount1 currentAccount = (CurrentAccount1) account;
            System.out.println("\nWell hello client, this is your current account.\nHere you may deposit and withdraw with no amount limits.\nHowever, " +
                    "your savings interest is low");
            System.out.println("Bank Offer: 10% Interest.\n");

            System.out.println("Deposit Money: ");
            scan.nextLine();
            double depoMon = scan.nextDouble();
            currentAccount.deposit(depoMon);

            System.out.println("You deposit a money with an amount of ₱" + depoMon + "0");
            System.out.println("Your current balance: ₱" + currentAccount.getBalance() + "0");

            System.out.println("Type 'Yes/No' if you like to withdraw or not:");
            scan.nextLine();
            String decide = scan.nextLine();

            if (decide.equalsIgnoreCase("Yes")){
                System.out.println("How much: ");
                double withDr = scan.nextDouble();

                if (currentAccount.withdraw(withDr)) {
                    System.out.println("You withdraw a money with an amount of ₱" + withDr + "0");
                    System.out.println("Your current balance: ₱" + currentAccount.getBalance() + "0");
                } else {
                    System.out.println("Insufficient balance.\nYour current balance is only ₱" + currentAccount.getBalance() + "0");
                }
            } else if (decide.equalsIgnoreCase("No")) {
                System.out.println("\nExiting...\n");
            }
            else {
                System.out.println("\nInvalid input. Please Try Again...");
            }
        } else {
            System.out.println("\nInvalid account number/password or not a Current Account. Please Try Again...");
        }
    }

    static void checkAcc(){
        if (ClientCount == 0){
            System.out.println("\nThere's no Bank Account that has been made or created.");
            return;
        }
        System.out.println("\nBank Account's Data: ");

        for (int i = 0; i < ClientCount; i++){
            System.out.println("ID: " + (i + 1) + "\n" + bankaccs[i] + "\n");
        }
    }

    static void updateAcc(){
        if (ClientCount == 0){
            System.out.println("\nThere's no Bank's Accounts that has made or created...\n");
            return;
        }

        System.out.println("\nEnter Bank Account's ID to update: ");
        int id = scan.nextInt();

        if (id < 1 || id > ClientCount){
            System.out.println("\nInvalid ID. Please Try Again...");
            return;
        }

        System.out.println("Enter New Holder Name: ");
        scan.nextLine();
        String newName = scan.nextLine();
        System.out.println("New Gender: ");
        String newGender = scan.nextLine();
        System.out.println("New Nationality: ");
        String newNL = scan.nextLine();
        System.out.println("Age: ");
        int newAge = scan.nextInt();
        System.out.println("New Password: ");
        int newPass = scan.nextInt();

        BankAcc1 account = bankaccs[id - 1];
        account.setHolderName(newName);
        account.setGender(newGender);
        account.setNationality(newNL);
        account.setAge(newAge);
        account.setPasscode(newPass);

        System.out.println("\nBank Account updated successfully...");
    }

    static void deleteAcc(){
        if (ClientCount == 0){
            System.out.println("\nThere's no Bank Account that has been made or created...\n");
            return;
        }

        System.out.println("\nEnter Bank Account's ID to delete: ");
        int id = scan.nextInt();

        if (id < 1 || id > ClientCount){
            System.out.println("\nInvalid ID. Please try again...\n");
            return;
        }

        for (int i = id - 1; i < ClientCount - 1; i++){
            bankaccs[i] = bankaccs[id - 1];
        }
        bankaccs[ClientCount - 1] = null;
        ClientCount--;

        System.out.println("\nBank Account Deleted Successfully...");
    }

    static BankAcc1 validateNum(int accNum, int passcode){
        for (int i = 0; i < ClientCount; i++){
            if (bankaccs[i].getAccNum() == accNum && bankaccs[i].getPasscode() == passcode){
                return bankaccs[i];
            }
        }
        return null;
    }
}
