package ch17.shape2;


import java.io.Serializable;

public class Line extends AbstractShape implements ILine, Cloneable, Serializable {
    private double length;

    public Line(double length) {
        this.length = length;
    }

    public Line(Line line) {
        this.length = line.getLength();
        setId(line.getId());
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Line{" +
                "length=" + length +
                '}';
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return (Double.compare(getLength(), line.getLength()) == 0) && (Long.compare(getId(), line.getId()) == 0);
    }

    @Override
    public int hashCode() {
        int result =  Double.hashCode(getLength());
        result = 31 * result + Long.hashCode(getId());
        return result;
    }
}
