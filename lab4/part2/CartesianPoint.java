import java.lang.Math;


public class CartesianPoint implements Point {

    private double x_coord;
    private double y_coord;

    public CartesianPoint(double x_coord, double y_coord) {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    public double xCoordinate() {
        return x_coord;
    }

    public double yCoordinate() {
        return y_coord;
    }

    public double radius() {
        return Math.sqrt(x_coord * x_coord + y_coord * y_coord);
    }

    public double angle() {
        double angle = 0.0;

        if (x_coord > 0.0 && y_coord > 0.0) {
            angle = Math.atan2(y_coord, x_coord);
        } else if ((x_coord < 0.0 && y_coord > 0.0) || (x_coord < 0.0 && y_coord < 0.0)) {
            angle = Math.atan2(y_coord, x_coord) + Math.PI;
        } else if (x_coord > 0.0 && y_coord < 0.0) {
            angle = Math.atan2(y_coord, x_coord) + 2*Math.PI;
        } else if (x_coord == 0.0 && y_coord == 0.0) {
            angle = 0.0;
        } else if (x_coord == 0.0) {
            if (y_coord > 0.0) {
                angle = Math.PI/2;
            } else {
                angle = Math.PI * 3 / 2;
            }
        } else if (y_coord == 0.0) {
            if (x_coord < 0) {
                angle = Math.PI;
            }
        }

        return angle;
    }

    public Point rotate90() {
        return new CartesianPoint(-y_coord, x_coord);
    }
}
