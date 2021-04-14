package com.gildedrose;

public class ItemWrapper {

    private final Item item;
    private final SellInUpdateBehaviour sellInUpdateBehaviour;
    private final QualityUpdateBehaviour qualityUpdateBehaviour;

    public ItemWrapper(Item item, SellInUpdateBehaviour sellInUpdateBehaviour, QualityUpdateBehaviour qualityUpdateBehaviour) {
        this.item = item;
        this.sellInUpdateBehaviour = sellInUpdateBehaviour;
        this.qualityUpdateBehaviour = qualityUpdateBehaviour;
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

    public SellInUpdateBehaviour getSellInUpdateBehaviour() {
        return this.sellInUpdateBehaviour;
    }

    public QualityUpdateBehaviour getQualityUpdateBehaviour() {
        return this.qualityUpdateBehaviour;
    }
}
