package com.company.model;

public class Vector2D {
    private int x,y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void add(Vector2D v){
        x += v.getX();
        y += v.getY();
    }

    public void addX(int x){
        this.x += x;
    }

    public void addY(int y){
        this.y += y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector2D))
            return false;
        Vector2D vector = (Vector2D) obj;
        return this.x == vector.getX() && this.y == vector.getY();
    }
}
