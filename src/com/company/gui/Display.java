package com.company.gui;

import com.company.util.GraphicsConfig;
import com.company.util.Mapper;

import javax.swing.*;
import java.awt.*;

public class Display {

    private GraphicsConfig config = GraphicsConfig.getInstance();
    private JFrame frame;
    private  JPanel panel;
    private int rows, columns, width, height, boxSize, sidebarWidth, topMargin, sideMargin;

    public Display(int rows, int columns) {
        int maxRows = config.getMaxRows();
        int maxColumns = config.getMaxColumns();
        if (rows > maxRows){
            System.out.println("Number of rows exceeded, panel is created with maximum number of rows.");
            rows = maxRows;
        }
        if (columns > maxColumns) {
            System.out.println("Number of columns exceeded, panel is created with maximum number of columns.");
            columns = maxColumns;
        }
        System.out.println("rows are: " + rows + " and columns are: " + columns);
        this.rows = rows;
        this.columns = columns;
        init();
    }

    private void init()  {
        setConfigs();
        setSize();
        initializeFrame();
        initializePanel();

        frame.add(panel);
        frame.pack();
    }

    private void initializeFrame() {
        frame = new JFrame("Tetris");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initializePanel() {
        panel = new TPanel(rows, columns);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
    }

    private void setConfigs() {
        GraphicsConfig config = GraphicsConfig.getInstance();
        boxSize = config.getBoxSize();
        sidebarWidth = config.getSidebarWidth();
        topMargin = config.getTopMargin();
        sideMargin = config.getSideMargin();
    }

    private void setSize(){
        width = rows * boxSize + sidebarWidth + sideMargin ;
        Mapper.getInstance().setWidth(width);
        height = columns * boxSize + topMargin;
        Mapper.getInstance().setHeight(height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
