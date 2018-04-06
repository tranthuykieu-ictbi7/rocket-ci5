import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage star; // chua anh ngoi sao
    int positionStarX = 900;
    int positionStarY = 300;

    public GameCanvas() {
        // Set size
        this.setSize(1024, 600);
        // Load image
        try {
            this.star = ImageIO.read(new File("resources/images/star.png"));
        } catch (IOException e) {
            e.printStackTrace();
            /// ko load dc
        }
        this.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        // noi ve toa bo moi thu
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1024, 600);
        g.drawImage(this.star, this.positionStarX, this.positionStarY, 32, 32, null);
    }
}
