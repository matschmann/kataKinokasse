package de.hundertneun.vo;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<Seat> seats = new ArrayList<>();
    
    private String name;

    public Room() {
    }

    public Room(String name, String seatsAsString) {
        assert name != null;
        assert seatsAsString != null;
        assert seatsAsString.length() > 0;
        
        this.name = name; 
        
        int seatCounter = 1; 
        String[] rows = seatsAsString.split("\n");
        for (int rowCounter = 0; rowCounter < rows.length; rowCounter++) {
            int length = rows[rowCounter].trim().length();
            for (int i = 0; i < length; i++) {
                seats.add(new Seat(seatCounter, rowCounter));
                seatCounter++;
            }
        }
    }

    public int getTotalNumberOfSeats() {
        return seats.size();
    }

    public Seat getByNumber(int seatNumber) {
        if (seatNumber <= 0 || seatNumber > seats.size()) {
            throw new IllegalArgumentException("Seat " + seatNumber + " does not exist. Largest seat number is " + seats.size());
        }
        
        return seats.get(seatNumber - 1);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
