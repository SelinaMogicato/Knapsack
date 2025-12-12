package ch.knapsack.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-Tests für die Backpack-Klasse.
 */
class BackpackTest {

    /**
     * Test: Maximalgewicht darf nicht überschritten werden.
     * - Erzeuge Backpack mit maxWeightGrams = 100
     * - Füge Item 60 hinzu -> addItem muss true sein
     * - Füge Item 50 hinzu -> addItem muss false sein (weil 60+50 > 100)
     * - getCurrentWeightGrams() muss weiterhin 60 sein
     * - items.size() muss 1 sein
     */
    @Test
    void testMaxWeightCannotBeExceeded() {
        // Arrange
        Backpack backpack = new Backpack(100);
        Item item60 = new Item(60);
        Item item50 = new Item(50);

        // Act & Assert - Item 60 hinzufügen (sollte passen)
        boolean added60 = backpack.addItem(item60);
        assertTrue(added60, "Item mit 60g sollte hinzugefügt werden können");

        // Act & Assert - Item 50 hinzufügen (sollte nicht passen: 60+50 > 100)
        boolean added50 = backpack.addItem(item50);
        assertFalse(added50, "Item mit 50g sollte NICHT hinzugefügt werden (60+50 > 100)");

        // Assert - Gewicht und Anzahl prüfen
        assertEquals(60, backpack.getCurrentWeightGrams(),
                "Aktuelles Gewicht sollte weiterhin 60 sein");
        assertEquals(1, backpack.getItems().size(),
                "Es sollte nur 1 Item im Rucksack sein");
    }

    @Test
    void testBackpackConstructorWithInvalidWeight() {
        assertThrows(IllegalArgumentException.class, () -> new Backpack(0),
                "Backpack mit maxWeightGrams=0 sollte IllegalArgumentException werfen");
        assertThrows(IllegalArgumentException.class, () -> new Backpack(-10),
                "Backpack mit negativem maxWeightGrams sollte IllegalArgumentException werfen");
    }

    @Test
    void testAddNullItemThrowsNullPointerException() {
        Backpack backpack = new Backpack(100);
        assertThrows(NullPointerException.class, () -> backpack.addItem(null),
                "addItem(null) sollte NullPointerException werfen");
    }

    @Test
    void testClearBackpack() {
        Backpack backpack = new Backpack(100);
        backpack.addItem(new Item(30));
        backpack.addItem(new Item(40));

        assertEquals(70, backpack.getCurrentWeightGrams());
        assertEquals(2, backpack.getItems().size());

        backpack.clear();

        assertEquals(0, backpack.getCurrentWeightGrams(),
                "Nach clear() sollte das Gewicht 0 sein");
        assertEquals(0, backpack.getItems().size(),
                "Nach clear() sollte die Liste leer sein");
    }

    @Test
    void testGetMaxWeightGrams() {
        Backpack backpack = new Backpack(150);
        assertEquals(150, backpack.getMaxWeightGrams(),
                "getMaxWeightGrams() sollte den korrekten Wert zurückgeben");
    }

    @Test
    void testGetItemsReturnsUnmodifiableList() {
        Backpack backpack = new Backpack(100);
        backpack.addItem(new Item(30));

        assertThrows(UnsupportedOperationException.class,
                () -> backpack.getItems().add(new Item(10)),
                "getItems() sollte eine unveränderliche Liste zurückgeben");
    }
}
