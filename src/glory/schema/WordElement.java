/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory.schema;

/**
 *
 * @author Hashane
 */
public class WordElement {

    private int noOfLetters;
    private boolean valid;
    private String word;
    private String[] wordArray;

    public WordElement() {
    }

    public WordElement(int noOfLetters, boolean valid) {
        this.noOfLetters = noOfLetters;
        this.valid = valid;
    }

    public int getNoOfLetters() {
        return noOfLetters;
    }

    public void setNoOfLetters(int noOfLetters) {
        this.noOfLetters = noOfLetters;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String WordDef(String letter1, String letter2, String letter3, String letter4, String letter5,
            String letter6, String letter7, String letter8, String letter9, String letter10, String letter11) {

        word = letter1 + letter2 + letter3 + letter4 + letter5 + letter6 + letter7 + letter8 + letter9 + letter10 + letter11;

        String[] wordArray = {letter1, letter2, letter3, letter4, letter5, letter6, letter7, letter8, letter9, letter10, letter11};

        return word.trim();
    }

    public int noOfLetters(String word) {
        noOfLetters = word.trim().length();
        return noOfLetters;
    }
}
