import static java.lang.Math.random;

public class CustomPanel extends Panel {
    private boolean click;

    public CustomPanel(int _x, int _y, int _w, int _h) {
        super(_x, _y, _w, _h);
    }

    public void display() {
        int a = (int)Main.app.random(255); //random isn't a thing in java
        int b = (int)Main.app.random(255);
        int c = (int)Main.app.random(255);

        if (!click){
            super.display();
        } else {
            Main.app.tint(a, b, c);
            super.display();
            Main.app.noTint();
        }
    }


    public void handleMouseClicked(int _mx, int _my) {
        if (_mx > getX() && _mx < (getX() + getW()) && _my > getY() && _my < (getY() + getH())) {
            click = !click;
        }
    }
}
