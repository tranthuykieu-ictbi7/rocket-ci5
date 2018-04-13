import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Player {
    public Vector2D position;
    public Color color;
    private Polygon polygon;
    private List<Vector2D> vertices;

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
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2)) //bn trong list dc cong het lai
                .multiply(1.0f / (float)this.vertices.size());
        Vector2D translate = this.position.subtract(center);
        this.vertices
                .stream()
                .map(vector2D -> vector2D.add(translate)) // duyet tat ca phan tu -> vector se dc cong them mot vector khac
                .forEach(vector2D -> polygon.addPoint((int)vector2D.x, (int)vector2D.y));
    }
}
