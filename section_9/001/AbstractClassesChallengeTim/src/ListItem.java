public abstract class ListItem {

    protected ListItem rightLink = null;
    protected ListItem leftLInk = null;

    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem next);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem previous);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return this.value = value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
