package com.company.model;

public class Player {

    private int scores;

    public Player(){
        scores = 0;
    }

    public void addScores(int scores){
        this.scores += scores;
    }

    public int getScores() {
        return scores;
    }

}
