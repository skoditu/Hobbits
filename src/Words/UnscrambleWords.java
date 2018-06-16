/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Words;

/**
 *
 * @author Suhasini
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnscrambleWords {
	String word = "";
	char[] letters;
	int wordLength = 0;
	
	public void setWord(String newWord) {
		word = newWord;
		letters = word.toCharArray();
		Arrays.sort(letters);
	}
	
	public int getLength() {
		return this.word.length();
	}
	
	public char[] getLetters() {
		return letters;
	}
}




