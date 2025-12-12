package ch.knapsack.redesign.inheritance;

import ch.knapsack.model.Item;
import java.util.Collection;

public interface Packable {
    void pack(Collection<Item> itemsToPack);
}
