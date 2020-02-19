public class LinkedList {
    ListItem head;

    public void addItem(String item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
            return;
        }

        ListItem currentNode = head;
        while (true) {
            int compareResult = node.compareTo(currentNode);
            if (compareResult == 0) {
                break;
            }
            if (compareResult > 0) {
                if (currentNode.getRight() == null) {
                    node.setLeft(currentNode);
                    currentNode.setRight(node);
                    break;
                }
                currentNode = currentNode.getRight();
                continue;
            }
            if (compareResult < 0) {
                if (currentNode.getLeft() != null) {
                    currentNode.getLeft().setRight(node);
                }
                node.setLeft(currentNode.getLeft());
                node.setRight(currentNode);
                currentNode.setLeft(node);
                if (node.getLeft() == null) {
                    head = node;
                }
                break;
            }
        }
    }

    public void printList() {
        ListItem listItem = head;
        int i = 0;
        while (listItem != null) {
            System.out.println(i + ": " + listItem.getValue());
            listItem = listItem.getRight();
            i++;
        }
    }
}
