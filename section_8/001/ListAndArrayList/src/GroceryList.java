import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    private void modifyGroceryItem(int position, String item) {
        groceryList.set(position, item);
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= -1) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
//        String item = groceryList.get(position);
        groceryList.remove(position);
    }

    private int findItem(String item) {
//        boolean exists = groceryList.contains(item);
        return groceryList.indexOf(item);

    }

    public void modifyGroceryItem(String item, String newItem) {
        int position = findItem(item);
        if (position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }

    public boolean onFile(String item) {
        int position = findItem(item);
        return position >= 0;
    }
}
