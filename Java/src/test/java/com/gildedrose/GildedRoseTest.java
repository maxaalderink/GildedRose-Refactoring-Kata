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

}
