package com.company;

public class Main {

    public static void main(String[] args) {
        Boats boat = new Boats();

        boat.addBoat("Boss Man");
        boat.addBoat("Big Chief");

        boat.viewBoatRecords();
        boat.setBoatOut(1);
        boat.setBoatOut(2);
        boat.setBoatOut(2);
        boat.setBoatIn(2);
        System.out.println(boat.viewBoatRecords());
    }
}
