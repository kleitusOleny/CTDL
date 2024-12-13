package lab10.task4;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class OrderManager {
    List<Order> orders;
    
    public OrderManager(List<Order> orders) {
        this.orders = orders;
    }
    
   public List<Order> getAllOrdersWithCategory(String category){
        return orders.stream().filter(order -> order.getItems().stream().anyMatch(orderItem -> orderItem.getP().getCategory().equals(category))).collect(Collectors.toList());
   }
   
   public List<Order> getAllOrdersByTierBetweenDate(int tier,LocalDate start, LocalDate end){
        return orders.stream().filter(order -> order.getCustomer().getTier() == tier).filter(order -> order.getOrderDate().isBefore(end) && order.getOrderDate().isAfter(start)).collect(Collectors.toList());
   }
   
   public List<Order>get3OrderRecent(){
        return orders.stream().sorted((o1, o2) -> o2.getOrderDate().compareTo(o1.getOrderDate())).limit(3).collect(Collectors.toList());
   }
   
   public List<Order>getAllOrderOnDate(LocalDate date){
        return orders.stream().filter(order -> order.getOrderDate().equals(date)).collect(Collectors.toList());
   }
   
   public double getCostInYearMonth(int year, int month){
        return orders.stream().filter(order -> order.getOrderDate().getYear() == year).filter(order -> order.getOrderDate().getMonth().getValue() == month).flatMap(order -> order.getItems().stream()).mapToDouble(value -> value.getQuantity()*value.getP().getPrice()).sum();
   }
   
   public double getAVGCostInDate(LocalDate date){
        return orders.stream().filter(order -> order.getOrderDate().equals(date)).flatMap(order -> order.getItems().stream()).mapToDouble(value -> value.getQuantity()*value.getP().getPrice()).sum()/orders.stream().filter(order -> order.getOrderDate().equals(date)).count();
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
        List<OrderItem> orderItemList2 = new ArrayList<>();
        orderItemList2.add(orderItem3);
        orderItemList2.add(orderItem1);
        List<OrderItem> orderItemList3 = new ArrayList<>();
        orderItemList3.add(orderItem2);
        orderItemList3.add(orderItem2);
        
        Customer customer1 = new Customer(5L,"A",1);
        Customer customer2 = new Customer(2L,"B",2);
        
        
        Order order1 = new Order(1L,"available", LocalDate.of(2024,11,10),LocalDate.of(2024,12,12),customer1,orderItemList1);
        
        Order order2 = new Order(2L,"export",LocalDate.of(2024,3,11),LocalDate.of(2024,11,20),customer2,orderItemList2);
        
        Order order3 = new Order(3L,"export",LocalDate.of(2024,11,10),LocalDate.of(2024,11,21),customer1,orderItemList3);
        
        Order order4 = new Order(4L,"export",LocalDate.of(2024,3,15),LocalDate.of(2024,11,21),customer1,orderItemList2);
        
        List<Order> listOrder = new ArrayList<>();
        listOrder.add(order1);
        listOrder.add(order2);
        listOrder.add(order3);
        listOrder.add(order4);
        OrderManager orderManager = new OrderManager(listOrder);
        
//        System.out.println(orderManager.getAllOrdersWithCategory("Drink"));
//
//        System.out.println(orderManager.getAllOrdersByTierBetweenDate(2,LocalDate.of(2024,2,1),LocalDate.of(2024,4,1)));
        
//        System.out.println(orderManager.get3OrderRecent());
        
//        System.out.println(orderManager.getAllOrderOnDate(LocalDate.of(2024,3,15)));
        
//        System.out.println(orderManager.getCostInYearMonth(2024,2));
        
//        System.out.println(orderManager.getAVGCostInDate(LocalDate.of(2024,3,15)));
    }
}
