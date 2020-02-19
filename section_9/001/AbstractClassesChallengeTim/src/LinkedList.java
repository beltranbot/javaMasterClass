public class LinkedList implements NodeList {
    private ListItem root = null;

    public LinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            // the list was empty, so this item becomes the head of the list
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;

        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);

            if (comparison < 0) {
                // newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no next, so insert at end of list
                    currentItem.setNext(item);
                    item.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                // item is less, insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(item);
                    item.setPrevious(currentItem.previous());
                    item.setNext(currentItem);
                    currentItem.setPrevious(item);
                } else {
                    // the node with a privous is the root
                    item.setNext(this.root);
                    this.root.setPrevious(item);
                    this.root = item;
                }
                return true;
            } else {
                // equal
                System.out.println(item.getValue() + " is already present, no added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}
