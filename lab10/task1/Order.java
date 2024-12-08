package lab10.task1;


import java.time.LocalDate;
import java.util.*;

public class Order {
    private String id;
    private String customer;
    private String employee;
    private LocalDate date;
    private List<OrderItem> items;
    
    public Order(String id, String customer, String employee, LocalDate date, List<OrderItem> items) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.date = date;
        this.items = items;
    }
    
    public String getId() {
        return id;
    }
    
    public String getCustomer() {
        return customer;
    }
    
    public String getEmployee() {
        return employee;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public List<OrderItem> getItems() {
        return items;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customer='" + customer + '\'' +
                ", employee='" + employee + '\'' +
                ", date=" + date +
                ", items=" + items +
                ", total=" + totalPrice() +
                '}';
    }
    
    public Product getMaxProduct() {
        Product highest = null;
        for (OrderItem orderItem : items){
            highest = orderItem.getItem().ProductHigherPrice(highest);
        }
        return highest;
    }
    
    public HashMap<String,Integer> getProductType(){
        HashMap<String,Integer> res = new HashMap<>();
        for (OrderItem item : items){
            res.put(item.getTypeProduct(),res.getOrDefault(item.getTypeProduct(),0)+ item.getAmount());
        }
        return res;
    }
    
    public int totalPrice() {
        int total = 0;
        for (OrderItem item : items){
            total += item.getAmount() * item.getItem().getPrice();
        }
        return total;
    }
}
