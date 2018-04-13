import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public Vector2D position;
    public BufferedImage image;
    public int width;
    public int height;
    public Vector2D velocity;

    // constructor
    public Star(Vector2D position, BufferedImage image, int width, int height, Vector2D velocity) {
        this.position = position;
        this.image = image;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
    }


    public void run() {
        this.position.subtractBy(this.velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, this.width, this.height, null);
    }
}
