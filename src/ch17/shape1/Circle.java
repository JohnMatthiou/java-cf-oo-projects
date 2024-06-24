package ch17.shape1;

import java.io.Serializable;

public class Circle extends AbstractShape implements ITwoDimensional, Cloneable, Serializable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(Circle circle) {
        this.radius = circle.radius;
        setId(circle.getId());
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    protected Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(getRadius(), circle.getRadius()) == 0 && Long.compare(getId(), circle.getId()) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(getRadius());
        result = 31 * result + Long.hashCode(getId());
        return result;
    }
}
