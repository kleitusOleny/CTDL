package lab10.task1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class OrderManager {
    private List<Order> orders;
    
    public OrderManager(List<Order> orders) {
        this.orders = orders;
    }
    
    //Task1.1 Product maxProduct() tìm ra sản phẩm có giá bán cao nhất.
    public Product maxProduct() {
        Product product = orders.getFirst().getMaxProduct();
        for (int i = 1; i < orders.size(); i++) {
            product = product.ProductHigherPrice(orders.get(i).getMaxProduct());
        }
        return product;
    }
    
    public Product maxProductJava8() {
        return orders.stream().flatMap(order -> order.getItems().stream().map(OrderItem::getItem)).max((o1, o2) -> Integer.compare(o1.getPrice(), o2.getPrice())).orElse(null);
    }
    
    //Task1.2 HashMap<String, Integer> productTypesStatistics() trả về loại sản phẩm và
    //số lượng bán ra cho mỗi loại.
    public HashMap<String, Integer> productTypesStatistics() {
        HashMap<String, Integer> res = new HashMap<>();
        
        for (Order order : orders) {
            HashMap<String, Integer> orderToMap = order.getProductType();
            for (String key : orderToMap.keySet()) {
                res.put(key, res.getOrDefault(key, 0) + orderToMap.getOrDefault(key, 0));
            }
        }
        return res;
    }
    
    public Map<String, Integer> productTypesStatisticsJava8() {
        return orders.stream().flatMap(order -> order.getItems().stream())
                .collect(Collectors.toMap(o -> o.getItem().getType(), OrderItem::getAmount, Integer::sum));
    }
    
    //Task1.3 TreeSet<Order> ordersByCost() trả về danh sách các hóa đơn sắp xếp giảm
    //dần theo giá trị của hóa đơn. Nếu 2 hóa đơn có cùng giá trị thì xếp theo ngày.
    public TreeSet<Order> ordersByCost() {
        Comparator<Order> c = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return (o1.totalPrice() - o2.totalPrice() != 0 ? o2.totalPrice() - o1.totalPrice() : o1.getDate().compareTo(o2.getDate()));
            }
            
        };
        Comparator<Order> com = (o1, o2) -> o1.totalPrice() - o2.totalPrice();
        TreeSet<Order> result = new TreeSet<>(c);
        result.addAll(orders);
        return result;
    }
    
    public Set<Order> ordersByCostJava8() {
        Set<Order> res = new TreeSet<Order>(((o1, o2) -> (o2.totalPrice() - o1.totalPrice() != 0 ? o2.totalPrice() - o1.totalPrice() : o1.getDate().compareTo(o2.getDate()))));
        res.addAll(orders);
        return res;
    }
}
