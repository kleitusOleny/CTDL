package lab10.task3;

import java.util.List;

public class Book {
    private String id;
    private String title;
    private int price;
    private String type;
    private int year;
    private List<Author> authors;
    
    public Book(String id, String title, int price, String type, int year, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.type = type;
        this.year = year;
        this.authors = authors;
    }
    
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getType() {
        return type;
    }
    
    public int getYear() {
        return year;
    }
    
    public List<Author> getAuthors() {
        return authors;
    }
    
    public boolean isSameAuthorInYear(String authorName, int year) {
        for (Author author : authors){
            if (author.getName().equals(authorName) && this.year == year){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", authors=" + authors +
                '}';
    }
}
