package com.techelevator;

import java.util.ArrayList;

public class Airplane {

    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;
    private int availableFirstClassSeats;
    private int availableCoachSeats;


    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableFirstClassSeats() {
        return getTotalFirstClassSeats() - getBookedFirstClassSeats();
    }

    public int getAvailableCoachSeats() {
        return getTotalCoachSeats() - getBookedCoachSeats();
    }

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        boolean isItBooked = false;

        if (forFirstClass && totalNumberOfSeats <= getAvailableFirstClassSeats()) {
            isItBooked = true;
            bookedFirstClassSeats = bookedFirstClassSeats + totalNumberOfSeats;
        }
        if (!forFirstClass && totalNumberOfSeats <= getAvailableCoachSeats()) {
            isItBooked = true;
            bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
        }
        return isItBooked;
    }
}






