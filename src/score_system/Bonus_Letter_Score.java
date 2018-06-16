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
public class Bonus_Letter_Score {
    
    public static int bonus_score = 0;
    public static int bonus_letter_count = 0;
    
    //not used
//    public int count_bonus_letters(char a[][]){
//        
//        //for loop to get the token
//        for(int i=0; i>=a.length; i++){
//            if (a[1][i] == 'b'){
//                //count the number of bonus letters
//                bonus_letter_count++;
//            }
//        }
//        
//        //return the number of bonus letters used
//        return bonus_letter_count;
//    }
    
    
    //public int calc_bonus_score(char a[][]){
    public int calc_bonus_score(int bonus_letter_count){
        
        //get score by number of letters
        switch(bonus_letter_count){
            case 0: bonus_score = 0; 
                    break;
            case 1: bonus_score = 5; 
                    break;
            case 2: bonus_score = 10; 
                    break;
            case 3: bonus_score = 15;
                    break;
            default: bonus_score = 0;
                     break;
        }
        
        //return the final bonus score
        return bonus_score;
    }
    
    
}