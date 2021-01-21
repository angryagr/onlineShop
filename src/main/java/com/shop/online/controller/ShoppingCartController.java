package com.shop.online.controller;

import com.shop.online.model.ShoppingCart;
import com.shop.online.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @GetMapping(value = {"/show"})
    public String showCart(HttpServletRequest request, Model model) {
        ShoppingCart cart = Utils.getCartInSession(request);
        model.addAttribute("cartForm", cart);
        return "cart";
    }



}
