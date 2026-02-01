package edu.narxoz.galactic.task;
import edu.narxoz.galactic.bodies.CelestialBody;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;

public class DeliveryTask {
    private CelestialBody origin;
    private CelestialBody destination;
    private Cargo cargo;
    private TaskState state;
    private Drone assignedDrone;

    public DeliveryTask(CelestialBody origin, CelestialBody destination, Cargo cargo) {
        this.origin = origin;
        this.destination = destination;
        this.cargo = cargo;
        this.state = TaskState.CREATED;
    }
    public double estimateTime() {
        if(assignedDrone==null) throw new IllegalStateException("No drone assigned");
        return origin.distanceTo(destination) / assignedDrone.speedKmPerMin();
    }
    public TaskState getState() {return state;}
    public Cargo getCargo() {return cargo;}
    public Drone getAssignedDrone() {return assignedDrone;}

    public void setState(TaskState state) {this.state = state;}
    public void setAssignedDrone(Drone drone) {this.assignedDrone = drone;}
}