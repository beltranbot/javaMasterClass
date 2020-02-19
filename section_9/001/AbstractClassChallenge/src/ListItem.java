public abstract class ListItem {

    private ListItem left;
    private ListItem right;
    private String value;

    public ListItem(ListItem left, ListItem right, String value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public ListItem(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setLeft(ListItem left) {
        this.left = left;
    }

    public void setRight(ListItem right) {
        this.right = right;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public int compareTo(ListItem listItem) {
        return this.value.compareTo(listItem.value);
    }

    public ListItem getLeft() {
        return left;
    }

    public ListItem getRight() {
        return right;
    }
}
