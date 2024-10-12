package Lab3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class OrderManager {
    private Order[] orders;

    public OrderManager(Order[] orders) {
        this.orders = orders;
    }

    Comparator<Order> comp = new Comparator<Order>() {
        public int compare(Order o1, Order o2) {
            if (o1.cost() < o2.cost()){
                return 1;
            }else{
                return -1;
            }
        }
    };
    // sort orders by cost (descending)
    public void sortByCost() {
        Arrays.sort(orders, comp);
    }

    // get top N highest orders by cost
    public Order[] topNOrders(int n) {
        Order[] result = new Order[n];
        this.sortByCost();
        System.arraycopy(orders, 0, result, 0, n);
        return result;
    }
}
