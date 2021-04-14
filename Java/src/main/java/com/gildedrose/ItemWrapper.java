package com.gildedrose;

public class ItemWrapper {

    private final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public String getName() {
        return this.item.name;
    }

    public int getSellIn() {
        return this.item.sellIn;
    }

    public void setSellIn(int sellIn) {
        this.item.sellIn = sellIn;
    }

    public int getQuality() {
        return this.item.quality;
    }

    public void setQuality(int quality) {
        this.item.quality = quality;
    }
}
