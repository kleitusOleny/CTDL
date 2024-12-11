package lab10.task4;

import java.time.LocalDate;
import java.util.*;

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
}
