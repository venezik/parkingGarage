package parkinGarage;

public class ParkingSpot<T> { // class to represent parking space. <T> abstract Type to represent a car that is being parked.
    private final int spotNumber; // variable to represent a parking spot
    private boolean occupied; // boolean to represent if spot is available or not
    private T parkedCar; // represents a car to be parked in the space
    private double balance;

    public ParkingSpot(int spotNumber) { // a constructor to initialize parking space with a number
        this.spotNumber = spotNumber;
        this.occupied = false; // spot is available at first
        this.parkedCar = null; // car is not parked.
        this.balance = 0.0;  // Initialize balance to 0.0
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

    public void occupySpot(T car) { // method that occupies the spot with specific car ( setter )
        this.occupied = true; // changes the spot to the occupied status
        this.parkedCar = car; // parks specific car.
    }

    public void vacateSpot() { // method to vacate a spot, makes it available for parking for others
        this.occupied = false; // changes the spot to the unoccupied status
        this.parkedCar = null; // removes the parked car
    }

    public double calculatePayment() {
        // check if the spot is occupied and the balance is not yet updated for this parking period
        if (occupied) {
            // assume a flat fee of $5.0 for simplicity
            balance += 5.0;
            System.out.println("Your balance is now: $" + balance); // prints it out
            return balance; // return the updated balance
        }
        return balance; // return balance if no payment is made
    }
}

