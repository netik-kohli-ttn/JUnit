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

    @BeforeClass
    public static void initialization() {
        emailService = new EmailService();
    }

    @Test
    public void testGetInstance() {
        Assert.assertNotNull(EmailService.getInstance());
    }

    @Test
    public void testSendEmail() {
        Order order = new Order(1, "Sandwich", 150);
        Assert.assertTrue(emailService.sendEmail(order, "netik@gmail.com"));
    }

    @Test(expected = RuntimeException.class)
    public void testSendEmailException() {
        Order order = new Order(2, "Burger", 200);
        emailService.sendEmail(order);
    }
}
