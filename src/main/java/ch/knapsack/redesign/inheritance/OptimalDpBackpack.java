package ch.knapsack.redesign.inheritance;

import ch.knapsack.model.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OptimalDpBackpack extends AbstractBackpack {

    public OptimalDpBackpack(int maxWeightGrams) {
        super(maxWeightGrams);
    }

    @Override
    public void pack(Collection<Item> itemsToPack) {
        if (itemsToPack == null)
            throw new NullPointerException("itemsToPack cannot be null");
        for (Item i : itemsToPack)
            if (i == null)
                throw new NullPointerException("Item cannot be null");

        clear();

        List<Item> list = new ArrayList<>(itemsToPack);
        int capacity = getMaxWeightGrams();

        // Check sum first (optimization)
        int total = 0;
        for (Item i : list)
            total += i.getWeightGrams();
        if (total <= capacity) {
            for (Item i : list)
                addItem(i);
            return;
        }

        boolean[] dp = new boolean[capacity + 1];
        int[] prev = new int[capacity + 1];
        int[] chosenIndex = new int[capacity + 1];

        dp[0] = true;
        for (int i = 0; i <= capacity; i++) {
            prev[i] = -1;
            chosenIndex[i] = -1;
        }

        for (int i = 0; i < list.size(); i++) {
            int wi = list.get(i).getWeightGrams();
            for (int w = capacity; w >= wi; w--) {
                if (dp[w - wi] && !dp[w]) {
                    dp[w] = true;
                    prev[w] = w - wi;
                    chosenIndex[w] = i;
                }
            }
        }

        int best = 0;
        for (int w = capacity; w >= 0; w--) {
            if (dp[w]) {
                best = w;
                break;
            }
        }

        List<Item> toAdd = new ArrayList<>();
        int w = best;
        while (w > 0 && chosenIndex[w] != -1) {
            toAdd.add(list.get(chosenIndex[w]));
            w = prev[w];
        }

        for (Item item : toAdd) {
            addItem(item);
        }
    }
}
