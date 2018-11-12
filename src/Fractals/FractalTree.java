package Fractals;

import processing.core.PApplet;

public class FractalTree extends Fractal {

    public FractalTree(String s, float l, float t, PApplet p) {
        super(s, l, t, p);
    }

    @Override
    public void render() {

        for(int i = 0; i < todo.length(); i++){
            char c = todo.charAt(i);
            if (c == '1') {
                p.line(0, 0, len, 0);
                p.translate(len, 0);
            } else if (c == '[') {
                p.pushMatrix();
                p.rotate(p.radians(-45));
            } else if (c == ']') {
                p.popMatrix();
                p.rotate(p.radians(45));
            }else if( c == '0'){
                p.line(0, 0, len, 0);
            }
        }
    }
}
