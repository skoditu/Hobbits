/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score_system;

import DatabaseClass.DBConnection;
import Player.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harmlk
 */
public class temp_score {
    
    DBConnection db = new DBConnection();
    
    //public int calc_temp_score(String word_, int no_of_players_, String unused_letters_, char a[][]){
    public int calc_temp_score(String word_, int no_of_players_, String unused_letters_, int count_bonus_letters_){
        int temp_score_ = 0;
        int special_score_ = 0;
        int basic_score_ = 0;
        int bonus_score_ = 0;
        int unused_letters_score_ = 0;
        
        Basic_score obj = new Basic_score();
        basic_score_ = obj.calc_basic_score(word_);
        
        if(count_bonus_letters_ != 0){
            Bonus_Letter_Score obj_bonus = new Bonus_Letter_Score();
            bonus_score_ = obj_bonus.calc_bonus_score(count_bonus_letters_);
            
            if(count_bonus_letters_ == 3){
                special_score obj_special = new special_score();
                special_score_ = obj_special.get_special_score(no_of_players_, basic_score_);
                basic_score_ = 0;
            }
        }     
        
        //bonus_score_ = obj_bonus.calc_bonus_score(a);
        //int count_bonus_letters_ = obj_bonus.count_bonus_letters(a);
        
        unused_letters_score obj_unused = new unused_letters_score();
        unused_letters_score_ = obj_unused.calc_unused_letters_score(unused_letters_);
        
        
        temp_score_ = basic_score_ + bonus_score_ + special_score_ - unused_letters_score_;
        
        return temp_score_;
    }
    
    public void set_temp_score(int player_id_, int score_, int place_){
        //add the score to the existing score
        score_ = score_ + get_temp_score(player_id_);

        //set values in temp table
        try{
            String query="INSERT INTO temp_tab (player_Id,score,place )VALUES( '"+player_id_+"','"+score_+"','"+place_+"')";  

           PreparedStatement statement= db.InsertUpdate(query);     
               statement.executeUpdate();
               statement = null;           
        }catch(Exception ex){
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public int get_temp_score(int player_id_){
        //get values from temp table
        int score_ = 0;
        
        try{
            String query="SELECT score FROM temp_tab  WHERE player_id = '"+player_id_+"'";            
            ResultSet rs= (ResultSet) db.fetch(query);
            
            while(rs.next()){
                score_ = rs.getInt("score");
            }
            rs.close();
            rs = null;
            
            
        }catch(Exception ex){
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return score_;
    }
    
}
