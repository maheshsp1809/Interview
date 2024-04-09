package LLD.Elevator;

import java.util.*;

public class ElevatorSystem {
    private List<Elevator> elevators;

    public ElevatorSystem(int numElevators) {
        elevators = new ArrayList<>();
        for (int i = 1; i <= numElevators; ++i) {
            elevators.add(new Elevator(i));
        }
    }

    public void requestElevator(int floor) {
        Elevator closesElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            if (!elevator.isBusy()) {
                int distance = Math.abs(elevator.getCurrentFloor() - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    closesElevator = elevator;
                }
            }
        }
        if (closesElevator != null) {
            closesElevator.moveToFloor(floor);
        }
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public void selectFloor(int elevatorId, int floor) {
        for (Elevator elevator : elevators) {
            if (elevator.getElevatorId() == elevatorId) {
                elevator.moveToFloor(floor);
                break;
            }
        }
    }
}
