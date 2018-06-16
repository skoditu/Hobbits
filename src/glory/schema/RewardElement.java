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
public class RewardElement extends ScoreElement{
    
    public int trophies;
    public int playerID;
    public int score;
    
    public RewardElement(int trophies, int playerID, int score,boolean wordValidity) {  
        super(playerID,wordValidity,score);
        this.trophies = trophies;
        this.playerID = playerID;
        this.score= score;
    }
     public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTrophies() {
        return trophies;
    }

    public int getPlayerID() {
        return playerID;
    }

    public int getScore() {
        return score;
    }
    
    
    
}
