package de.hundertneun.vo;

public class Seat {
    
    private int seatNumber;
    private int row;
    private boolean isTaken;

    public Seat() {
    }

    public Seat(int seatNumber, int row) {
        this.seatNumber = seatNumber;
        this.row = row;
    }
    
    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }


    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getRow() {
        return row;
    }
}
