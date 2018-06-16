/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import DatabaseClass.DBConnection;
import glory.schema.PlayersElement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suhasini
 */
public class Register {
    
    DBConnection db = new DBConnection();

   // check whether inserted username is exists in database
    public boolean ValidateExistingPlayers(PlayersElement newPlayer){
        
        boolean returnValue=false;
        try{
            String query="SELECT * FROM player  WHERE Name = '"+newPlayer.getPlayerName()+"' LIMIT 1";            
            ResultSet rs= (ResultSet) db.fetch(query);
            if(rs==null){
                returnValue=false;            
            }else{
                returnValue=true;
            }
            while(rs.next()){
                if((rs.getString("playerName")!=null)||(!"".equals(rs.getString("playerName")))){
                returnValue=true;
                }
            }
        }catch(Exception ex){
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return returnValue;
    }
    
    //Register new player
    public int RegisterPlayer(PlayersElement newPlayer){

         int val = 0;
        
        try{
            //first check new player has unique username
           if(this.ValidateExistingPlayers(newPlayer)){
               String query="INSERT INTO player (playerId,NAME,PASSWORD,highScore,trophies )VALUES( NULL,'"+newPlayer.getPlayerName()+"','"+newPlayer.getPassword()+"',NULL,NULL)";  

           PreparedStatement statement= db.InsertUpdate(query);     
               val = statement.executeUpdate();
                statement = null;           
           }
           else{
               System.out.println("USERNAME EXISTS");
           }
        

        }catch(Exception ex){
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return val;
    }
}
