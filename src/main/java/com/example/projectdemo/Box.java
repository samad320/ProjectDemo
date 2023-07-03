package com.example.projectdemo;

public class Box {
    private int number;
    private boolean isSelected;

    public Box(int number) {
        this.number = number;
        this.isSelected = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
