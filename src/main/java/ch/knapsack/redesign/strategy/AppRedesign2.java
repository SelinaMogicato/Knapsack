package ch.knapsack.redesign.strategy;

import ch.knapsack.model.Item;
import java.util.Arrays;
import java.util.List;

public class AppRedesign2 {

    public static void main(String[] args) {
        // Liste von Items definieren (Gewichte: 6, 4, 3, 3, 2)
        List<Item> items = Arrays.asList(
                new Item(6),
                new Item(4),
                new Item(3),
                new Item(3),
                new Item(2));

        // Erzeuge eine StrategyBackpack-Instanz mit Maximalgewicht 20
        // Startstrategie: GreedyPackingStrategy
        StrategyBackpack backpack = new StrategyBackpack(20, new GreedyPackingStrategy());

        // 1. Packen mit Greedy-Strategie
        backpack.pack(items);
        printResult("Greedy", backpack);

        // 2. Strategie zur Laufzeit wechseln (auf Optimal/DP)
        backpack.setStrategy(new DpPackingStrategy());

        // 3. Erneut packen (selbe Instanz, neue Strategie)
        backpack.pack(items);
        printResult("Optimal (DP)", backpack);
    }

    /**
     * Hilfsmethode für die Konsolenausgabe
     */
    private static void printResult(String strategyName, StrategyBackpack backpack) {
        System.out.println("Strategie: " + strategyName);
        System.out.println("Maximalgewicht: " + backpack.getMaxWeightGrams());
        System.out.println("Aktuelles Gewicht: " + backpack.getCurrentWeightGrams());

        System.out.print("Items: [");
        List<Item> packedItems = backpack.getItems();
        for (int i = 0; i < packedItems.size(); i++) {
            System.out.print(packedItems.get(i).getWeightGrams());
            if (i < packedItems.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println(); // Leerzeile für Abstand
    }
}
