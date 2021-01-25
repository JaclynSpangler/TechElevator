package com.techelevator;

public class Television {

    private boolean on;
    private int currentChannel;
    private int currentVolume;

    public boolean isOn() {
        return on;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public Television() {
        on = false;
        currentChannel = 3;
        currentVolume = 2;
    }

    public void turnOff() {
        on = false;
    }

    public void turnOn() {
        on = true;
    }

    public void changeChannel(int newChannel) {
        if (on && (newChannel >= 3) && (newChannel <= 18)) {
            currentChannel = newChannel;
        }
    }

        public void channelUp() {
            if (currentChannel >= 3 && currentChannel <= 17 && on) {
                currentChannel = currentChannel + 1;
            } else if (on) {
                currentChannel = 3;
            }
        }

    public void channelDown() {
        if (on) {
            if (currentChannel == 3) {
                currentChannel = 18;
            }
            if (currentChannel > 3 && currentChannel < 18) {
                currentChannel--;
            }
            }
        }

    public void raiseVolume() {
            if(on && currentVolume<= 10) {
                currentVolume++;
            }
    }

    public void lowerVolume() {
            if (on && currentVolume > 0) {
                currentVolume--;
            }
        }


}
