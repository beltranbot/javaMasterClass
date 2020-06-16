package com.beltranbot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private final static int INITIAL_LOCATION = 64;

    public static void main(String[] args) {
        // Change the program to allow players to type full words, or phrases, then move to the
        // correct location based upon their input.
        // The player should be able to type commands such as "Go West", "run South", or just "East"
        // and the program will move to the appropriate location if there is one.  As at present, an
        // attempt to move in an invalid direction should print a message and remain in the same place.
        //
        // Single letter commands (N, W, S, E, Q) should still be available.

        /**
        * challenge 2
         * part 1:
         * modify the program so tha it uses a bufferedReader to read in the locations data.
         * Run the program to test it before moving on to part 2.
         *
         * part 2:
         * Modify the main method of the Locations class so that it uses a
         * BufferedWriter to write the data.
         *
         * Open the locations.txt and directions.txt files to check that the data has been written successfully.
         *
         * you will then need to make another change to the program to allow
         * for the 0 (Quit) exits before using the newly created files
         *
         * hint: you may wan t to change the three instances of HashMap to
         * LinkedHashMap in the Location class and one instance in the
         * Locations class so that you can compare the files more easily
        * */
        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = INITIAL_LOCATION
                ;
        while(true) {
            System.out.println(locations.get(loc).getDescription());

            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
