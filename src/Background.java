import java.awt.*;

public class Background {
    public int x;
    public int y;
    public Color color;

    public Background(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(this.x, this.y, 1024, 600);
    }
}
