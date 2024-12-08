package lab9_map;

import java.io.IOException;

public class TestTextAnalyzer {
    public static void main(String[] args) throws IOException {
        TextAnalyzer textA = new TextAnalyzer();
        
        textA.load("data/short.txt");
//		System.out.println(textA.map);
        
        textA.displayWords();

		textA.displayText();

		System.out.println("occurs most frequently word: " + textA.mostFrequentWord());
    
    
    }
}
