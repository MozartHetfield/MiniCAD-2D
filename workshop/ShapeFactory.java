package workshop;

public final class ShapeFactory {

    public static final int SASE_ZECE = 16;
    public static final int PATRU_DOUA_ZECI = 24;
    private static ShapeFactory creator = new ShapeFactory();
    private ShapeFactory() {

    }

    public static ShapeFactory getCreator() {
        return creator;
    }

    public Shape createShape(final String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("CANVAS")) {
            return Canvas.getBackground();
        }
        if (type.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        if (type.equalsIgnoreCase("LINE")) {
            return new Line();
        }
        if (type.equalsIgnoreCase("TRIANGLE")) {
            return new Triangle();
        }
        if (type.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        if (type.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        if (type.equalsIgnoreCase("POLYGON")) {
            return new Polygon();
        }
        if (type.equalsIgnoreCase("DIAMOND")) {
            return new Diamond();
        }
        return null;
    }

    public int translateColor(final String rgb, final String alpha) {
        String[] rgbString = rgb.split("#");
        int rgbNew = Integer.parseInt(rgbString[1], SASE_ZECE);
        int alphaInt = Integer.parseInt(alpha);
        int alphaNew = alphaInt << PATRU_DOUA_ZECI;
        int color = alphaNew + rgbNew;
        return color;
    }

}
