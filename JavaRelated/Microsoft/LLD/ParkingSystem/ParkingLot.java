package LLD.ParkingSystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int totalSlots;
    private int occupiedSlots;
    private List<Boolean> slots;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.occupiedSlots = 0;
        this.slots = new ArrayList<>(totalSlots);
        for (int i = 0; i < totalSlots; i++) {
            this.slots.add(false); // Initialize all slots as empty
        }
    }

    public boolean checkAvailability() {
        return occupiedSlots < totalSlots;
    }

    public int parkVehicle() {
        if (checkAvailability()) {
            for (int i = 0; i < totalSlots; i++) {
                if (!slots.get(i)) {
                    slots.set(i, true);
                    occupiedSlots++;
                    return i + 1; // Return slot number (1-based indexing)
                }
            }
        }
        return -1; // Parking lot full or no available slots
    }

    public boolean freeSlot(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= totalSlots && slots.get(slotNumber - 1)) {
            slots.set(slotNumber - 1, false);
            occupiedSlots--;
            return true; // Slot freed successfully
        }
        return false; // Invalid slot number or already empty
    }
}
