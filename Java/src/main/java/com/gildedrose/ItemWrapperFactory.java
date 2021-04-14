package com.gildedrose;

public class ItemWrapperFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private ItemWrapperFactory() {
    }

    public static ItemWrapper create(Item item) {
        SellInUpdateBehaviour sellInUpdateBehaviour = getSellInUpdateBehavior(item.name);
        QualityUpdateBehaviour qualityUpdateBehaviour = getQualityUpdateBehaviour(item.name);
        return new ItemWrapper(item, sellInUpdateBehaviour, qualityUpdateBehaviour);
    }

    private static SellInUpdateBehaviour getSellInUpdateBehavior(String itemName){
        switch (itemName){
            case SULFURAS:
                return SellInUpdateBehaviour.STATIC;
            default:
                return SellInUpdateBehaviour.DEFAULT_DECREASING;
        }
    }

    private static QualityUpdateBehaviour getQualityUpdateBehaviour(String itemName){
        switch (itemName){
            case AGED_BRIE:
                return QualityUpdateBehaviour.INCREASING;
            case BACKSTAGE_PASS:
                return QualityUpdateBehaviour.INCREASING_UNTIL_SELL_IN;
            case SULFURAS:
                return QualityUpdateBehaviour.STATIC;
            default:
                return QualityUpdateBehaviour.DEFAULT_DECREASING;
        }
    }
}
