package com.company.model;

import java.util.Random;

public class BlockFactory {

    private Random random = new Random(System.nanoTime());
    private int count = 0;


    public Block createNew() {
        count++;
//        System.out.println(count + " blocks created.");
        int numberOfTypes = BlockType.values().length; // = 7
        BlockType type =  BlockType.values()[random.nextInt(numberOfTypes)];
        BoxColor color = BoxColor.values()[random.nextInt(7)];

        int x = 0;
        int y = - type.getHeight();

        return new Block(new BoxVector(x,y), type, color);

    }
}
