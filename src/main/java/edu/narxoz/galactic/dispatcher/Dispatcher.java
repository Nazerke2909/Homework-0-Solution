package edu.narxoz.galactic.dispatcher;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.DroneStatus;
import edu.narxoz.galactic.task.DeliveryTask;
import edu.narxoz.galactic.task.TaskState;

public class Dispathcer {
    public Result assignTask(DeliveryTask task, Drone drone) {
        if (task==null || drone==null) {
            return new Result(false, "Task or Drone is null");
        }
        if (drone.getStatus() != DroneStatus.IDLE) {
            return new Result(false, "Drone is busy");
        }
        if (task.getCargo().getWeightKg() > drone.getMaxPayLoadKg()) {
            return new Result(false, "Cargo is too heavy!");
        }
        if (task.getState() != TaskState.CREATED) {
            return new Result(false, "Task is alredy processed!")
        }
        task.setAssignedDrone(drone);
        task.setState(TaskState.ASSIGNED);
        return new Result(true, null);
    }
    public Result completeTask(DeliveryTask task) {
        if(task==null) return new Result(false, "Task is null"); 
        if(task.getState() != TaskState.ASSIGNED || task.getAssignedDrone() == null) {
            return new Result(false, "Task is not in progress");
        }
        task.setState(TaskState.DONE);
        return new Result(true, null);
    }
}