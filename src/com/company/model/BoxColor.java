package com.company.model;

public enum BoxColor {

    RED("red"),
    BLUE("blue"),
    PINK("pink"),
    ORANGE("orange"),
    CREAM("cream"),
    TOR("tortoise"),
    TAN("tangerine"),
    DEFAULT("tangerine");

    private String name;

    BoxColor(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
