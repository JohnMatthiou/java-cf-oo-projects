package ch17.shape2;


import java.io.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Line line1 = new Line(3.0);
        line1.setId(2);
        Line line2 = line1.clone();
        System.out.println("line1 is equal to line2: " + line1.equals(line2));
        System.out.println();

        Rectangle rectangle1 = new Rectangle(6.0, 2.0);
        Rectangle rectangle2 = rectangle1.clone();
        System.out.println("rectangle1 hash: " + rectangle1.hashCode());
        System.out.println("rectangle2 hash: " + rectangle2.hashCode());
        System.out.println();

        Circle circle1 = new Circle(3.2);
        Circle circle2 = new Circle(circle1);
        System.out.println("circle1 is equal to circle2: " + circle1.equals(circle2));
        System.out.println("circle1 hash: " + circle1.hashCode());
        System.out.println("circle2 hash: " + circle2.hashCode());
        System.out.println();


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/temp/line.ser"))){
            oos.writeObject(line1);
        } catch (NotSerializableException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/temp/line.ser"))) {
            Line newLineFromFile = (Line) ois.readObject();
            System.out.println(newLineFromFile);
        } catch (NotSerializableException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch ( IOException e) {
            throw  new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
