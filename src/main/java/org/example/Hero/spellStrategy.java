package org.example.Hero;

public class spellStrategy implements DragonSlayingStrategy {
    @Override
    public String execute() {
        return "You cast the spell of disintegration to the Dragon, it seems like it's working!" ;
    }

    @Override
    public int strategyPower() {
        return 15;
    }
}
