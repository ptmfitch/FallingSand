package Material;

import processing.core.PApplet;

public class Stone extends Cell {
    Stone(PApplet _s, int _x, int _y) {
        super(_s, _x, _y);
    }

    @Override
    public void update() {
        // DO NOTHING
    }

    @Override
    public void display() {
        super.sketch.noStroke();
        super.sketch.fill(100);
        super.sketch.rect(x, y, 1, 1);
    }

}
