import Material.Chunk;
import Material.World;
import processing.core.PApplet;

public class FallingSand extends PApplet {

    private int CHUNK_SIZE = 32;
    private int GRID_H = 4;
    private int GRID_W = 4;

    public void settings(){
        size(CHUNK_SIZE * GRID_W, CHUNK_SIZE * GRID_H);
    }

    private World world;
    private int brushSize;

    public void setup() {
        brushSize = 4;
        world = new World(this, 0, 0, GRID_H, GRID_W, CHUNK_SIZE);
    }

    public void draw(){
        background(0);
        int brushHalf = brushSize/2;

        if (mousePressed) {
            int type = mouseButton;
            for (int i = mouseX - brushHalf; i <= mouseX + brushHalf; i++)
                for (int j = mouseY - brushHalf; j <= mouseY + brushHalf; j++) {
                    world.addCell(i, j, type);
                }
        }
        world.update();
//        println(frameRate);
    }

    public static void main(String[] args){
        PApplet.main("FallingSand");
    }

}
