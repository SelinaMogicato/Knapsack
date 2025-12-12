package ch.knapsack.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-Tests für die SmartBackpack-Klasse.
 */
class SmartBackpackTest {

    // Tatsaechlich optimales Gewicht: 10
    @Test
    void pack_findsOptimalWeight() {
        // Arrange
        SmartBackpack backpack = new SmartBackpack(10);
        Item item6 = new Item(6);
        Item item4 = new Item(4);
        Item item3a = new Item(3);
        Item item3b = new Item(3);

        // Act
        backpack.pack(Arrays.asList(item6, item4, item3a, item3b));

        // Assert
        assertEquals(10, backpack.getCurrentWeightGrams(),
                "Optimales Gewicht sollte 10 sein (6+4 oder 4+3+3)");
        assertEquals(2, backpack.getItems().size(),
                "Es sollten 2 Items im Rucksack sein (6+4)");
    }

    @Test
    void pack_withNullCollection_throwsNullPointerException() {
        SmartBackpack backpack = new SmartBackpack(100);
        assertThrows(NullPointerException.class, () -> backpack.pack(null),
                "pack(null) sollte NullPointerException werfen");
    }

    @Test
    void pack_withNullItem_throwsNullPointerException() {
        SmartBackpack backpack = new SmartBackpack(100);
        assertThrows(NullPointerException.class,
                () -> backpack.pack(Arrays.asList(new Item(10), null, new Item(20))),
                "pack mit null-Item sollte NullPointerException werfen");
    }

    @Test
    void pack_allItemsFit_addsAllItems() {
        SmartBackpack backpack = new SmartBackpack(100);
        Item item1 = new Item(20);
        Item item2 = new Item(30);
        Item item3 = new Item(40);

        backpack.pack(Arrays.asList(item1, item2, item3));

        assertEquals(90, backpack.getCurrentWeightGrams(),
                "Alle Items sollten passen (20+30+40=90)");
        assertEquals(3, backpack.getItems().size(),
                "Alle 3 Items sollten hinzugefügt werden");
    }

    @Test
    void pack_clearsBeforePacking() {
        SmartBackpack backpack = new SmartBackpack(100);

        // Erstes Packen
        backpack.pack(Arrays.asList(new Item(50)));
        assertEquals(50, backpack.getCurrentWeightGrams());

        // Zweites Packen - sollte vorherige Items löschen
        backpack.pack(Arrays.asList(new Item(30)));
        assertEquals(30, backpack.getCurrentWeightGrams(),
                "Nach erneutem pack sollte nur das neue Item drin sein");
        assertEquals(1, backpack.getItems().size());
    }

    @Test
    void pack_emptyCollection_resultsInEmptyBackpack() {
        SmartBackpack backpack = new SmartBackpack(100);
        backpack.addItem(new Item(50));

        backpack.pack(Arrays.asList());

        assertEquals(0, backpack.getCurrentWeightGrams(),
                "Bei leerer Collection sollte Rucksack leer sein");
        assertEquals(0, backpack.getItems().size());
    }
}
