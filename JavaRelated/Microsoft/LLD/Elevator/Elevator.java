package LLD.Elevator;

public class Elevator {
    private int elevatorId;
    private int currentFloor;
    private Direction direction;
    private boolean doorsOpen;
    private int currentWeight;
    private static final int MAX_WEIGHT = 100;

    public Elevator(int elavatorId) {
        this.elevatorId = elevatorId;
        this.currentFloor = 1;
        this.direction = Direction.STOPPED;
        this.doorsOpen = false;
        this.currentWeight = 0;

    }

    public void moveToFloor(int floor) {
        if (floor == currentFloor) {
            openDoors();
        } else {
            closeDoors();
            if (floor > currentFloor) {
                direction = Direction.UP;
            } else {
                direction = Direction.DOWN;
            }

            while (currentFloor != floor) {
                if (direction == Direction.UP) {
                    currentFloor++;
                } else {
                    currentFloor--;
                }
                System.out.println("Elevator" + elevatorId + "is at floor" + currentFloor);
            }
            openDoors();
        }
    }

    public boolean isBusy() {
        return direction != Direction.STOPPED || doorsOpen;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void addWeight(int weight) {
        currentWeight += weight;
        if (currentWeight > MAX_WEIGHT) {
            System.out.println("WARNING: Maximum limit excedded! Please Drop off");
        }
    }

    public void reemoveWeight(int weight) {
        currentWeight -= weight;

    }

    public void openDoors() {
        doorsOpen = true;
        System.out.println("Elevator" + elevatorId + "doors are open");
    }

    public void closeDoors() {
        doorsOpen = false;
        System.out.println("Elevator" + elevatorId + "doors are closed");
    }

    public enum Direction {
        UP,
        DOWN,
        STOPPED
    }

}
