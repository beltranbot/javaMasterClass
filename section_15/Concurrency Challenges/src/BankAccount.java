public class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
        }

    }

    public void withdraw(double amount) {
        synchronized (this) {
            balance -= amount;
        }
    }
}
