package org.example.Dragon;

public class IceBreathDragon implements Dragon {
    private final Dragon decorated;
    public IceBreathDragon(Dragon decorated) {
        this.decorated = decorated;
    }
    @Override
    public String attack() {
        return decorated.attack()+ ", he can ice you to death";
    }

    @Override
    public int getAttackpower() {
        return decorated.getAttackpower()+25;
    }

    @Override
    public void flyAway() {
        decorated.flyAway();
    }
}
