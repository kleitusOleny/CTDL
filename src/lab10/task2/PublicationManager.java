package lab10.task2;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PublicationManager {
    private List<Publication> publicationList;
    
    public PublicationManager(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }
    //Task2.3 Phương thức xác định loại của ấn phẩm (Tạp chí hay Sách tham khảo)
    public void detectTypePfPublication() {
        for (Publication publication : publicationList) {
            System.out.println(publication.getTitle() + "-Type: " + publication.getTypeOfPublication());
        }
    }
    
    public void detectTypePfPublicationJava8(){
        publicationList.forEach(publication -> System.out.println(publication.getTitle() + "-Type: " + publication.getTypeOfPublication()));
    }
    
    //Task2.4 Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây (2024) 10 năm hay không?
    public boolean checkMagazineAround10y(){
        return false;
    }
    
    public boolean checkMagazineAround10yJava8(){
        return publicationList.stream().anyMatch(publication -> publication.getYearPublication()-LocalDate.now().getYear() <= 10);
    }
    
    //Task2.6 Tính tổng tiền của tất các ấn phẩm trong nhà sách
    public double totalAllPublication() {
        double total = 0;
        for (Publication publication : publicationList) {
            total += publication.getPrice();
        }
        return total;
    }
    
    public double totalAllPublicationJava8(){
        return publicationList.stream().mapToDouble(Publication::getPrice).sum();
    }
   
    //Task2.7 Tìm quyển sách tham khảo có chương sách nhiều trang nhất
    public Publication findMaxPageChapterOfPublicationM() {
        Publication refPublication = publicationList.getFirst();
        for (Publication publication : publicationList) {
            if (publication.getMaxChapterPageNum() > refPublication.getMaxChapterPageNum()) {
                refPublication = publication;
            }
        }
        return refPublication;
    }
    
    public Optional<Publication> findMaxPageChapterOfPublicationMJava8(){
        return publicationList.stream().filter(publication -> publication instanceof ReferenceBook).max((o1, o2) -> Integer.compare(o1.getMaxChapterPageNum(),o2.getMaxChapterPageNum()));
    }
    //Task 2.8 Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay không?
    public boolean checkMagazine(String title) {
        for (Publication publication : publicationList) {
            if (publication.checkMagazineTitle(title)) return true;
        }
        return false;
    }
    public boolean checkMagazineJava8(String title){
        return publicationList.stream().anyMatch(publication -> publication.getTitle().equals(title) && publication instanceof Magazine);
    }
    
    //Task 2.9 Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
    public List<Publication> getMagazineAround1year(){
        List<Publication>result = new ArrayList<>();
        for (Publication publication : publicationList){
            if (publication.getMagazineAround1year()){
                result.add(publication);
            }
        }
        return result;
    }
    
    public List<Publication> getMagazineAround1yearJava8(){
        return publicationList.stream().filter(publication -> LocalDate.now().getYear()-publication.getYearPublication() <= 1 && publication instanceof Magazine).collect(Collectors.toList());
    }
    
    //Task2.10 Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản (sử dụng interface Comparable hoặc Comparator)
    public void sortPublication(){
        publicationList.sort(new Comparator<Publication>() {
            @Override
            public int compare(Publication o1, Publication o2) {
                return (o1.getTitle().compareTo(o2.getTitle()) !=0 ? o1.getTitle().compareTo(o2.getTitle()) : o1.getYearPublication() - o2.getYearPublication());
            }
        });
    }
    public void sortPublicationJava8(){
        publicationList.sort((o1, o2) -> (o1.getTitle().compareTo(o2.getTitle()) !=0 ? o1.getTitle().compareTo(o2.getTitle()) : o1.getYearPublication() - o2.getYearPublication()));
    }
    
    //Task2.11)Thống kê số lượng ấn phẩm theo năm xuất bản. Ví dụ 2020: 5, 2021: 10, ...
    //năm 2020 có 5 ấn phẩm, năm 2021 có 10 ấn phẩm.
    public Map<Integer,Integer> statsByYear(){
        Map<Integer,Integer> res = new TreeMap<>();
        for (Publication publication : publicationList){
                res.put(publication.getYearPublication(),res.getOrDefault(publication.getYearPublication(),0) + 1);
        }
        return res;
    }
    
    public Map<Integer,Integer> statsByYearJava8(){
        return (Map<Integer, Integer>) publicationList.stream().collect(Collectors.toMap(Publication::getYearPublication, publication -> 1, Integer::sum));
    }
    
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
        
//        manager.detectTypePfPublication();

//        System.out.println(magazine1.checkYearPublication());
        
//        System.out.println();
//
//        System.out.println(manager.totalAllPublication());
//        System.out.println(manager.totalAllPublicationJava8());

//        System.out.println(manager.findMaxPageChapterOfPublicationM());
//        System.out.println(manager.findMaxPageChapterOfPublicationMJava8());
//
        
//        System.out.println(manager.checkMagazine("may lan 10 nam"));
        
//        System.out.println(manager.getMagazineAround1year());
//        System.out.println(manager.getMagazineAround1yearJava8());
//
//        manager.sortPublicationJava8();
//
//        for (Publication e : manager.publicationList) {
//            System.out.println(e);
//        }
//
//        System.out.println(manager.statsByYear());
//        System.out.println(manager.statsByYearJava8());
    }
}
