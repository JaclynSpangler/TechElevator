package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class FlowerShopOrderTests {

    @Test
    public void flowerShopOrder_constructor_string_bigdecimal() {
        FlowerShopOrder sut = new FlowerShopOrder("flowers", BigDecimal.TEN);
        Assert.assertEquals("flowers", sut.getBouquetType());
        Assert.assertEquals(BigDecimal.TEN, sut.getNumberOfRoses());
    }

    @Test
    public void setSubtotal_returns_correct_price() {
        FlowerShopOrder sut = new FlowerShopOrder("flowers", new BigDecimal("7.00"));
        sut.getSubtotal();
        Assert.assertEquals(new BigDecimal("40.9200"), sut.getSubtotal());
    }

    @Test
    public void deliveryTotal_returns_the_correct_delivery_fee_when_zipcode_between_20000_29999() {
        FlowerShopOrder sut = new FlowerShopOrder("flower", BigDecimal.TEN);
        sut.deliveryTotal(true, "20000");

        Assert.assertEquals(new BigDecimal("9.98"), sut.deliveryTotal(true, "20000"));
    }

    @Test
    public void deliveryTotal_returns_the_correct_delivery_fee_when_zipcode_between_30000_39999() {
        FlowerShopOrder sut = new FlowerShopOrder("flower", BigDecimal.TEN);
        sut.deliveryTotal(true, "20000");

        Assert.assertEquals(new BigDecimal("12.98"), sut.deliveryTotal(true, "30000"));
    }

    @Test
    public void deliveryTotal_returns_the_correct_delivery_fee_when_zipcode_between_10000_19999() {
        FlowerShopOrder sut = new FlowerShopOrder("flower", BigDecimal.TEN);
        sut.deliveryTotal(true, "20000");

        Assert.assertEquals(new BigDecimal("0"), sut.deliveryTotal(true, "10000"));

    }

    @Test
    public void deliveryTotal_returns_the_correct_delivery_fee_when_zipcode_not_the_other_same_day_not_true() {
        FlowerShopOrder sut = new FlowerShopOrder("flower", BigDecimal.TEN);
        sut.deliveryTotal(true, "20000");

        Assert.assertEquals(new BigDecimal("19.99"), sut.deliveryTotal(false, "40000"));

    }
}
