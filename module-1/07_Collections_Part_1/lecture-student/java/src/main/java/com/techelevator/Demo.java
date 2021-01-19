package com.techelevator;


import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        int num = 5; //put on stack

        Integer number = 5; //put on heap, reference type, if you didnt assign it a number it would be null

        String s = number.toString(); //s will be "5"

        num = number;
        number = 7; //created a new number reference and assigned it 7, it is not changed

        List<Integer> myList; //step 1: import class, step 2: <> input what type of list it will be is null
        myList = new ArrayList<Integer>();//empty array list that can hold integers, dont need to have <Integer> can be <>since it was already specified


        myList.add(5);
        myList.add(10);
        myList.add(2);
        myList.add(99);

        for (int i = 0; i < myList.size(); i++){ // if you need an index you need to use the for loop
            System.out.println(myList.get(i));
        }

        for(int value : myList){
            System.out.println(value);
        }





    }
}
