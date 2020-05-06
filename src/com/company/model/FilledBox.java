package com.company.model;

import java.util.LinkedList;
import java.util.List;

public class FilledBox extends BoxVector{

    private Color color;

    public FilledBox(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    public static List<FilledBox> createFilledBoxes(List<BoxVector> vectors, Color color){
        List<FilledBox> filledBoxes = new LinkedList<>();
        for(BoxVector vector : vectors){
            filledBoxes.add(new FilledBox(vector.getX(), vector.getY(), color));
        }
        return filledBoxes;
    }


    public Color getColor() {
        return color;
    }

    public enum Color {
        RED("red"),
        BLUE("blue"),
        PINK("pink"),
        ORANGE("orange"),
        CREAM("cream"),
        TOR("tortoise"),
        TAN("tangerine");

        private String name;

        Color(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


}
