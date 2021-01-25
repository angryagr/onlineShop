package com.shop.online.model;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    private long id;
    private User user;
    private final List<CartLine> productList = new ArrayList<>();

    public ShoppingCart() {
    }

    private CartLine findLineById(long id) {
        for (CartLine line : this.productList) {
            if (line.getProduct().getId() == id) {
                return line;
            }
        }
        return null;
    }

    public void addProduct(Product product, int quantity) {
        CartLine cartLine = findLineById(product.getId());
        if (cartLine == null) {
            cartLine = new CartLine();
            cartLine.setProduct(product);
            cartLine.setQuantity(0);
            cartLine.setPrice(product.getPrice());
            productList.add(cartLine);
        }
        int newQuantity = cartLine.getQuantity() + quantity;

        if (newQuantity == 0) {
            removeProduct(product);
        } else {
            cartLine.setQuantity(newQuantity);
            cartLine.setPrice(product.getPrice() * newQuantity);
        }
    }

    public void removeProduct(Product product) {
        CartLine cartLine = findLineById(product.getId());
        if (cartLine != null) {
            productList.remove(cartLine);
        }
    }

    public boolean isEmpty() {
        return productList.isEmpty();
    }

    public double getPriceTotal() {
        return productList.stream().mapToDouble(CartLine::getPrice).sum();
    }

    public double getAmountTotal() {
        return productList.stream().mapToDouble(CartLine::getAmount).sum();
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

    public List<CartLine> getProductList() {
        return productList;
    }

}
