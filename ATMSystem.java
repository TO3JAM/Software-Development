//Jayden Misseldine
import java.util.Scanner;
class Account {
    private int id;
    private double balance;
    private static double annualInterestRate = 0;
    private java.util.Date dateCreated;

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.dateCreated = new java.util.Date();
    }
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new java.util.Date();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }
    public java.util.Date getDateCreated() {
        return dateCreated;
    }
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
    public double getMonthlyInterest() {
        return balance * (getMonthlyInterestRate() / 100);
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("No more money");
        }
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10];
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 100.0);
        }
        System.out.println("This is the ATM system");
        while (true) {
            int id = -1;
            while (id < 0 || id > 9) {
                System.out.print("Enter an id (0-9): ");
                try {
                    id = scanner.nextInt();
                    if (id < 0 || id > 9) {
                        System.out.println("Invalid ID.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                    scanner.nextLine(); 
                }
            }
            boolean exitMenu = false;
            while (!exitMenu) {
                System.out.println("\nMain menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                try {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1: 
                            System.out.printf("The balance is $%.2f\n", accounts[id].getBalance());
                            break;
                        case 2: 
                            System.out.print("Enter an amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            if (withdrawAmount > 0) {
                                accounts[id].withdraw(withdrawAmount);
                                System.out.printf("$%.2f withdrawn successfully.\n", withdrawAmount);
                            } else {
                                System.out.println("Invalid amount.");
                            }
                            break;
                        case 3: 
                            System.out.print("Enter an amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            if (depositAmount > 0) {
                                accounts[id].deposit(depositAmount);
                                System.out.printf("$%.2f deposited successfully.\n", depositAmount);
                            } else {
                                System.out.println("Invalid amount."");
                            }
                            break;
                        case 4: 
                            exitMenu = true;
                            System.out.println("Exiting account");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                    scanner.nextLine(); 
                }
            }
        }
    }
}
