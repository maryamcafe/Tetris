package com.company.gui;

import com.company.control.GameAction;
import com.company.control.GameState;
import com.company.control.Level;
import com.company.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TPanel extends JPanel {

    private Mapper mapper;
    private GameState gameState;
    private GameAction gameAction;
    private Level level;

    private Drawer drawer;
    private int rows, columns;


    public TPanel(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        initialize();
        start();
    }

    private void initialize(){
        mapper = Mapper.getInstance();
        mapper.setRows(rows);
        mapper.setColumns(columns);
        // creating the first level
        mapper.setLevel(level);
        gameState = level.getGameState();

        gameAction = GameAction.getInstance();
    }


    public void start(){
        javax.swing.Timer timer = new javax.swing.Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               tick();
               render();
            }
        });
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        if(drawer == null) {
            drawer = new Drawer(g2d, rows, columns);
        }
        drawer.setGraphics2D(g2d);
        requestFocus();

        drawer.drawBgImage();
        if (gameState.isGameOver()){
            drawer.drawGameOver();
        } else {
            drawer.drawGameState(gameState);
        }
    }

    public void tick(){
        gameAction.executeRequests();
        gameState.update();
    }

    private void render() {
        repaint();
        revalidate();
    }



}
