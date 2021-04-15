package com.gildedrose;

class GildedRose {
    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    private static final int TEN_DAYS_LEFT = 10;
    private static final int FIVE_DAYS_LEFT = 5;
    private static final int ONE_DAY_AFTER = -1;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            final ItemWrapper itemWrapper = ItemWrapperFactory.create(item);

            if (itemWrapper.getSellInUpdateBehaviour() == SellInUpdateBehaviour.DEFAULT_DECREASING) {
                itemWrapper.setSellIn(itemWrapper.getSellIn() + getSellInDeltaDefault());
            }

            int qualityDelta;
            switch (itemWrapper.getQualityUpdateBehaviour()){
                case INCREASING:
                    qualityDelta = getQualityDeltaIncreasing();
                    break;
                case INCREASING_UNTIL_SELL_IN:
                    qualityDelta = getQualityDeltaIncreasingUntillSellIn(itemWrapper);
                    break;
                case STATIC:
                    qualityDelta = getQualityDeltaStatic();
                    break;
                case DEFAULT_DECREASING:
                    qualityDelta = getQualityDeltaDefault(itemWrapper);
                    break;
                default:
                    throw new UnsupportedOperationException("QualityUpdateBehaviour '" + itemWrapper.getQualityUpdateBehaviour().name() + "' has not been implemented");
            }
            if (qualityDelta > 0) {
                itemWrapper.setQuality(Math.min(MAXIMUM_QUALITY, item.quality + qualityDelta));
            }
            if (qualityDelta < 0) {
                itemWrapper.setQuality(Math.max(MINIMUM_QUALITY, item.quality + qualityDelta));
            }
        }
    }

    private int getSellInDeltaDefault() {
        return -1;
    }

    private int getQualityDeltaDefault(ItemWrapper itemWrapper) {
        return itemWrapper.getSellIn() >= 0 ? -1 : -2;
    }

    private int getQualityDeltaIncreasing() {
        return 1;
    }

    private int getQualityDeltaIncreasingUntillSellIn(ItemWrapper itemWrapper) {
        if (itemWrapper.getSellIn() > TEN_DAYS_LEFT) {
            return 1;
        } else if (itemWrapper.getSellIn() > FIVE_DAYS_LEFT) {
            return 2;
        } else if (itemWrapper.getSellIn() > ONE_DAY_AFTER) {
            return 3;
        } else if (itemWrapper.getSellIn() == ONE_DAY_AFTER){
            return -itemWrapper.getQuality();
        } else {
            return 0;
        }
    }

    private int getQualityDeltaStatic() {
        return 0;
    }
}