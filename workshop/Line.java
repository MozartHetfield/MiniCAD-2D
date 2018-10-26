package workshop;

public class Line extends ShapeClass implements Visitable {

    private int startingX;
    private int startingY;
    private int endingX;
    private int endingY;


    public Line() {

    }

    public Line(final int startingX, final int startingY,
    final int endingX, final int endingY) {
        this.startingX = startingX;
        this.startingY = startingY;
        this.endingX = endingX;
        this.endingY = endingY;
    }
    /**
     * Returneaza abscisa punctului de start.
     * @return
     */
    public int getStartingX() {
        return startingX;
    }
    /**
     * Returneaza ordonata punctului de start.
     * @return
     */
    public int getStartingY() {
        return startingY;
    }
    /**
     * Returneaza abscisa punctului final.
     * @return
     */
    public int getEndingX() {
        return endingX;
    }
    /**
     * Returneaza ordonata punctului final.
     * @return
     */
    public int getEndingY() {
        return endingY;
    }
    /**
     * Metoda accept pentru pattern-ul visitor.
     */
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
