package com.shop.online.service.impl;

import com.shop.online.dao.OrderDao;
import com.shop.online.exception.NullEntityReferenceException;
import com.shop.online.model.Order;
import com.shop.online.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    /**
     * Returns list of all existing orders or empty list
     *
     * @return <code> @link #List<@link #Order></code>
     */
    @Override
    public List<Order> getAll() {
       List<Order> orders = orderDao.findAll();
        return orders.isEmpty() ? new ArrayList<>() : orders;
    }

    /**
     * Returns order object if  given id exists
     * else throws EntityNotFoundException
     *
     * @param id id of order object to be found
     * @return <code> @link #Order</code>
     * @throws EntityNotFoundException <code> @link #EntityNotFoundException</code> if given id doesn't exist
     */
    @Override
    public Order readById(long id) {
        Optional<Order> optional = orderDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EntityNotFoundException("Order with id " + id + " not found");
    }

    /**
     * Returns updated order object
     *
     * @param order order object to be updated
     * @return <code> @link #List<@link #Order></code>
     * @throws NullEntityReferenceException <code> @link #com.shop.online.exception.NullEntityReferenceException</code> if given object is null
     */
    @Override
    public Order update(Order order) {
        if (order != null) {
            Order oldOrder = readById(order.getId());
            if (oldOrder != null) {
                return orderDao.save(order);
            }
        }
        throw new NullEntityReferenceException("Order cannot be 'null'");
    }

    /**
     * Deletes order object by id
     *
     * @param id id of order object to be deleted
     * @throws NullEntityReferenceException <code> @link #com.shop.online.exception.NullEntityReferenceException</code> if order object with given id is null
     */
    public void delete(long id) {
        Order order = readById(id);
        if (order != null) {
            orderDao.delete(order);
        } else {
            throw new NullEntityReferenceException("Order cannot be 'null'");
        }
    }


}
