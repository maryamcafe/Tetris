package com.company.model;

import com.company.control.GameState;

import java.util.*;

public class Ground {

    private Set<BoxVector> groundTotal;
    private Map<Integer, Integer> groundSurface;
    private Set<BoxVector> firstRow;
    private GameState gameState;
    private Block block;
    int rows, columns;

    public Ground(int rows, int columns, GameState gameState) {
        this.rows = rows;
        this.columns = columns;
        this.gameState = gameState;
        firstRow = new HashSet<>();
        groundTotal = new HashSet<>();
        groundSurface = new HashMap<>();
        init();
    }
    public void init(){
        block = gameState.getCurrentBlock();
    }

    public boolean hitTheGround() {
        for(BoxVector box : block.getBoxes()) {
            if (box.getY() == groundSurface.get(box.getX()) - 1) {
                return true;
            }
        }
        return false;
    }

    public void update() {
        groundTotal.addAll(block.getFilledBoxes());
        updateFirstRow();
        while (isFirstRowOmitted()){
            gameState.setRowsOmitted(gameState.getRowsOmitted() + 1);
            omitFirstRow();
            shiftRowsDown();
            updateFirstRow();
        }
        updateGroundSurface();
    }

    private void updateGroundSurface() {
        for (BoxVector box : block.getFilledBoxes()){
            //remove old ones, e.g. underneath the recent block
            groundSurface.remove(box.getX());
            //add new ones, e.g. the recent block.
            groundSurface.put(box.getX(), box.getY());
        }
    }

    private boolean isFirstRowOmitted() {
        if (firstRow.size() == columns) {
            return true; // it acts in a recursive manner.
        }
        return false;
    }

    private void omitFirstRow() {
        groundTotal.removeAll(firstRow);
    }

    private void shiftRowsDown() {
        Iterator<BoxVector> iterator = groundTotal.iterator();
        while (iterator.hasNext()){
            int y = iterator.next().getY();
            iterator.next().setY(y+1);
        }
    }

    private void updateFirstRow() {        
        for (BoxVector box : groundTotal) {
            if (box.getY() == rows) { // first row is actually the last.
                firstRow.add(box);
            }
        }
    }

    public Set<BoxVector> getGroundTotal() {
        return groundTotal;
    }

    public Map<Integer, Integer> getGroundSurface() {
        return groundSurface;
    }

    public Set<BoxVector> getFirstRow() {
        return firstRow;
    }

    public boolean isGameOver() {
        //when the ground surface reaches row number 1: return true, else return false.
        return groundSurface.get(columns / 2) == 1;
    }
}
