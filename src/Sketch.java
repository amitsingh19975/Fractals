import Fractals.*;
import processing.core.*;
import processing.event.MouseEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sketch extends PApplet {

    LSystem lsys = null;
    Fractal test = null;
    HashMap<Character,String> ruleset = null;
    int counter = 0;
    int op = 0;
    int r = 0;
    int g = 64;
    int b = 255;
    boolean render = false;

    @Override
    public void settings() {
        size(900,800);
    }

    @Override
    public void setup() {
    }

    @Override
    public void draw() {
        Menu();
        tranlateSet();
        stroke(0);
        if(test != null && render){
            test.render();
        }
        noLoop();
    }

    private void tranlateSet() {
        switch (op){
            case 1:
                translate(width/2,height);
                rotate(-PI/2);
                break;
            case 2:
                translate(100,height/2);
                rotate(0);
                break;
            case 3:
                translate(100,4*height/5);
                rotate(0);
                break;
            case 4:
                translate(250,(3.5f)*height/5);
                rotate(0);
                break;
            case 5:
                translate(width/2,4 * height/5);
                rotate(0);
                break;
            case 6:
                translate(width/2,height);
                rotate(-PI/2);
                break;
        }
    }

    public void Menu(){
        List l = Arrays.asList("Fractal (binary) tree","Cantor set","Koch curve","Sierpinski triangle",
                "Dragon curve","Fractal plant");
        background(255);
        fill(96,125,139);
        textSize(42);
        noStroke();
        rect(0,0,width,60);
        fill(255);
        text("FRACTALS",width/2 - 100,45);
        textSize(15);
        stroke(255);

        resetTitleButton();


        fill(30,136,229);
        stroke(0);
        rect(25,height-90,width/6,50);
        fill(255);
        textSize(30);
        text("Press",60,height-55);

    }

    private void resetTitleButton() {
        if(op == 2){
            fill(r, g, b);
            rect(0,60,width/6,50);
            fill(255);
            text("Cantor set",30,90);
        }else{
            fill(30,136,229);
            rect(0,60,width/6,50);
            fill(255);
            text("Cantor set",30,90);
        }

        if(op == 3){
            fill(r, g, b);
            rect(width/6,60,width/6,50);
            fill(255);
            text("Koch curve",width/6+30,90);
        }else{
            fill(30,136,229);
            rect(width/6,60,width/6,50);
            fill(255);
            text("Koch curve",width/6+30,90);
        }

        if(op == 4){
            fill(r, g, b);
            rect(2*width/6,60,width/6,50);
            fill(255);
            text("Sierpinski triangle",2*width/6 + 10,90);
        }else{
            fill(30,136,229);
            rect(2*width/6,60,width/6,50);
            fill(255);
            text("Sierpinski triangle",2*width/6 + 10,90);
        }

        if(op == 5){
            fill(r, g, b);
            rect(3*width/6,60,width/6,50);
            fill(255);
            text("Dragon curve",3*width/6+25,90);
        }else{
            fill(30,136,229);
            rect(3*width/6,60,width/6,50);
            fill(255);
            text("Dragon curve",3*width/6+25,90);
        }

        if(op == 1){
            fill(r, g, b);
            rect(4*width/6,60,width/6,50);
            fill(255);
            text("Fractals Tree",4*width/6+25,90);
        }else{
            fill(30,136,229);
            rect(4*width/6,60,width/6,50);
            fill(255);
            text("Fractals Tree",4*width/6+25,90);
        }

        if(op == 6){
            fill(r, g, b);
            rect(5*width/6,60,width/6,50);
            fill(255);
            text("Fractal plant",5*width/6+25,90);
        }else{
            fill(30,136,229);
            rect(5*width/6,60,width/6,50);
            fill(255);
            text("Fractal plant",5*width/6+25,90);
        }

    }

    @Override
    public void mousePressed(MouseEvent event) {
        if(boundCheck(event.getX(),event.getY(),25,width/6,height - 90,50)){
            if(counter < 10 && test != null && lsys != null){
                render = true;
                pushMatrix();
                lsys.generate();
                test.setToDo(lsys.getSentence());
                if(op == 3){
                    test.changeLen(0.4f);
                }else if(op == 5){
                    test.changeLen(0.7f);
                }else{
                    test.changeLen(0.5f);
                }
                popMatrix();
                redraw();
                counter++;
            }
        }

        if(boundCheck(event.getX(),event.getY(),0,width/6,60,50)){
            setFractal(2);
            op = 2;
            render = false;
        }

        if(boundCheck(event.getX(),event.getY(),width/6,width/6,60,50)){
            setFractal(3);
            op = 3;
            render = false;
        }

        if(boundCheck(event.getX(),event.getY(),2*width/6,width/6,60,50)){
            setFractal(4);
            op = 4;
            render = false;
        }

        if(boundCheck(event.getX(),event.getY(),3*width/6,width/6,60,50)){
            setFractal(5);
            op = 5;
            render = false;
        }

        if(boundCheck(event.getX(),event.getY(),4*width/6,width/6,60,50)){
            setFractal(1);
            op = 1;
            render = false;
        }

        if(boundCheck(event.getX(),event.getY(),5*width/6,width/6,60,50)){
            setFractal(6);
            op = 6;
            render = false;
        }
        redraw();
    }

    public boolean boundCheck(int X,int Y, int x1,int x2,int y1,int y2){
        return X >= x1 && X <= (x1 + x2) && Y >= y1 && Y <= (y1 + y2);
    }

    public void setFractal(int type){
        this.counter = 0;
        switch (type){
            case 1:
                ruleset = new HashMap<>();
                ruleset.put('1',"11");
                ruleset.put('0',"1[0]0");
                lsys = new LSystem("0",ruleset);
                test = new FractalTree(lsys.getSentence(),height/2,radians(0), this);
                break;
            case 2:
                ruleset = new HashMap<>();
                ruleset.put('A',"ABA");
                ruleset.put('B',"BBB");
                lsys = new LSystem("A&",ruleset);
                test = new CantorSet(lsys.getSentence(),height/2,radians(25), this);
                break;
            case 3:
                ruleset = new HashMap<>();
                ruleset.put('F',"F+F-F-F+F");
                lsys = new LSystem("F",ruleset);
                test = new KochCurve(lsys.getSentence(),height/4,radians(25), this);
                break;
            case 4:
                ruleset = new HashMap<>();
                ruleset.put('F',"G-F-G");
                ruleset.put('G',"F+G+F");
                lsys = new LSystem("F",ruleset);
                test = new SierpinskiTriangle(lsys.getSentence(),height/2,radians(60), this);
                break;
            case 5:
                ruleset = new HashMap<>();
                ruleset.put('X',"X+YF+");
                ruleset.put('Y',"-FX-Y");
                lsys = new LSystem("FX",ruleset);
                test = new DragonCurve(lsys.getSentence(),height/2,radians(90), this);
                break;
            case 6:
                ruleset = new HashMap<>();
                ruleset.put('X',"F+[[X]-X]-F[-FX]+X");
                ruleset.put('F',"FF");
                lsys = new LSystem("X",ruleset);
                test = new FractalPlant(lsys.getSentence(),height/4,radians(25), this);
                break;
        }
    }

}
