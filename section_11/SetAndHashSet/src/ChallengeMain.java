import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChallengeMain {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

    }
}
