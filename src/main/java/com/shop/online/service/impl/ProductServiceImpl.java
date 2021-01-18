package com.shop.online.service.impl;

import com.shop.online.dao.ProductDao;
import com.shop.online.exception.NullEntityReferenceException;
import com.shop.online.model.Product;
import com.shop.online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    /**
     * Returns list of all existing products
     *
     * @return <code> @link #List<@link #Product></code>
     */
    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    /**
     * Deletes product object by id
     *
     * @param id id of product object to be deleted
     * @throws NullEntityReferenceException <code> @link #com.shop.online.exception.NullEntityReferenceException</code> if product object with given id is null
     */
    @Override
    public void delete(long id) {
        Product productToDelete = readById(id);
        if (productToDelete != null) {
            productDao.delete(productToDelete);
        } else {
            throw new NullEntityReferenceException("Product cannot be 'null'");
        }
    }

    /**
     * Returns product object if  given id exists
     * else throws EntityNotFoundException
     *
     * @param id id of order object to be found
     * @return <code> <@link #Product></code>
     * @throws EntityNotFoundException <code> @link #EntityNotFoundException</code> if given id doesn't exist
     */
    @Override
    public Product readById(long id) {
        Optional<Product> optional = productDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EntityNotFoundException("Product with id " + id + " not found");
    }
}
