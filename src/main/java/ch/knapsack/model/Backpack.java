package ch.knapsack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backpack {

    protected int maxWeightGrams;
    protected List<Item> items;

    // Konstruktor 
    public Backpack(int maxWeightGrams) {
        if (maxWeightGrams <= 0) {
            throw new IllegalArgumentException("maxWeightGrams muss grösser als 0 sein");
        }
        this.maxWeightGrams = maxWeightGrams;
        this.items = new ArrayList<>();
    }

    // Item hinzufügen (falls es noch vom Gewicht reinpasst)
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

    // Berechnung des aktuellen Gewichts im Rucksack
    public int getCurrentWeightGrams() {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeightGrams();
        }
        return totalWeight;
    }

    // Leeren
    public void clear() {
        items.clear();
    }

    public int getMaxWeightGrams() {
        return maxWeightGrams;
    }

    // Unveränderliche Sicht auf die Items
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
