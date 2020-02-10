import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        LinkedList<String> places = new LinkedList<>();
        addInOrder(places, "Sydney");
        addInOrder(places, "Melbourne");
        addInOrder(places, "Brisbane");
        addInOrder(places, "Perth");
        addInOrder(places, "Canberra");
        addInOrder(places, "Adelaide");
        addInOrder(places, "Darwin");
        printList(places);

        addInOrder(places, "Alice Springs");
        addInOrder(places, "Darwin");
        printList(places);

        visit(places);

//        places.add("Sydney");
//        places.add("Melbourne");
//        places.add("Brisbane");
//        places.add("Perth");
//        places.add("Canberra");
//        places.add("Adelaide");
//        places.add("Darwin");

//        printList(places);
//        printListFor(places);

//        places.add(1, "Alice Springs");
//        printList(places);
//
//        places.remove(4);
//        printList(places);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("====================");
    }

    private static void printListFor(LinkedList<String> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("Now visiting " + linkedList.get(i));
        }
        System.out.println("====================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String city) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(city);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(city + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // new city should appear before this one
                // Brisbane -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(city);
                return true;
            } else if (comparison < 0) {
                // move on next city
            }
        }

        stringListIterator.add(city);
        return true;
    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.getFirst().isEmpty()) {
            System.out.println("No cities in the itinerary");
            return;
        }

        System.out.println("now Visiting " + listIterator.next());
        printMenu();

        while (!exit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Holiday (vacation) over.");
                    exit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next() + ".");
                    } else {
                        System.out.println("Reached the end of the list.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous() + ".");
                    } else {
                        System.out.println("We are at the start of the list.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                default:
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options"
        );
    }
}
