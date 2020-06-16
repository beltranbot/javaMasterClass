package com.beltranbot;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile randomAccessFile;

    public static void main(String[] args) throws IOException {
//        writeLocationsToRandomAccessFile();
    }

    static {
        try {
            loadLocationsFromRandomAccessFile();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
    * this function might take a while to complete, to ensure the rest of the
     * application works properly, wait until is done running.
    * */
    private static void writeLocationsToRandomAccessFile() throws IOException {
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")) {
            rao.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationStart);

            long indexStart = rao.getFilePointer();

            int startPointer = locationStart;
            rao.seek(startPointer);

            for (Location location : locations.values()) {
                System.out.println("inside for location id: " + location.getLocationID());
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                rao.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }

            rao.seek(indexStart);
            for (Integer locationID : index.keySet()) {
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }
            System.out.println("For finished");
        }
        System.out.println("Writing finished");
    }

    private static void writeLocationsToFile() throws IOException {
        try (
                BufferedWriter locationsFile = new BufferedWriter(new FileWriter("locations.txt"));
                BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"));
        ) {
            for (Location location : locations.values()) {
                locationsFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
    }

    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section bytes (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long. It will start at byte 8 and end at byte 1692)
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700.

    public static void loadLocationsFromFile() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("locations_big.txt"))) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split(",");
                int location = Integer.parseInt(data[0]);
                String description = data[1];
                System.out.println("imported location: " + location + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(location, new Location(location, description, tempExit));
            }
        }

        // now read the exits

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(loc);
                stringBuilder.append(": ");
                stringBuilder.append(direction);
                stringBuilder.append(": ");
                stringBuilder.append(destination);
                System.out.println(stringBuilder);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        }
    }

    private static void loadLocationsFromRandomAccessFile() throws IOException {
        try {
            randomAccessFile = new RandomAccessFile("locations_rand.dat", "rwd");
            int numberOfLocations = randomAccessFile.readInt();
            long locationStartPoint = randomAccessFile.readInt();

            while (randomAccessFile.getFilePointer() < locationStartPoint) {
                int locationId = randomAccessFile.readInt();
                int locationStart = randomAccessFile.readInt();
                int locationLength = randomAccessFile.readInt();

                IndexRecord indexRecord = new IndexRecord(locationStart, locationLength);
                index.put(locationId, indexRecord);
            }
        } catch (IOException ioException) {
            System.out.println("IOException in static initializer: " + ioException.getMessage());
        }
    }

    public Location getLocation(int locationId) throws IOException {
        IndexRecord indexRecord = index.get(locationId);
        randomAccessFile.seek(indexRecord.getStartByte());
        int id = randomAccessFile.readInt();
        String description = randomAccessFile.readUTF();
        String exits = randomAccessFile.readUTF();
        String[] exitPart = exits.split(",");
        Location location = new Location(locationId, description, null);
        if (locationId != 0) {
            System.out.println("exitPart.length " + exitPart.length);
            printArray(exitPart);
            for (int i = 0; i < exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i + 1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
    }

    private void printArray(Object[] arr) {
        for(Object object : arr) {
            System.out.println(object);
        }
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

    public void close() throws IOException {
        randomAccessFile.close();
    }
}
