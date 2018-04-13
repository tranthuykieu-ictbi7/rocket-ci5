import java.awt.*;

public class Player {
    public int x;
    public int y;
    public Color color;
    private Polygon polygon;

    public Player(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.polygon = new Polygon();
        this.polygon.addPoint(0, 0);
        this.polygon.addPoint(0, 16);
        this.polygon.addPoint(20, 8);
    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);
    }
}
