package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.DeliveryTask;

public class Main {
    public static void main(String[] args) {
        Planet earth = new Planet("Earth", 0, 0, "Nitrogen-Oxygen");
        SpaceStation iss = new SpaceStation("ISS", 100, 100, 1);

        Drone light = new LightDrone("L1", 10.0);
        Drone heavy = new HeavyDrone("H1", 100.0);
        Cargo bifCargo = new Cargo(50.0, "Building materials");

        Dispatcher dispatcher = new Dispatcher();
        DeliveryTask task = new DeliveryTask(earth, iss, bifCargo);

        Result r1= dispatcher.assigntask(task, light);
        System.out.println("Light Drone Assignmed: " + res1.ok());

        Result res2 = dispatcher.assignTask(task, heavy);
        System.out.println("Heavy Drone Assignment: " + res2.ok());

        if (res2.ok()) {
            System.out.println("Estimated Time: " + task.estimateTime()); [cite: 206]
            dispatcher.completeTask(task); // Завершаем [cite: 205]
            System.out.println("Final Task State: " + task.getState()); [cite: 206]
        }
    }
}