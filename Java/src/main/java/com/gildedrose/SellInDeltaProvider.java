package com.gildedrose;

public class SellInDeltaProvider {

    public static int getSellInDelta(ItemWrapper itemWrapper) {
        switch (itemWrapper.getSellInUpdateBehaviour()) {
            case DEFAULT_DECREASING:
                return -1;
            case STATIC:
                return 0;
            default:
                throw new UnsupportedOperationException("SellInUpdateBehaviour '" + itemWrapper.getSellInUpdateBehaviour().name() + "' has not been implemented");
        }
    }
}
