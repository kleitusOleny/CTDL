package lab10.task4;

public class OrderItem {
    private int quantity;
    private Product p;
    
    public OrderItem(int quantity, Product p) {
        this.quantity = quantity;
        this.p = p;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public Product getP() {
        return p;
    }
    
    @Override
    public String toString() {
        return "OrderItem{" +
                "quantity=" + quantity +
                ", p=" + p +
                '}';
    }
}
