package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.DeliveryTask;
public class Main {
    public static void main(String[] args) {
        System.out.println("Galactic Drone Delivery System");
        Planet earth = new Planet("Earth", 0, 0, "Nitrogen-Oxygen");
        SpaceStation iss = new SpaceStation("ISS", 100, 100, 1);
        Cargo bigCargo = new Cargo(50.0, "Building materials");
        DeliveryTask task = new DeliveryTask(earth, iss, bigCargo);
        Drone light = new LightDrone("L1", 10.0);  
        Drone heavy = new HeavyDrone("H1", 100.0); 
        
        Dispatcher dispatcher = new Dispatcher();
        Result res1 = dispatcher.assignTask(task, light);
        System.out.println("1. Assigning 50kg to LightDrone: " + (res1.ok() ? "SUCCESS" : "FAILED"));
        System.out.println("   Reason: " + res1.reason());
        Result res2 = dispatcher.assignTask(task, heavy);
        System.out.println("2. Assigning 50kg to HeavyDrone: " + (res2.ok() ? "SUCCESS" : "FAILED"));
        
        if (res2.ok()) {
            System.out.println("3. Estimated Delivery Time: " + task.estimateTime() + " minutes");
            
            Result res3 = dispatcher.completeTask(task);
            System.out.println("4. Task Completion: " + (res3.ok() ? "SUCCESS" : "FAILED"));
            
            System.out.println("Final Statuses");
            System.out.println("Drone Status: " + heavy.getStatus()); 
            System.out.println("Task State: " + task.getState());  
        }
    }
}