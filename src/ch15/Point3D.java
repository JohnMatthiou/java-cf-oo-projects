package ch15;

public class Point3D extends Point2D {
    private double z;

    public Point3D() {

    }

    Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String convertToString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }

    @Override
    public void movePlus10() {
        super.movePlus10();
        z += 10;
    }

    @Override
    public void movePlusOne() {
        super.movePlusOne();
        z += 1;
    }

    @Override
    public double getDistanceFromOrigin() {
        double distanceX = getX() - getORIGIN();
        double distanceY = getY() - getORIGIN();
        double distanceZ = z - getORIGIN();
        return Math.sqrt( Math.pow(distanceX , 2) + Math.pow(distanceY , 2) + Math.pow(distanceZ , 2));
    }

    @Override
    protected void reset() {
        super.reset();
        z = 0;
    }

}
