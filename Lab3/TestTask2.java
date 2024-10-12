package Lab3;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TestTask2 extends TestCase {
    Product p1 = new Product("1", "A", 10000, "01");
    Product p2 = new Product("2", "B", 15000, "01");
    Product p3 = new Product("3", "C", 30000, "02");
    OrderItem orderItem1 = new OrderItem(p1, 3);
    OrderItem orderItem2 = new OrderItem(p2, 2);
    OrderItem orderItem3 = new OrderItem(p3, 4);
    Order order = new Order(new OrderItem[]{orderItem1, orderItem2});
    Order order2 = new Order(new OrderItem[]{orderItem3, orderItem1});
    Order order3 = new Order(new OrderItem[]{orderItem3, orderItem2, orderItem1});

    public void testCost() {
        assertEquals(60000.0, order.cost());
    }
    public void testContains() {
        assertTrue(order.contains(p1));
        assertFalse(order2.contains(p2));
    }
    public void testFilter() {
        Product[] products = {p1,p2,p3};
        assertEquals(order3.filter("01"),products);
    }
}
