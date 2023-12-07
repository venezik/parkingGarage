package parkinGarage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParkingLot<T> { // a parking spot that can hold a generic type of item
    private int totalSpots;
    private ArrayList<ParkingSpot<T>> parkingSpots; // array list to store parking spots of generic type t in the parking lot

    public ParkingLot(int totalSpots) { //this is a constructor
        this.totalSpots = totalSpots;
        this.parkingSpots = new ArrayList<>(); // initialize the parking spots array list when creating a new ParkingLot instance

        for (int i = 1; i <= totalSpots; i++) {
            parkingSpots.add(new ParkingSpot<>(i)); // populate the parking lot with parking spots by creating instances of parkingSpot<T> and adding them to the list
        }
    }

    public List<ParkingSpot<T>> findAvailableSpots() {  // performed a linear search to find available parking spots in the parking lot O(n) time complexity
        List<ParkingSpot<T>> availableSpots = new ArrayList<>(); // list to store available parking spots
        for (ParkingSpot<T> spot : parkingSpots) { // iterate through each parking spot in the parking lot
            if (!spot.isOccupied()) { // check if the parking spot is not occupied
                availableSpots.add(spot); // if not occupied, add the spot to the list of available spots
            }
        }
        return availableSpots;
    }

    public void parkCar(T car) { // park a car in an available spot
        List<ParkingSpot<T>> availableSpots = findAvailableSpots();  // find available spots in the parking lot
        if (!availableSpots.isEmpty()) { // Conditional to check if there are available spots
            ParkingSpot<T> firstAvailableSpot = availableSpots.get(0); // get the first available spot
            firstAvailableSpot.occupySpot(car);   // occupy the spot with the item

            // print a message indicating the successful parking
            System.out.println(" ");
            System.out.println("Car with License Plate: " + car + " has been parked in spot " + firstAvailableSpot.getSpotNumber() + ".");
        }
        else {
            System.out.println("No available spots. Parking lot is full.");
        }
    }

    public void parkCar(T car, int spotNumber) { // Method to park a car in a specific spot example in main method
        if (spotNumber < 1 || spotNumber > totalSpots) {   // Conditional to check if the specified spot number is valid
            System.out.println("Invalid spot number. Please choose a spot within the valid range.");
            return;
        }

        ParkingSpot<T> targetSpot = parkingSpots.get(spotNumber - 1);  // get the target spot using the spot number (It's an arrayList, starting index = 0

        if (targetSpot.isOccupied()) {  // Conditional to check if the target spot is preoccupied
            System.out.println("\nSpot " + spotNumber + " is already occupied.");
        } else {
            targetSpot.occupySpot(car); // Park/occupy specific spot with the car
            System.out.println("Car with License Plate: " + car + " has been parked in spot " + spotNumber + "."); // Output
        }
    }

    public void vacateSpot(int spotNumber) { // method that we use to remove/vacate specified spot and charge the parking fee
        for (ParkingSpot<T> spot : parkingSpots) {   // iterate through each spot in the parking lot
            if (spot.getSpotNumber() == spotNumber && spot.isOccupied()) {    // conditional to check if the spot matches the specified spot number and is occupied
                spot.calculatePayment(); // calling the calculatePayment method which is simplified for a flat fee of $5 per parking period.
                System.out.println("Payment of $5 received for spot " + spotNumber + "."); // print a message indicating the received payment
                spot.vacateSpot();  // vacate the spot
                System.out.println("Spot " + spotNumber + " vacated.");  // Output a message indicating the vacated spot
               //System.out.println(spot.calculatePayment());
                return;
            }
        }

        System.out.println("Spot " + spotNumber + " is not occupied."); // if spot is not occupied, outputs this.
    }

    public void sortParkingSpotsBySpotNumber() { // sort parking spots by spot number
        parkingSpots.sort(new sortBySpotNumber());
    }

    public void sortParkingSpotsByOccupancy() { // sort parking spots by occupancy status
        parkingSpots.sort(new sortByOccupancy()); // use the sortByOccupancy comparator to sort the parking spots by occupancy status
    }
    
    public ArrayList<ParkingSpot<T>> getParkingSpots() { // gets the list of parking spots in the parking lot.
        return parkingSpots; // returns it
    }

    public void iterateOverSpots() {
        // create an iterator for the parking spots
        Iterator<ParkingSpot<T>> iterator = getParkingSpots().iterator();
        // iterate through each spot using the iterator
        while (iterator.hasNext()) {
            ParkingSpot<T> spot = iterator.next();
            // print information about each spot, including occupancy status
            System.out.println("Spot " + spot.getSpotNumber() +
                    (spot.isOccupied() ? " (Occupied - License Plate: " + spot.getParkedCar() + ")" : " (Available)"));
        }
    }
}

