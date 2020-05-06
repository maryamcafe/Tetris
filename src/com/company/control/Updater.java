package com.company.control;

import com.company.util.Mapper;

public class Updater {

    private Mapper mapper = Mapper.getInstance();
    private Level level = mapper.getLevel();
    //update blocks
    //update score
    //show top scores
    //show omitted lines
    public void update(){
        updateLevel();
    }

    private void updateLevel() {
        //the current block should come down till it "hits" the ground. so we have a y = ground(x)

    }

    private void updateBlocks() {
        //listen to the keyboard,
    }

}
