package com.shop.online.model;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    private long id;
    private User user;
    private final List<Product> productList = new ArrayList<>();

    public ShoppingCart() {
    }


    public void addProduct(Product product, int quantity) {
        if (!productList.contains(product)) {
            productList.add(product);
        }
        product.setQuantity(product.getQuantity() + quantity);

        if (product.getQuantity() == 0) {
            removeProduct(product);
        }
    }

    public void removeProduct(Product product) {
        if (productList.contains(product)) {
            productList.remove(product);
        }
    }

    public boolean isEmpty(){
        return productList.isEmpty();
    }

    public double getAmountTotal(){
        return productList.stream().mapToDouble(Product::getAmount).sum();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

}
