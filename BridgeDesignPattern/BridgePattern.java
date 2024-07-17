// Implementor
public interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
}


// ConcreteImplementor 1
public class VectorDrawingAPI implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing circle with Vector API at (" + x + ", " + y + ") with radius " + radius);
    }
}

// ConcreteImplementor 2
public class RasterDrawingAPI implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing circle with Raster API at (" + x + ", " + y + ") with radius " + radius);
    }
}

// Abstraction
public abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
    public abstract void resizeByPercentage(double pct);
}

// RefinedAbstraction
public class CircleShape extends Shape {
    private double x, y, radius;

    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }

    @Override
    public void resizeByPercentage(double pct) {
        radius *= (1.0 + pct / 100.0);
    }
}

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
                new CircleShape(1, 2, 3, new VectorDrawingAPI()),
                new CircleShape(5, 7, 11, new RasterDrawingAPI())
        };

        for (Shape shape : shapes) {
            shape.draw();
            shape.resizeByPercentage(10);
            shape.draw();
        }
    }
}
