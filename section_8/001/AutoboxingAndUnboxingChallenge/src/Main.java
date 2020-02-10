public class Main {

    /*
     * Your job is to create a simple banking application.
     * There should be a Bank class
     * It should have an arrayList of Branches
     * Each Branch should have an arraylist of Customers
     * The customer class should have and arrayList of Doubles (transactions)
     * Customer:
     * name and the arraylist of doubles
     * Branch:
     * needs to be add a new customer and initial transaction amount.
     * Also needs to add additional transactions for that customer/branch
     * Branch:
     * Add ad new branch
     * Add a customer to that branch with initial transaction
     * Add a transaction for an existing customer for that branch
     * Show a list of customers for a particular branch and optionally a list
     * of their transactions
     * Demonstration autoboxing and unboxing in your code
     * Hint: Transactions
     * Add data validation
     * e.g. check if exists, or does not exist, etc.
     * Think about where you are adding the code to perform certain actions.
     * */

    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");
        String[] branches = {
                "Adelaide",
                "Sydney"
        };
        bank.addBranch(branches[0]);
        String[] adelaideCustomers = {
                "Tim",
                "Mike",
                "Percy"
        };
        double[] adelaideInitialAmounts = {
                50.05,
                175.34,
                220.12
        };
        String[] sydneyCustomers = {
                "Bob"
        };
        double[] sydneyInitialAmounts = {
                150
        };

        addBranches(bank, branches);

        addCustomers(bank, branches[0], adelaideCustomers, adelaideInitialAmounts);
        addCustomers(bank, branches[1], sydneyCustomers, sydneyInitialAmounts);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers(branches[0], true);
        bank.listCustomers(branches[1], true);

        bank.addBranch("Melbourne");

        if(!bank.addCustomer("Melbourne", "Brian", 5.53)) {
            System.out.println("Error Melbourne branch does not exists.");
        }

        if (!bank.addBranch("Adelaide")) {
            System.out.println("Adelaide branch already exists.");
        }

        if (!bank.addCustomerTransaction("Adelaide", "Fergus", 52.33)) {
            System.out.println("Customer does not exist at branch.");
        }

        if (!bank.addCustomer("Adelaide", "Tim", 12.12)) {
            System.out.println("customer Tim already exists.");
        }
    }

    private static void addCustomers(Bank bank, String branch, String[] customers, double[] initialAmounts) {
        for (int i = 0; i < customers.length; i++) {
            bank.addCustomer(branch, customers[i], initialAmounts[i]);
        }
    }

    private static void addBranches(Bank bank, String[] branches) {
        for (int i = 0; i < branches.length; i++) {
            bank.addBranch(branches[i]);
            System.out.println(branches[i] + " branch created.");
        }
    }
}
