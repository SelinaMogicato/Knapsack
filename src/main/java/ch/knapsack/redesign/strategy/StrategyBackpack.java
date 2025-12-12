package ch.knapsack.redesign.strategy;

import ch.knapsack.model.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StrategyBackpack {
    protected int maxWeightGrams;
    protected List<Item> items;
    protected PackingStrategy strategy;

    public StrategyBackpack(int maxWeightGrams, PackingStrategy strategy) {
        if (maxWeightGrams <= 0)
            throw new IllegalArgumentException("Max weight must be > 0");
        if (strategy == null)
            throw new IllegalArgumentException("Strategy cannot be null");
        this.maxWeightGrams = maxWeightGrams;
        this.strategy = strategy;
        this.items = new ArrayList<>();
    }

    public void setStrategy(PackingStrategy strategy) {
        if (strategy == null)
            throw new NullPointerException("Strategy cannot be null");
        this.strategy = strategy;
    }

    public void pack(Collection<Item> itemsToPack) {
        if (itemsToPack == null)
            throw new NullPointerException("itemsToPack cannot be null");
        for (Item i : itemsToPack)
            if (i == null)
                throw new NullPointerException("Item cannot be null");

        clear();
        List<Item> selected = strategy.selectItems(itemsToPack, maxWeightGrams);
        for (Item item : selected) {
            addItem(item);
        }
    }

    public boolean addItem(Item item) {
        if (item == null)
            throw new NullPointerException("Item cannot be null");
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
        for (Item item : items)
            sum += item.getWeightGrams();
        return sum;
    }

    public int getMaxWeightGrams() {
        return maxWeightGrams;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
