package com.techelevator;

import java.util.Scanner;

public class ExceptionExample {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean finished = false;
        while(!finished) {
            System.out.print("Please enter your first name: ");
            String firstName = input.nextLine();
            System.out.print("Please enter your last name: ");
            String lastName = input.nextLine();

            NameFormatter nameFormatter = new NameFormatter();
            //A

            try {
                //B
                String formattedName = nameFormatter.formatName(firstName, lastName);
                //C
                System.out.println("Your properly formatted name is: " + formattedName);
                finished = true;//now while loop will end
            } catch (NameFormatException e) {
                //D
                System.out.println(e.getMessage());
            }
        }
        //E
        System.out.println("Thank you for using this program.");
    }
}
