package Fix;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Product> products;
    public Storage(List<Product> products) {
        this.products = products;
    }
    
    public void sortProductByID() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).getProductID().compareTo(products.get(j).getProductID()) > 0) {
                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }
    }
    public void sortProductByName() {
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).getProductName().compareTo(products.get(j).getProductName()) > 0) {
                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
        }
    }
    
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < products.size(); i++) {
            s += products.get(i).toString() + "\n";
        }
        return s;
    }
    
    public static void main(String[] args) {
        Product p1 = new Product("1","AVC","11",100);
        Product p2 = new Product("2","BAC","12",100);
        Product p3 = new Product("3","CDA","13",100);
        
        List<Product> products = new ArrayList<Product>();
        products.add(p1);
        products.add(p3);
        products.add(p2);
        
        Storage s = new Storage(products);
        s.sortProductByName();
        System.out.println(s);
    }
}
