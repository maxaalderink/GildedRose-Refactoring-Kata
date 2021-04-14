package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            final ItemWrapper itemWrapper = ItemWrapperFactory.create(items[i]);
            if (!itemWrapper.getName().equals("Aged Brie")
                    && !itemWrapper.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (itemWrapper.getQuality() > 0) {
                    if (!itemWrapper.getName().equals("Sulfuras, Hand of Ragnaros")) {
                        itemWrapper.setQuality(itemWrapper.getQuality() - 1);
                    }
                }
            } else {
                if (itemWrapper.getQuality() < 50) {
                    itemWrapper.setQuality(itemWrapper.getQuality() + 1);

                    if (itemWrapper.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (itemWrapper.getSellIn() < 11) {
                            if (itemWrapper.getQuality() < 50) {
                                itemWrapper.setQuality(itemWrapper.getQuality() + 1);
                            }
                        }

                        if (itemWrapper.getSellIn() < 6) {
                            if (itemWrapper.getQuality() < 50) {
                                itemWrapper.setQuality(itemWrapper.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!itemWrapper.getName().equals("Sulfuras, Hand of Ragnaros")) {
                itemWrapper.setSellIn(itemWrapper.getSellIn() - 1);
            }

            if (itemWrapper.getSellIn() < 0) {
                if (!itemWrapper.getName().equals("Aged Brie")) {
                    if (!itemWrapper.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (itemWrapper.getQuality() > 0) {
                            if (!itemWrapper.getName().equals("Sulfuras, Hand of Ragnaros")) {
                                itemWrapper.setQuality(itemWrapper.getQuality() - 1);
                            }
                        }
                    } else {
                        itemWrapper.setQuality(0);
                    }
                } else {
                    if (itemWrapper.getQuality() < 50) {
                        itemWrapper.setQuality(itemWrapper.getQuality() + 1);
                    }
                }
            }
        }
    }
}