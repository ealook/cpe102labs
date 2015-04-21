import java.lang.Math;


public class PolarPoint implements Point {

    private double radius;
    private double angle;

    public PolarPoint(double radius, double angle) {
        this.radius = radius;
        this.angle= angle;
    }

    public double xCoordinate() {
        return radius * Math.cos(angle);
    }

    public double yCoordinate() {
        return radius * Math.sin(angle);
    }

    public double radius() {
        return radius;
    }

    public double angle() {
        return angle;
    }

    public Point rotate90() {
        return new PolarPoint(radius, angle + Math.PI/2);
    }
}