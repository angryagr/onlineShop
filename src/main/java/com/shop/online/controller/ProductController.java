package com.shop.online.controller;

import com.shop.online.model.Product;
import com.shop.online.model.ShoppingCart;
import com.shop.online.service.ProductService;
import com.shop.online.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping({"/all"})
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping({"/sortAsc"})
    public String sortAscending( Model model) {
        model.addAttribute("products", productService.sortByPriceAsc());
        return "products";
    }

    @GetMapping({"/sortDsc"})
    public String sortDescending( Model model) {
        model.addAttribute("products", productService.sortByPriceDesc());
        return "products";
    }

    @GetMapping({"/{id}/buy"})
    public String buyProduct(@PathVariable long id, HttpServletRequest request, Model model) {
        Product product = productService.readById(id);

        if (product != null) {
            ShoppingCart cart = Utils.getCartInSession(request);
            cart.addProduct(product, 1);
            model.addAttribute("cartForm", cart);
        }

        return "redirect:/cart/show";
    }

}
