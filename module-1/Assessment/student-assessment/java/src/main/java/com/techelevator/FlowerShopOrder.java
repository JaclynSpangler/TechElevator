package com.techelevator;

import java.math.BigDecimal;

public class FlowerShopOrder {

    private String bouquetType; //type of bouquet
    private BigDecimal numberOfRoses; // # of roses in bouquet
    private BigDecimal subtotal; //order subtotal before shipping is add
    private static final BigDecimal STANDARD_BOUQUET = new BigDecimal("19.99");
    private static final BigDecimal COST_PER_ROSE = new BigDecimal("2.99");

    public FlowerShopOrder(String bouquetType, BigDecimal numberOfRoses){
        this.bouquetType = bouquetType;
        this.numberOfRoses = numberOfRoses;
    }

    public String getBouquetType(){
        return bouquetType;
    }

    public void setBouquetType(String bouquetType){
        this.bouquetType = bouquetType;
    }
    public BigDecimal getNumberOfRoses(){
        return numberOfRoses;
    }

    public void setNumberOfRoses(BigDecimal numberOfRoses){
        this.numberOfRoses =numberOfRoses;
    }
    public BigDecimal getSubtotal(){
       return (STANDARD_BOUQUET.add(COST_PER_ROSE.multiply(numberOfRoses)));
    }
    public void setSubtotal(BigDecimal subtotal){
        this.subtotal = subtotal;
    }

    public BigDecimal deliveryTotal(boolean sameDayDelivery, String zipCode) {
        int zipCodeNumber = Integer.parseInt(zipCode);
        BigDecimal deliveryFee = new BigDecimal("0.00");
        BigDecimal sameDayFee = new BigDecimal("5.99");

        if (zipCodeNumber >= 20000 && zipCodeNumber <= 29999) {
            deliveryFee = new BigDecimal("3.99");
            if (sameDayDelivery = true) {
                deliveryFee = deliveryFee.add(sameDayFee);
            }
        } else if (zipCodeNumber >= 30000 && zipCodeNumber <= 39999) {
            deliveryFee = new BigDecimal("6.99");
            if (sameDayDelivery = true) {
                deliveryFee = deliveryFee.add(sameDayFee);
            }
        }
        if (zipCodeNumber >= 10000 && zipCodeNumber <= 19999) {
            deliveryFee = BigDecimal.ZERO;
        }{
            deliveryFee = new BigDecimal("19.99");
        }
            return deliveryFee;
    }

    @Override
    public String toString() {
        return "ORDER - " + getBouquetType() + " - " + getNumberOfRoses() + " roses - " + getSubtotal();
    }
}
