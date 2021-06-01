package com.triggerise.checkout.services;

import com.triggerise.checkout.products.Product;

import java.math.BigDecimal;

public class ProductService {

    public static Product getProduct(String productCode) {
        if ("Mug".equalsIgnoreCase(productCode)) {
            return new Product("Triggerise Mug", "Mug", new BigDecimal(4.00));
        } else if ("Tshirt".equalsIgnoreCase(productCode)) {
            return new Product("Triggerise Tshirt", "Tshirt", new BigDecimal(21.00));
        } else if ("USBKEY".equalsIgnoreCase(productCode)) {
            return new Product("Triggerise USB Key", "USBKEY", new BigDecimal(10.00));
        }
        else {
            return null;
        }

    }



}
