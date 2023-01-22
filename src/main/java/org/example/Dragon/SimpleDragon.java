package org.example.Dragon;

public class SimpleDragon implements Dragon {
    @Override
    public String attack() {
        return "The dragon noticed you";
    }

    @Override
    public int getAttackpower() {
        return 15;
    }

    @Override
    public void flyAway() {
        System.out.println("The dragon got scared and he's flying away");
    }
}
