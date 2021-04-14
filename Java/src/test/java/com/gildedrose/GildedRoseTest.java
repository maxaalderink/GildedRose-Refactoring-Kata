package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateDefault_QualityIsZero_QualityDoesNotDecreaseBellowZero() {
        Item[] items = new Item[] { new Item("default", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("default", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateDefault_SellInIsAboveZero_QualityDecrementsOne() {
        Item[] items = new Item[] { new Item("default", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("default", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void updateDefault_SellInIsZeroOrBellow_QualityDecrementsTwo() {
        Item[] items = new Item[] { new Item("default", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("default", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void updateAgedBrie_SellInIsAboveZero_QualityIncrementsOne() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateAgedBrie_QualityIsFifty_QualityDoesNotIncreaseAboveFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void updateSulfuras_QualityAndSellInDoesNotChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }
}
