package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

//TODO
//Save the list of boats to a file, and read at program start. 
//Be able to remove boats at an arbitary index.

public class Boats {
    private ArrayList<Boat> listOfBoats = new ArrayList<Boat>();

    public void addBoat(String owner){
        listOfBoats.add(new Boat(owner));
    }

    public String getBoatsCurrentlyOut(){
        String s = "";

        for(Boat b: listOfBoats)
            if(b.isOut())
                s += b.getID() + ", ";

        return s;
    }

    public String getBoatDetails(){
        String s = "";

        for(Boat b: listOfBoats)
            s += b.getDetails() + "\n\n";

        return s;
    }

    public void setBoatIn(int id){
        Boat b = null;

        for(Boat b_: listOfBoats) {
            if (b_.getID() == id) {
                b = b_;
                break;
            }
        }

        if(b == null){
            System.out.println("A boat with that idea has not been found.");
            return;
        }else if(!b.isOut()){
            System.out.println("Boat " + String.valueOf(b.getID()) + " is already in the harbour.");
        }

        b.changeStatus();

        File f = findFile();

        try {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm");
            Date date = new Date(System.currentTimeMillis());

            FileWriter wr = new FileWriter(f.getName(), true);
            wr.write(String.valueOf(formatter.format(date)) + " " + b.getID() + " went in.\n");
            wr.close();
        } catch (IOException e) {
            System.out.println("An error occurred. Please contact Gaston.");
            e.printStackTrace();
        }
    }

    public void setBoatOut(int id){
        Boat b = null;

        for(Boat b_: listOfBoats) {
            if (b_.getID() == id) {
                b = b_;
                break;
            }
        }

        if(b == null){
            System.out.println("A boat with that id has not been found.");
            return;
        }else if(b.isOut()){
            System.out.println("Boat " + String.valueOf(b.getID()) + " is already out at sea.");
            return;
        }

        b.changeStatus();

        File f = findFile();

        try {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm");
            Date date = new Date(System.currentTimeMillis());

            FileWriter wr = new FileWriter(f.getName(), true);
            wr.write(String.valueOf(formatter.format(date)) + " " + b.getID() + " went out.\n");
            wr.close();
        } catch (IOException e) {
            System.out.println("An error occurred. Please contact Gaston.");
            e.printStackTrace();
        }
    }

    private File findFile(){
        File f = new File("boat_records.txt");
        try {
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred. Please contact Gaston.");
            e.printStackTrace();
        }

        return f;
    }

    public String viewBoatRecords(){
        String s = "";
        File f = findFile();

        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String data = sc.nextLine() + "\n";
                s += data;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Please contact Gaston.");
            e.printStackTrace();
        }

        return s;
    }
}
