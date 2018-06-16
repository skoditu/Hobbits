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
public class PenealtyElement extends ScoreElement{
    
     private int penalty;
    private int playerID;
    
    public PenealtyElement(int penalty, int playerID,int score,boolean wordValidity) {
        super(playerID,wordValidity,score);
        this.penalty = penalty;
        this.playerID = playerID;
    }
    
    public int getPenalty() {
        return penalty;
    }
    

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    
    
}
