import javax.swing.*;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        // set size cho window
        this.setSize(1024, 600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
         // cho phep window dc hien thi
        this.setVisible(true);
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {
                this.gameCanvas.positionStarX -= 5;
                this.gameCanvas.repaint();
                this.lastTime = currentTime;
            }

        }
    }
}
