package de.yimrim.hangman;

import java.util.Arrays;

public class HangMan {

    private String word;
    private int failAmount;
    private char[] def;
    private int allowedAttempts;
    private String afterGuessMessage = "";


    public HangMan(String word, int allowedAttempts) {
        this.word = word.toLowerCase();
        this.allowedAttempts = allowedAttempts;
        setUp();
    }

    public int getFailAmount() {
        return failAmount;
    }

    public String getAfterGuessMessage() {
        return afterGuessMessage;
    }

    public void setUp() {
        def = new char[word.length()];
        Arrays.fill(def, '-');
    }


    public String getDef() {
        String s = new String(def);
        return s;
    }


    public void guess(String g) {
        char[] temp;
        temp = g.toLowerCase().toCharArray();
        char guess = temp[0];

        int fails = 0;

        for (int i = 0; i < word.length(); i++) {
            char cAtIndex = word.charAt(i);

            if (cAtIndex == guess) {
                def[i] = guess;
                afterGuessMessage = guess + " is correct";
            } else {
                fails++;
                if (fails == word.length()) {
                    afterGuessMessage = guess + " is not included";
                    failAmount++;
                }
            }
        }
    }

    public boolean isWon() {
        int correctAmount = 0;

        for (int i = 0; i < def.length; i++) {
            if (def[i] != '-') {
                correctAmount++;
            }
            if (correctAmount == def.length) {
                return true;
            }
        }
        return false;
    }

    public boolean isFailed() {
        return failAmount == allowedAttempts;

    }
}