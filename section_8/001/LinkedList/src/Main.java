import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("Balanace for customer: " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(3);
        integers.add(4);

        for (int i = 0; i < integers.size(); i++) {
            System.out.println(i + ": " + integers.get(i));
        }

        System.out.println("****");

        integers.add(1,2);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(i + ": " + integers.get(i));
        }


    }
}

