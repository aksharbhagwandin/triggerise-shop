package com.triggerise.checkout;

import com.triggerise.checkout.offers.PricingStrategy;
import com.triggerise.checkout.offers.PricingStrategyResolver;
import com.triggerise.checkout.pricingrules.impl.PricingRuleImpl;
import com.triggerise.checkout.services.ProductService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {

    private Map<String, Integer> products;

    public BigDecimal total;

    private List<PricingRuleImpl> pricingRules;

    public Checkout(List<PricingRuleImpl> pricingRules) {
        this.pricingRules = pricingRules;
    }

    public Checkout scan(String name) {
        if (products == null) {
            products = new HashMap<String, Integer>();
        }

        if (products.get(name) == null) {
            products.put(name, 1);
        } else {
            products.put(name, products.get(name) + 1);
        }
        total = reCalculateCart();
        return this;
    }

    private BigDecimal reCalculateCart() {
        BigDecimal total;
        BigDecimal totalPrice = new BigDecimal(BigInteger.ZERO);
        BigDecimal totalDiscount = new BigDecimal(BigInteger.ZERO);

        for (Map.Entry<String, Integer> entry : products.entrySet()) {

            totalPrice = totalPrice.add(ProductService.getProduct(entry.getKey()).getPrice().multiply(new BigDecimal(entry.getValue())));
            for (PricingRuleImpl rule : pricingRules) {
                if (rule.getProduct().getCode().equalsIgnoreCase(entry.getKey())) {
                    PricingStrategy pricingStrategy = PricingStrategyResolver.getPricingStrategy(rule.getOffer());
                    if (pricingStrategy != null) {
                        totalDiscount = totalDiscount.add(pricingStrategy.getDiscountAmount(ProductService.getProduct(entry.getKey()), entry.getValue()));
                    }
                }
            }
        }

        total = totalPrice.subtract(totalDiscount);
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
