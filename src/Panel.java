import processing.core.PImage;

public class Panel {
    private int x, y;
    private int w, h;
    private PImage img;
    //private int identifier;
    //private PApplet pApplet;

    public Panel (int _x, int _y, int _w, int _h) {
        //pApplet = _pApplet;
        x = _x;
        y = _y;
        w = _w;
        h = _h;
        //identifier = _identifier;
    }

    public void setupImage(String name) {
        img = Main.app.loadImage(name);
    }

    public void display() {
        Main.app.image(img, x, y, w, h);
    }

    public void handleMouseClicked(int x, int y) {
        System.out.println("Mouse clicked");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public void setX(int _x) {
        x = _x;
    }

    public void setY(int _y) {
        y = _y;
    }

    public PImage getImage() {
        return img.copy();
    }
}
