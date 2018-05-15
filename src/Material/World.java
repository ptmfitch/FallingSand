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

    public addCell(int x, int y, int type) {

    }

    private Chunk getChunkFromPos(int x, int y) {
        chunks.get()
    }

    private ArrayList<ArrayList<Chunk>> initialiseChunks() {

        ArrayList<ArrayList<Chunk>> cs = new ArrayList<>();
        int x = oX, y = oY;

        for (int i = 0; i < w; i++) {
            x += px;
            for (int j = 0; j < h; j++) {
                y += px;
                chunks.get(i).add(new Chunk(sketch, x, y, px));
            }
        }

        return cs;

    }

}
