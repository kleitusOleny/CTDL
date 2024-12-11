package lab10.task2;

import java.util.List;

public class ReferenceBook extends Publication{
    private String field;
    private List<Chapter> chapters;
    
    public ReferenceBook(String title, int pageNumber, int yearPublication, String authorName, double price, String field, List<Chapter> chapters) {
        super(title, pageNumber, yearPublication, authorName, price);
        this.field = field;
        this.chapters = chapters;
    }
    
    @Override
    public String getTypeOfPublication() {
        return "Reference Book";
    }
    
    @Override
    public boolean checkYearPublication() {
        return false;
    }
    
    @Override
    public String toString() {
        return super.toString() + "ReferenceBook{" + "field='" + field + '\'' + ", chapters=" + chapters + "}}";
    }
    
    public int getMaxChapterPageNum(){
        Chapter maxChapter = chapters.getFirst();
        for (Chapter chap : chapters){
            if ( chap.getPageNumber() > maxChapter.getPageNumber()){
                maxChapter = chap;
            }
        }
        return maxChapter.getPageNumber();
    }
    
    @Override
    public boolean checkMagazineTitle(String title) {
        return false;
    }
    
    @Override
    public boolean getMagazineAround1year() {
        return false;
    }
}
