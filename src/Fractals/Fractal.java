package Fractals;

import processing.core.PApplet;

public abstract class Fractal {
    String todo;
    float len;
    float theta;
    PApplet p;

    public Fractal(String s,float l, float t,PApplet p){
        todo = s;
        len = l;
        theta = t;
        this.p = p;
    }

    public abstract void render();

    public void setLen(float l) {
        len = l;
    }

    public void changeLen(float percent) {
        len *= percent;
    }

    public void setToDo(String s) {
        todo = s;
    }
}
