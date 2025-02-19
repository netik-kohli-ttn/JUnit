package com.demo.service;

import com.demo.domain.Order;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {
    private Order order;
    private OrderService orderService;

    @Before
    public void setUp() {
        order = new Order(1, "Smartphone", 12000.0);
        orderService = new OrderService();
    }

    @Test
    public void testPlaceOrder() {
        assertTrue(orderService.placeOrder(order, "netik@gmail.com"));
        assertTrue(order.isCustomerNotified());
    }

    @Test(expected = RuntimeException.class)
    public void placeOrderTest() {
        orderService.placeOrder(order);
    }

}
