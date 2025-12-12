package ch.knapsack.redesign.inheritance;

import ch.knapsack.model.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class GreedyBackpack extends AbstractBackpack {

    public GreedyBackpack(int maxWeightGrams) {
        super(maxWeightGrams);
    }

    @Override
    public void pack(Collection<Item> itemsToPack) {
        if (itemsToPack == null) throw new NullPointerException("itemsToPack cannot be null");
        for (Item i : itemsToPack) if (i == null) throw new NullPointerException("Item cannot be null");

        clear();

        List<Item> sorted = new ArrayList<>(itemsToPack);
        sorted.sort(Comparator.comparingInt(Item::getWeightGrams).reversed());

        for (Item item : sorted) {
            addItem(item);
        }
    }
}
