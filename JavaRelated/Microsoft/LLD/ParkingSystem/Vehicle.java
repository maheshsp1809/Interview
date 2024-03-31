package Microsoft.LLD.ParkingSystem;

public class Vehicle {
    private String type;
    private String licensePlate;
    private long entryTime; // Entry time in milliseconds since epoch

    public Vehicle(String type, String licensePlate, long entryTime) {
        this.type = type;
        this.licensePlate = licensePlate;
        this.entryTime = entryTime;
    }
}
