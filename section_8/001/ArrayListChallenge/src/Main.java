import java.util.Scanner;

public class Main {

    /*
    * create a program that implements a simple mobile phone with the following capabilities
    * able to store, modify, remove and query contact names.
    * you will want to create a separate class for Contacts (name and phone number)
    * Create a master class (MobilePhone) that holds the ArrayList of Contacts
    * The MobilePhone class has the functionality listed above.
    * Add a menu of options that are available
    * Options: Quit, print list of contacts, add new contact, update existing contact, remove contact
    * and search/find contact
    * when adding or updating be sure to check if the contact already exists (use name)
    * Be sure not to expose the inner workings of the ArrayList to MobilePhone
    * e.g. no ints, not .get(i) etc
    * MobilePhone should do everything with Contact objects only
    * */

    public static Scanner scanner = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        while (true) {
            printOptionsMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            if (handleOption(option)) {
                break;
            }
        }
    }

    public static void printOptionsMenu() {
        System.out.println();
        System.out.println("Menu: ");
        System.out.println("\t0 - Quit");
        System.out.println("\t1 - List Contacts");
        System.out.println("\t2 - Add Contact");
        System.out.println("\t3 - Update Contact");
        System.out.println("\t4 - Remove Contact");
        System.out.print("Select an option: ");
    }

    public static boolean handleOption(int option) {
        boolean exit = false;

        switch (option) {
            case 0:
                exit = true;
                break;
            case 1:
                mobilePhone.printContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                updateContact();
                break;
            case 4:
                removeContact();
            default:
                break;
        }

        return exit;
    }

    private static void addContact() {
        System.out.println();
        System.out.print("Enter the contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the contact phone number: ");
        String phoneNumber = scanner.nextLine();

        mobilePhone.addContact(name, phoneNumber);
    }

    private static void updateContact() {
        System.out.println();
        System.out.print("Enter the name of the contact to edit: ");
        String name = scanner.nextLine();
        Contact oldContact = mobilePhone.findContactByName(name);
        if(oldContact == null) {
            System.out.println("Contact by name [" + name + "] not found.");
            return;
        }
        System.out.print("Enter the new contact name (current: " + oldContact.getName() + "): ");
        String newName = scanner.nextLine();
        System.out.print("Enter the new contact phone number (current: " + oldContact.getPhoneNumber() + "): ");
        String newPhoneNumber = scanner.nextLine();
        mobilePhone.updateContact(oldContact, newName, newPhoneNumber);
    }

    private static void removeContact() {
        System.out.println();
        System.out.print("Enter the contact name to remove: ");
        String name = scanner.nextLine();
        mobilePhone.removeContact(name);
    }
}
