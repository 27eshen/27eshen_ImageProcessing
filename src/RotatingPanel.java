import static javax.swing.SwingConstants.CENTER;
import static processing.core.PApplet.radians;
import static processing.core.PConstants.CORNER;

public class RotatingPanel extends Panel {
    private boolean rotating;
    private float degrees;

    public RotatingPanel(int _x, int _y, int _w, int _h) {
        super(_x, _y, _w, _h);
        rotating = false;
        degrees = 1;
    }

    public void display() {
        Main.app.tint(100, 200, 200);
        if (!rotating) {
            super.display();
        } else {
            Main.app.push();
            Main.app.imageMode(CENTER);
            int x = getX();
            int y = getY();

            Main.app.translate(getX() + getW()/2, getY() + getH()/2);
            Main.app.rotate(radians(degrees));
            degrees+=10;
            setX(0);
            setY(0);
            super.display();

            setX(x);
            setY(y);
            Main.app.imageMode(CORNER);
            Main.app.pop();
        }
        Main.app.noTint();
    }

    public void handleMouseClicked(int _mx, int _my) {
        if (_mx > getX() && _mx < (getX() + getW()) && _my > getY() && _my < (getY() + getH())) {
            rotating = !rotating;
        }
    }
}
