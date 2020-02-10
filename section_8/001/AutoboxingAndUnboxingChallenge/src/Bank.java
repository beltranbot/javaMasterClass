import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != null) {
            return false;
        }

        this.branches.add(new Branch(branchName));
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        return branch.newCustomer(customerName, initialAmount);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        return branch.addCustomerTransaction(customerName, amount);
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        System.out.println("Customer details for branch " + branch.getName());

        ArrayList<Customer> customers = branch.getCustomers();
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println("Customer: " + customer.getName() + " [" + (i + 1) + "]");
            if (showTransactions) {
                System.out.println("Transactions");
                ArrayList<Double> transactions = customer.getTransactions();
                for (int j = 0; j < transactions.size(); j++) {
                    System.out.println("[" + (j + 1) + "] Amount: " + transactions.get(j));
                }
            }
        }

        return true;
    }
}
