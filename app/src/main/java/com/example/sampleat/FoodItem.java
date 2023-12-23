package com.example.sampleat;

public class FoodItem {
    private String food;
    private int hour;
    private int minute;

    public FoodItem(String food, int hour, int minute) {
        this.food = food;
        this.hour = hour;
        this.minute = minute;
    }

    public String getFood() {
        return food;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getTimeString() {
        return String.format("%02d:%02d", hour, minute);
    }
}

