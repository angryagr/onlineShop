package com.shop.online.controller;

import com.shop.online.model.Order;
import com.shop.online.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping({"/{id}/edit"})
    public String update(@PathVariable long id, Model model) {
        Order order = orderService.readById(id);
        model.addAttribute("order", order);
        return "edit-order";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable long id, @ModelAttribute("order") Order order) {
        Order oldOrder = orderService.readById(id);
        order.setBill(oldOrder.getBill());
        order.setBillingAddress(oldOrder.getBillingAddress());
        order.setProductList(oldOrder.getProductList());
        orderService.update(order);
        return "redirect:/orders/all";
    }


}
