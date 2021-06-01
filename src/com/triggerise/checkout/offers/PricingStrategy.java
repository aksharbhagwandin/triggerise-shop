package com.triggerise.checkout.offers;

import com.triggerise.checkout.products.Product;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getDiscountAmount(Product product, int quantity);
}
