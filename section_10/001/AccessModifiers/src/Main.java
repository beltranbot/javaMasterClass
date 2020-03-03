public class Main {

    public static void main(String[] args) {

        Account account = new Account("Tim");
        account.deposit(1000);
        account.withdraw(500);
        account.withdraw(-200);
        account.deposit(-20);
        account.calculateBalance();

        System.out.println("Balance on account is " + account.getBalance());

    }
}
