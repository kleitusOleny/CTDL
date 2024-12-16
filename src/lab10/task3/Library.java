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
    //Task3.1 Phương thức public Book getOldestBook() trả về quyển sách được xuất bản lâu nhất.
    public Book getOldestBook() {
        Book res = books.getFirst();
        for (Book book : books) {
            if (book.getYear() < res.getYear()) {
                res = book;
            }
        }
        return res;
    }
    
    public Optional<Book> getOldestBookJava8() {
        return books.stream().min((o1, o2) -> o1.getYear() - o2.getYear());
    }
    
    //Task3.2 Phương thức public Map<Integer, List<Book>> getBooksByYears () để
    //thống kê các quyển sách theo năm, với key là năm xuất bản và value là các
    //quyển sách xuất bản trong năm đó.
    public Map<Integer, List<Book>> getBooksByYear() {
        Map<Integer, List<Book>> result = new HashMap<>();
        for (Book book : books) {
            List<Book> bookList = result.getOrDefault(book.getYear(), new ArrayList<>());
            bookList.add(book);
            result.put(book.getYear(), bookList);
        }
        return result;
    }
    
    public Map<Integer, List<Book>> getBooksByYearJava8() {
        return books.stream().collect(Collectors.groupingBy(Book::getYear));
    }
    
    //Task3.3 Phương thức public Set<Book> findBooks(String authorName, int year) trả
    //về các quyển sách có năm xuất bản là tham số year và tên tác giả là tham số
    //authorName. Các quyển sách được sắp xếp theo thứ tự bảng chữ cái của tiêu
    //đề.
    public Set<Book> findBooks(String authorName, int year) {
        Set<Book> bookSet = new HashSet<>();
        for (Book book : books) {
            if (book.isSameAuthorInYear(authorName, year)) {
                bookSet.add(book);
            }
        }
        return bookSet;
    }
    
    public Set<Book> findBooksJava8(String authorName, int year) {
        return books.stream().filter(book -> book.getYear() == year && book.getAuthors().stream()
                .anyMatch(author -> author.getName().equals(authorName))).collect(Collectors.toSet());
    }
}
