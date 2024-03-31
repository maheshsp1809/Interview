package Microsoft.LLD.ParkingSystem;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10); // Creating a parking lot with 10 slots
        ParkingManagementSystem parkingSystem = new ParkingManagementSystem(parkingLot);

        // Creating vehicles
        Vehicle car1 = new Vehicle("Car", "ABC123", System.currentTimeMillis());
        Vehicle motorcycle1 = new Vehicle("Motorcycle", "XYZ456", System.currentTimeMillis());

        // Parking vehicles
        int carSlot = parkingSystem.parkVehicle(car1);
        int motorcycleSlot = parkingSystem.parkVehicle(motorcycle1);

        if (carSlot != -1) {
            System.out.println("Car parked at slot: " + carSlot);
        } else {
            System.out.println("Parking lot full. Unable to park car.");
        }

        if (motorcycleSlot != -1) {
            System.out.println("Motorcycle parked at slot: " + motorcycleSlot);
        } else {
            System.out.println("Parking lot full. Unable to park motorcycle.");
        }

        // Exiting parking
        boolean carExit = parkingSystem.exitParking(carSlot);
        boolean motorcycleExit = parkingSystem.exitParking(motorcycleSlot);

        if (carExit) {
            System.out.println("Car exited from parking.");
        } else {
            System.out.println("Error: Car not found in parking slot " + carSlot);
        }

        if (motorcycleExit) {
            System.out.println("Motorcycle exited from parking.");
        } else {
            System.out.println("Error: Motorcycle not found in parking slot " + motorcycleSlot);
        }
    }
}
