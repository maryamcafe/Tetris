package com.company.util;

import com.company.control.GameState;
import com.company.control.Level;
import com.company.gui.Display;

public class Mapper {
    private static Mapper instance;
    private Level level;

    private int rows, columns, width, height;

    private Mapper(){

    }

    public static Mapper getInstance(){
        if (instance == null){
            instance = new Mapper();
        }
        return instance;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

}
