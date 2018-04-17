import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {
    public Vector2D position;
    public Color color;
    private Polygon polygon;
    private List<Vector2D> vertices;
    public Vector2D velocity;
    private double angle = -30;
    private Random random = new Random();

    public Player(Vector2D position, Color color) {
        this.position = position;
        this.color = color;
        this.polygon = new Polygon();
        this.vertices = Arrays.asList(
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.vertices
                .forEach(vector2D -> polygon.addPoint((int)vector2D.x, (int)vector2D.y));
        this.velocity = new Vector2D(2, 0);
        this.velocity.set(this.velocity.rotate(this.angle));
    }

    public void run() {
        this.position.addUp(this.velocity);
        if (this.position.x > 1024) {
            this.position.set(0, this.random.nextInt(600));
        }
        if (this.position.x < 0) {
            this.position.set(1024, this.random.nextInt(600));
        }
        if (this.position.y > 600) {
            this.position.set(this.random.nextInt(1024), 0);
        }
        if (this.position.y < 0) {
            this.position.set(this.random.nextInt(1024), 600);
        }
    }

    public void render(Graphics graphics) {
        this.update();
        graphics.setColor(this.color);
        graphics.fillPolygon(this.polygon);
    }

    private void update() {
        this.polygon.reset();
        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))//bn trong list dc cong het lai
                .multiply(1.0f / (float)this.vertices.size());

        Vector2D translate = this.position.subtract(center);
        List<Vector2D> vector2DList = new ArrayList<>();
        this.vertices.forEach(vector2D -> {
            Vector2D v = vector2D.add(translate);
            vector2DList.add(v);
        });
        this.vertices
                .stream()
                .map(vector2D -> vector2D.rotate(angle)) // xoay dinh
                .map(vector2D -> vector2D.add(translate)) // duyet tat ca phan tu -> vector se dc cong them mot vector khac
                .forEach(vector2D -> polygon.addPoint((int)vector2D.x, (int)vector2D.y));
    }
}
