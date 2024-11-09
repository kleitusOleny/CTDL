package Lab8.set_student;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> re = new ArrayList<WordCount>();
		for(String word : this.words) {
			if(!updateWordCount(re, word)) {
				re.add(new WordCount(word, 1));
			}
		}
		return re;
	}
	
	private boolean updateWordCount(List<WordCount> re, String word) {
		for(WordCount wc : re) {
			if(wc.getWord().equals(word)) {
				wc.setCount(wc.getCount()+1);
				return true;
			}
		}
		return false;
	}

//	public Map<String, Integer> getWordCounts1() {
//		Map<String, Integer> re = new HashMap<>();
//		for (String word : words) {
//			re.put(word, re.getOrDefault(word, 0) + 1);
//		}
//		return re;
//	}


	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		return null;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		// TODO
		return null;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		// TODO
		return null;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		// TODO
		return null;
	}

	// delete words beginning with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		// TODO
		return null;
	}
}
