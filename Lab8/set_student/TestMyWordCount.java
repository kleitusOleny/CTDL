package Lab8.set_student;

public class TestMyWordCount {
    public static void main(String[] args) {
        MyWordCount myWordCount = new MyWordCount();
        
        System.out.println("get Word Counts: " + myWordCount.getWordCounts());
        
		System.out.println("get Unique Word: " + myWordCount.getUniqueWords());
        
        System.out.println("get Distinct Words: "+ myWordCount.getDistinctWords());
        
        System.out.println("print Word Counts: " + myWordCount.printWordCounts());
        
        System.out.println("export Word Counts By Occurence: " + myWordCount.exportWordCountsByOccurence());
        
        System.out.println("filter Words: " + myWordCount.filterWords("N"));
    }
}
