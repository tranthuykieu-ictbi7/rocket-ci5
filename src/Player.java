import java.awt.*;
import java.util.Random;

public class Player {
    public Vector2D position;
    private PolygonRenderer renderer;
    private PlayerMove playerMove;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
    }

    public void run() {
        this.playerMove.run(this);
        this.renderer.angle = this.playerMove.angle;
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
