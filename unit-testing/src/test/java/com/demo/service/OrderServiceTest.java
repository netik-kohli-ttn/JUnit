package com.demo.service;

import com.demo.domain.Order;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {
    private static Order order;
    private static OrderService orderService;

    @BeforeClass
    public static void initialization() {
        order = new Order(1, "Thinkpad", 29000);
        orderService = new OrderService();
    }

    @Test
    public void testGetInstance(){
        assertNotNull(OrderService.getInstance());
    }

    @Test
    public void testPlaceOrder() {
        assertTrue(orderService.placeOrder(order, "netikkohli@gmail.com"));
        assertTrue(order.isCustomerNotified());
    }

    @Test(expected = RuntimeException.class)
    public void placeOrderTest() {
        orderService.placeOrder(order);
    }
    
}
