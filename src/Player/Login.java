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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hashane
 */
public class Login {

    DBConnection db = new DBConnection();
    public static int userId;
    public static String playerName;
    
    PlayersElement player= new PlayersElement();

    public boolean PlayerLogin(String username, String password) {
        boolean loging = false;
        try {
            DBConnection db = new DBConnection();
            ResultSet rst = (ResultSet) db.fetch("Select * from player where  Name='" + username + "'");
            while (rst.next()) {
                userId = rst.getInt("playerId");
                playerName = rst.getString("Name");
                if (password.equals(rst.getString("password"))) {
                    loging = true;
                } else {
                    loging = false;
                }
            }
            rst.close();
            rst = null;
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loging;
    }

    public void GetPlayerId(String username) {
        try {
            ResultSet rs = (ResultSet) db.fetch("Select * from player where Name='" + username + "'");
            while (rs.next()) {
                userId = rs.getInt("player_id");
            }
            rs.close();
            rs = null;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
