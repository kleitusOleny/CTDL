package lab9_map;

import java.io.IOException;

public class TestMyWordCount {
    public static void main(String[] args)throws IOException {
        MyWordCountApp wordCount = new MyWordCountApp();
        wordCount.loadData();
        
        System.out.println(wordCount.countUnique());
        
        wordCount.printWordCounts();
        
        wordCount.printWordCountsAlphabet();
    }
}
