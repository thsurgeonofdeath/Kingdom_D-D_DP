package org.example.Hero;

public enum HeroRace {
    ELF,
    DWARF,
    ORC,
    GOBLIN,
    HUMAN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
