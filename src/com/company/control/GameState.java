package com.company.control;

import com.company.interfaces.Updatable;
import com.company.model.*;
import com.company.util.GameConstants;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameState implements Updatable {

    private Player palyer;
    private GameConstants constants = GameConstants.getInstance();

    private Level level;
    private Block currentBlock;
    private Ground ground;

    private int columns, rows, rowsOmitted, previousOmitted;
    private boolean gameOver;

    private List<Block> blocks;
    private BlockObjectPool blocksPool;

    public GameState(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        initialize();
    }

    private void initialize() {
        palyer = new Player();
        ground = new Ground(rows, columns, this);

        blocks = Collections.synchronizedList(new LinkedList<>());
        blocksPool = new BlockObjectPool(blocks);

        gameOver = false;
        rowsOmitted = 0;
    }

    public void update(){
        createNewBlock();

        level = new Level(this);
        while (!level.isLevelFinish()) {
            level.run(); // at the end of each level
        }
        ground.update();
        if (rowsOmitted > previousOmitted){
            addScores(4*(rowsOmitted - previousOmitted));
        } else {
            addScores(1);
        }

    }

    private void createNewBlock() {
        currentBlock = blocksPool.checkout();
    }

    public void addScores(int scores) {
        palyer.addScores(scores);
    }

    public Block getCurrentBlock() {
        return currentBlock;
    }


    @Override
    public String toString() {
        return "GameState{" +
                "currentBlock=" + currentBlock +
                '}';
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getRowsOmitted() {
        return rowsOmitted;
    }

    public void setRowsOmitted(int rowsOmitted) {
        this.rowsOmitted = rowsOmitted;
    }

    public Ground getGround() {
        return ground;
    }
}