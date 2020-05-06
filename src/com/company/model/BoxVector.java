package com.company.model;

import com.company.util.GraphicsConfig;

import java.util.LinkedList;
import java.util.List;

// this class is created to use boxes instead of pixels for block position, drawing, etc.
public class BoxVector extends Vector2D {
    private int x, y; // indicates the position of upper right corner of each blocj
    private int boxSize = GraphicsConfig.getInstance().getBoxSize();
    private BoxColor color;

    public BoxVector (int x, int y){
        super(x, y);
        color = BoxColor.DEFAULT;
    }

    public BoxVector(int x, int y, BoxColor color) {
        super(x, y);
        this.color = color;
    }

    public static List<BoxVector> addColor(List<BoxVector> vectors, BoxColor color){
        List<BoxVector> filledBoxes = new LinkedList<>();
        for(BoxVector vector : vectors){
            filledBoxes.add(new BoxVector(vector.getX(), vector.getY(), color));
        }
        return filledBoxes;
    }


    public BoxVector addBoxVector(Vector2D v) {
        super.add(v);
        return this;
    }

    public void rotateAboutCenter(){
        int xPrime = this.getY();
        int yPrime = -this.getX();
        this.setX(xPrime);
        this.setY(yPrime);
    }

}
