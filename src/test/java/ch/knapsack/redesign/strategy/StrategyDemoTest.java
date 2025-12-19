package ch.knapsack.redesign.strategy;

import ch.knapsack.model.Item;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyDemoTest {

    @Test
    public void testStrategyDemo() {
        System.out.println("=== START: Strategy Demo Test ===");

        // Liste von Items definieren (Gewichte: 6, 4, 3, 3, 3)
        List<Item> items = Arrays.asList(
                new Item(6),
                new Item(4),
                new Item(3),
                new Item(3),
                new Item(3));

        int capacity = 20; // Wie in AppRedesign2, aber dort war es 20? AppRedesign2 hatte 20 im Code.
        // Moment, AppRedesign2 Code: StrategyBackpack backpack = new
        // StrategyBackpack(20, new GreedyPackingStrategy());
        // Aber Items sind 6+4+3+3+3 = 19.
        // Lass uns eine Kapazität nehmen, wo es einen Unterschied macht, oder einfach
        // die Demo nachbauen.
        // Ich nehme capacity 10, damit man den Unterschied sieht, falls es einen gibt,
        // oder einfach 20 wie im Original.
        // Im Original AppRedesign2 war capacity 20.

        StrategyBackpack backpack = new StrategyBackpack(20, new GreedyPackingStrategy());

        // 1. Packen mit Greedy-Strategie
        backpack.pack(items);

        System.out.println("\n[Strategie: Greedy]");
        System.out.println(
                "Max: " + backpack.getMaxWeightGrams() + "g, Aktuell: " + backpack.getCurrentWeightGrams() + "g");
        System.out.print("Items: ");
        backpack.getItems().forEach(i -> System.out.print(i.getWeightGrams() + " "));
        System.out.println();

        // Bei Capacity 20 und Items Summe 19 sollte alles reinpassen.
        assertEquals(19, backpack.getCurrentWeightGrams(), "Greedy sollte bei genug Platz alles packen");

        // 2. Strategie wechseln
        System.out.println("\n... Wechsle Strategie zu Optimal (DP) ...");
        backpack.setStrategy(new DpPackingStrategy());

        // 3. Erneut packen
        backpack.pack(items);

        System.out.println("\n[Strategie: Optimal DP]");
        System.out.println(
                "Max: " + backpack.getMaxWeightGrams() + "g, Aktuell: " + backpack.getCurrentWeightGrams() + "g");
        System.out.print("Items: ");
        backpack.getItems().forEach(i -> System.out.print(i.getWeightGrams() + " "));
        System.out.println();

        assertEquals(19, backpack.getCurrentWeightGrams(), "DP sollte auch alles packen");

        System.out.println("\n=== END: Strategy Demo Test ===");
    }
}
