package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class QualityDeltaProviderTest {

    @Test
    void getQualityDeltaDefaultDecreasing_SellInIsPositive_QualityDecrementsOne() {
        Item item = new Item("itemName", 0, 10);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.DEFAULT_DECREASING);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(-1, qualityDelta);
    }

    @Test
    void getQualityDeltaDefaultDecreasing_SellInIsNegative_QualityDecrementsTwo() {
        Item item = new Item("itemName", -1, 10);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.DEFAULT_DECREASING);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(-2, qualityDelta);
    }

    @Test
    void getQualityDeltaIncreasing_SellInIsPositive_QualityIncrementsOne() {
        Item item = new Item("itemName", 0, 10);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.INCREASING);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(1, qualityDelta);
    }

    @Test
    void getQualityDeltaIncreasingUntilSellIn_SellInIsAboveTen_QualityIncrementsOne() {
        Item item = new Item("itemName", 20, 10);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.INCREASING_UNTIL_SELL_IN);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(1, qualityDelta);
    }

    @Test
    void getQualityDeltaIncreasingUntilSellIn_SellInIsBelowTenAndAboveFive_QualityIncrementsTwo() {
        Item item = new Item("itemName", 7, 10);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.INCREASING_UNTIL_SELL_IN);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(2, qualityDelta);
    }

    @Test
    void getQualityDeltaIncreasingUntilSellIn_SellInIsBelowFiveAndAboveZero_QualityIncrementsThree() {
        Item item = new Item("itemName", 3, 10);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.INCREASING_UNTIL_SELL_IN);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(3, qualityDelta);
    }

    @Test
    void getQualityDeltaIncreasingUntilSellIn_SellInIsNegative_QualityIsZero() {
        int originalQuality = 10;
        Item item = new Item("itemName", -1, originalQuality);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.INCREASING_UNTIL_SELL_IN);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(0 - originalQuality, qualityDelta);
    }

    @Test
    void getQualityDeltaStatic_QualityDoesNotChange() {
        Item item = new Item("itemName", 0, 80);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.STATIC);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(0, qualityDelta);
    }

    @Test
    void getQualityDeltaDecreasingDoubleRate_SellInIsPositive_QualityDecrementsTwo() {
        Item item = new Item("itemName", 0, 10);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.DECREASING_DOUBLE_RATE);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(-2, qualityDelta);
    }

    @Test
    void getQualityDeltaDecreasingDoubleRate_SellInIsNegative_QualityDecrementsFour() {
        Item item = new Item("itemName", -1, 10);
        ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, QualityUpdateBehaviour.DECREASING_DOUBLE_RATE);

        int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);

        assertEquals(-4, qualityDelta);
    }

    @Test
    void getQualityDeltaAllBehaviours_noExceptionThrown() {
        for (QualityUpdateBehaviour behaviour : QualityUpdateBehaviour.values()) {
            Item item = new Item("itemName", 0, 0);
            ItemWrapper itemWrapper = new ItemWrapper(item, SellInUpdateBehaviour.DEFAULT_DECREASING, behaviour);

            assertDoesNotThrow(() -> QualityDeltaProvider.getQualityDelta(itemWrapper));
        }
    }
}
