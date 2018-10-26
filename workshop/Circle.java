package workshop;

public class Circle extends ShapeClass implements Visitable {

    private int centerX;
    private int centerY;
    private int radius;

    public Circle() {

    }

    public Circle(final int centerX, final int centerY, final int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
    /**
     * Returneaza abscisa centrului.
     * @return
     */
    public int getCenterX() {
        return centerX;
    }
    /**
     * Returneaza ordonata centrului.
     * @return
     */
    public int getCenterY() {
        return centerY;
    }
    /**
     * Returneaza valoarea razei.
     * @return
     */
    public int getRadius() {
        return radius;
    }
    /**
     * Metoda accept pentru pattern-ul visitor.
     */
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
