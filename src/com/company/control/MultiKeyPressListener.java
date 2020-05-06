package com.company.control;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MultiKeyPressListener implements KeyListener {
    // Set of currently pressed keys
    private final Set<Integer> pressedKeys = new HashSet<>();

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        Point offset = new Point();
        if (!pressedKeys.isEmpty()) {
            for (Iterator<Integer> it = pressedKeys.iterator(); it.hasNext();) {
                switch (it.next()) {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        offset.y = -1;
                        break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        offset.x = -1;
                        break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        offset.y = 1;
                        break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        offset.x = 1;
                        break;
                }
            }
        }
        System.out.println(offset); // Do something with the offset.
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) { /* Not used */ }

    public static void main(String[] args) {
        MultiKeyPressListener listener ;
    }


}