package com.shop.online.controller;

import com.shop.online.model.Order;
import com.shop.online.model.ShoppingCart;
import com.shop.online.service.OrderService;
import com.shop.online.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping({"/all"})
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @GetMapping({"/{id}/delete"})
    public String deleteOrder(@PathVariable long id) {
        orderService.delete(id);
        return "redirect:/orders/all";
    }

    @GetMapping({"/create"})
    public String create(HttpServletRequest request, Model model) {
        ShoppingCart cart = Utils.getCartInSession(request);
        model.addAttribute("cart", cart);
        return "create-order";
    }

    @PostMapping({"/create"})
    public String create(@ModelAttribute("cart") ShoppingCart cart, HttpServletRequest request) {
        orderService.save(cart);
        Utils.removeCartFromSession(request);
        Utils.storeLastOrderedCartInSession(request, cart);
        return "redirect:/orders/confirm";
    }

    @GetMapping({"/confirm"})
    public String confirm(HttpServletRequest request, Model model) {
        ShoppingCart lastOrderedCart = Utils.getLastOrderedCartInSession(request);
        model.addAttribute("lastOrderedCart", lastOrderedCart);
        return "confirmed-order";
    }

    @GetMapping({"/{id}/edit"})
    public String update(@PathVariable long id, Model model) {
        Order order = orderService.readById(id);
        model.addAttribute("order", order);
        return "edit-order";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable long id, @ModelAttribute("order") Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-order";
        }

        Order oldOrder = orderService.readById(id);
        order.setBillingAddress(oldOrder.getBillingAddress());
        order.setProductList(oldOrder.getProductList());
        orderService.update(order);
        return "redirect:/orders/all";
    }

}
