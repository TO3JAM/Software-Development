import java.util.Date;
import java.text.SimpleDateFormat;

public class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    public Account() {
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public int getId() { 
        return id; 
    }
    
    public double getBalance() { 
        return balance; 
    }
    
    public static double getAnnualInterestRate() { 
        return annualInterestRate; 
    }
    
    public Date getDateCreated() { 
        return dateCreated; 
    }

    public void setId(int id) { 
        this.id = id; 
    }
    
    public void setBalance(double balance) { 
        this.balance = balance; 
    }
    
    public static void setAnnualInterestRate(double rate) { 
        annualInterestRate = rate; 
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public static void main(String[] args) {
        Account myAccount = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);
        myAccount.withdraw(2500);
        myAccount.deposit(3000);
        System.out.println("Balance: $" + String.format("%.2f", myAccount.getBalance()));
        System.out.println("Monthly Interest: $" + String.format("%.2f", myAccount.getMonthlyInterest()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        System.out.println("Date Created: " + dateFormat.format(myAccount.getDateCreated()));
    }
}
