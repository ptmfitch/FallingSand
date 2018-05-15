package Material;

import processing.core.PApplet;

import java.util.ArrayList;

public class Cell {

    PApplet sketch;
    int x, y;
    private ArrayList<Cell> neighbours;

    Cell(PApplet s, int col, int row) {
        sketch = s;
        x = col;
        y = row;
        neighbours = new ArrayList<>();
    }

    public void update() {
        if (neighbours.isEmpty()) {
            fall(0);
            return;
        } else if (neighbours.size() == 3) {
            return;
        }
        Cell cellUnderneath = getCellUnderneath();
        if (cellUnderneath == null) {
            fall(0);
            return;
        }
        ArrayList<Cell> cellsDiagonalBelow = getCellsDiagonalBelow();
        if (cellsDiagonalBelow.isEmpty()) {
            int dir = 1;
            if (Math.random() < 0.5) dir = -1;
            fall(dir);
        } else if (cellsDiagonalBelow.size() == 2) {
        } else if (cellsDiagonalBelow.get(0).isAtCol(x-1)) {
            fall(1);
        } else {
            fall(-1);
        }
    }

    void display() {
        sketch.noStroke();
        sketch.fill(255, 240, 201);
        sketch.rect(x, y, 1, 1);
    }

    private void fall(int dir) {
        y+=1;
        x+=dir;
    }

    void remove() { // TODO make a non hack version of this
        y = -2;
    }

    void setNeighboursUnderneath(ArrayList<Cell> grid) {
        neighbours = new ArrayList<>();
        int row = y+1;
        int lCol = x-1;
        int rCol = x+1;
        for (Cell s : grid) {
            if (s.isAtRow(row) && (s.isAtCol(lCol) || s.isAtCol(x) || s.isAtCol(rCol))) {
                neighbours.add(s);
            }
        }
    }

    boolean isOutOfBounds() {
        return x < 0 || x >= sketch.width || y < 0 || y >= sketch.height;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    private Cell getCellUnderneath() {
        int below = y + 1;
        for (Cell s: neighbours) {
            if (s.isAtPos(x, below)) return s;
        }
        return null;
    }

    private boolean isAtRow(int _y) {
        return y == _y;
    }

    private boolean isAtCol(int _x) {
        return x == _x;
    }

    private boolean isAtPos(int _x, int _y) {
        return x == _x && y == _y;
    }

    private ArrayList<Cell> getCellsDiagonalBelow() {
        int below = y + 1;
        ArrayList<Cell> row = new ArrayList<>();
        for (Cell s: neighbours) {
            if (s.isAtRow(below) && !s.isAtCol(x)) row.add(s);
        }
        return row;
    }

}
