public class Main {

    public static void main(String[] args) {
        int newScore = calculateScore("Tim", 500);
        System.out.println("new Score is " + newScore);
        calculateScore(75);
        calculateScore();
        double centimeters = calcFeetAndInchesToCentimeters(0, 9);
        System.out.println("Centimeters: " + centimeters);
        centimeters = calcFeetAndInchesToCentimeters(69);
        System.out.println("Centimeters: " + centimeters);
    }

//    Create a method called calcFeetAndInchesToCentimeters
//    It needs to have two parameters.
//    feet is the first parameter, inches is the 2nd parameter
//
//    you should validate that the first parameter is >= 0
//    you should validate that the 2nd parameter inches is >= 0 and <= 12
//    return -1 from the method if either of the above is not the true
//
//    if the parameters are valid, then calculate how many centimetres
//    comprise the feet and inches passed to this method and return that value
//
//    create a 2nd method of the same name but with only one parameter
//    inches is the parameter
//    validate that its >= 0
//    return -1 if it is not true
//    but if its valid, then calculate how many feet are in the inches
//    and then here is the tricky part
//    call the other overloaded method passing the correct feet and inches
//    calculated so that it can calculate correctly
//    hints: use double for your number datatypes is probably a good idea
//    1 inch = 2.54cm and one foot = 12 inches
//    use the link i give you to confirm your code is calculating correctly
//    calling another overloaded method just requires you to use
//    the right number of parameters

    public static int calculateScore(String playerName, int score) {
        System.out.println("player " + playerName);
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("unnamed player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet < 0 || (inches < 0 || inches > 12)) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }
        double centimeters = ((feet * 12) + inches) * 2.54;
        System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            System.out.println("Invalid inches parameter");
            return -1;
        }

        double feet = (int) inches / 12;
        double remainder = inches % 12;
        System.out.println(inches + " inches is equal to " + feet + " feet and " + remainder + " inches");
        return calcFeetAndInchesToCentimeters(feet, remainder);
    }
}
