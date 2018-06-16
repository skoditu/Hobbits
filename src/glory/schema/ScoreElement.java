/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory.schema;

/**
 *
 * @author Suhasini
 */
public class ScoreElement {

    private int playerID;
    private boolean wordValidity;
    private int score;

    public ScoreElement(int playerID, boolean wordValidity, int score) {

        this.playerID = playerID;
        this.wordValidity = wordValidity;
        this.score = score;
    }

    public ScoreElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public boolean isWordValidity() {
        return wordValidity;
    }

    public void setWordValidity(boolean wordValidity) {
        this.wordValidity = wordValidity;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int highScore(int[][] scoreList) {
        //highest score player identify 
        int playerId = 0;
        int highscore = 0;
        for (int i = 0; i < scoreList.length; i++) {
            if (scoreList[i][1] > scoreList[highscore][1]) {
                highscore = i;
                playerId = scoreList[i][0];
            }
        }
        return playerId;
    }

    public int initialLetters(String[] word, String letter1, String letter2, String letter3, int score) {
        //intial letters score system
        int initialLettersScore = 10;
        boolean CheckLetter1 = false;
        boolean CheckLetter2 = false;
        boolean CheckLetter3 = false;

        for (int i = 0; i < word.length; i++) {

            if (!CheckLetter1) {
                if (word[i].trim() == letter1) {
                    score = score + initialLettersScore;
                }
                CheckLetter1 = true;
            }
            else if (!CheckLetter2) {
                if (word[i].trim() == letter2) {
                    score = score + initialLettersScore;
                }
                CheckLetter2 = true;
            }
           else if (!CheckLetter3) {
                if (word[i].trim() == letter3) {
                    score = score + initialLettersScore;
                }
                CheckLetter3 = true;
            }
        }

        return score;
    }

    public int longestLetters(String word, int score) {
        //longest letter
        if (word.length() == 11) {
            score = score + 10;
        }
        return score;
    }

    public int roundScore(int[] roungScoreList) {
        //score the total per player
        int score = 0;
        for (int i = 0; i < roungScoreList.length; i++) {
            score = roungScoreList[i];
        }
        return score;
    }

}
