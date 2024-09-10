import processing.core.PImage;

public class ContrastedPanel extends Panel {

    public ContrastedPanel(int _x, int _y, int _w, int _h) {
        super(_x, _y, _w, _h);
    }

    public void display() {
        PImage i = getImage();
        i.loadPixels();
        for (int x = 0; x < i.width; x++) {
            for (int y = 0; y < i.height; y++) {
                int loc = x + (y * i.width);
                if (Main.app.brightness(i.pixels[loc]) > 190) {
                    i.pixels[loc] = Main.app.color(255);
                } else {
                    i.pixels[loc] = Main.app.color(0, 0);
                }
            }
            i.updatePixels();
            Main.app.image(i, getX(), getY(), getW(), getH());
        }
    }
}
