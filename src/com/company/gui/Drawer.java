package com.company.gui;

import com.company.control.GameState;
import com.company.model.Block;
import com.company.util.GraphicsConfig;
import com.company.util.ImageLoader;
import com.company.util.Mapper;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawer {

    private Graphics2D g2d;
    private int rows, columns, width, height, boxSize, gridWidth, gridHeight;
    private BufferedImage grid, sideBar, sideMargin, topMargin,
            choob, kooh, moraba, ordakR, ordakCH, payeR, payeCh;
    private BufferedImage blockImage;

    public Drawer(Graphics2D g2d, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.g2d = g2d;
        init();
    }

    public void init() {
        GraphicsConfig config = GraphicsConfig.getInstance();
        boxSize = config.getBoxSize();
//        sideBar

        width = Mapper.getInstance().getWidth();
        height = Mapper.getInstance().getHeight();


        grid = ImageLoader.loadImage("grid");
        sideMargin = ImageLoader.loadImage("sideMargin");
        topMargin = ImageLoader.loadImage("topMargin");
        sideBar = ImageLoader.loadImage("sideBar");

        gridWidth = columns * boxSize;
        gridHeight = rows * boxSize;
        System.out.println("gridWidth is: " + gridWidth + " and gridHeight is: " + gridHeight);


    }


    public void setGraphics2D(Graphics2D g2d) {
        this.g2d = g2d;
    }

    public void drawBgImage() {
        Image croppedGrid = grid.getSubimage(0, 0, gridWidth, gridHeight);
        g2d.drawImage(croppedGrid, 10, 25, null);

    }

    public void drawGameState(GameState gameState) {
//        drawBlock(gameState.getCurrentBlock());
        System.out.println(gameState.getCurrentBlock().toString());
    }

    private void drawBlock(Block block) {
        String imageName = block.getColor().getName();
        blockImage = ImageLoader.loadImage(imageName);
        g2d.drawImage(blockImage, block.getPosition().getX(), block.getPosition().getY(),null);
    }

    public int getPixels(int boxes) {
        return boxes * boxSize;
    }

    public int getBoxes(int pixels) {
        float f = ((float) pixels / (float) boxSize);
        return (int) f;
    }

    public void drawGameOver() {

    }
}
