package com.company.util;

import com.company.gui.TPanel;

public class GraphicsConfig {
    private static GraphicsConfig graphicsConfig;

    private ConfigReader configs;
    private String backgroundImg;
    private TPanel panel;

    private int boxSize, sidebarWidth, topMargin, sideMargin;
    private int maxPanelWidth, maxPanelHeight, maxRows, maxColumns;

    private GraphicsConfig() {
        initialize();
//        this.panel = panel;
    }

    public static GraphicsConfig getInstance() {
        if (graphicsConfig == null) {
            graphicsConfig = new GraphicsConfig();
        }
        return graphicsConfig;
    }

//    public static GraphicsConfig getInstance(TPanel panel){
//        if (graphicsConfig == null) {
//            graphicsConfig = new GraphicsConfig(panel);
//        }
//        return graphicsConfig;
//    }




    private void initialize() {

        configs = ConfigLoader.getInstance().getGraphicConfig();

        boxSize = configs.readInt("boxSize");
        sidebarWidth = configs.readInt("sidebarWidth");
        sideMargin = 3 *  configs.readInt("sideMargin");;
        topMargin = 2 * configs.readInt("topMargin");
        backgroundImg = configs.getProperty("backgroundImg");
        maxPanelWidth = configs.readInt("maxPanelWidth");
        maxPanelHeight = configs.readInt("maxPanelHeight");
        maxRows = (maxPanelHeight - topMargin)/boxSize;
        maxColumns = (maxPanelWidth - sidebarWidth - sideMargin )/boxSize;
        System.out.println("maxRows is: "  + maxRows + " and maxColumns is: " +  maxColumns);
    }

    public int getBoxSize() {
        return boxSize;
    }

    public int getSidebarWidth() {
        return sidebarWidth;
    }

    public int getTopMargin() {
        return topMargin;
    }

    public int getSideMargin() {
        return sideMargin;
    }

    public int getMaxRows() {
        return maxRows;
    }

    public int getMaxColumns() {
        return maxColumns;
    }

    public String getbackgroungImg() {
        return backgroundImg;
    }


}
