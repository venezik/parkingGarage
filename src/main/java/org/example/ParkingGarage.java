package org.example;
import java.util.ArrayList;


class Car {
    private String licensePlate;
    private String brand;

    public Car(String licensePlate, String brand) {
        this.licensePlate = licensePlate;
        this.brand = brand;
    }

    // write getLicencePlate(){}

    // write getBrand(){}

}

class ParkingSpace<T> {
    private Node<T> head;

    public void parkCar(T car) {
        Node<T> newNode = new Node<>(car);
        newNode.next = head;
        head = newNode;
    }

    public void removeCar(T car) {
        Node<T> current = head;
        Node<T> prev = null;

        while (current != null && !current.data.equals(car)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev == null) {
                head = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }

    // public void sort() {}





    public void printSpaces() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}

class ParkingLot {
    private ParkingSpace<Car> parkingSpaces;

    public ParkingLot() {
        parkingSpaces = new ParkingSpace<>();
    }

    public void parkCar(Car car) {
        parkingSpaces.parkCar(car);
    }

    public void removeCar(Car car) {
        parkingSpaces.removeCar(car);
    }

    public void analyzeIncomingCars() {
        // Simulate the process of analyzing incoming cars
    }

    public void printParkingSpaces() {
        System.out.println("Self Parking Spaces:");
        parkingSpaces.printSpaces();
    }
}

public class ParkingGarage {
    public static void main(String[] args) {
        // Car car1 = new Car("ABC123", "BMW");


        // ParkingLot parkingLot = new ParkingLot();

        //parkingLot.parkCar(car1);


        // Simulate sorting self-parking spaces based on license plate
        // parkingLot.analyzeIncomingCars(); // Implement your analysis logic here

        //parkingLot.parkingSpaces.sort();

        // System.out.println("\nSorted Parking Spaces:");
        // parkingLot.printParkingSpaces();
    }
}

