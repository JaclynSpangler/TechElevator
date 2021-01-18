package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println("Welcome to this very useful Fibonacci Sequence Finder!");

		//Prompt user for inter value
		System.out.print("Enter a whole integer value: ");
		Scanner input = new Scanner(System.in);
		String userNumber = input.nextLine();


		// calculate fibonacci sequence leading to that number int i = 0;
		int wholeUserNumber = Integer.parseInt(userNumber);
		int[] fibonacciArray = new int[wholeUserNumber + 2];
		fibonacciArray[0] = 0;
		fibonacciArray[1] = 1;
		if (wholeUserNumber == 0) {
			System.out.print("O");
		}
		else {
			System.out.print("0, 1, ");
		}
		int i =2;
		while(fibonacciArray[i - 1] + fibonacciArray[i - 2] <= wholeUserNumber) {
			if (wholeUserNumber >= 2) {
				fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
				System.out.print(fibonacciArray[i] + ", ");
			}
			i++;
		}
	}
}




