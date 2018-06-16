/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Letters;

import DatabaseClass.DBConnection;
import glory.schema.LetterValueElement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Random;
/**
 *
 * @author Suhasini
 */
public class Letter {
      
   
// function to select first three letters
    public char[] FirstThreeLetters() {
        
      Random random = new Random();
      char specialLetter;
      char[] firstThreeLetters = new char[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j >= 0; j++) {
                specialLetter = (char) (random.nextInt(26) + 'A');               
                if (firstThreeLetters[0] != specialLetter && firstThreeLetters[1] != specialLetter && firstThreeLetters[2] != specialLetter) {
                    firstThreeLetters[i] = specialLetter;
                    break;
                }
            }
        }
       return firstThreeLetters;
    }
    
    // function to select first three letters from database
    public List<LetterValueElement> SelectSpecial(){
    List<LetterValueElement> returnList=null;
        try {
                DBConnection dbManager=new DBConnection();
                String query="SELECT letter,score,letterType FROM letter ORDER BY RAND() LIMIT 3";
                ResultSet rst= (ResultSet) dbManager.fetch(query);
                while(rst.next()){
                    LetterValueElement newLetter= new LetterValueElement();
                    newLetter.setLetter(rst.getString("letter"));
                    newLetter.setScore(rst.getInt("score"));
                    newLetter.setLetterType(rst.getString("letterType"));
                    returnList.add(newLetter);
                }               
            } catch (Exception ex) {
                Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnList;
    }
    
    // function to select a vowel from database
    public LetterValueElement SelectVowel(){
        LetterValueElement returnObj=new LetterValueElement();
        try{
            DBConnection dbManager=new DBConnection();
            String query="SELECT letter,score,letterType FROM letter WHERE letterType=1 ORDER BY RAND() LIMIT 1";
            ResultSet rst= (ResultSet) dbManager.fetch(query);
            while(rst.next()){
                LetterValueElement newVowel=new LetterValueElement();
                newVowel.setLetter(rst.getString("letter"));
                newVowel.setScore(rst.getInt("score"));
                newVowel.setLetterType(rst.getString("letterType"));                
                returnObj=newVowel;
            }          
            
        }catch(Exception ex){
        Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnObj;
    }
    
    // function to select a consonants from database
    public LetterValueElement SelectConsonants (){
        LetterValueElement returnObj=null;
        try{
            DBConnection dbManager=new DBConnection();
            String query="SELECT letter,score,letterType FROM letter WHERE letterType=2 ORDER BY RAND() LIMIT 1";
            ResultSet rst= (ResultSet) dbManager.fetch(query);
            while(rst.next()){
                LetterValueElement newConsonants=new LetterValueElement();
                newConsonants.setLetter(rst.getString("letter"));
                newConsonants.setScore(rst.getInt("score"));
                newConsonants.setLetterType(rst.getString("letterType"));                
                returnObj=newConsonants;
            } 
            
        }catch(Exception ex){
        Logger.getLogger(Letter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnObj;
    }
    
}
