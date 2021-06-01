package com.triggerise.checkout.offers;

public class PriceBasedOffer implements Offer {
    double discountPercentage;
    int minimumQuantity;

    public PriceBasedOffer(double discountPercentage, int minimumQuantity) {
        this.discountPercentage = discountPercentage;
        this.minimumQuantity = minimumQuantity;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }
}
