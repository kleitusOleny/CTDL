package lab10.task1;

import java.time.LocalDate;

public class Product {
    private String name;
    private String type;
    private int price;
    private LocalDate expiredDate;
    
    public Product(String name, String type, int price, LocalDate expiredDate) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.expiredDate = expiredDate;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getType() {
        return type;
    }
    
    public Product ProductHigherPrice(Product that){
        if (that == null) return this;
        return ((this.price - that.price) > 0 ? this : that);
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", expiredDate=" + expiredDate +
                '}';
    }
}
