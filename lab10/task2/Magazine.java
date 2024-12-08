package lab10.task2;

import java.time.LocalDate;

public class Magazine extends Publication{
    private String title;
    
    public Magazine(String title, int pageNumber, int yearPublication, String authorName, double price, String title1) {
        super(title, pageNumber, yearPublication, authorName, price);
        this.title = title1;
    }
    
    @Override
    public String getTypeOfPublication() {
        return "" + this.getClass();
    }
    
    @Override
    public boolean checkYearPublication() {
        return (LocalDate.now().getYear() - this.getYearPublication() <= 10);
    }
    
    @Override
    public int getMaxChapterPageNum() {
        return 0;
    }
    
    @Override
    public boolean checkMagazineTitle(String title) {
        return this.title.equals(title);
    }
    
    
}
