package ch.knapsack.redesign.inheritance;

import ch.knapsack.model.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractBackpack implements Packable {
    protected int maxWeightGrams;
    protected List<Item> items;

    public AbstractBackpack(int maxWeightGrams) {
        if (maxWeightGrams <= 0) {
            throw new IllegalArgumentException("Max weight must be > 0");
        }
        this.maxWeightGrams = maxWeightGrams;
        this.items = new ArrayList<>();
    }

    public boolean addItem(Item item) {
        if (item == null) {
            throw new NullPointerException("Item cannot be null");
        }
        if (getCurrentWeightGrams() + item.getWeightGrams() <= maxWeightGrams) {
            items.add(item);
            return true;
        }
        return false;
    }

    public void clear() {
        items.clear();
    }

    public int getCurrentWeightGrams() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getWeightGrams();
        }
        return sum;
    }

    public int getMaxWeightGrams() {
        return maxWeightGrams;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
