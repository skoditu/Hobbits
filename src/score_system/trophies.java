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
public class trophies {
    
    public int calc_trophies(int place, int no_of_players){
        int no_of_trophies = 0;
        
        switch (no_of_players) {
            case 2: no_of_trophies = trophies_for_2(place);
                break;
            case 3: no_of_trophies = trophies_for_3(place);
                break;
            case 4: no_of_trophies = trophies_for_4(place);
                break;
            default:
                break;
        }

        return no_of_trophies;
    }
    
    public int trophies_for_2(int place_){
        int trophies_ = 0;
        
        switch (place_) {
            case 1: trophies_ = 20;
                break;
            case 2: trophies_ = -20;
                break;
            default: trophies_ = 0;
                break;
        }
        
        return trophies_;
    }
    
    
    public int trophies_for_3(int place_){
        int trophies_ = 0;
        
        switch (place_) {
            case 1: trophies_ = 20;
                break;
            case 2: trophies_ = 5;
                break;
            case 3: trophies_ = -20;
                break;
            default: trophies_ = 0;
                break;
        }
        
        return trophies_;
    }
    
    
    public int trophies_for_4(int place_){
        int trophies_ = 0;
        
        switch (place_) {
            case 1: trophies_ = 20;
                break;
            case 2: trophies_ = 5;
                break;
            case 3: trophies_ = -5;
                break;
            case 4: trophies_ = -20;
                break;
            default: trophies_ = 0;
                break;
        }
        
        return trophies_;
    }
    
    public void get_trophies(){
        
    }
    
    public void set_trophies(){
        
    }
    
}
