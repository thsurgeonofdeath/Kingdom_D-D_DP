package org.example.Hero;

public enum SwordType {
    STONE_SWORD("stone sword"),
    IRON_SWORD("iron sword"),
    DIAMOND_SWORD("diamond sword"),
    NETHERITE_SWORD("netherite sword"),
    ENCHANTED_SWORD("enchanted sword");

    private final String title;

    SwordType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
