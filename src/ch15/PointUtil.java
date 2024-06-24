package ch15;

public class PointUtil {
    public static void main(String[] args) {
        Point p1 = new Point(1);
        Point p2 = new Point2D(5, 12);
        Point p3 = new Point3D(5, 9, 23);


        System.out.printf("Point p1 distance from origin: %.2f\n", distanceFromOrigin(p1));
        System.out.printf("Point p2 distance from origin: %.2f\n", distanceFromOrigin(p2));
        System.out.printf("Point p3 distance from origin: %.2f\n", distanceFromOrigin(p3));

    }

    public static double distanceFromOrigin(Point point) {
        return point.getDistanceFromOrigin();
    }
}
