package com.ecommerce;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {
    @Test
    public void testAddProductAndFinalAmount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(500);
        cart.addProduct(700);
        assertEquals(1080.0, cart.calculateFinalAmount(), 0.01);
    }

    @Test
    public void testDiscountCalculation() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(2000);
        assertEquals(200.0, cart.calculateDiscount(), 0.01);
    }

    @Test
    public void testNoDiscountBelowThreshold() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(500);
        assertEquals(0.0, cart.calculateDiscount(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidProductPrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(-100);
    }
}
