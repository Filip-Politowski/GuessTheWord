package org.example;

import java.util.Random;

public class Words {
    private String[] randomWords = {"animals", "happiness", "indefinite", "steady", "birthday", "properties", "ceremony"
            , "independence", "beneath", "students"};
    private String selectedWord;
    private Random random = new Random();
    private char[] letters;

    public Words() {
        selectedWord = randomWords[random.nextInt(randomWords.length)];
        letters = new char[selectedWord.length()];
    }


    public String toString() {
        StringBuilder text = new StringBuilder();

        for (char letter : letters) {

            // the same part of code
            /*  if (letter == '\u0000') {
                text.append('-');
            } else {
                text.append(letter);
            }*/
            //the same part of code
            text.append(letter == '\u0000' ? '-' : letter);
            text.append(' ');


        }

        return text.toString();
    }

    public boolean isGuessedRight() {
        for (char letter : letters) {
            if (letter == '\u0000') {
                return false;
            }
        }
        return true;
    }

    public boolean guess(char letter, char[] answer) {
        boolean guessRight = false;

        if (answer.length == selectedWord.length()) {
            for (int i = 0; i < selectedWord.length(); i++) {

                if (String.valueOf(answer).equals(selectedWord)) {
                    letters[i] = answer[i];
                    guessRight = true;
                } else {
                    System.out.println("Wrong answer ");
                    break;
                }
            }
        }


        for (
                int i = 0; i < selectedWord.length(); i++) {
            if (letter == selectedWord.charAt(i)) {
                letters[i] = letter;
                guessRight = true;
            }
        }

        return guessRight;
    }
}
