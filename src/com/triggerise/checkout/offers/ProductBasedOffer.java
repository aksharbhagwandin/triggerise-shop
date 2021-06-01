package com.triggerise.checkout.offers;

public class ProductBasedOffer implements Offer {
    int qualifyingItems;
    int discountableItems;

    public ProductBasedOffer(int qualifyingItems, int discountableItems) {
        this.qualifyingItems = qualifyingItems;
        this.discountableItems = discountableItems;
    }

    public int getQualifyingItems() {
        return qualifyingItems;
    }

    public void setQualifyingItems(int qualifyingItems) {
        this.qualifyingItems = qualifyingItems;
    }

    public int getDiscountableItems() {
        return discountableItems;
    }

    public void setDiscountableItems(int discountableItems) {
        this.discountableItems = discountableItems;
    }
}
