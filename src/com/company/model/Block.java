package com.company.model;

import com.company.util.GameConstants;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

import static com.company.model.BoxVector.addColor;


public class Block {

    private BoxVector position;
    private BoxColor color;
    private BlockType type;
    private BoxVector speed;
    private List<BoxVector> boxes;
    private List<BoxVector> filledBoxes;


    public Block(BoxVector position, BlockType type, BoxColor color) {
        this.position = position;
        this.color = color;
        this.type = type;
        speed = new BoxVector(0, GameConstants.getInstance().getSpeed());
        initFilledBoxes();
    }

    private void initFilledBoxes() {
        boxes = getAbsolutePosition(type.getInitialFilledBoxes());
        filledBoxes = addColor(boxes, color);
    }

    private List<BoxVector> getAbsolutePosition(List<BoxVector> relativeBoxes) {
        List<BoxVector> absoluteBoxes = new LinkedList<>();
        for(BoxVector box : relativeBoxes){
            absoluteBoxes.add(box.addBoxVector(position));
        }
        return absoluteBoxes;
    }

    // we assume that each block turns about it's center
    public void rotate() {
        //all blocks rotate but MORABA does'nt.
        if (this.type == BlockType.MORABA) {
            return;
        }
        if (enoughSpace()) {
            for (BoxVector box : this.filledBoxes) {
                box.rotateAboutCenter();
            }
        }
    }

    private boolean enoughSpace() {
        return true;
    }

    public void move(){
        this.setPosition(this.getPosition().addBoxVector(speed));
    }

    public BoxVector getCenter() {
        return type.getCenter().addBoxVector(position);
    }

    @Override
    public String toString() {
        return String.format("This is a %s block", this.getType().toString());
    }

    public BoxVector getPosition() {
        return position;
    }

    public void setPosition(BoxVector position) {
        this.position = position;
    }

    public List<BoxVector> getBoxes() {
        return boxes;
    }

    public List<BoxVector> getFilledBoxes() {
        return filledBoxes;
    }

    public BlockType getType() {
        return type;
    }

    public BoxColor getColor() {
        return color;
    }
}
