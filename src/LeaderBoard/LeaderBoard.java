/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeaderBoard;

import DatabaseClass.DBConnection;
import glory.schema.PlayersElement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suhasini
 */
public class LeaderBoard {
    
    public List<PlayersElement> PlayerListByTrophies(){
        List<PlayersElement> playerList=null;
        try{
        DBConnection db =new DBConnection();
        String query="SELECT * FROM player ORDER BY trophies DESC LIMIT 5";
        ResultSet rst= (ResultSet) db.fetch(query);
        
        while(rst.next()){
            PlayersElement player=new PlayersElement();
            player.setPlayerID(rst.getInt("playerId"));
            player.setPlayerName(rst.getString("Name"));            
            player.setHighscore(rst.getInt("highScore"));
            player.setTrophies(rst.getInt("trophies"));
            
            playerList.add(player);            
        }
        
        }catch(Exception ex){
         Logger.getLogger(LeaderBoard.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return playerList;
    
    }
    
    
    public List<PlayersElement> PlayerListByHighScore(){
        List<PlayersElement> playerList=null;
        try{
        DBConnection db =new DBConnection();
        String query="SELECT * FROM player ORDER BY highScore DESC LIMIT 5";
        ResultSet rst= (ResultSet) db.fetch(query);
        
        while(rst.next()){
            PlayersElement player=new PlayersElement();
            player.setPlayerID(rst.getInt("playerId"));
            player.setPlayerName(rst.getString("Name"));            
            player.setHighscore(rst.getInt("highScore"));
            player.setTrophies(rst.getInt("trophies"));
            
            playerList.add(player);            
        }
        
        }catch(Exception ex){
         Logger.getLogger(LeaderBoard.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return playerList;
    
    }
    
}
