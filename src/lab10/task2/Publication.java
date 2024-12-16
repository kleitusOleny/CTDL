package lab10.task2;

public abstract class Publication {
    private String title;
    private int pageNumber;
    private int yearPublication;
    private String AuthorName;
    private double price;
    
    public Publication(String title, int pageNumber, int yearPublication, String authorName, double price) {
        this.title = title;
        this.pageNumber = pageNumber;
        this.yearPublication = yearPublication;
        AuthorName = authorName;
        this.price = price;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getPageNumber() {
        return pageNumber;
    }
    
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    
    public int getYearPublication() {
        return yearPublication;
    }
    
    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }
    
    public String getAuthorName() {
        return AuthorName;
    }
    
    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", pageNumber=" + pageNumber +
                ", yearPublication=" + yearPublication +
                ", AuthorName='" + AuthorName + '\'' +
                ", price=" + price + ", ";
    }
    
    public abstract String getTypeOfPublication();
    public abstract boolean checkYearPublication();
    public boolean checkAuthor(Publication that){
        return this.AuthorName.equals(that.AuthorName);
    }
    
    public abstract int getMaxChapterPageNum();
    public abstract boolean checkMagazineTitle(String title);
    public abstract boolean getMagazineAroundNyear(int nYear);
}
