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
}
