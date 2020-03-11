import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, HeavenlyBody> solarSysten = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody heavenlyBody = new HeavenlyBody("Mercury", 88);
        solarSysten.put(heavenlyBody.getName(), heavenlyBody);
        planets.add(heavenlyBody);

        heavenlyBody = new HeavenlyBody("Venus", 225);
        solarSysten.put(heavenlyBody.getName(), heavenlyBody);
        planets.add(heavenlyBody);

        heavenlyBody = new HeavenlyBody("Earth", 365);
        solarSysten.put(heavenlyBody.getName(), heavenlyBody);
        planets.add(heavenlyBody);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSysten.put(tempMoon.getName(), tempMoon);
        heavenlyBody.addMoon(tempMoon);

        heavenlyBody = new HeavenlyBody("Mars", 687);
        solarSysten.put(heavenlyBody.getName(), heavenlyBody);
        planets.add(heavenlyBody);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSysten.put(tempMoon.getName(), tempMoon);
        heavenlyBody.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSysten.put(tempMoon.getName(), tempMoon);
        heavenlyBody.addMoon(tempMoon);

        heavenlyBody = new HeavenlyBody("Jupiter", 4332);
        solarSysten.put(heavenlyBody.getName(), heavenlyBody);
        planets.add(heavenlyBody);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSysten.put(tempMoon.getName(), tempMoon);
        heavenlyBody.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSysten.put(tempMoon.getName(), tempMoon);
        heavenlyBody.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSysten.put(tempMoon.getName(), tempMoon);
        heavenlyBody.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSysten.put(tempMoon.getName(), tempMoon);
        heavenlyBody.addMoon(tempMoon);

        heavenlyBody = new HeavenlyBody("Saturn", 10759);
        solarSysten.put(heavenlyBody.getName(), heavenlyBody);
        planets.add(heavenlyBody);

        heavenlyBody = new HeavenlyBody("Uranus", 30660);
        solarSysten.put(heavenlyBody.getName(), heavenlyBody);
        planets.add(heavenlyBody);

        heavenlyBody = new HeavenlyBody("Neptune", 165);
        solarSysten.put(heavenlyBody.getName(), heavenlyBody);
        planets.add(heavenlyBody);

        heavenlyBody = new HeavenlyBody("Pluto", 248);
        solarSysten.put(heavenlyBody.getName(), heavenlyBody);
        planets.add(heavenlyBody);

        System.out.println("Plannets");

        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = solarSysten.get("Jupiter");
        System.out.println("Moons of " + body.getName());

        for (HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");

        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);
        for (HeavenlyBody planet : planets) {
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        }

        Object o = new Object();
        o.equals(o);
        "pluto".equals("");
    }
}
