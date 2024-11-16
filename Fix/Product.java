package Fix;

public class Product {
    public String productID;
    private String productName;
    private String category;
    private double price;
    public Product(String productID, String productName, String category, double price) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }
    public String getProductID() {
        return productID;
    }
    
    public String getProductName() {
        return productName;
    }
    
    @Override
    public String toString() {
        return "Product [productID=" + productID + ", productName=" + productName + ", category=" + category + ", price=" + price + "]";
    }
}
