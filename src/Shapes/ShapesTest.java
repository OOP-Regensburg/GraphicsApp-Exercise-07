package Shapes;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

public class ShapesTest extends GraphicsApp {

    /* Private constants */
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final int FRAME_RATE = 60;
    private static final Color BACKGROUND_COLOR = Colors.WHITE;
    // private Triangle triangle;
    // private Hexagon hexagon;

    /*
     * Die initialize-Methode wird einmalig zum Start des Programms
     * aufgerufen.
     */

    @Override
    public void initialize() {
        setupCanvas();
        initShapes();
    }

    /*
     * In der initShapes()-Methode werden die zu implementierenden Shapes der GraphicsApp
     * instanziiert. Wenn Sie die Klassen angelegt haben und die Konstruktoren geschrieben haben,
     * können Sie den Code in dieser Methode einkommentieren und die ShapesTest-Anwendung ausführen.
     */
    private void initShapes() {
        /*
        triangle = new Triangle(250, 250, 100, 100, Colors.BLACK);
        triangle.setBorderWeight(3);
        hexagon = new Hexagon(250, 250, 100, 100, Colors.BLACK);
        hexagon.setBorderWeight(3);
        */
    }

    /*
     * Die draw-Methode wird so lange wiederholt aufgerufen, bis das Programm
     * beendet wird.
     */

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
        drawShapes();
    }

    private void setupCanvas() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        setFrameRate(FRAME_RATE);
    }

    /*
     * Um zu überprüfen, ob die neuen Shapes korrekt gezeichnet werden, können Sie den Code
     * in der drawShapes()-Methode einkommentieren.
     */
    private void drawShapes() {
        /*
        triangle.move(2, 2);
        triangle.draw();
        hexagon.move(-2, -2);
        hexagon.draw();
        */
    }
}