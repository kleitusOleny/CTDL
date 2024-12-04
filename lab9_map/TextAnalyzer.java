package lab9_map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int pos = 0;
		while ((line = reader.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line, " ");
			while (tokens.hasMoreTokens()) {
				String s = tokens.nextToken();
				pos++;
				if (tokens.hasMoreTokens()){
					add(s,pos);
				}else{
					add(s,-pos);
				}
			}
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		// TODO
		ArrayList<Integer> arrayList =  new ArrayList<Integer>();
		map.getOrDefault(word, arrayList).add(position);
		map.put(word, map.getOrDefault(word, arrayList));
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		for (Map.Entry entry: map.entrySet()){
			System.out.println(entry);
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		for (String key : map.keySet()){
			System.out.print(key + " ");
		}
		System.out.println();
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		int maxFrequently = 0;
		Map.Entry<String,List> res = null;
		for (Map.Entry entry : map.entrySet()){
			int entryFrequently = ((ArrayList)entry.getValue()).size();
			if ( entryFrequently > maxFrequently) {
				maxFrequently = entryFrequently;
				res = entry;
			}
		}
		return res.getKey();
	}
	
	public static void main(String[] args) throws IOException {
		TextAnalyzer textA = new TextAnalyzer();
		
		textA.load("data/length.txt");
		System.out.println(textA.map);
		
		textA.displayWords();
		
		textA.displayText();
		
		System.out.println("occurs most frequently word: " + textA.mostFrequentWord());
	}
}
