package Fractals;

import processing.core.PApplet;

public class FractalPlant extends Fractal{
    public FractalPlant(String s, float l, float t, PApplet p) {
        super(s, l, t, p);
    }

    @Override
    public void render() {
        for(int i = 0; i < todo.length(); i++){
            char c = todo.charAt(i);
            if (c == 'F') {
                p.line(0, 0, len, 0);
                p.translate(len, 0);
            }else if(c == '+'){
                p.rotate(p.radians(25));
            }else if( c == '-'){
                p.rotate(p.radians(-25));
            }else if(c=='['){
                p.pushMatrix();
            }else if(c==']'){
                p.popMatrix();
            }
        }
    }
}
