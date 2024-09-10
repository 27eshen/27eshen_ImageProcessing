import processing.core.PApplet;

public class Main extends PApplet {
    private final int vertical = 5;
    private final int horizontal = 4;
    private Panel[] panels;
    public static PApplet app;

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
        panels = new Panel[horizontal * vertical];
        int h = height / vertical;
        int w = width / horizontal;
        int index = 0;
        Panel p;

        for (int j = 0; j < horizontal; j++) {
            for (int i = 0; i < vertical; i++) {
                int x = j * w;
                int y = i * h;
                if (i % 5 == 0) {
                    p = new Panel(x, y, w, h);
                } else if (i % 5 == 1) {
                    p = new TintedPanel(x, y, w, h);
                } else if (i % 5 == 2) {
                    p = new RotatingPanel(x, y, w, h);
                } else if (i % 5 == 3) {
                    p = new ContrastedPanel(x, y, w, h);
                } else {
                    p = new CustomPanel(x, y, w, h);
                }

                p.setupImage("data/frog.png");
                panels[index] = p;
                index++;
            }
        }
    }

    public void draw() {
        fancyBackground();
        for (int i = 0; i < panels.length; i++) {
            panels[i].display();
        }
    }

    public void mouseClicked() {
        for (int i = 0; i < panels.length; i++) {
            panels[i].handleMouseClicked(mouseX, mouseY);
        }
    }

    private void fancyBackground() {
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
