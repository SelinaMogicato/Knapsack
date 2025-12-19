package ch.knapsack.redesign.inheritance;

import ch.knapsack.model.Item;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class InheritanceDemoTest {

    @Test
    public void testInheritanceDemo() {
        System.out.println("=== START: Inheritance Demo Test ===");

        List<Item> items = Arrays.asList(
                new Item(6), new Item(4), new Item(3), new Item(3), new Item(2), new Item(2), new Item(1));
        int capacity = 10;

        // 1. Test Optimal DP Backpack
        OptimalDpBackpack dpBackpack = new OptimalDpBackpack(capacity);
        dpBackpack.pack(items);

        System.out.println("\n[Optimal DP Backpack]");
        System.out.println(
                "Max: " + dpBackpack.getMaxWeightGrams() + "g, Aktuell: " + dpBackpack.getCurrentWeightGrams() + "g");
        System.out.print("Items: ");
        dpBackpack.getItems().forEach(i -> System.out.print(i.getWeightGrams() + " "));
        System.out.println();

        // Assertions für DP (sollte 10g füllen: 6+4 oder 4+3+3 oder ähnlich)
        assertEquals(10, dpBackpack.getCurrentWeightGrams(), "DP sollte den Rucksack optimal füllen (10g)");

        // 2. Test Greedy Backpack
        GreedyBackpack greedyBackpack = new GreedyBackpack(capacity);
        greedyBackpack.pack(items);

        System.out.println("\n[Greedy Backpack]");
        System.out.println("Max: " + greedyBackpack.getMaxWeightGrams() + "g, Aktuell: "
                + greedyBackpack.getCurrentWeightGrams() + "g");
        System.out.print("Items: ");
        greedyBackpack.getItems().forEach(i -> System.out.print(i.getWeightGrams() + " "));
        System.out.println();

        // Assertions für Greedy (6, 4, 3, 3, 2, 2, 1 -> sortiert: 6, 4, 3, 3, 2, 2, 1)
        // Nimmt 6. Rest 4. Nimmt 4. Rest 0. -> Total 10.
        // Warte, Greedy sortiert absteigend: 6, 4, 3, 3, 2, 2, 1.
        // 1. Item (6) passt -> drin. Rest 4.
        // 2. Item (4) passt -> drin. Rest 0.
        // Voll.
        assertEquals(10, greedyBackpack.getCurrentWeightGrams(), "Greedy sollte hier auch 10g erreichen");

        System.out.println("\n=== END: Inheritance Demo Test ===");
    }
}
