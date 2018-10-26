import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import workshop.Canvas;
import workshop.Circle;
import workshop.Diamond;
import workshop.DrawFigure;
import workshop.FillFigure;
import workshop.Line;
import workshop.Polygon;
import workshop.Rectangle;
import workshop.Shape;
import workshop.ShapeFactory;
import workshop.Square;
import workshop.Triangle;

public final class Main {

    private Main() {

    }

    public static final int TREI = 3;
    public static final int PATRU = 4;
    public static final int CINCI = 5;
    public static final int SASE = 6;
    public static final int SAPTE = 7;
    public static final int OPT = 8;
    public static final int NOUA = 9;
    public static final int ZECE = 10;

    public static void main(final String[] args) throws IOException {

        ShapeFactory creator = ShapeFactory.getCreator();
        FillFigure filler = FillFigure.getFiller();
        DrawFigure drawer = DrawFigure.getDrawer();
        Canvas canvas = Canvas.getBackground();
        Scanner scanf = new Scanner(new BufferedReader(new FileReader(args[0])));
        File output = new File("drawing.png"); //output-ul cu numele dat in cerinta

        int numberOfFigures = scanf.nextInt(); //numarul de forme
        scanf.nextLine();
        String auxiliar = new String();
        auxiliar = scanf.nextLine(); //aici e scanata partea pentru canvas
        String[] parts = auxiliar.split(" ");
        canvas.initialize(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        int backgroundColor = creator.translateColor(parts[TREI], parts[PATRU]);

        BufferedImage image = new BufferedImage(canvas.getWidthMatrix(),
        canvas.getHeightMatrix(), BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < canvas.getHeightMatrix(); i++) {
            for (int j = 0; j < canvas.getWidthMatrix(); j++) {
                image.setRGB(j, i, backgroundColor);
            }
        } //pana aici am facut background-ul imaginiii (canvas)

        Shape[] shapes = new Shape[numberOfFigures - 1]; //restul formelor
        int shapeColor; //culoare outline
        int shapeFillColor; //culoare fill

        for (int i = 0; i < numberOfFigures - 1; i++) { //treci prin fisier

            auxiliar = scanf.nextLine();
            parts = auxiliar.split(" ");
            canvas.clearMatrix(); //intializezi iar matricea cu 0

            if (parts[0].equalsIgnoreCase("LINE")) {
                shapes[i] = creator.createShape("LINE"); //tipul formei
                shapes[i] = new Line(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[PATRU]),
                Integer.parseInt(parts[TREI])); //constructor pentru parametrii
                shapes[i].accept(drawer); //desenarea schemei pentru conturul formei
                shapeColor = creator.translateColor(parts[CINCI], parts[SASE]); //culoarea in argb
                canvas.draw(shapeColor, image); //desenarea efectiva a conturului
                continue;
            } else if (parts[0].equalsIgnoreCase("SQUARE")) {
                shapes[i] = creator.createShape("SQUARE");
                shapes[i] = new Square(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[TREI]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[PATRU], parts[CINCI]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler); //schema pentru fill-ul formei
                shapeFillColor = creator.translateColor(parts[SASE], parts[SAPTE]);
                canvas.fill(shapeFillColor, image); //umplerea efectiva a formei
                continue;
            } else if (parts[0].equalsIgnoreCase("TRIANGLE")) {
                shapes[i] = creator.createShape("TRIANGLE");
                shapes[i] = new Triangle(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[PATRU]),
                Integer.parseInt(parts[TREI]),
                Integer.parseInt(parts[SASE]),
                Integer.parseInt(parts[CINCI]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[SAPTE], parts[OPT]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[NOUA], parts[ZECE]);
                canvas.fill(shapeFillColor, image);
                continue;
            } else if (parts[0].equalsIgnoreCase("RECTANGLE")) {
                shapes[i] = creator.createShape("RECTANGLE");
                shapes[i] = new Rectangle(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[TREI]),
                Integer.parseInt(parts[PATRU]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[CINCI], parts[SASE]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[SAPTE], parts[OPT]);
                canvas.fill(shapeFillColor, image);
                continue;
            } else if (parts[0].equalsIgnoreCase("DIAMOND")) {
                shapes[i] = creator.createShape("DIAMOND");
                shapes[i] = new Diamond(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[TREI]),
                Integer.parseInt(parts[PATRU]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[CINCI], parts[SASE]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[SAPTE], parts[OPT]);
                canvas.fill(shapeFillColor, image);
                continue;
            } else if (parts[0].equalsIgnoreCase("CIRCLE")) {
                shapes[i] = creator.createShape("CIRCLE");
                shapes[i] = new Circle(Integer.parseInt(parts[2]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[TREI]));
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[PATRU], parts[CINCI]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[SASE], parts[SAPTE]);
                canvas.fill(shapeFillColor, image);
                continue;
            } else if (parts[0].equalsIgnoreCase("POLYGON")) {
                shapes[i] = creator.createShape("POLYGON");

                int pointsNumber = Integer.parseInt(parts[1]);
                int[] points = new int[pointsNumber * 2];
                int q = 0;
                int w = 2;
                for (w = 2; w < parts.length - PATRU; w++) {
                    points[q] = Integer.parseInt(parts[w]);
                    q++;
                }
                shapes[i] = new Polygon(pointsNumber, points);
                shapes[i].accept(drawer);
                shapeColor = creator.translateColor(parts[w], parts[w + 1]);
                canvas.draw(shapeColor, image);

                shapes[i].accept(filler);
                shapeFillColor = creator.translateColor(parts[w + 2], parts[w + TREI]);
                canvas.fill(shapeFillColor, image);
                continue;
           }
       }
        ImageIO.write(image, "png", output); //afisarea rezultatului in fisier
        scanf.close(); //inchidem scanner-ul
    }
}
