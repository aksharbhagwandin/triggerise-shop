package com.triggerise.checkout.offers;

import com.triggerise.checkout.products.Product;

import java.math.BigDecimal;

public class BuyProductBasedOffer implements PricingStrategy {

    private ProductBasedOffer productBasedOffer;

    BuyProductBasedOffer(ProductBasedOffer productBasedOffer) {
        this.productBasedOffer = productBasedOffer;
    }

    @Override
    public BigDecimal getDiscountAmount(Product product, int quantity) {
        int totalItemCount = productBasedOffer.getQualifyingItems() + productBasedOffer.getDiscountableItems();

        if (quantity >= totalItemCount) {
            int quantityCalculation = quantity;
            BigDecimal discount = new BigDecimal(0.00);

            while (quantityCalculation >= totalItemCount) {
                discount = discount.add(product.getPrice().multiply(new BigDecimal(productBasedOffer.getDiscountableItems())));
                quantityCalculation = quantityCalculation - totalItemCount;
            }
            return discount;
        }
        return new BigDecimal(0.00);
    }
}
