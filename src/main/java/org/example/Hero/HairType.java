package org.example.Hero;

public enum HairType {
    BALD("bald head"),
    SHORT("short hair"),
    CURLY("curly hair"),
    LONG_STRAIGHT("long and straight hair"),
    LONG_CURLY("long and curly hair");

    private final String title;
    HairType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
