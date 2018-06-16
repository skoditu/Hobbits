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
public class PlayersElement {
    private int playerID;
    private String playerName;
    private String password;
    private int highscore;
    private int trophies;

    public PlayersElement() {
    }

    public PlayersElement(int playerID, String playerName, String password, int highscore, int trophies) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.password = password;
        this.highscore = highscore;
        this.trophies = trophies;
    }

   
    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }
    
    
}
