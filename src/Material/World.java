package Material;

import java.util.ArrayList;
import processing.core.PApplet;


public class World {

    PApplet sketch;
    private final int oX, oY, w, h, px;
    ArrayList<ArrayList<Chunk>> chunks;

    public World(PApplet s, int x, int y, int _w, int _h, int p) {
        sketch = s;
        oX = x; oY = y; w = _w; h = _h; px = p;
        chunks = initialiseChunks();
    }

    public void update() {
        for (ArrayList<Chunk> row : chunks) {
            for (Chunk chunk : row) {
                chunk.update();
            }
        }
    }

    public void addCell(int x, int y, int type) {
        getChunkFromPos(x, y).addCell(x, y, type);
    }

    private Chunk getChunkFromPos(int x, int y) {
        System.out.print(x);
        System.out.print(y);
        return chunks.get(x/(w*px)).get(y/(h*px));
    }

    private ArrayList<ArrayList<Chunk>> initialiseChunks() {

        ArrayList<ArrayList<Chunk>> newChunks = new ArrayList<>();
        int x = oX, y = oY;
        ArrayList<Chunk> row;
        for (int i = 0; i < w; i++) {
            x += px;
            row  = new ArrayList<>();
            for (int j = 0; j < h; j++) {
                y += px;
                row.add(new Chunk(sketch, x, y, px));
            }
            newChunks.add(row);
        }

        return newChunks;

    }

}
