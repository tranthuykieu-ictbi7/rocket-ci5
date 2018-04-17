import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public Vector2D position;
    public Vector2D velocity;
    public BufferedImage image;
    public int width, height;

    public Enemy(Vector2D position, BufferedImage image) {
        this.position = position;
        this.velocity = new Vector2D();
        this.image = image;
        this.width = 20;
        this.height = 20;
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, this.width, this.height, null);
    }
}
