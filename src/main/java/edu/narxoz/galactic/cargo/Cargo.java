package edu.narxoz.galactic.cargo;
public class Cargo {
    private double weightKg;
    private String description;

    public Cargo(double weightKg, String description) {
        if(weightKg<=0) throw new IllegalArgumentExeption("Weight must be positive");
        this.weightKg = weightKg;
        this.description =description;
    }
    public double getWeightKg() {return weightKg;}
}