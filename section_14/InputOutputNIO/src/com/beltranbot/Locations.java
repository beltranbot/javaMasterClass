package com.beltranbot;

import jdk.dynalink.linker.support.DefaultInternalObjectFilter;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static final String LOCATIONS_FILE = "locations_big.txt";
    private static final String DIRECTIONS_FILE = "directions_big.txt";
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        writeObjectToFileUsingNIO();
    }

    static {
        loadLocationsObjectsUsingNIO();
    }

    private static void loadLocationsObjectsUsingNIO() {
        Path locationsPath = FileSystems.getDefault().getPath(LOCATIONS_FILE);
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locationsPath)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(), location);
                } catch (EOFException eofException) {
                    eof = true;
                }
            }
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private static void writeObjectToFileUsingNIO() {
        Path locationsPath = FileSystems.getDefault().getPath(LOCATIONS_FILE);
        Path directionsPath = FileSystems.getDefault().getPath(DIRECTIONS_FILE);

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locationsPath)))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void writeToFileUsingNIO() {
        Path locationsPath = FileSystems.getDefault().getPath(LOCATIONS_FILE);
        Path directionsPath = FileSystems.getDefault().getPath(DIRECTIONS_FILE);
        try (
                BufferedWriter locationsFile = Files.newBufferedWriter(locationsPath);
                BufferedWriter directionsFile = Files.newBufferedWriter(directionsPath);
        ) {
            for (Location location : locations.values()) {
                locationsFile.write(
                        location.getLocationID() + "," +
                                location.getDescription() + "\n"
                );
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        String directionString = String.format(
                                "%s,%s,%s\n",
                                location.getLocationID(),
                                direction,
                                location.getExits().get(direction)
                        );
                        directionsFile.write(directionString);
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void loadLocationsUsingIO() {
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
        } catch (IOException ioException) {
            ioException.printStackTrace();
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
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private static void loadLocationsUsingNIO() {
        Path locationsPath = FileSystems.getDefault().getPath(LOCATIONS_FILE);
        Path directionsPath = FileSystems.getDefault().getPath(DIRECTIONS_FILE);

        try (Scanner scanner = new Scanner(Files.newBufferedReader(locationsPath))) {
            scanner.useDelimiter(COMMA_DELIMITER);
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                locations.put(
                        loc,
                        new Location(loc, description, null)
                );
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (BufferedReader dirFIle = Files.newBufferedReader(directionsPath)) {
            String input;

            while ((input = dirFIle.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
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
}
