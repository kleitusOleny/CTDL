package lab10.task2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PublicationManager {
    private List<Publication> publicationList;
    
    public List<Publication> getPublicationList() {
        return publicationList;
    }
    
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
        for (Publication publication : publicationList){
            if (publication instanceof Magazine && Math.abs(publication.getYearPublication() - LocalDate.now().getYear()) <=10){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkMagazineAround10yJava8(){
        return publicationList.stream().anyMatch(publication -> publication.getYearPublication()-LocalDate.now().getYear() <= 10);
    }
    
    //Task2.5 Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
    public boolean checkPublicationSameAuth(Publication that){
        for (Publication publication : publicationList){
            if (publication.getTypeOfPublication().equals(that.getTypeOfPublication()) && publication.checkAuthor(that)){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkPublicationSameAuthJava8(Publication that){
        return publicationList.stream().anyMatch(publication -> publication.getTypeOfPublication().equals(that.getTypeOfPublication()) && publication.checkAuthor(that));
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
    public List<Publication> getMagazineAroundNYear(int nYear){
        List<Publication>result = new ArrayList<>();
        for (Publication publication : publicationList){
            if (publication.getMagazineAroundNyear(nYear)){
                result.add(publication);
            }
        }
        return result;
    }
    
    public List<Publication> getMagazineAroundNYearJava8(int nYear){
        return publicationList.stream().filter(publication -> LocalDate.now().getYear()-publication.getYearPublication() <= nYear && publication instanceof Magazine).collect(Collectors.toList());
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
}
