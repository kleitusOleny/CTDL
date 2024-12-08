package lab10.task1;

import java.time.LocalDate;
import java.util.*;

public class OrderManager {
    private List<Order> orders;
    
    public OrderManager(List<Order> orders) {
        this.orders = orders;
    }
    
    public Product maxProduct(){
        Product product = orders.getFirst().getMaxProduct();
        for (int  i = 1; i < orders.size(); i++){
                product = product.ProductHigherPrice(orders.get(i).getMaxProduct());
        }
        return product;
    }
    
    public HashMap<String, Integer> productTypesStatistics(){
        HashMap<String, Integer> res = new HashMap<>();
        
        for (Order order : orders){
            HashMap<String, Integer> orderToMap = order.getProductType();
            for (String key : orderToMap.keySet()){
                    res.put(key,res.getOrDefault(key,0)+ orderToMap.getOrDefault(key,0));
            }
        }
        return res;
    }
    
    public TreeSet<Order>ordersByCost(){
        Comparator<Order> c = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return (o1.totalPrice() - o2.totalPrice() != 0 ? o1.totalPrice() - o2.totalPrice() : o1.getDate().compareTo(o2.getDate()));
            }
            
        };
        Comparator<Order> com = (o1,o2) -> o1.totalPrice() - o2.totalPrice();
        TreeSet<Order> result = new TreeSet<>(c);
        result.addAll(orders);
        return result;
    }
    
    public static void main(String[] args) {
        Product p1 = new Product("A","T",250000,LocalDate.of(2024,5,1));
        Product p2 = new Product("B","T",150000,LocalDate.of(2024,5,2));
        Product p3 = new Product("C","V",200000,LocalDate.of(2024,5,3));
        Product p4 = new Product("D","V",250000,LocalDate.of(2024,5,3));
        
        OrderItem orderItem = new OrderItem(p1,10);
        OrderItem orderItem1 = new OrderItem(p2,20);
        OrderItem orderItem2 = new OrderItem(p3, 5);
        OrderItem orderItem3 = new OrderItem(p4, 15);
        
        
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);
        List<OrderItem> orderItemList1 = new ArrayList<>();
        orderItemList1.add(orderItem3);
        
        Order order = new Order("001","Vinh","V",LocalDate.of(2024,5,1),orderItemList);
        Order order1 = new Order("002","T","V",LocalDate.of(2024,5,3),orderItemList1);
        
        List<Order> orderList = new ArrayList<>();
        orderList.add(order);
        orderList.add(order1);
        
        OrderManager orderManager = new OrderManager(orderList);
        
        System.out.println(orderManager.maxProduct());
        
        System.out.println(orderManager.productTypesStatistics());
        
        System.out.println(orderManager.ordersByCost());
        
    }
}
