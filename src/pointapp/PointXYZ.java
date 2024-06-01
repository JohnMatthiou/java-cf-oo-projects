package pointapp;

public class PointXYZ {
    private int x;
    private int y;
    private int z;

    public PointXYZ() {

    }

    public PointXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double getXYDistance() {
        return Math.sqrt( Math.pow(x , 2) + Math.pow(y , 2) );
    }

    public double getYZDistance() {
        return Math.sqrt( Math.pow(y , 2) + Math.pow(z , 2) );
    }

    public double getXZDistance() {
        return Math.sqrt( Math.pow(x , 2) + Math.pow(z , 2) );
    }

    public double getXYZDistance() {
        return Math.sqrt( Math.pow(x , 2) + Math.pow(y , 2) + Math.pow(z , 2) );
    }

    public String convertToString() {
        return "Point{ x=" + x + ", y=" + y + ", z=" + z + " }";
    }
}
