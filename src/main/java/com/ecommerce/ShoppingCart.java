package com.ecommerce;

public class ShoppingCart {
    private double totalAmount;

    public ShoppingCart() {
        totalAmount = 0.0;
    }

    public void addProduct(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        totalAmount += price;
    }

    public double calculateDiscount() {
        return totalAmount >= 1000 ? totalAmount * 0.10 : 0.0;
    }

    public double calculateFinalAmount() {
        return totalAmount - calculateDiscount();
    }

    public void displayCart() {
        System.out.println("E-Commerce Shopping Cart");
        System.out.println("------------------------");
        System.out.println("Total Amount: Rs." + totalAmount);
        System.out.println("Discount: Rs." + calculateDiscount());
        System.out.println("Final Amount: Rs." + calculateFinalAmount());
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(500);
        cart.addProduct(700);
        cart.displayCart();
    }
}
