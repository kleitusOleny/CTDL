package lab10.task2;

import java.util.ArrayList;
import java.util.List;

public class TestTask2 {
    
    public static void main(String[] args) {
        Publication magazine1 = new Magazine("Cay Cam Ngot", 150, 2024, "Vinh", 150000, "Magazine");
        Publication magazine2 = new Magazine("Glitch", 200, 2007, "A", 120000, "may lan 10 nam");
        Publication magazine3 = new Magazine("CA", 300, 2005, "B", 135000, "ABC");
        
        Chapter chapter1 = new Chapter("Co so Logic", 50);
        Chapter chapter2 = new Chapter("Co so phep dem", 200);
        
        Chapter chapter3 = new Chapter("Phan Phoi",50);
        Chapter chapter4 = new Chapter("Ham lien tuc",250);
        
        List<Chapter> chapterList1 = new ArrayList<>();
        chapterList1.add(chapter1);
        chapterList1.add(chapter2);
        
        List<Chapter> chapterList2 = new ArrayList<>();
        chapterList2.add(chapter3);
        chapterList2.add(chapter4);
        
        Publication refBook1 = new ReferenceBook("Toan Roi Rac", 250, 2007, "Tram", 34000, "Toan", chapterList1);
        Publication refBook2 = new ReferenceBook("Xac Suat Thong Ke", 300, 2020, "Tram", 34000, "Toan", chapterList2);
        
        List<Publication> publications = new ArrayList<>();
        publications.add(refBook1);
        publications.add(magazine1);
        publications.add(magazine2);
        publications.add(magazine3);
        publications.add(refBook2);
        
        PublicationManager manager = new PublicationManager(publications);
        
        System.out.println("Phương thức xác định loại của ấn phẩm (Tạp chí hay Sách tham khảo):");
        System.out.println("\t\t\t Java Core");
        manager.detectTypePfPublication();
        System.out.println("\t\t\t Java 8");
        manager.detectTypePfPublicationJava8();
        System.out.println();
        
        System.out.println("Kiem tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây 10 năm: \n");
        System.out.println("\t\t\t Java Core");
        System.out.println(manager.checkMagazineAround10y());
        System.out.println("\t\t\t Java 8");
        System.out.println(manager.checkMagazineAround10yJava8());
        System.out.println();
//
        System.out.println("kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không");
        System.out.println("\t\t\t Java Core");
        System.out.println(manager.checkPublicationSameAuth(magazine2));
        System.out.println("\t\t\t Java 8");
        System.out.println(manager.checkPublicationSameAuth(magazine1));
        System.out.println();
        
        System.out.println("Tính tổng tiền của tất các ấn phẩm trong nhà sách");
        System.out.println("\t\t\t Java Core");
        System.out.println(manager.totalAllPublication());
        System.out.println("\t\t\t Java 8");
        System.out.println(manager.totalAllPublicationJava8());
        
        System.out.println("Tìm quyển sách tham khảo có chương sách nhiều trang nhất");
        System.out.println("\t\t\t Java Core");
        System.out.println(manager.findMaxPageChapterOfPublicationM());
        System.out.println("\t\t\t Java 8");
        System.out.println(manager.findMaxPageChapterOfPublicationMJava8());
        
        System.out.println("Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay không?");
        System.out.println("\t\t\t Java Core");
        System.out.println(manager.checkMagazine("may lan 10 nam"));
        System.out.println("\t\t\t Java 8");
        System.out.println(manager.checkMagazineJava8("may lan 10 nam"));
        
        System.out.println("Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước");
        System.out.println("\t\t\t Java Core");
        System.out.println(manager.getMagazineAroundNYear(1));
        System.out.println("\t\t\t Java 8");
        System.out.println(manager.getMagazineAroundNYearJava8(2));
        
        System.out.println("Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản");
        manager.sortPublicationJava8();
        System.out.println(manager.getPublicationList());
        
        System.out.println("11)Thống kê số lượng ấn phẩm theo năm xuất bản");
        System.out.println("\t\t\t Java Core");
        System.out.println(manager.statsByYear());
        System.out.println("\t\t\t Java 8");
        System.out.println(manager.statsByYearJava8());
    }
}
