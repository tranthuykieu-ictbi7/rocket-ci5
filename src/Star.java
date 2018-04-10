import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    public int x;
    public int y;
    public BufferedImage image;
    public int width;
    public int height;
    public int velocityX;

    public void run() {
        this.x -= this.velocityX;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}
