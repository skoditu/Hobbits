/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Words;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suhasini
 */
public class Dictionary {
	public List<String> load() {
		List<String> myDict = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream("C:\\Users\\User\\Desktop\\New folder (3)\\Glory\\words_alpha.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str;
			while ((str = br.readLine()) != null) {
				myDict.add(str);
			}
			br.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		return myDict;
	}
	
}