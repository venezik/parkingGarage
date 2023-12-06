package org.example;

public class ParkingSpot<T> { // class to represent parking space. <T> abstract Type to represent a car that is being parked.
    private final int spotNumber; // variable to represent a parking spot
    private boolean occupied; // boolean to represent if spot is available or not
    private T parkedCar; // represents a car to be parked in the space
    private double balance = 0.0;
    private int hours;

    public ParkingSpot(int spotNumber) { // a constructor to initialize parking space with a number
        this.spotNumber = spotNumber;
        this.occupied = false; // spot is available at first
        this.parkedCar = null; // car is not parked.
    }

    public int getSpotNumber() { // getter for the spot number
        return spotNumber;
    }

    public boolean isOccupied() { // conditional method to check the availability
        return occupied; // returns boolean
    }

    public T getParkedCar() {  // getter method to get the parked car
        return parkedCar; // return the car or null if empty
    }

    public void occupySpot(T car, int hours) { // method that occupies the spot with specific car ( setter )
        this.occupied = true; // changes the spot to the occupied status
        this.parkedCar = car; // parks specific car.
        this.hours = hours;
    }

    public int getHours(){
        return hours;
    }

    public void vacateSpot() { // method to vacate a spot, makes it available for parking for others
        if (occupied) {
            this.occupied = false; // changes the spot to the unoccupied status
            this.parkedCar = null; // removes the parked car
            System.out.println("Your balance is: $" + balance);
        }
    }

    public void calculatePayment(double payment) { // calculates the payment, charges the flat price of $5.0 and applies it to the balance.
        // for the real life development would have to be further modified.
        if (occupied) {
            balance += payment;
            System.out.println("Your balance is: $" + balance);
        }
    }
}

