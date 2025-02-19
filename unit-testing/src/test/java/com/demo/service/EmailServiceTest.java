package com.demo.service;

import com.demo.domain.Order;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {
    private static EmailService emailService;
    private static Order order;

    @BeforeClass
    public static void InitBeforeClass() throws Exception {
         emailService = new EmailService();
         order = new Order(1, "Smart Phone", 200000);
    }

    @Test
    public void sendEmail() {
        Assert.assertTrue(emailService.sendEmail(order, "netik@gmail.com"));
    }
    @Test
    public void sendEmailWithException() {
        try {
            emailService.sendEmail(order);
            throw new AssertionError("RuntimeException was not thrown");
        } catch (RuntimeException e) {
            Assert.assertFalse(order.isCustomerNotified());
        }
    }
}