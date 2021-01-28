package com.shop.online.service;

import com.shop.online.dao.OrderDao;
import com.shop.online.exception.NullEntityReferenceException;
import com.shop.online.model.Order;
import com.shop.online.model.ShoppingCart;
import com.shop.online.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderDao orderDao;

    @InjectMocks
    private OrderServiceImpl sut;

    private List<Order> expectedList;
    private Order expectedOrder;
    private Order orderToDelete;
    private ShoppingCart cart;

    @BeforeEach
    public void prepare() {
        expectedList = mock(List.class);
        expectedOrder = mock(Order.class);
        orderToDelete = mock(Order.class);
        cart = mock(ShoppingCart.class);

        when(orderDao.findAll()).thenReturn(expectedList);

        when(orderDao.findById(expectedOrder.getId())).thenReturn(java.util.Optional.ofNullable(expectedOrder));
        when(orderDao.findById(8L)).thenThrow(new EntityNotFoundException("Order with id " + 8L + " not found"));

        when(orderDao.save(isA(Order.class))).thenReturn(expectedOrder);
        when(orderDao.save(null)).thenThrow(new NullEntityReferenceException("Order cannot be 'null'"));

        doThrow(new NullEntityReferenceException("Order cannot be 'null'")).when(orderDao).delete(orderToDelete);

    }

    @Test
    public void shouldSaveOrderWhenCartExists() {
        sut.save(cart);
        verify(orderDao, times(1)).save(Mockito.any());
    }

    @Test
    public void shouldThrowExceptionWhenCartIsNull() {
        Assertions.assertThrows(NullEntityReferenceException.class, () -> {
            sut.save(null);
        });

    }

    @Test
    public void shouldReturnAllOrders() {
        List<Order> actual = sut.getAll();
        Assertions.assertEquals(expectedList, actual);
    }

    @Test
    public void shouldReturnOrderIfIdExists() {
        Order actual = sut.readById(expectedOrder.getId());
        Assertions.assertEquals(expectedOrder, actual);
    }

    @Test
    public void shouldThrowExceptionIfIdNotExists() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> sut.readById(8L));
    }

    @Test
    public void shouldReturnUpdatedOrder() {
        Order actual = sut.update(expectedOrder);
        Assertions.assertEquals(expectedOrder, actual);
    }

    @Test
    public void shouldThrowExceptionIfOrderToUpdateIsNull() {
        Assertions.assertThrows(NullEntityReferenceException.class, () -> sut.update(null));
    }

    @Test
    public void shouldDeleteOrderWhenIdExists() {
        sut.delete(expectedOrder.getId());
        verify(orderDao, times(1)).delete(eq(expectedOrder));
    }

    @Test
    public void shouldThrowExceptionWhenDeleteIdNotExist() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            sut.delete(3L);
        });

    }

}
