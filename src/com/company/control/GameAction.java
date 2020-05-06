package com.company.control;

import com.company.model.BoxVector;
import com.company.interfaces.MyExecutable;
import com.company.model.Block;
import com.company.util.GameConstants;
import com.company.util.Mapper;

import java.util.Iterator;
import java.util.LinkedList;

public class GameAction {

    private static GameAction instance = new GameAction();

    private static Mapper mapper;
    private static GameState gameState;
    private static GameConstants constants;
    private static Level level;


    private GameAction(){
        mapper = Mapper.getInstance();
        gameState = mapper.getGameState();
        constants = GameConstants.getInstance();
        requests = new LinkedList<>();
    }


    public static GameAction getInstance() {
        return instance;
    }

    public void addRequest(Request request) {
        if(request != null)
            requests.add(request);
    }

    public void executeRequests() {
        for (Iterator<Request> requestIterator = requests.iterator(); requestIterator.hasNext();){
            Request request = requestIterator.next();
            request.execute();
            requestIterator.remove();
        }
    }

    private static void moveRight() {
        Block block = gameState.getCurrentBlock();
        if((block.getPosition().getX() + block.getType().getWidth()) < mapper.getRows()){
            BoxVector forward = new BoxVector(constants.getSpeed(), 0);
            forward.add(block.getPosition());
            block.setPosition(forward);
        }
    }

    private static void moveLeft(){
        Block block = gameState.getCurrentBlock();
        if(block.getPosition().getX() > 0){
            BoxVector backward = new BoxVector(-constants.getSpeed(), 0);
            backward.add(block.getPosition());
            block.setPosition(backward);
        }
    }

    private static void tobe(){
    }


    public enum Request implements MyExecutable {

        BLOCK_MOVE_RIGHT{
            @Override
            public void execute(){
                moveRight();
            }
        }, BLOCK_MOVE_LEFT {
            @Override
            public void execute(){
                moveLeft();
            }
        }, TOBEH {
            @Override
            public void execute(){
                tobe();
            }
        }
    }
}
