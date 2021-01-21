package com.shop.online.model;

public class CartLine {
    private Product product;
    private int quantity;
    private double price;

    public CartLine() {
        this.quantity = 0;
    }

    public double getAmount() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
