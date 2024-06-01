package pointapp;


public class Main {

    public static void main(String[] args) {
        PointXYZ p1 = new PointXYZ(10, 20, 30);

        System.out.println(p1.convertToString());
        System.out.printf("Distance between x and y: %.2f\n", p1.getXYDistance());
        System.out.printf("Distance between y and z: %.2f\n", p1.getYZDistance());
        System.out.printf("Distance between x and z: %.2f\n", p1.getXZDistance());
        System.out.printf("Distance between x, y and z: %.2f\n", p1.getXYZDistance());

    }
}
