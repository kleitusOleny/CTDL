package lab10.task4;

public class Product {
    private Long pid;
    private String name;
    private String category;
    private double price;
    
    public Product(Long pid, String name, String category, double price) {
        this.pid = pid;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    
    public Long getPid() {
        return pid;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getPrice() {
        return price;
    }
}
