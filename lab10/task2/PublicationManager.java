package lab10.task2;

import java.util.List;

public class PublicationManager {
    private List<Publication> publicationList;
    
    public PublicationManager(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }
    public double totalAllPublication(){
        double total = 0;
        for (Publication publication : publicationList){
            total += publication.getPrice();
        }
        return total;
    }
    public Publication findMaxPageChapterOfPublicationM(){
        Publication refPublication = publicationList.getFirst();
        for (Publication publication : publicationList){
            if (publication.getMaxChapterPageNum() > refPublication.getMaxChapterPageNum()){
                refPublication = publication;
            }
        }
        return refPublication;
    }
    public boolean checkMagazine(String title){
        for (Publication publication : publicationList){
            if (publication.checkMagazineTitle(title)) return true;
        }
        return false;
    }
}
