package lab10.task4;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class Order {
    private Long iod;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Customer customer;
    private List<OrderItem> items;
    
    public Order(Long iod, String status, LocalDate orderDate, LocalDate deliveryDate, Customer customer, List<OrderItem> items) {
        this.iod = iod;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
        this.items = items;
    }
    
    public Long getIod() {
        return iod;
    }
    
    public String getStatus() {
        return status;
    }
    
    public LocalDate getOrderDate() {
        return orderDate;
    }
    
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public List<OrderItem> getItems() {
        return items;
    }
    
    public List<Product> getProductHigher(int threshold, String category) {
        return items.stream().map(OrderItem::getP).filter(p -> p.getCategory().equals(category) && p.getPrice() >= threshold).collect(Collectors.toList());
    }
    
    public void decreaseAllByCategory(String category){
        items.stream().map(OrderItem::getP).filter(p -> p.getCategory().equals(category)).forEach(Product::setPrice);
    }
    
    public Optional<Product> getCheapestProduct(){
        return items.stream().map(OrderItem::getP).min((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
    }
    
    public Optional<Product> getStaticsProduct(String category, Product product){
        return items.stream().map(OrderItem::getP).filter(p -> p.getCategory().equals(category)).filter(p -> p.equals(product)).findFirst();
    }
    
    public Map<String,String> getExpensiveProductByCategory(String category){
        return items.stream().map(OrderItem::getP).filter(p -> p.getCategory().equals(category)).collect(Collectors.toMap(Product::getCategory, Product::getName));
    }
    
    public static void main(String[] args) {
        Product p1 = new Product(1L,"Kem","Food",10000);
        Product p2 = new Product(2L,"Tra sua","Drink",20000);
        Product p3 = new Product(3L,"Banh Trang Tron","Food",15000);
        
        OrderItem orderItem1 = new OrderItem(2,p1);
        OrderItem orderItem2 = new OrderItem(5,p2);
        OrderItem orderItem3 = new OrderItem(3,p3);
        
        List<OrderItem> orderItemList1 = new ArrayList<>();
        orderItemList1.add(orderItem1);
        orderItemList1.add(orderItem2);
        orderItemList1.add(orderItem3);
        
        Customer customer1 = new Customer(5L,"A",1);
        
        
        Order order = new Order(1L,"available",LocalDate.of(2024,12,10),LocalDate.of(2024,12,12),customer1,orderItemList1);
        
//        System.out.println(order.getProductHigher(10000,"Food"));
//
//        order.decreaseAllByCategory("Drink");
//        System.out.println(order.getItems().get(1).getP());
        
//        System.out.println(order.getCheapestProduct());
        
        System.out.println(order.getExpensiveProductByCategory("Food"));
    }
}
