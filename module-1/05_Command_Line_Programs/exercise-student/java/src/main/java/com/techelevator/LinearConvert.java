package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		System.out.println("Welcome to the Measurement Converter!");

		//Prompt user to input a length
		System.out.print("Please enter a length: ");
		Scanner input = new Scanner(System.in);
		String length = input.nextLine();

		//prompt user to input whether measurement is meter or feet
		System.out.print("Is the measurement (m)eters or (f)eet: ");
		String typeOfMeasurement = input.nextLine();


		// Convert length to opposite measure
		double convertedLength = 0;
		int newLength = Integer.parseInt(length);
		int wholeNewLength = (int) newLength;
		if (typeOfMeasurement.contentEquals("m")) {
			convertedLength = (wholeNewLength * 3.2808399);
			int wholeConvertedLength = (int) Math.round(convertedLength);

			System.out.println( wholeNewLength + "m is " + wholeConvertedLength + "f.");
		} if (typeOfMeasurement.contentEquals("f")) {
			convertedLength = (newLength * 0.3048);
			int wholeConvertedLength = (int) Math.round(convertedLength);
			System.out.println(wholeNewLength + "f is " + wholeConvertedLength + "m.");
		}
		//Output old and new temp




		System.out.println("Thank you for participating in the Temperature Converter.");

	}

	}


