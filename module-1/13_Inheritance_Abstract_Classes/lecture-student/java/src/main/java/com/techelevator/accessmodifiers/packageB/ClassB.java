package com.techelevator.accessmodifiers.packageB;


import com.techelevator.accessmodifiers.packageA.ClassA;

public class ClassB extends ClassA {

   public boolean methodB() {
       methodA();
       return true;
   }
}
