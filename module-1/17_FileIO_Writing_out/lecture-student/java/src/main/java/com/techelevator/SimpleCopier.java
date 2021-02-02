package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

public class SimpleCopier {

    public static void main(String[] args) {
        //prompt for source file

        //one scanner for interacting with user and one for

        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter a filename to a copy: ");
        String sourceFileName = userInput.nextLine();


        System.out.print("Please enter a new name to copy to: ");
        String destFileName = userInput.nextLine();

        Path source = Path.of(sourceFileName);
        //Scanner that reads through
        try (Scanner sourceScanner = new Scanner(source)){//outer try checking scanner
            try(PrintWriter destWriter = new PrintWriter(destFileName)){//inner try checking printwriter

                while(sourceScanner.hasNextLine()) {//hasNextLine makes sure another line exists
                    String line = sourceScanner.nextLine();//this just reads the line from the source
                    //any changes to the line would go in here
                    destWriter.println(line);//print/write a line
                }

            } catch (FileNotFoundException e){
                System.out.println("Output file couldn't be written to.");
            }

        } catch (IOException e) {
            System.out.println("Couldn't read from input file.");
        }

    }
}
