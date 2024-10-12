package Lab3;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class TestTask2 extends TestCase {
    Product p1 = new Product("1", "A", 10000, "01");
    Product p2 = new Product("2", "B", 15000, "01");
    Product p3 = new Product("3", "C", 30000, "02");
    OrderItem orderItem1 = new OrderItem(p1, 3);
    OrderItem orderItem2 = new OrderItem(p2, 4);
    OrderItem orderItem3 = new OrderItem(p3, 4);
    Order order1 = new Order(new OrderItem[]{orderItem3, orderItem2, orderItem1});
    Order order2 = new Order(new OrderItem[]{orderItem1, orderItem2});
    Order order3 = new Order(new OrderItem[]{orderItem3, orderItem2});
    Order order4 = new Order(new OrderItem[]{orderItem1});

    Order[]orders = new Order[]{order1, order2, order3};
    OrderManager orderManager = new OrderManager(orders);

    public void testCost() {
        assertEquals(210000.0, order1.cost());
        assertEquals(90000.0, order2.cost());
        assertEquals(180000.0, order3.cost());
    }
    public void testContains() {
        assertTrue(order1.contains(p1));
        assertTrue(order2.contains(p2));
        assertFalse(order3.contains(p1));
    }
    public void testFilter() {
        assertEquals(Arrays.toString(order1.filter("01")),Arrays.toString(new Product[]{p2, p1}));
        assertEquals(Arrays.toString(order4.filter("01")),Arrays.toString(new Product[]{p1}));
    }

    public void testSortByCost() {
        orderManager.sortByCost();
        Order[] result = new Order[]{order1, order3, order2};
        assertEquals(Arrays.toString(orders),Arrays.toString(result));
    }

    public void testGetHighest() {
        assertEquals(Arrays.toString(orderManager.topNOrders(2)),Arrays.toString(new Order[]{order1, order3}));
    }
}
