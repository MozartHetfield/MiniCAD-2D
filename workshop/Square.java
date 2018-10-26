package workshop;

public class Square extends ShapeClass implements Visitable {

    private int leftUpperX;
    private int leftUpperY;
    private int lineDimension;

    public Square() {

    }

    public Square(final int leftUpperX, final int leftUpperY, final int lineDimension) {
        this.leftUpperX = leftUpperX;
        this.leftUpperY = leftUpperY;
        this.lineDimension = lineDimension;
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
     * Returneaza dimensiunea laturii.
     * @return
     */
    public int getLineDimension() {
        return lineDimension;
    }
    /**
     * Metoda accept pentru pattern-ul visitor.
     */
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
