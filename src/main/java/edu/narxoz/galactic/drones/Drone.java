package edu.narxoz.galactic.drones;
public abstract class Drone {
    private Srting id;
    private DroneStatus status;
    private double maxPayLoadKg;

    protected Drone(String id, double maxPayLoadKg) {
        if(maxPayLoadKg <= 0) throw new IllegalArgumentExeption("Payload must be positive");
        this.id = id;
        this.maxPayLoadKg =maxPayLoadKg;
        this.status = DroneStatus.IDLE;
    }
    public String getId() {return id;}
    public DroneStatus getStatus() {return status;}
    public double getMaxPayLoadKg() {return maxPayLoadKg;}

    protected void setStatus(DroneStatus status){this.status = status; }
}