package com.shop.online.utils;

import com.shop.online.model.ShoppingCart;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    /**
     * Returns cart, stored in session.
     * If cart doesn't exist creates the cart object and sets it as session attribute.Ø
     *
     * @param request @link #HttpServletRequest
     * @return <code> @link #ShoppingCart</code>
     */
    public static ShoppingCart getCartInSession(HttpServletRequest request) {

        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");


        if (cart == null) {
            cart = new ShoppingCart();

            request.getSession().setAttribute("cart", cart);
        }

        return cart;
    }

    public static void removeCartFromSession(HttpServletRequest request) {
        request.getSession().removeAttribute("cart");
    }

    public static void storeLastOrderedCartInSession(HttpServletRequest request, ShoppingCart cart) {
        request.getSession().setAttribute("lastOrderedCart", cart);
    }

    public static ShoppingCart getLastOrderedCartInSession(HttpServletRequest request) {
        return (ShoppingCart) request.getSession().getAttribute("lastOrderedCart");
    }

}

