package org.example.Hero;

public class meleeStrategy implements DragonSlayingStrategy {
    @Override
    public String execute() {
        return "With your Excalibur you damage the dragon with a severe wound!";
    }

    @Override
    public int strategyPower() {
        return 5;
    }
}
