package org.example.Hero;

public final class Hero {
    private final Armor armor;
    private final HairColor hairColor;
    private final HairType hairType;
    private final HeroRace heroRace;
    private final String name;
    private final SwordType sword;

    public DragonSlayingStrategy strategy;

    public Hero(DragonSlayingStrategy strategy, Builder builder) {

        this.strategy = strategy;
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.hairType = builder.hairType;
        this.sword = builder.sword;
        this.armor = builder.armor;
        this.heroRace = builder.heroRace;

    }

    public void changeStrategy(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }
    public String goToBattle() {
       return strategy.execute();
    }


    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("This is a ")
                .append(heroRace)
                .append(" named ")
                .append(name);
        if (hairColor != null || hairType != null) {
            sb.append(" with ");
            if (hairColor != null) {
                sb.append(hairColor).append(' ');
            }
            if (hairType != null) {
                sb.append(hairType).append(' ');
            }
            sb.append(hairType != HairType.BALD ? "hair" : "head");
        }
        if (armor != null) {
            sb.append(" wearing a ").append(armor);
        }
        if (sword != null) {
            sb.append(" and wielding a ").append(sword);
        }
        sb.append('.');
        return sb.toString();
    }

    private Hero(Builder builder) {
        this.name = builder.name;
        this.hairColor = builder.hairColor;
        this.hairType = builder.hairType;
        this.sword = builder.sword;
        this.armor = builder.armor;
        this.heroRace = builder.heroRace;
    }

    public Armor getArmor() {
        return armor;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public HairType getHairType() {
        return hairType;
    }

    public HeroRace getHeroRace() {
        return heroRace;
    }

    public String getName() {
        return name;
    }

    public SwordType getSword() {
        return sword;
    }

    public static class Builder {
        private final String name;
        private HairType hairType;
        private HairColor hairColor;
        private Armor armor;
        private SwordType sword;
        private HeroRace heroRace;

        public Builder(HeroRace race, String name) {
            if (race == null || name == null) {
                throw new IllegalArgumentException("race and name can not be null");
            }
            this.heroRace = race;
            this.name = name;
        }

        public Builder withHairType(HairType hairType) {
            this.hairType = hairType;
            return this;
        }

        public Builder withHairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder withArmor(Armor armor) {
            this.armor = armor;
            return this;
        }

        public Builder withWeapon(SwordType sword) {
            this.sword = sword;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }
}
