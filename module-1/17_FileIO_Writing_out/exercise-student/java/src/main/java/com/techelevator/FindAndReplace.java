package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();
        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();
        System.out.println("What is the source file?");
        String sourceFileName = userInput.nextLine();
        System.out.println("What is the destination file?");
        String destFileName = userInput.nextLine();

        Path source = Path.of(sourceFileName);

        try(Scanner sourceScanner = new Scanner(source)){
            try(PrintWriter destWriter = new PrintWriter(destFileName)){

                while(sourceScanner.hasNextLine()){
                    String line = sourceScanner.nextLine();
                    if(line.contains(searchWord)){
                        String replace = line.replaceAll(searchWord, replacementWord);
                        destWriter.println(replace);
                    }else{
                        destWriter.println(line);
                    }
                }
            } catch(FileNotFoundException e){
                System.out.println("Output file couldn't be written to.");
            }

        } catch (IOException e) {
            System.out.print("Couldn't read from input file");
        }


    }

}
