package ch.knapsack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Repräsentiert einen Rucksack mit maximalem Gewicht.
 * Items können hinzugefügt werden, solange das Maximalgewicht nicht
 * überschritten wird.
 */
public class Backpack {

    protected int maxWeightGrams;
    protected List<Item> items;

    /**
     * Erstellt einen neuen Rucksack mit dem angegebenen Maximalgewicht.
     *
     * @param maxWeightGrams das maximale Gewicht in Gramm (muss > 0 sein)
     * @throws IllegalArgumentException wenn maxWeightGrams <= 0
     */
    public Backpack(int maxWeightGrams) {
        if (maxWeightGrams <= 0) {
            throw new IllegalArgumentException("maxWeightGrams muss größer als 0 sein");
        }
        this.maxWeightGrams = maxWeightGrams;
        this.items = new ArrayList<>();
    }

    /**
     * Fügt ein Item zum Rucksack hinzu, wenn das Maximalgewicht nicht überschritten
     * wird.
     *
     * @param item das hinzuzufügende Item
     * @return true wenn das Item hinzugefügt wurde, false wenn es nicht passt
     * @throws NullPointerException wenn item null ist
     */
    public boolean addItem(Item item) {
        if (item == null) {
            throw new NullPointerException("Item darf nicht null sein");
        }
        if (getCurrentWeightGrams() + item.getWeightGrams() <= maxWeightGrams) {
            items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Berechnet das aktuelle Gesamtgewicht aller Items im Rucksack.
     *
     * @return das aktuelle Gewicht in Gramm
     */
    public int getCurrentWeightGrams() {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeightGrams();
        }
        return totalWeight;
    }

    /**
     * Leert den Rucksack komplett.
     */
    public void clear() {
        items.clear();
    }

    /**
     * Gibt das maximale Gewicht des Rucksacks zurück.
     *
     * @return das maximale Gewicht in Gramm
     */
    public int getMaxWeightGrams() {
        return maxWeightGrams;
    }

    /**
     * Gibt eine unveränderliche Sicht auf die Items im Rucksack zurück.
     *
     * @return unveränderliche Liste der Items
     */
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
