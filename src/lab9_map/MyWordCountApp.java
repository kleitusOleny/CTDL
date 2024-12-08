package lab9_map;

import java.io.*;
import java.util.*;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData()throws IOException{
		// TODO
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while ((line = reader.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line, " ");
			while (tokens.hasMoreTokens()) {
				String s = tokens.nextToken();
				map.put(s, map.getOrDefault(s, 0)+1);
			}
		}
		reader.close();
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() throws IOException {
		int count = 0;
		for (Integer i : map.values()){
			if (i == 1){
				count++;
			}
		}
		return count;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		System.out.println(map);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		// TODO
        Map<String, Integer> treeMap = new TreeMap<>(map);
		System.out.println(treeMap);
	}
}
