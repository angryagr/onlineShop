package com.shop.online.controller;

import com.shop.online.model.Product;
import com.shop.online.model.ShoppingCart;
import com.shop.online.service.ProductService;
import com.shop.online.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/show"})
    public String showCart(HttpServletRequest request, Model model) {
        ShoppingCart cart = Utils.getCartInSession(request);
        model.addAttribute("cartForm", cart);
        return "cart";
    }

    @GetMapping({"/{id}/remove"})
    public String deleteProduct(@PathVariable long id, HttpServletRequest request) {
        Product product = productService.readById(id);
        if (product != null) {
            ShoppingCart cart = Utils.getCartInSession(request);
            cart.removeProduct(product);
        }
        return "redirect:/cart/show";
    }
}





