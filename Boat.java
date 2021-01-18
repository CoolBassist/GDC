package com.company;

public class Boat {
    private static int curNoOfBoats = 1;
    private int id;
    private String owner;
    private boolean isOut;

    public Boat(String owner) {
        id = curNoOfBoats;
        ++curNoOfBoats;
        this.owner = owner;
        isOut = false;
    }

    public boolean isOut(){
        return isOut;
    }

    public String getOwner(){
        return owner;
    }

    public int getID(){
        return id;
    }

    public void changeStatus(){
        isOut = !isOut;
    }

    public String getDetails(){
        String s = "";
        s += "ID:\t\t" + String.valueOf(id) + "\n";
        s += "Owner:\t" + owner + "\n";
        s += "Status:\t" + (isOut ? "Out to Sea" : "In harbour");
        return s;
    }
}
