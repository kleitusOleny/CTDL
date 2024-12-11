package lab10.task2;

public class Chapter {
    private String titleChapter;
    private int pageNumber;
    
    public Chapter(String titleChapter, int pageNumber) {
        this.titleChapter = titleChapter;
        this.pageNumber = pageNumber;
    }
    
    @Override
    public String toString() {
        return "Chapter{" +titleChapter + '\'' + "," + pageNumber + '}';
    }
    
    public int getPageNumber() {
        return pageNumber;
    }
}
