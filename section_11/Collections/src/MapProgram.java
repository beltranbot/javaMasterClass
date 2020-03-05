import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level, object-orientated, platform independent language");
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the Map");
        } else {
            System.out.println(languages.put("Java", "this course is about java"));
            System.out.println(languages.get("Java"));
        }

        System.out.println("=========================");
        // languages.remove("Lisp");

        // check for kay/value pair
        if (languages.remove("Algol", "a family of algorithmic languages")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

//        System.out.println(languages.replace("Lisp", "A functional programming language with imperative features"));
        System.out.println(languages.replace("Scala", "this will not be added"));

        // find in replace
        if (languages.replace("Lisp", "this will not work", "A functional programming language with imperative features")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }

        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

    }
}
