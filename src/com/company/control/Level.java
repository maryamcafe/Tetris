package com.company.control;

import com.company.model.*;
import com.company.util.Mapper;

import java.util.*;

public class Level implements Runnable {

    private GameState gameState;
    private Block block;
    private Ground ground;
    private boolean levelFinish;


    public Level(GameState gameState) {
        this.gameState = gameState;
        levelFinish = false;
        block = gameState.getCurrentBlock();
        ground = gameState.getGround();
    }



    @Override
    public void run() {
        System.out.println("In Level.run: " + gameState.toString());
        if( ground.isGameOver()){
            gameState.setGameOver(true);
        }
        //the current block should come down till it "hits" the ground.
        if (ground.hitTheGround()) {
            levelFinish = true;
            //  levelFirstGameState = gameState; // this was meant to be for memento...
        } else {
            block.move();
        }
    }


    public boolean isLevelFinish() {
        return levelFinish;
    }

}
