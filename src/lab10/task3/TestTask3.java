package lab10.task3;

import java.util.ArrayList;
import java.util.List;

public class TestTask3 {
    public static void main(String[] args) {
        Author au1 = new Author("A",2001);
        Author au2 = new Author("B", 1997);
        
        List<Author> aus1 = new ArrayList<>();
        aus1.add(au1);
        
        List<Author> aus2 = new ArrayList<>();
        aus2.add(au2);
        
        Book b1 = new Book("B01","Cay Cam Ngot Cua Toi",59000,"Tieu thuyet",2021,aus1);
        Book b2 = new Book("A02","Goth",79000,"Tieu Thuyet",2023,aus2);
        Book b3 = new Book("A02","Arya",89000,"Light Novel",2024,aus1);
        
        List<Book>bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        
        Library nluLib = new Library("NLU",bookList);

        System.out.println(nluLib.getOldestBook());
        System.out.println(nluLib.getOldestBookJava8());
        
        System.out.println(nluLib.getBooksByYear());
        System.out.println(nluLib.getBooksByYearJava8());
        
        System.out.println(nluLib.findBooks("B",2023));
        System.out.println(nluLib.findBooksJava8("A",2021));
        
    }
}
