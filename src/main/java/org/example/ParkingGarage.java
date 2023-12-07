package parkinGarage;

import java.util.Comparator;

class sortBySpotNumber implements Comparator<ParkingSpot<?>> {
    // comparator for sorting parking spots in ascending order
    public int compare(ParkingSpot<?> a, ParkingSpot<?> b) {
        return a.getSpotNumber() - b.getSpotNumber();
        // compare spot numbers of parking spots a and b
        // we get positive if a is greater negative if smaller and if equal we get 0
    }
}
class sortByOccupancy implements Comparator<ParkingSpot<?>> {
    // Comparator for sorting the parking spaces, the occupied come first.
    public int compare(ParkingSpot<?> a, ParkingSpot<?> b) {
        return Boolean.compare(b.isOccupied(), a.isOccupied());
        // we compare if a or b is occupied and then sort
        // if b is occupied and a isn't we get negative return
    }
}
public class ParkingGarage { // parking garage class that includes the main method calls parking lot class parking spot class
    public static void main(String[] args) {
        // string type generic class and passing in x-amount of parking spots
        ParkingLot<String> pLot = new ParkingLot<>(10);

        // display available spots before parking
        System.out.println("Available spots before parking:");
        pLot.iterateOverSpots();

        // parking cars in available spots

        pLot.parkCar("ABC123");
        pLot.parkCar("ABC1233545");
        pLot.parkCar("ABC2424123");

        // displaying available spots after parking
        System.out.println("\nAvailable spots after parking:");
        pLot.iterateOverSpots();

        // park another item in spot 3
        System.out.println("\nTrying to park another car in the occupied slot:");
        pLot.parkCar("XYZ9876", 3); // Parking another car at the occupied spot #3

        // vacating a spot
        System.out.println("\nVacating spot #2");
        pLot.vacateSpot(2);
        System.out.println("Park another car in the spot 4: ");
        System.out.print("\n");
        pLot.parkCar("OPQ8901", 4); // Parking another car at the spot #4

        // displaying spots after vacating
        System.out.println("\nParking spots after vacating spot 2:");
        pLot.iterateOverSpots();

        pLot.parkCar("ZXY123", 7);
        pLot.parkCar("ZXB4321",9);
        pLot.parkCar("SDA98543");

        // sort parking spots and display again
        // sort parking spots by spot number
        pLot.sortParkingSpotsBySpotNumber();
        System.out.println("\nParking spots after sorting by number: ");
        pLot.iterateOverSpots();

        // sort parking spots by occupancy
        pLot.sortParkingSpotsByOccupancy();
        System.out.println("\nParking spots after sorting:");
        pLot.iterateOverSpots();
        
        System.out.println("\nVacating spot #9");
        pLot.vacateSpot(9);
       
       
    }
}
