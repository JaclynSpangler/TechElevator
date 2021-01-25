package com.techelevator;

import java.math.BigDecimal;

public class BigDecimalDemo {

    public static void main(String[] args){

        double d1 = 0.1;
        double d2 = 0.2;
        System.out.println(d1 + d2);

        BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.2");
        BigDecimal b3 = b1.add(b2);// just calling ad doesnt change b1
        System.out.println(b3);
        System.out.println(b1);

        BigDecimal number = new BigDecimal("2.56");

        BigDecimal otherNumber = BigDecimal.ZERO;//both static methods so it doesnt need a "new"

        BigDecimal fromDouble = BigDecimal.valueOf(d1);//if you need to convert from an already existing double

        if(b3.compareTo(b2) > 0) {
            System.out.println("b3 is greater than b2");
        }
    }
}
