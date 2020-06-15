package com.beltranbot;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("writing location " + location.getLocationID() + " :" + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1);
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }

    static {
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while(!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    System.out.println("locId: " + locID);
                    String description = locFile.readUTF();
                    int numExists = locFile.readInt();
                    System.out.println("read location " + locID +  " : " + description);
                    System.out.println("found " + numExists + " exists");

                    for (int i = 0; i < numExists; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + ", " + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));
                } catch(IOException ioException) {
                    eof = true;
                }
            }
        } catch (IOException ioException) {
            System.out.println("IO exception");
        }
        // --
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("locations_big.txt"))) {
//            String input;
//            while ((input = bufferedReader.readLine()) != null) {
//                String[] data = input.split(",");
//                int location = Integer.parseInt(data[0]);
//                String description = data[1];
//                System.out.println("imported location: " + location + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(location, new Location(location, description, tempExit));
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//
//        // now read the exits
//
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//            while ((input = bufferedReader.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                StringBuilder stringBuilder = new StringBuilder();
//                stringBuilder.append(loc);
//                stringBuilder.append(": ");
//                stringBuilder.append(direction);
//                stringBuilder.append(": ");
//                stringBuilder.append(destination);
//                System.out.println(stringBuilder);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
