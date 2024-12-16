package lab10.task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestTask1 {
    public static void main(String[] args) {
        Product p1 = new Product("A", "T", 270000, LocalDate.of(2024, 5, 1));
        Product p2 = new Product("B", "T", 150000, LocalDate.of(2024, 5, 2));
        Product p3 = new Product("C", "V", 200000, LocalDate.of(2024, 5, 3));
        Product p4 = new Product("D", "V", 250000, LocalDate.of(2024, 5, 3));
        
        OrderItem orderItem = new OrderItem(p1, 10);
        OrderItem orderItem1 = new OrderItem(p2, 20);
        OrderItem orderItem2 = new OrderItem(p3, 5);
        OrderItem orderItem3 = new OrderItem(p4, 15);
        
        
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);
        List<OrderItem> orderItemList1 = new ArrayList<>();
        orderItemList1.add(orderItem3);
        
        Order order = new Order("001", "Vinh", "V", LocalDate.of(2024, 5, 1), orderItemList);
        Order order1 = new Order("002", "T", "V", LocalDate.of(2024, 5, 3), orderItemList1);
        
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderList.add(order1);
        
        OrderManager orderManager = new OrderManager(orderList);
        
        System.out.println("Max Product(Java core): "+orderManager.maxProduct());
        System.out.println("Max Product(Java 8): "+orderManager.maxProductJava8());
        System.out.println();
        System.out.println("sản phẩm và số lượng bán ra cho mỗi loại(Java Core): \n" + orderManager.productTypesStatistics());
        System.out.println("sản phẩm và số lượng bán ra cho mỗi loại(Java 8): \n" +orderManager.productTypesStatisticsJava8());
        System.out.println();
        System.out.println("hóa đơn sắp xếp giảm dần theo giá trị của hóa đơn(Java Core): \n" + orderManager.ordersByCost());
        System.out.println("hóa đơn sắp xếp giảm dần theo giá trị của hóa đơn(Java Core): \n" +orderManager.ordersByCostJava8());
        
    }
}
