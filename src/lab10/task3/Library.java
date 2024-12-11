package lab10.task3;


import java.util.*;

public class Library {
    private String name;
    private List<Book> books;
    
    public Library(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }
    
    public Book getOldestBook(){
        Book res = books.getFirst();
        for (Book book : books){
            if (book.getYear() > res.getYear()){
                res = book;
            }
        }
        return res;
    }
    
    public Map<Integer, List<Book>> getBooksByYear(){
        Map<Integer, List<Book>> result = new HashMap<>();
        for (Book book :books){
            List<Book>bookList = result.getOrDefault(book.getYear(),new ArrayList<>());
            bookList.add(book);
            result.put(book.getYear(),bookList);
        }
        return result;
    }
    
    public Set<Book> findBooks(String authorName, int year){
        Set<Book> bookSet = new HashSet<>();
        for (Book book :books){
            if (book.isSameAuthorInYear(authorName, year)){
                bookSet.add(book);
            }
        }
        return bookSet;
    }
    
    public static void main(String[] args) {
    
    }
}
