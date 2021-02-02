package com.techelevator.readfiles;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class CountFileWords {

    public static void main(String[] args) {
        Path path = Path.of("alice.txt");
        WordCounter wc = new WordCounter();

        int sum = 0;
        try (Scanner filesScanner = new Scanner(path)) {
            while (filesScanner.hasNextLine()) {
                String line = filesScanner.nextLine();
                int count = wc.countWordsInLine(line);
                sum += count;
            }
        } catch (IOException e) {
            System.out.println("couldn't find file.");
        }

        System.out.println("Total words: " + sum);
    }
}
