package com.company.util;

public class GameConstants {

    private static GameConstants instance = new GameConstants();
    private ConfigReader configs;

    private int speed;


    private GameConstants(){
        configs = ConfigLoader.getInstance().getGameConstants();
        init();
    }

    public static GameConstants getInstance() {
        return instance;
    }

    private void init() {
        speed = configs.readInt("speed"); //speed = 1box at a time;
    }

    public int getSpeed() {
        return speed;
    }

    public int getConstant(String name) {
        return configs.readInt(name);
    }

    public int getBolckPoolNumber() {
        return configs.readInt("blocksNumber");
    }
}
