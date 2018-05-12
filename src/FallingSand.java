import Material.Grid;
import processing.core.PApplet;

public class FallingSand extends PApplet {

    public void settings(){
        size(32, 32);
    }

    private Grid grid;
    private int brushSize;

    public void setup() {
        brushSize = 4;
        grid = new Grid(this);
        for (int i = 0; i < width; i++) {
            grid.addCell(i, height - 10, RIGHT);
        }
    }

    public void draw(){
        background(0);
        int brushHalf = brushSize/2;

        if (mousePressed) {
            int type = mouseButton;
            for (int i = mouseX - brushHalf; i <= mouseX + brushHalf; i++)
                for (int j = mouseY - brushHalf; j <= mouseY + brushHalf; j++) {
                    grid.addCell(i, j, type);
                }
        }
        grid.update();
//        println(frameRate);
    }

    public static void main(String[] args){
        PApplet.main("FallingSand");
    }

}
