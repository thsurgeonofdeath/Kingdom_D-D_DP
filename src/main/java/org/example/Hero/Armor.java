package org.example.Hero;

public enum Armor {

    LEATHER_ARMOR("leather armor"),
    IRON_ARMOR("iron armor"),
    COPPER_ARMOR("copper armor"),
    DIAMOND_ARMOR("diamond armor"),
    GOLD_ARMOR("golden armor"),
    NETHERITE_ARMOR("netherite armor");

    private final String title;

    Armor(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}