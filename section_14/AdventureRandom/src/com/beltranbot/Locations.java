package com.beltranbot;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile randomAccessFile;

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("locations_rand.dat", "rwd")) {
            randomAccessFile.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + randomAccessFile.getFilePointer() + Integer.BYTES);
            randomAccessFile.writeInt(locationStart);
            long indexStart = randomAccessFile.getFilePointer();
            int startPointer = locationStart;
            randomAccessFile.seek(startPointer);
            for (Location location : locations.values()) {
                randomAccessFile.writeInt(location.getLocationID());
                randomAccessFile.writeUTF(location.getDescription());
                StringBuilder stringBuilder = new StringBuilder();

                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        stringBuilder.append(direction);
                        stringBuilder.append(",");
                        stringBuilder.append(location.getExits().get(direction));
                        stringBuilder.append(",");
                    }
                }

                randomAccessFile.writeUTF(stringBuilder.toString());
                IndexRecord indexRecord = new IndexRecord(startPointer, (int) randomAccessFile.getFilePointer() - startPointer);
                index.put(location.getLocationID(), indexRecord);
                startPointer = (int) randomAccessFile.getFilePointer();
            }

            randomAccessFile.seek(indexStart);
            for (Integer locationId : index.keySet()) {
                randomAccessFile.writeInt(locationId);
                randomAccessFile.writeInt(index.get(locationId).getStartByte());
                randomAccessFile.writeInt(index.get(locationId).getLength());
            }
        }
    }

    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section bytes (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long. It will start at byte 8 and end at byte 1692)
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700.

    static {

        try {
            randomAccessFile = new RandomAccessFile("locations_rand.dat", "rwd");
            int numberOfLocations = randomAccessFile.readInt();
            long locationStartPoint = randomAccessFile.read();

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

//        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            while(true) {
//                try {
//                    Location location = (Location) locFile.readObject();
//                    System.out.println("Read location" + location.getLocationID() + " : " + location.getDescription());
//                    System.out.println("Found " + location.getExits().size() + " exits");
//                    locations.put(location.getLocationID(), location);
//                } catch (EOFException eofException) {
//                    break;
//                }
//            }
//        } catch (IOException | ClassNotFoundException exception) {
//            exception.printStackTrace();
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
