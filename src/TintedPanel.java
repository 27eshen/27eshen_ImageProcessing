public class TintedPanel extends Panel {
    public TintedPanel(int _x, int _y, int _w, int _h) {
        super(_x, _y, _w, _h);
    }

    public void display() {
        Main.app.tint(193, 230, 184);
        super.display();
        Main.app.noTint();
    }
}