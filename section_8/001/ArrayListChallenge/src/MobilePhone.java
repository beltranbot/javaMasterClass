import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contactArrayList;

    public MobilePhone() {
        this.contactArrayList = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (findContactByName(name) != null || findContactByPhoneNumber(phoneNumber) != null) {
            System.out.println("Contact with the given name or phoneNumber already exists.");
            return;
        }

        Contact contact = new Contact(name, phoneNumber);
        this.contactArrayList.add(contact);
        System.out.println("New contact: " + contact + " added");
    }

    public void printContacts() {
        System.out.println();
        System.out.println("Contact list");
        if (this.contactArrayList.size() == 0) {
            System.out.println("No contacts found.");
            return;
        }
        for (int i = 0; i < this.contactArrayList.size(); i++) {
            System.out.println((i + 1) + ". " + contactArrayList.get(i));
        }
    }

    public void updateContactByName(String name) {
        int position = getContactPositionByName(name);
        int newPosition = getContactPositionByName(name);
        if (position != newPosition) {
            System.out.println("Name " + name + " is already in use.");
            return;
        }
        if (!(position >= 0)) {
            System.out.println("Contact no found.");
            return;
        }
        Contact oldContact = this.contactArrayList.get(position);
        Contact contact = new Contact(name, oldContact.getPhoneNumber());

        updateContact(position, contact);
    }

    public void updateContactByPhoneNumber(String phoneNumber) {
        int position = getContactPositionByPhoneNumber(phoneNumber);
        int newPosition = getContactPositionByPhoneNumber(phoneNumber);
        if (position != newPosition) {
            System.out.println("Phone number is already in use.");
            return;
        }
        if (!(position >= 0)) {
            System.out.println("Contact no found.");
            return;
        }
        Contact oldContact = this.contactArrayList.get(position);
        Contact contact = new Contact(oldContact.getName(), phoneNumber);

        updateContact(position, contact);
    }

    private void updateContact(int position, Contact contact) {
        String output = "Contact " + this.contactArrayList.get(position).toString() + " updated to " + contact;
        this.contactArrayList.set(position, contact);
        System.out.println(output);
    }

    public Contact findContactByName(String name) {
        for (int i = 0; i < this.contactArrayList.size(); i++) {
            if (this.contactArrayList.get(i).getName().equals(name)) {
                return this.contactArrayList.get(i);
            }
        }

        return null;
    }

    public Contact findContactByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < this.contactArrayList.size(); i++) {
            if (this.contactArrayList.get(i).getPhoneNumber().equals(phoneNumber)) {
                return this.contactArrayList.get(i);
            }
        }

        return null;
    }

    private int getContactPositionByName(String name) {
        for (int i = 0; i < this.contactArrayList.size(); i++) {
            if (this.contactArrayList.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    private int getContactPositionByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < this.contactArrayList.size(); i++) {
            if (this.contactArrayList.get(i).getName().equals(phoneNumber)) {
                return i;
            }
        }

        return -1;
    }

    public void removeContact(String name) {
        int position = getContactPositionByName(name);
        if (position == -1) {
            System.out.println("Contact no found");
            return;
        }
        removeContact(position);
    }

    private void removeContact(int position) {
        Contact contact = this.contactArrayList.get(position);
        this.contactArrayList.remove(position);
        System.out.println("Contact " + contact + " was removed from the list.");
    }

    public void updateContact(Contact contact, String name, String phoneNumber) {
        int position = getContactPositionByName(contact.getName());
        int positionName = getContactPositionByName(name);
        if (positionName != -1 && position != positionName) {
            System.out.println(position + " " + positionName);
            System.out.println("Name ["+ name + "] is already in use.");
            return;
        }
        int positionPhoneNumber = getContactPositionByPhoneNumber(phoneNumber);
        if (positionPhoneNumber != -1 && position != positionPhoneNumber) {
            System.out.println("Phone number [" + phoneNumber+ "] is already in use.");
        }
        Contact newContact = new Contact(name, phoneNumber);
        updateContact(position, newContact);
    }


}
