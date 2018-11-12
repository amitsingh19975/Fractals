package Fractals;
import java.util.*;

import processing.core.PApplet;

public class CantorSet extends Fractal {
    static String A = "";
    public CantorSet(String s, float l, float t, PApplet p) {
        super(s, l, t, p);
    }

    @Override
    public void render() {
        A += todo;
        p.strokeWeight(3);
        p.pushMatrix();
        float len = (float)p.width-200;

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == 'A') {
                p.line(0, 0, len, 0);
                p.translate(len, 0);
            } else if (c == 'B') {
                p.translate(len, 0);
            } else{
                p.popMatrix();
                p.translate(0, 30);
                len /= 3;
                p.pushMatrix();
            }
        }
        p.strokeWeight(1);
    }


}
