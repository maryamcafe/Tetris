package com.company.model;

import com.company.util.ObjectPool;

import java.util.List;

public class BlockObjectPool extends ObjectPool<Block> {

    private BlockFactory factory;

    public BlockObjectPool(List<Block> inTheGame) {
        super(inTheGame);
        factory = new BlockFactory();
    }

    @Override
    protected Block create() {
        return factory.createNew();
    }
}
