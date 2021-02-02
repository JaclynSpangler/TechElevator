package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

		System.out.println("What is the destination file?");
		String sourceFileName = userInput.nextLine();

		try (PrintWriter fizzWriter = new PrintWriter(sourceFileName)) {
			for(int i = 1; i <= 300; i++){
				String number = String.valueOf(i);
				if(i % 3 == 0 && i % 5 == 0){
					fizzWriter.println("FizzBuzz");
				}else if(i % 3 == 0 || number.contains("3")){
					fizzWriter.println("Fizz");
				}else if( i % 5 == 0 || number.contains("5")){
					fizzWriter.println("Buzz");
				}else{
					fizzWriter.println(number);
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("Invalid destination file.");
		}


	}
}