package com.company.model;

import java.util.List;

public class MovingBlock  {

    private BlockType type;
    private BoxVector speed;
    private List<BoxVector> filledBoxes;

    public MovingBlock(BoxVector position, BlockType type, BoxColor color) {
//        super(position, color);
        this.type = type;

    }
}
