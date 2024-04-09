package LLD.Elevator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an elevator system with 1 elevator
        ElevatorSystem elevatorSystem = new ElevatorSystem(1);

        // Request an elevator to floor 5
        elevatorSystem.requestElevator(5);

        // Simulate adding weight to the elevator
        List<Elevator> elevators = elevatorSystem.getElevators();
        if (!elevators.isEmpty()) {
            Elevator elevator = elevators.get(0); // Assuming only 1 elevator in the system
            elevator.addWeight(80); // Add 80 units of weight (within limit)
            elevator.addWeight(30); // Add 30 units of weight (exceeds limit, triggers alarm)

            // Select floor 10 for the elevator
            elevatorSystem.selectFloor(elevator.getElevatorId(), 10);
        } else {
            System.out.println("No elevators in the system.");
        }
    }
}
