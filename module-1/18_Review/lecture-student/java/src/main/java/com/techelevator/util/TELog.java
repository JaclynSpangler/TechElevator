package com.techelevator.util;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TELog {
    public static void log(String message) {
        try (FileOutputStream stream = new FileOutputStream("logs/search.log", true);
             PrintWriter writer = new PrintWriter(stream)){//appending to file (Adding)
//want to add date and time to our log file
            LocalDateTime timeStamp = LocalDateTime.now();
            //if you dont want default style, date time formatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/y hh:mm");
            writer.println(timeStamp.format(formatter) + " : " + message);

        } catch (Exception e) {
            throw new TELogException(e.getMessage());
        }
    }

}