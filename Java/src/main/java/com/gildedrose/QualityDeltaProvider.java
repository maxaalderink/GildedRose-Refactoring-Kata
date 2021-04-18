package com.gildedrose;

public class QualityDeltaProvider {
    private static final int TEN_DAYS_LEFT = 10;
    private static final int FIVE_DAYS_LEFT = 5;
    private static final int ONE_DAY_AFTER = -1;

    public static int getQualityDelta(ItemWrapper itemWrapper) {
        switch (itemWrapper.getQualityUpdateBehaviour()) {
            case INCREASING:
                return getQualityDeltaIncreasing();
            case INCREASING_UNTIL_SELL_IN:
                return getQualityDeltaIncreasingUntillSellIn(itemWrapper);
            case STATIC:
                return getQualityDeltaStatic();
            case DECREASING_DOUBLE_RATE:
                return getQualityDeltaDecreasingDoubleRate(itemWrapper);
            case DEFAULT_DECREASING:
                return getQualityDeltaDefault(itemWrapper);
            default:
                throw new UnsupportedOperationException("QualityUpdateBehaviour '" + itemWrapper.getQualityUpdateBehaviour().name() + "' has not been implemented");
        }
    }

    private static int getQualityDeltaDefault(ItemWrapper itemWrapper) {
        return itemWrapper.getSellIn() >= 0 ? -1 : -2;
    }

    private static int getQualityDeltaDecreasingDoubleRate(ItemWrapper itemWrapper) {
        return getQualityDeltaDefault(itemWrapper) * 2;
    }

    private static int getQualityDeltaIncreasing() {
        return 1;
    }

    private static int getQualityDeltaIncreasingUntillSellIn(ItemWrapper itemWrapper) {
        if (itemWrapper.getSellIn() > TEN_DAYS_LEFT) {
            return 1;
        } else if (itemWrapper.getSellIn() > FIVE_DAYS_LEFT) {
            return 2;
        } else if (itemWrapper.getSellIn() > ONE_DAY_AFTER) {
            return 3;
        } else if (itemWrapper.getSellIn() == ONE_DAY_AFTER) {
            return -itemWrapper.getQuality();
        } else {
            return 0;
        }
    }

    private static int getQualityDeltaStatic() {
        return 0;
    }
}
