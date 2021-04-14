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
            if (!itemWrapper.getName().equals("Aged Brie")
                    && !itemWrapper.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (itemWrapper.getQuality() > MINIMUM_QUALITY) {
                    if (!itemWrapper.getName().equals("Sulfuras, Hand of Ragnaros")) {
                        itemWrapper.setQuality(itemWrapper.getQuality() - 1);
                    }
                }
            } else {
                if (itemWrapper.getQuality() < MAXIMUM_QUALITY) {
                    itemWrapper.setQuality(itemWrapper.getQuality() + 1);

                    if (itemWrapper.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (itemWrapper.getSellIn() < 11 && itemWrapper.getQuality() < MAXIMUM_QUALITY) {
                                itemWrapper.setQuality(itemWrapper.getQuality() + 1);
                            }

                        if (itemWrapper.getSellIn() < 6 && itemWrapper.getQuality() < MAXIMUM_QUALITY) {
                            itemWrapper.setQuality(itemWrapper.getQuality() + 1);
                        }
                    }
                }
            }

            if (itemWrapper.getSellInUpdateBehaviour() == SellInUpdateBehaviour.DEFAULT_DECREASING) {
                itemWrapper.setSellIn(itemWrapper.getSellIn() + getSellInDeltaDefault());
            }

            if (itemWrapper.getSellIn() < 0) {
                if (!itemWrapper.getName().equals("Aged Brie")) {
                    if (!itemWrapper.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (itemWrapper.getQuality() > MINIMUM_QUALITY) {
                            if (!itemWrapper.getName().equals("Sulfuras, Hand of Ragnaros")) {
                                itemWrapper.setQuality(itemWrapper.getQuality() - 1);
                            }
                        }
                    } else {
                        itemWrapper.setQuality(MINIMUM_QUALITY);
                    }
                } else {
                    if (itemWrapper.getQuality() < MAXIMUM_QUALITY) {
                        itemWrapper.setQuality(itemWrapper.getQuality() + 1);
                    }
                }
            }
        }
    }

    private int getSellInDeltaDefault() {
        return -1;
    }
}