package com.gildedrose;

public class ItemWrapperFactory {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private ItemWrapperFactory() {
    }

    public static ItemWrapper create(Item item) {
        SellInUpdateBehaviour sellInUpdateBehaviour =  getSellInUpdateBehavior(item.name);
        return new ItemWrapper(item, sellInUpdateBehaviour);
    }

    private static SellInUpdateBehaviour getSellInUpdateBehavior(String itemName){
        switch (itemName){
            case SULFURAS:
                return SellInUpdateBehaviour.STATIC;
            default:
                return SellInUpdateBehaviour.DEFAULT_DECREASING;
        }
    }
}
