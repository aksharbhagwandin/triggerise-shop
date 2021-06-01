package com.triggerise.checkout.pricingrules.impl;

import com.triggerise.checkout.offers.Offer;
import com.triggerise.checkout.pricingrules.PricingRule;
import com.triggerise.checkout.products.Product;

public class PricingRuleImpl implements PricingRule {
    private Product product;
    private Offer offer;

    public PricingRuleImpl(Product product, Offer offer) {
        this.product = product;
        this.offer = offer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
