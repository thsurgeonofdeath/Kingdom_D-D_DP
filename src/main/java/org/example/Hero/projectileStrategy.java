package org.example.Hero;

public class projectileStrategy implements DragonSlayingStrategy {
    @Override
    public String execute() {
        return "You shoot the dragon with the magical crossbow and it screams a roar from the damage!" ;
    }

    @Override
    public int strategyPower() {
        return 10;
    }
}
