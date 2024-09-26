import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {
    public static PApplet app;
    final int vertical = 5;
    final int horizontal = 4;
    private ArrayList<Panel> panels = new ArrayList<Panel>(horizontal * vertical);

    public static void main(String[] args) {
        //String[] processingArgs = {"Image Processing Migration Project"};
        //Main mySketch = new Main();
        //PApplet.runSketch(processingArgs, mySketch);
        PApplet.main("Main");
    }

    public Main() {
        super();
        app = this;
    }

    public void settings() {
        size(400, 500);
    }

    public void setup() {
        int h = height / vertical;
        int w = width / horizontal;
        int index = 0;
        Panel p;

        for (int j = 0; j < horizontal; j++) {
            for (int i = 0; i < vertical; i++) {
                int x = j * w;
                int y = i * h;
                if (i % 5 == 0) {
                    p = new ContrastedPanel(x, y, w, h);
                } else if (i % 5 == 1) {
                    p = new TintedPanel(x, y, w, h);
                } else if (i % 5 == 2) {
                    p = new Panel(x, y, w, h);
                } else if (i % 5 == 3) {
                    p = new RotatingPanel(x, y, w, h);
                } else {
                    p = new CustomPanel(x, y, w, h);
                }

                p.setupImage("data/frog.png");
                panels.add(p);
                index++;
            }
        }
    }

    public void draw() {
        fancyBackground();
        for (int i = 0; i < panels.size(); i++) {
            panels.get(i).display();
        }
    }

    public void mouseClicked() {
        for (int i = 0; i < panels.size(); i++) {
            panels.get(i).handleMouseClicked(mouseX, mouseY);
        }
    }

    public void keyPressed() {
        if (key == 's') {
            System.out.println("key s is pressed");
            Panel first = panels.getFirst();
            Panel last = panels.getLast();
            panels.set(0, last);
            panels.set(panels.size() - 1, first);
            int tempX = first.getX();
            int tempY = first.getY();
            first.setX(last.getX());
            first.setY(last.getY());
            last.setX(tempX);
            last.setY(tempY);
        }
        if (key == 'r') {
            System.out.println("key r is pressed");
            int index = (int) random(0, panels.size() - 1);
            if (!(panels.get(index) instanceof ContrastedPanel)){
                int xx = panels.get(index).getX();
                int yy = panels.get(index).getY();
                Panel a = new ContrastedPanel(xx, yy, width / horizontal, height / vertical);
                a.setupImage("data/frog.png");
                panels.set(index, a);
            } else {
                int xx = panels.get(index).getX();
                int yy = panels.get(index).getY();
                Panel a = new CustomPanel(xx, yy, width / horizontal, height / vertical);
                a.setupImage("data/frog.png");
                panels.set(index, a);
            }
        }
    }

    public void fancyBackground() {
        loadPixels();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int loc = x + (y * width);
                if (x % 5 < 2) {
                    pixels[loc] = color(255);
                } else {
                    pixels[loc] = color(219, 227, 218);
                }
            }
        }

        updatePixels();

    }
}
