package com.shop.online.service;

import com.shop.online.model.Order;
import com.shop.online.model.ShoppingCart;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    void delete(long id);
    Order readById(long id);
    Order update (Order order);
    void save(ShoppingCart cart);

}
