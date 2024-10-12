package Lab3;

import java.util.List;
import java.util.ArrayList;

public class Order {
    private OrderItem[] items;

    public Order(OrderItem[] items) {
        this.items = items;
    }

    public double cost() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.cost();
        }
        return total;
    }

    // using binary search approach
    public boolean contains(Product p) {
        for (OrderItem item : items) {
            if (item.contain(p)) {
                return true;
            }
        }
        return false;
    }

    // get all products based on the given type using linear
    //search
    public Product[] filter(String type) {
        List<Product> filtered = new ArrayList<Product>();
        for (OrderItem item : items) {
            if (item.containType(type)) filtered.add(item.getP());

        }
        return filtered.toArray(new Product[0]);
    }

    @Override
    public String toString() {
        return "Cost: " + this.cost();
    }
}

