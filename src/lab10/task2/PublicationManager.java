package lab10.task2;

import java.util.*;

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
    
    //Task2.4 Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây (2024) 10 năm hay không?
    public boolean checkPublicationAround10y(){
        return false;
    }
    
    //Task2.6 Tính tổng tiền của tất các ấn phẩm trong nhà sách
    public double totalAllPublication() {
        double total = 0;
        for (Publication publication : publicationList) {
            total += publication.getPrice();
        }
        return total;
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
    
    //Task 2.8 Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay không?
    public boolean checkMagazine(String title) {
        for (Publication publication : publicationList) {
            if (publication.checkMagazineTitle(title)) return true;
        }
        return false;
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
    
    //Task2.10 Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản (sử dụng interface Comparable hoặc Comparator)
    public void sortPublication(){
        publicationList.sort(new Comparator<Publication>() {
            @Override
            public int compare(Publication o1, Publication o2) {
                return (o1.getTitle().compareTo(o2.getTitle()) !=0 ? o1.getTitle().compareTo(o2.getTitle()) : o1.getYearPublication() - o2.getYearPublication());
            }
        });
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
    public static void main(String[] args) {
        Publication magazine1 = new Magazine("Cay Cam Ngot", 150, 2024, "Vinh", 150000, "Magazine");
        Publication magazine2 = new Magazine("Glitch", 200, 2007, "A", 120000, "may lan 10 nam");
        Publication magazine3 = new Magazine("CA", 300, 2005, "B", 135000, "ABC");
        
        Chapter chapter1 = new Chapter("Co so Logic", 50);
        Chapter chapter2 = new Chapter("Co so phep dem", 150);
        
        List<Chapter> chapterList = new ArrayList<>();
        chapterList.add(chapter1);
        chapterList.add(chapter2);
        
        Publication refBook1 = new ReferenceBook("Toan Roi Rac", 250, 2007, "Tram", 34000, "Toan", chapterList);
        
        List<Publication> publications = new ArrayList<>();
        publications.add(refBook1);
        publications.add(magazine1);
        publications.add(magazine2);
        publications.add(magazine3);
        
        PublicationManager manager = new PublicationManager(publications);
        
        manager.detectTypePfPublication();

        System.out.println(magazine1.checkYearPublication());

        System.out.println(manager.totalAllPublication());
        
        System.out.println(manager.findMaxPageChapterOfPublicationM());
        
        System.out.println(manager.getMagazineAround1year());
        
        manager.sortPublication();

        for (Publication e : manager.publicationList) {
            System.out.println(e);
        }
        
        System.out.println(manager.statsByYear());
    }
}
