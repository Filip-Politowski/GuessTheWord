package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class GuessTheWord {
    private boolean play = true;
    private Words randomWord = new Words();
    private Scanner scanner = new Scanner(System.in);
    private int rounds = 10;
    private char lastRound;
    private char[] answer;

    public void start() {
        do {
            showWord();
            getInput();
            checkInput();

        } while (play);
    }


    void showWord() {
        System.out.println("You have " + rounds + " tries left. If u know the word type the full answer");
        System.out.println(randomWord);
    }

    void getInput() {
        System.out.println("Enter a letter to guess the word: ");
        String userGuess = scanner.nextLine();
        lastRound = userGuess.charAt(0);
        answer = userGuess.toCharArray();

    }

    void checkInput() {
        boolean isGuessedRight = randomWord.guess(lastRound, answer);

        if (isGuessedRight) {
            if (randomWord.isGuessedRight()) {
                System.out.println("Congrats, you won!");
                System.out.println("The word is: " + randomWord);
                play = false;
            }
        } else {
            rounds--;
            if (rounds == 0) {
                System.out.println("Game Over!");
                play = false;
            }
        }
    }

    public void end() {
        scanner.close();
    }
}
