package com.company.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private GameAction.Request request;

    public MyActionListener(GameAction.Request request){
        this.request = request;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameAction.getInstance().addRequest(request);
    }

    public GameAction.Request getRequest() {
        return request;
    }
}
