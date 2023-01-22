package org.example.Dragon;

public class FireDragon implements Dragon {
    private final Dragon decorated;

    public FireDragon(Dragon decorated) {
        this.decorated = decorated;
    }
    @Override
    public String attack() {
        return decorated.attack()+", he can use fire breath";
    }

    @Override
    public int getAttackpower() {
        return decorated.getAttackpower()+ 20;
    }

    @Override
    public void flyAway() {
        decorated.flyAway();
    }
}
