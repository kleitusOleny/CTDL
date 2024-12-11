package lab10.task4;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
    
    public List<OrderItem> getProductHigher(double threshold){
        List<OrderItem> ps = items.stream().filter(orderItem -> orderItem.getP().getPrice() > threshold).collect(Collectors.toList());
        return ps;
    }
}
