public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        return this.rightLink = item;
    }

    @Override
    ListItem previous() {
        return leftLInk;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        return this.leftLInk = item;
    }

    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        }

        return -1;
    }
}
