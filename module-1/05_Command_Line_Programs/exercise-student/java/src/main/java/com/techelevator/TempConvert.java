package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		System.out.println("Welcome to the Temperature Converter!");

		//Prompt user to input a temperature
		System.out.print("Please enter the temperature: ");
		Scanner input = new Scanner(System.in);
		String temperature = input.nextLine();

		//prompt user to input whether temperature is Celcius or Fahrenheit
		System.out.print("Is the temperature in (C)elsius or (F)ahrenheit: ");
		String typeOfTemperature = input.nextLine();


		// Convert temperature to opposite measure
		double convertedTemperature = 0;
		int newTemperature = Integer.parseInt(temperature);
		int wholeNewTemp = (int) newTemperature;
		if (typeOfTemperature.contentEquals("C")) {
			convertedTemperature = (newTemperature * 1.8) + 32;
			int wholeConvertedTemp = (int) Math.round(convertedTemperature);

			System.out.println( wholeNewTemp + "C is " + wholeConvertedTemp + "F");
		} if (typeOfTemperature.contentEquals("F")) {
			convertedTemperature = (newTemperature - 32) / 1.8;
			int wholeConvertedTemp = (int) Math.round(convertedTemperature);
			System.out.println(wholeNewTemp + "F is " + wholeConvertedTemp + "C");
		}
		//Output old and new temp




		System.out.println("Thank you for participating in the Temperature Converter.");

	}

}
