package workshop;

public class Triangle extends ShapeClass implements Visitable {

    private int firstX;
    private int secondX;
    private int thirdX;
    private int firstY;
    private int secondY;
    private int thirdY;

    public Triangle() {

    }

    public Triangle(final int firstX, final int firstY, final int secondX, final int secondY,
    final int thirdX, final int thirdY) {

        this.firstX = firstX;
        this.firstY = firstY;
        this.secondX = secondX;
        this.secondY = secondY;
        this.thirdX = thirdX;
        this.thirdY = thirdY;

    }
    /**
     * Returneaza abscisa primului punct.
     * @return
     */
    public int getFirstX() {
        return firstX;
    }
    /**
     * Returneaza abscisa celui de-al doilea punct.
     * @return
     */
    public int getSecondX() {
        return secondX;
    }
    /**
     * Returneaza abscisa celui de-al treilea punct.
     * @return
     */
    public int getThirdX() {
        return thirdX;
    }
    /**
     * Rturneaza ordonata primului punct.
     * @return
     */
    public int getFirstY() {
        return firstY;
    }
    /**
     * Returneaza ordonata celui de-al doilea punct.
     * @return
     */
    public int getSecondY() {
        return secondY;
    }
    /**
     * Returneaza ordonata celui de-al treilea punct.
     * @return
     */
    public int getThirdY() {
        return thirdY;
    }
    /**
     * Metoda accept pentru pattern-ul visitor.
     */
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
