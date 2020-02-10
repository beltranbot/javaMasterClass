import java.util.ArrayList;

class IntClass {
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }
}

public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Tim");

        // ArraList<int> intArrayList = new ArrayList<int>(); -> can't be done with primitive types
        ArrayList<IntClass> intArrayList = new ArrayList<IntClass>();
        intArrayList.add(new IntClass(54));

        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerArrayList.add(Integer.valueOf(i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " --> " + integerArrayList.get(i).intValue());
        }

        Integer myIntValue = 56; // Integer.valueOf(56);
        int myInt = myIntValue; // Integer.intValue();

        ArrayList<Double> doubleArrayList = new ArrayList<>();
        for (double i = 0.0; i <= 10.0; i += 0.5) {
            doubleArrayList.add(Double.valueOf(i));
        }

        for (int i = 0; i < doubleArrayList.size(); i++) {
            double value = doubleArrayList.get(i).doubleValue();
            System.out.println(i +" ---> " + value);
        }
    }
}
