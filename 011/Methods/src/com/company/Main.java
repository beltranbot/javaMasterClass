package com.company;

public class Main {

    public static void main(String[] args) {

        int highScore = calculateScore(
                true,
                00,
                5,
                100
        );
        System.out.println("Your final score was " + highScore);

        highScore = calculateScore(
                true,
                10000,
                8,
                200
        );

        System.out.println("Your final score was " + highScore);

        // challenge
        // create a method called displayHighScorePosition
        // it should receive a players name as parameter, and a 2nd parameter as position in the highscore table
        // you should display the players name along with a message like " managed to get into position " and the
        // position they got and a further message "
        // on the high score table
        //
        // create a 2nd method called calculateHIghScorePosition
        // it should be sent one argument only, the player score
        // it should return an int
        // the return data should be
        // 1 if the score is > 1000
        // 2 if the score is > 500 and < 1000
        // 3 if the score is > 100 and < 500
        // 4 in all other cases
        // call both methods and display the results of the following
        // a score of 1500, 900, 400 and 50

        int position = calculateHighScorePosition(1500);
        displayHighScorePosition("Alice", position);

        position = calculateHighScorePosition(900);
        displayHighScorePosition("Bob", position);

        position = calculateHighScorePosition(400);
        displayHighScorePosition("Cathy", position);

        position = calculateHighScorePosition(50);
        displayHighScorePosition("Dylan", position);


    }

    public static int calculateScore(
            boolean gameOver,
            int score,
            int levelCompleted,
            int bonus
    ) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
            return finalScore;
        }
        return -1;
    }

    public static void displayHighScorePosition (
            String playerName,
            int position
    ) {
        System.out.println(
                playerName +
                " managed to get into position " +
                position +
                " on the high score table."
        );
    }

    public static int calculateHighScorePosition (int playerScore) {
        int result = 4;
        if (playerScore >= 1000) {
            result = 1;
        } else if (playerScore >= 500) {
            result = 2;
        } else if (playerScore >= 100) {
            result = 3;
        }
        return result;
    }


}
