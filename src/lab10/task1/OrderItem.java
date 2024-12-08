package lab10.task1;

public class OrderItem {
    private Product item;
    private int amount;
    
    public OrderItem(Product item, int amount) {
        this.item = item;
        this.amount = amount;
    }
    
    public Product getItem() {
        return item;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public String getTypeProduct(){
        return item.getType();
    }
    
    @Override
    public String toString() {
        return "OrderItem{" +
                "item=" + item +
                ", amount=" + amount +
                '}';
    }
}
