package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSplitter {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
//ask user for input
        System.out.println("Where is the input file?");
        String sourceFile = userInput.nextLine();
        System.out.println("How many lines of text (max) should there be in the split files?");
        String lineAmounts = userInput.nextLine();
        int userLineAmount = Integer.parseInt(lineAmounts);
//print out how many lines are in the text
        int count = 0;
        List<String> linesFromInput = new ArrayList<>();

        Path source = Path.of(sourceFile);
        try (Scanner sourceScanner = new Scanner(source)) {
            while (sourceScanner.hasNextLine()) {
                linesFromInput.add(sourceScanner.nextLine());
                count++;
            }
        } catch (IOException e) {
            System.out.println("This did not work :/");
        }
        int totalNumberOfLines = linesFromInput.size();
        System.out.println("The input file has " + totalNumberOfLines + " lines of text.");

        //print out how many lines of input.txt this produces "i" files
        int numberFiles = totalNumberOfLines % userLineAmount == 0 ? totalNumberOfLines / userLineAmount : ((totalNumberOfLines / userLineAmount) + 1);

        System.out.println("For a " + totalNumberOfLines + " line input file \"" + sourceFile + "\", this produces " + numberFiles + " output files.");


        //split the sourcefilestring to inlcie the

        String[] fileNameParts = sourceFile.split("\\.");

        //create split output files with max number of lines each

        for (int i = 1; i <= numberFiles; i++) {
            String sourceFileName = fileNameParts[0] + "-" + i + "." + fileNameParts[1];
            try (PrintWriter newFiles = new PrintWriter(sourceFileName)) {
                System.out.println("Generating " + sourceFileName);
                try {
                    for (int xMen = 0; xMen < userLineAmount; xMen++) {
                        newFiles.println(linesFromInput.remove(0));
                    }
                } catch (IndexOutOfBoundsException e) {
                    break;
                }


            } catch (FileNotFoundException e) {
                System.out.println("file not found yoh");
            }

        }
        System.out.println("Thanks for using the file splitter :)");

    }
}


