package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SellInDeltaProviderTest {

    @Test
    void getSellInDeltaDefaultDecreasing_isMinusOne() {
        Item item = new Item("itemName", 0, 0);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.DEFAULT_DECREASING);

        int sellInDelta = SellInDeltaProvider.getSellInDelta(itemWrapper);

        assertEquals(-1, sellInDelta);
    }

    @Test
    void getSellInDeltaStatic_isZero() {
        Item item = new Item("itemName", 0, 0);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.STATIC, QualityUpdateBehaviour.DEFAULT_DECREASING);

        int sellInDelta = SellInDeltaProvider.getSellInDelta(itemWrapper);

        assertEquals(0, sellInDelta);
    }

    @Test
    void getSellInDeltaAllBehaviours_noExceptionThrown() {
        for (SellInUpdateBehaviour behaviour : SellInUpdateBehaviour.values()) {
            Item item = new Item("itemName", 0, 0);
            ItemWrapper itemWrapper = new ItemWrapper(item, behaviour, QualityUpdateBehaviour.DEFAULT_DECREASING);

            assertDoesNotThrow(() -> SellInDeltaProvider.getSellInDelta(itemWrapper));
        }
    }
}
