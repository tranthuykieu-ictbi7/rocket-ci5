import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    private Star star;
    private BufferedImage backBuffered;
    private Graphics graphics;

    public GameCanvas() {
        // Set size
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupStar();
        this.setVisible(true);
    }

    private void setupStar() {
        this.star = new Star();
        this.star.image = this.loadImage("resources/images/star.png");
        this.star.x = 900;
        this.star.y = 300;
        this.star.width = 5;
        this.star.height = 5;
        this.star.velocityX = 2;
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.drawBackground();
        this.star.render(this.graphics);
        this.repaint();
    }

    private void drawBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    public void runAll() {
        // cap nhat tat ca moi thu
        this.star.run();
    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
