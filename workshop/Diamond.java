package workshop;

public class Diamond extends ShapeClass implements Visitable {

    private int centerX;
    private int centerY;
    private int horizontalDiag;
    private int verticalDiag;

    public Diamond() {

    }

    public Diamond(final int centerX, final int centerY, final int horizontalDiag,
    final int verticalDiag) {

        this.centerX = centerX;
        this.centerY = centerY;
        this.horizontalDiag = horizontalDiag;
        this.verticalDiag = verticalDiag;

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
     * Returneaza dimensiunea diagonalei orizontale.
     * @return
     */
    public int getHorizontalDiag() {
        return horizontalDiag;
    }
    /**
     * Returneaza dimensiunea diagonalei verticale.
     * @return
     */
    public int getVerticalDiag() {
        return verticalDiag;
    }
    /**
     * Metoda accept pentru pattern-ul visitor.
     */
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
