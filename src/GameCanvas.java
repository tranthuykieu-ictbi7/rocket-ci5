import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    private List<Star> stars;

    private BufferedImage backBuffered;
    private Graphics graphics;
    private Random random;
    private int count = 0;

    public GameCanvas() {
        // Set size
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.stars = new ArrayList<>();
        this.random = new Random();
        this.setVisible(true);
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
        this.stars.forEach(star -> star.render(graphics));
        this.repaint();
    }

    private void drawBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    public void runAll() {
        // cap nhat tat ca moi thu
        this.createStar();
        this.stars.forEach(star -> star.run());
    }

    private void createStar() {
        if (this.count == 30) {
            Star star = new Star(1024, this.random.nextInt(600), this.loadImage("resources/images/star.png"), 5, 5, this.random.nextInt(2) + 1);
            this.stars.add(star);
            this.count = 0;
        } else {
            this.count += 1;
        }
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
