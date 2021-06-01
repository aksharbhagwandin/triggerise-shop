package com.triggerise.checkout.offers;

public class PricingStrategyResolver {

    public static PricingStrategy getPricingStrategy(Offer offer) {

        if (offer instanceof PriceBasedOffer) {
            return new BuyPriceBasedOffer((PriceBasedOffer) offer);
        } else if (offer instanceof ProductBasedOffer) {
            return new BuyProductBasedOffer((ProductBasedOffer) offer);
        } else {
            return null;
        }

    }
}
