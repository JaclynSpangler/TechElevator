package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		System.out.println("Welcome to the Binary Calculator!");

		//Prompts user for a series of decimal integers separated by spaces.
		System.out.print("Please enter in a series of decimal integers (separated by spaces): ");
		Scanner input = new Scanner(System.in);
		String decimalIntegers = input.nextLine();
		String[] integerArray = decimalIntegers.split(" ");

		//convert decimal integers to binary
		for (int i = 0; i < integerArray.length; i++) {
			Integer binary = Integer.parseInt(integerArray[i]);


			//print out decimal integers turned into binary " " in binary is " "
			System.out.println(integerArray[i] + " in Binary is " + Integer.toBinaryString(binary));
		}
	}

	}
