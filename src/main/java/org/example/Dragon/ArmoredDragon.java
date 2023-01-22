package org.example.Dragon;

public class ArmoredDragon implements Dragon {
    private final Dragon decorated;

    public ArmoredDragon(Dragon decorated) {
        this.decorated = decorated;
    }
    @Override
    public String attack() {
        return decorated.attack()+", he is wearing an armor";
    }

    @Override
    public int getAttackpower() {
        return decorated.getAttackpower()+ 15;
    }

    @Override
    public void flyAway() {
        decorated.flyAway();
    }
}
