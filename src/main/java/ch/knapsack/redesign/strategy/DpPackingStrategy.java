package ch.knapsack.redesign.strategy;

import ch.knapsack.model.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DpPackingStrategy implements PackingStrategy {
    @Override
    public List<Item> selectItems(Collection<Item> itemsToPack, int capacity) {
        List<Item> list = new ArrayList<>(itemsToPack);

        // Optimization check
        int total = 0;
        for (Item i : list)
            total += i.getWeightGrams();
        if (total <= capacity)
            return list;

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

        List<Item> selected = new ArrayList<>();
        int w = best;
        while (w > 0 && chosenIndex[w] != -1) {
            selected.add(list.get(chosenIndex[w]));
            w = prev[w];
        }
        return selected;
    }
}
