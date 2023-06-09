import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {
        BankAccount obj1 = new BankAccount("Nadir","1993");
        obj1.showMenu();
    }

}

// created BankAccount class
class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname,String cid){
        customerName = cname;
        customerId = cid;
    }
    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withDraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited : "+previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("withdrawn : "+Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occured");
        }
    }

    void showMenu(){
        char option = '\0';
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("==========================================================");
            System.out.println("Enter an option");
            System.out.println("==========================================================");
            option = scan.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'A':
                    System.out.println("--------------------------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("--------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("--------------------------------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("--------------------------------------------------");
                    int amount = scan.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("--------------------------------------------------");
                    System.out.println("Enter amount to withdraw");
                    System.out.println("--------------------------------------------------");
                    int amount2 = scan.nextInt();
                    withDraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("--------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("--------------------------------------------------");
                    System.out.println("\n");
                case 'E':
                    System.out.println("==========================================================");
                    break;
                default:
                    System.out.println("Invalid Option!!.Please enter again");
                    break;
            }
        }while (option != 'E');
        System.out.println("Thank you fot using our servives");
    }

}