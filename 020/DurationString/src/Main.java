public class Main {

    /*
     * create a method called getDurationString with two parameters, first parameter
     * minutes and 2nd parameter seconds, both ints.
     * You should validate that the first parameter minutes is >= 0
     * You should validate that the 2nd parameter seconds is >= 0 and <= 59
     * the method should return "Invalid value" in the method if either of the above are not true
     * if the parameters are valid then calculate how many hours minutes and seconds
     * equal the minutes and seconds passed to this method and return that value as
     * string format "XXh YYm ZZs" where XX represents a number of hours, YY the minutes
     * and ZZ the seconds.
     * */

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        System.out.println(getDurationString(61L, 0L));
        System.out.println(getDurationString(3945L));
        System.out.println(getDurationString(-44L));

    }

    public static String getDurationString(long minutes, long seconds) {
        if (!(minutes >= 0) || !(seconds >= 0 && seconds <= 59)) {
            return INVALID_VALUE_MESSAGE;
        }
        long hours = minutes / 60;
        long remainderMinutes = minutes % 60;
        String hoursString = (hours >= 10 ? hours : "0" + hours) + "h ";
        String minutesString = (remainderMinutes >= 10 ? remainderMinutes : "0" + remainderMinutes) + "m ";
        String secondsString = (seconds >= 10 ? seconds : "0" + seconds) + "s";
        return hoursString + minutesString + secondsString;
    }

    public static String getDurationString(long seconds) {
        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }
        long minutes = seconds / 60;
        long remainderSeconds = seconds % 60;
        return getDurationString(minutes, remainderSeconds);
    }


}
