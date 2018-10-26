package workshop;

public class Polygon extends ShapeClass implements Visitable {

    private int numberOfPoints;
    private int[] coordonatesX;
    private int[] coordonatesY;

    public Polygon() {

    }

    public Polygon(final int numberOfPoints, final int[] points) {
        this.numberOfPoints = numberOfPoints;
        coordonatesX = new int[numberOfPoints];
        coordonatesY = new int[numberOfPoints];
        int j = 0;
        for (int i = 0; i < numberOfPoints; i++) {
            coordonatesY[i] = points[j];
            j++;
            coordonatesX[i] = points[j];
            j++;
        }
    }
    /**
     * Returneaza centrul de greutate al absciselor.
     * @return
     */
    public int getWeightPointX() {
        int sum = 0;
        for (int i = 0; i < this.numberOfPoints; i++) {
            sum += this.coordonatesX[i];
        }
        sum = sum / this.numberOfPoints;
        return sum;
    }
    /**
     * Returneaza centrul de greutate al ordonatelor.
     * @return
     */
    public int getWeightPointY() {
        int sum = 0;
        for (int i = 0; i < this.numberOfPoints; i++) {
            sum += this.coordonatesY[i];
        }
        sum = sum / this.numberOfPoints;
        return sum;
    }
    /**
     * Returneaza numarul de puncte.
     * @return
     */
    public int getNumberOfPoints() {
        return numberOfPoints;
    }
    /**
     * Returneaza coordonata absciselor de la un index.
     * @param index
     * @return
     */
    public int getCoordonatesX(final int index) {
        return coordonatesX[index];
    }
    /**
     * Returneaza coordonata ordonatelor de la un index.
     * @param index
     * @return
     */
    public int getCoordonatesY(final int index) {
        return coordonatesY[index];
    }
    /**
     * Metoda accept pentru pattern-ul visitor.
     */
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

}
