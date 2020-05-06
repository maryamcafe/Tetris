package com.company.model;

import java.util.LinkedList;
import java.util.List;

public enum BlockType {
    KOOH(3, 2) {
        @Override
        protected void setFillBoxes() {
            initialFilledBoxes.add(new BoxVector(0, 0).addBoxVector(center));//center itself
            initialFilledBoxes.add(new BoxVector(0, 1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(1, 0).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(-1, 0).addBoxVector(center));
        }
    },
    CHOOB(1, 4) {
        @Override
        protected void setFillBoxes() {
            initialFilledBoxes.add(new BoxVector(0, 0).addBoxVector(center));//center itself
            initialFilledBoxes.add(new BoxVector(0, -1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(0, 1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(0, 2).addBoxVector(center));
        }
    },
    MORABA(2, 2) {
        @Override
        protected void setFillBoxes() {
            initialFilledBoxes.add(new BoxVector(0, 0).addBoxVector(center));//center
            initialFilledBoxes.add(new BoxVector(-1, -1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(-1, 0).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(0, -1).addBoxVector(center));
        }
    },
    OrdakR(3, 2) {
        @Override
        protected void setFillBoxes() {
            initialFilledBoxes.add(new BoxVector(0, 0).addBoxVector(center));//center
            initialFilledBoxes.add(new BoxVector(0, -1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(1, 1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(-1, 0).addBoxVector(center));
        }
    },
    OrdakCH(3, 2) {
        @Override
        protected void setFillBoxes() {
            initialFilledBoxes.add(new BoxVector(0, 0).addBoxVector(center));//center itself
            initialFilledBoxes.add(new BoxVector(0, -1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(-1, -1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(1, 0).addBoxVector(center));
        }
    },
    PayeR(2, 3) {
        @Override
        protected void setFillBoxes() {
            initialFilledBoxes.add(new BoxVector(-1, 0).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(-1, 1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(-1, -1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(0, 1).addBoxVector(center));
        }
    },
    PayeCh(2, 3) {
        @Override
        protected void setFillBoxes() {
            initialFilledBoxes.add(new BoxVector(0, 0).addBoxVector(center)); //center itself
            initialFilledBoxes.add(new BoxVector(0, -1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(0, 1).addBoxVector(center));
            initialFilledBoxes.add(new BoxVector(-1, 1).addBoxVector(center));
        }
    };

    private int width, height;

    // center is relative to upper right point of each shape.
    protected final BoxVector center = new BoxVector(1,1);

    // each block's fill boxes relative to the "center"
    protected List<BoxVector> initialFilledBoxes = new LinkedList<>();
    protected abstract void setFillBoxes();

    BlockType(int width, int height) {
        this.width = width;
        this.height = height;
        setFillBoxes();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<BoxVector> getInitialFilledBoxes() {
        return initialFilledBoxes;
    }

    public BoxVector getCenter() {
        return center;
    }
}

