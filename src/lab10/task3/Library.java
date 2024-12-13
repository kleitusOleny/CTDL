package lab10.task3;


import java.util.*;
import java.util.stream.Collectors;

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
            if (book.getYear() < res.getYear()){
                res = book;
            }
        }
        return res;
    }
    
    public Optional<Book> getOldestBookJava8() {
        return books.stream().min((o1, o2) -> o1.getYear()-o2.getYear());
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
    
    public Map<Integer,List<Book>> getBooksByYearJava8(){
        return books.stream().collect(Collectors.groupingBy(Book::getYear));
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
    public Set<Book> findBooksJava8(String authorName, int year){
        return books.stream().filter(book -> book.getYear() == year && book.getAuthors().stream().anyMatch(author -> author.getName().equals(authorName))).collect(Collectors.toSet());
    }
    
    
    public static void main(String[] args) {
        Author au1 = new Author("A",2001);
        Author au2 = new Author("B", 1997);
        
        List<Author> aus1 = new ArrayList<>();
        aus1.add(au1);
        
        List<Author> aus2 = new ArrayList<>();
        aus2.add(au2);
        
        Book b1 = new Book("B01","Cay Cam Ngot Cua Toi",59000,"Tieu thuyet",2021,aus1);
        Book b2 = new Book("A02","Goth",79000,"Tieu Thuyet",2024,aus2);
        Book b3 = new Book("A02","Arya",89000,"Light Novel",2024,aus1);
        
        List<Book>bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        
        Library nluLib = new Library("NLU",bookList);
        
//        System.out.println(nluLib.getOldestBook());
//        System.out.println(nluLib.getOldestBookJava8());
        
        System.out.println(nluLib.getBooksByYearJava8());
        
        System.out.println(nluLib.findBooks("A",2023));
        
    }
}
