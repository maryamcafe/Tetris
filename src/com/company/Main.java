package com.company;

import com.company.gui.Display;
import com.company.model.Block;
import com.company.model.BlockObjectPool;
import com.company.model.BlockType;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random(System.nanoTime());

        //        int width = 1200;
//        int height = 800;
//        TPanel TPanel = new TPanel(width, height);
//
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.getContentPane().add(TPanel);
//        frame.setSize(1200, 800);
//        frame.setLocationRelativeTo(null);
//        frame.setTitle("TestFrame");
//        frame.setResizable(false);
//        frame.setVisible(true);

//        int a = GraphicsConfig.getInstance().getBoxSize();
//        System.out.println(a);

        try {
            Display display = new Display(24,16);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }



//        for (int i = 0; i < 100; i++) {
////            int r = random.nextInt(7);
////            System.out.println(BlockType.values()[r]);
//            List<Block> blocks = new LinkedList<>();
//            BlockObjectPool blocksPool = new BlockObjectPool(blocks);
//            Block newBlock = blocksPool.checkout();
//            System.out.println(newBlock.toString());
//        }


//        System.out.format("Our box size is: %f and %f%n", 337/3f , 225/2f);
//        String b = GraphicsConfig.getInstance().getbackgroungImg();
//        System.out.println(b);
//
//        for(int i = 0; i < 100; i++)
//            BlockFactory.createNew();
//        System.out.println(-GameConstants.getInstance().getSpeed());
    }
}
