package com.triggerise.test.checkout;

import com.triggerise.checkout.Checkout;
import com.triggerise.checkout.offers.PriceBasedOffer;
import com.triggerise.checkout.offers.ProductBasedOffer;
import com.triggerise.checkout.pricingrules.impl.PricingRuleImpl;
import com.triggerise.checkout.services.ProductService;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckoutAppTest {

    private Checkout checkout;

    @Before
    public void setUp() {
        List<PricingRuleImpl> pricingRuleList = new ArrayList<>();
        pricingRuleList.add(new PricingRuleImpl(ProductService.getProduct("Mug"), new ProductBasedOffer(1, 1)));
        pricingRuleList.add(new PricingRuleImpl(ProductService.getProduct("Tshirt"), new PriceBasedOffer(30, 3)));
        checkout = new Checkout(pricingRuleList);
    }

    @Test
    public void checkoutSingleTshirtTest() {
        BigDecimal total = checkout.scan("Tshirt").total;
        BigDecimal expectedValue = new BigDecimal(21.00);
        assertEquals(expectedValue.setScale(2, RoundingMode.CEILING), total);
    }

    @Test
    public void checkoutSingleMugTest() {
        BigDecimal total = checkout.scan("Mug").total;
        BigDecimal expectedValue = new BigDecimal(4.00);
        assertEquals(expectedValue.setScale(2, RoundingMode.CEILING), total);
    }

    @Test
    public void checkoutMultipleMugsTest() {
        BigDecimal total = checkout.scan("Mug").scan("Mug").scan("Mug").scan("Mug").scan("Mug").scan("Mug").scan("Mug").scan("Mug").total;
        BigDecimal expectedValue = new BigDecimal(16.00);
        assertEquals(expectedValue.setScale(2, RoundingMode.CEILING), total);
    }

    @Test
    public void checkoutSingleUSBKeyTest() {
        BigDecimal total = checkout.scan("USBKey").total;
        BigDecimal expectedValue = new BigDecimal(10.00);
        assertEquals(expectedValue.setScale(2, RoundingMode.CEILING), total);
    }

    @Test
    public void checkoutTshirtTshirtTshirtMugTshirtTest() {

        BigDecimal total = checkout.scan("Tshirt").scan("Tshirt").scan("Tshirt").scan("Mug").scan("Tshirt").total;
        BigDecimal expectedValue = new BigDecimal(62.80);
        assertEquals(expectedValue.setScale(2, RoundingMode.CEILING), total);
    }

    @Test
    public void checkoutMugTshirtUSBKeyTest() {
        BigDecimal total = checkout.scan("Mug").scan("Tshirt").scan("USBKey").total;
        BigDecimal expectedValue = new BigDecimal(35.00);
        assertEquals(expectedValue.setScale(2), total);
    }

    @Test
    public void checkoutMugTshirtMugTest() {
        BigDecimal total = checkout.scan("Mug").scan("Tshirt").scan("Mug").total;
        BigDecimal expectedValue = new BigDecimal(25.00);
        assertEquals(expectedValue.setScale(2), total);
    }

    @Test
    public void checkoutMugTshirtMugMugUSBKeyTshirtTshirtTest() {

        BigDecimal total = checkout.scan("Mug").scan("Tshirt").scan("Mug").scan("Mug").scan("USBKey").scan("Tshirt").scan("Tshirt").total;
        BigDecimal expectedValue = new BigDecimal(62.10);
        assertEquals(expectedValue.setScale(2, RoundingMode.FLOOR), total);
    }
}
