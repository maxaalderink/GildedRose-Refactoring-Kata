package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateDefault_QualityIsZero_QualityDoesNotDecreaseBellowZero() {
        Item item = new Item("default", 0, 0);

        testUpdateQualitySingleItem(item, -1, 0);
    }

    @Test
    void updateAgedBrie_QualityIsFifty_QualityDoesNotIncreaseAboveFifty() {
        Item item = new Item("Aged Brie", 0, 50);

        testUpdateQualitySingleItem(item, -1, 50);
    }

    @Test
    void updateBackstagePass_SellInIsAboveZeroAndQualityIsFifty_QualityDoesNotIncreaseAboveFifty() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50);

        testUpdateQualitySingleItem(item, 19, 50);
    }

    @Test
    void updateBackstagePass_SellInIsZero_QualityDoesNotDecreaseBellowZero() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0);

        testUpdateQualitySingleItem(item, -1, 0);
    }

    @Test
    void updateConjured_QualityIsZero_QualityDoesNotDecreaseBellowZero() {
        Item item = new Item("Conjured Mana Cake", 0, 0);

        testUpdateQualitySingleItem(item, -1, 0);
    }

    private void testUpdateQualitySingleItem(Item item, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }
}
