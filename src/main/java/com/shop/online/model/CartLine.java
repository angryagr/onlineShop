package com.shop.online.model;

public class CartLine {
    private Product product;
    private int quantity;

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
}
