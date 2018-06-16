/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Glory_GUI.IntroVideo;
import Glory_GUI.LoadingScreen;
import Glory_GUI.LoginForm;
import Glory_GUI.PlayScreen;
import Words.Dictionary;
import Words.UnscrambleWords;
import java.awt.Frame;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nisal Silva
 */
public class Glory {
    
    private static Scanner scanner = new Scanner( System.in );
	
	public static void main(String[] args) {
		
		// Check if arguments were passed
		int arglen = 1;
		if (args.length != 0) { 
			arglen = args.length;
		}
		String[] inputword = new String[arglen];
		
		// Prompt user for text if no arguments were passed
		if (args.length == 0) {
			System.out.print("Enter text: ");
			String input = scanner.nextLine();
			
			// Detect if multiple arguments were passed
			Pattern pattern = Pattern.compile("\\s");
			Matcher matcher = pattern.matcher(input);
			boolean found = matcher.find();
			
			// If more than one argument passed
			if (found) {
				String[] temp_input_arr = input.split(" ");
				arglen = temp_input_arr.length;
				inputword = new String[arglen];
				System.arraycopy(temp_input_arr, 0, inputword, 0, arglen);
			// Set inputword array to single word
			} else {
				inputword[0] = input;
				arglen = 1;
			}
		// Populate array with command-line arguments
		} else {
			for (int i=0; i<args.length; i++) {
				inputword[i] = args[i];
			}
			arglen = args.length;
			
		}
		
		// Create dictionary
		Dictionary dictionary = new Dictionary();
		List<String> myDict = dictionary.load();
		
		
		// Loop over all given words
		for (int x=0; x<arglen; x++) {
			int anagramsFound = 0;
			
			// Set word to unscramble
			UnscrambleWords unscramble = new UnscrambleWords();
			unscramble.setWord(inputword[x]);
			char[] letters = unscramble.getLetters();
			
			System.out.println("Searching for anagram of: " + inputword[x]);
			// Loop through each word in dictionary
			for (int i=0; i<myDict.size(); i++) {
				
				// Alphabetize word
				char[] dictLetters = myDict.get(i).toCharArray();
				Arrays.sort(dictLetters);
				
				// If dictionary word length matches
				if (dictLetters.length == unscramble.getLength()) {
					// If it's an anagram and not the same as the original word
					if (Arrays.equals(dictLetters, letters) && !myDict.get(i).equals(inputword[x])) {
						System.out.println(myDict.get(i));
						anagramsFound++;
					} 
				} 
			}
			if (anagramsFound == 0) {
				System.out.println("No anagrams found.");
				anagramsFound = 0;
			} else {
				anagramsFound = 0;
			}
		}
	}
    
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                
////                IntroVideo intro = new IntroVideo();
////                intro.setVisible(true);  
////                //LoginForm play = new LoginForm();
////                //play.setVisible(true);
////                //play.setExtendedState(play.getExtendedState() | Frame.MAXIMIZED_BOTH);
//
//
//                
//            }
//        });
//    }
    
}
