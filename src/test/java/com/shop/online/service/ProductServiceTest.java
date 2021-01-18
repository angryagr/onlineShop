package com.shop.online.service;

import com.shop.online.dao.ProductDao;
import com.shop.online.exception.NullEntityReferenceException;
import com.shop.online.model.Product;
import com.shop.online.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductServiceImpl sut;

    private List<Product> expectedList;
    private Product expectedProduct;
    private Product productToDelete;

    @BeforeEach
    public void prepare() {
        expectedList = mock(List.class);
        expectedProduct = mock(Product.class);
        productToDelete = mock(Product.class);

        when(productDao.findAll()).thenReturn(expectedList);

        when(productDao.findById(expectedProduct.getId())).thenReturn(java.util.Optional.ofNullable(expectedProduct));
        when(productDao.findById(8L)).thenThrow(new EntityNotFoundException("Order with id " + 8L + " not found"));

        doThrow(new NullEntityReferenceException("Product cannot be 'null'")).when(productDao).delete(productToDelete);
    }

    @Test
    public void shouldReturnAllProducts() {
        List<Product> actual = sut.getAll();
        Assertions.assertEquals(expectedList, actual);
    }

    @Test
    public void shouldReturnProductIfIdExists() {
        Product actual = sut.readById(expectedProduct.getId());
        Assertions.assertEquals(expectedProduct, actual);
    }

    @Test
    public void shouldThrowExceptionIfIdNotExists() {
        Assertions.assertThrows(EntityNotFoundException.class, ()-> sut.readById(8L));
    }
    @Test
    public void shouldDeleteProductWhenIdExists() {
        sut.delete(expectedProduct.getId());
        verify(productDao, times(1)).delete(eq(expectedProduct));
    }

    @Test
    public void shouldThrowExceptionWhenDeleteIdNotExist() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            sut.delete(3L);
        });

    }

}
