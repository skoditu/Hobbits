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
public class Basic_score {
    
    public int calc_basic_score(String word_){
        int basic_score = 0;
        letter_score obj = new letter_score();
        basic_score = obj.Get_Score_by_Word(word_);

        return basic_score;
    }
}
