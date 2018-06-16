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
public class unused_letters_score {
    
    public int calc_unused_letters_score(String word_){
        int unused_letters_score = 0;
        letter_score obj = new letter_score();
        unused_letters_score = obj.Get_Score_by_Word(word_);

        return unused_letters_score;
    }
    
    
}
