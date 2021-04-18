package com.gildedrose;

class GildedRose {
    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            final ItemWrapper itemWrapper = ItemWrapperFactory.create(item);

            final int sellInDelta = SellInDeltaProvider.getSellInDelta(itemWrapper);
            itemWrapper.setSellIn(itemWrapper.getSellIn() + sellInDelta);

            final int qualityDelta = QualityDeltaProvider.getQualityDelta(itemWrapper);
            if (qualityDelta > 0) {
                itemWrapper.setQuality(Math.min(MAXIMUM_QUALITY, itemWrapper.getQuality() + qualityDelta));
            }
            if (qualityDelta < 0) {
                itemWrapper.setQuality(Math.max(MINIMUM_QUALITY, itemWrapper.getQuality() + qualityDelta));
            }
        }
    }
}