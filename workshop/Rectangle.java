package workshop;

public class Rectangle extends ShapeClass implements Visitable {

    private int leftUpperX;
    private int leftUpperY;
    private int heightDimension;
    private int widthDimension;

    public Rectangle() {

    }

    public Rectangle(final int leftUpperX, final int leftUpperY, final int heightDimension,
    final int widthDimension) {
        this.leftUpperX = leftUpperX;
        this.leftUpperY = leftUpperY;
        this.heightDimension = heightDimension;
        this.widthDimension = widthDimension;
    }
    /**
     * Returneaza abscisa punctului din stanga sus.
     * @return
     */
    public int getLeftUpperX() {
        return leftUpperX;
    }
    /**
     * Returneaza ordonata punctului din stanga sus.
     * @return
     */
    public int getLeftUpperY() {
        return leftUpperY;
    }
    /**
     * Returneaza lungimea.
     * @return
     */
    public int getHeightDimension() {
        return heightDimension;
    }
    /**
     * Returneaza latimea.
     * @return
     */
    public int getWidthDimension() {
        return widthDimension;
    }
    /**
     * Metoda accept pentru pattern-ul visitor.
     */
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
