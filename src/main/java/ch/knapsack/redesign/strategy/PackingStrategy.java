package ch.knapsack.redesign.strategy;

import ch.knapsack.model.Item;
import java.util.Collection;
import java.util.List;

public interface PackingStrategy {
    List<Item> selectItems(Collection<Item> itemsToPack, int capacity);
}
