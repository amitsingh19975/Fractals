package Fractals;

import processing.core.PApplet;

public class SierpinskiTriangle extends Fractal{
    public SierpinskiTriangle(String s, float l, float t, PApplet p) {
        super(s, l, t, p);
    }

    @Override
    public void render() {
        for(int i = 0; i < todo.length(); i++){
            char c = todo.charAt(i);
            if (c == 'F' || c == 'G') {
                p.line(0, 0, len, 0);
                p.translate(len, 0);
            }else if(c == '+'){
                p.rotate(p.radians(-60));
            }else if( c == '-'){
                p.rotate(p.radians(60));
            }

        }
    }
}
