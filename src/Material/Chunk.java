package Material;

import processing.core.PApplet;

import java.util.ArrayList;

import static processing.core.PConstants.RIGHT;

public class Chunk {
    private PApplet sketch;
    private int oX, oY, px;
    private ArrayList<Cell> cells;
    public Chunk(PApplet s, int x, int y, int p) {
        sketch = s;
        oX = x; oY = y; px = p;
        cells = new ArrayList<>();
    }
    public void addCell(int x, int y, int type) {
        for (Cell s: cells) {
            if (s.getX() == x && s.getY() == y) s.remove();
        }
        if (type == RIGHT) cells.add(new Stone(sketch, x, y));
        else cells.add(new Cell(sketch, x, y));
    }
    public void update() {
        for (int i = 0; i < cells.size(); i++) {
            Cell s = cells.get(i);
            s.setNeighboursUnderneath(cells);
            s.update();
            if (s.isOutOfBounds()) cells.remove(i);
            s.display();
        }
    }
}
