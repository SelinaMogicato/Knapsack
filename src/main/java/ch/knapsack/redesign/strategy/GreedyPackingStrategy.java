package ch.knapsack.redesign.strategy;

import ch.knapsack.model.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class GreedyPackingStrategy implements PackingStrategy {
    @Override
    public List<Item> selectItems(Collection<Item> itemsToPack, int capacity) {
        List<Item> sorted = new ArrayList<>(itemsToPack);
        sorted.sort(Comparator.comparingInt(Item::getWeightGrams).reversed());

        List<Item> selected = new ArrayList<>();
        int currentWeight = 0;

        for (Item item : sorted) {
            if (currentWeight + item.getWeightGrams() <= capacity) {
                selected.add(item);
                currentWeight += item.getWeightGrams();
            }
        }
        return selected;
    }
}
