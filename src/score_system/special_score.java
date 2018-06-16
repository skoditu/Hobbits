/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package score_system;

/**
 *
 * @author harmlk
 */
public class special_score {
    public static int special_score;
    
    public int get_special_score(int no_of_players, int basic_score){
        
        special_score = basic_score * no_of_players;    
        
        return special_score;
    }
    
    
}
