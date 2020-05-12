import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exists;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {
            this.exists = new HashMap<>(exits);
        } else {
            this.exists = new HashMap<>();
        }
        this.exists.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExists() {
        return new HashMap<String, Integer>(exists);
    }
}
