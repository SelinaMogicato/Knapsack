package ch.knapsack.model;

import java.util.Objects;

/**
 * Repräsentiert einen Gegenstand mit Gewicht und optionalem Namen.
 * Diese Klasse ist unveränderlich (immutable).
 */
public class Item {

    protected int weightGrams;
    protected String name;

    /**
     * Erstellt einen neuen Gegenstand mit Gewicht und Namen.
     *
     * @param weightGrams das Gewicht in Gramm (muss > 0 sein)
     * @param name        der Name des Gegenstands (kann null sein)
     * @throws IllegalArgumentException wenn weightGrams <= 0
     */
    public Item(int weightGrams, String name) {
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("weightGrams muss größer als 0 sein");
        }
        this.weightGrams = weightGrams;
        this.name = name;
    }

    /**
     * Erstellt einen neuen Gegenstand nur mit Gewicht (Name ist null).
     *
     * @param weightGrams das Gewicht in Gramm (muss > 0 sein)
     * @throws IllegalArgumentException wenn weightGrams <= 0
     */
    public Item(int weightGrams) {
        this(weightGrams, null);
    }

    /**
     * Gibt das Gewicht in Gramm zurück.
     *
     * @return das Gewicht in Gramm
     */
    public int getWeightGrams() {
        return weightGrams;
    }

    /**
     * Gibt den Namen des Gegenstands zurück.
     *
     * @return der Name (kann null sein)
     */
    public String getName() {
        return name;
    }

    /**
     * Zwei Items sind gleich, wenn ihr Gewicht gleich ist.
     * Der Name wird ignoriert.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Item item = (Item) o;
        return weightGrams == item.weightGrams;
    }

    /**
     * HashCode basiert nur auf dem Gewicht.
     */
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
