/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score_system;

import DatabaseClass.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harmlk
 */
public class letter_score {
    int score_ = 0;
    
    public int Get_Score_by_Word(String word_){

        for(int i = 0; i< word_.length(); i++){
            char c = word_.charAt(i);
            score_ = score_ + this.Get_Score_by_Letter(c);
        }
        return score_;
    }
    
    
    public int Get_Score_by_Letter(char c){
        int letter_val_ = 0;
        
        //get the database value
        DBConnection db = new DBConnection();
        try {
            ResultSet rs = (ResultSet) db.fetch("Select score from letter where letter='" + c + "'");
            while (rs.next()) {
                letter_val_ = rs.getInt("score");
            }
            rs.close();
            rs = null;

        } catch (SQLException ex) {
            Logger.getLogger(Basic_score.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Basic_score.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return letter_val_;
    }
}
