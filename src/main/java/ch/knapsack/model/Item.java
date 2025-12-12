package ch.knapsack.model;

import java.util.Objects;

public class Item {

    protected int weightGrams;
    protected String name;

    // Konstruktor mit Namen und Gewicht
    public Item(int weightGrams, String name) {
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("weightGrams muss grösser als 0 sein");
        }
        this.weightGrams = weightGrams;
        this.name = name;
    }
    // Konstruktor ohne Namen
    public Item(int weightGrams) {
        this(weightGrams, null);
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public String getName() {
        return name;
    }

    // Vegleich mit equals basierend auf Gewicht
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Item item = (Item) o;
        return weightGrams == item.weightGrams;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightGrams);
    }

    @Override
    public String toString() {
        return "Item{" +
                "weightGrams=" + weightGrams +
                ", name='" + name + '\'' +
                '}';
    }
}
