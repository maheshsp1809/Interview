package LLD.ParkingSystem;

import java.util.HashMap;
import java.util.Map;

public class ParkingManagementSystem {
    private ParkingLot parkingLot;
    private Map<Integer, Vehicle> parkedVehicles;

    public ParkingManagementSystem(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.parkedVehicles = new HashMap<>();
    }

    public int parkVehicle(Vehicle vehicle) {
        if (parkingLot.checkAvailability()) {
            int slotNumber = parkingLot.parkVehicle();
            if (slotNumber != -1) {
                parkedVehicles.put(slotNumber, vehicle);
            }
            return slotNumber;
        }
        return -1; // Parking lot full
    }

    public boolean exitParking(int slotNumber) {
        if (parkedVehicles.containsKey(slotNumber)) {
            parkedVehicles.remove(slotNumber);
            return parkingLot.freeSlot(slotNumber);
        }
        return false; // Vehicle not found in specified slot
    }
}
