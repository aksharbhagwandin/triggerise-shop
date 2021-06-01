package com.triggerise.checkout.offers;

import com.triggerise.checkout.products.Product;

import java.math.BigDecimal;

public class BuyPriceBasedOffer implements PricingStrategy {

    private PriceBasedOffer priceBasedOffer;

    BuyPriceBasedOffer(PriceBasedOffer priceBasedOffer) {
        this.priceBasedOffer = priceBasedOffer;
    }

    @Override
    public BigDecimal getDiscountAmount(Product product, int quantity) {
        if (quantity >= priceBasedOffer.getMinimumQuantity()) {
            return product.getPrice().multiply(new BigDecimal(quantity))
                    .multiply(new BigDecimal(priceBasedOffer.getDiscountPercentage()))
                    .divide(new BigDecimal(100));
        }
        return new BigDecimal(0.00);
    }
}
