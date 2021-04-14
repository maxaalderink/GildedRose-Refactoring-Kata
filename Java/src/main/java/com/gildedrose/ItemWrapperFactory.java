package com.gildedrose;

public class ItemWrapperFactory {

    private ItemWrapperFactory() {
    }

    public static ItemWrapper create(Item item) {
        return new ItemWrapper(item);
    }
}
