package Shapes;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.GraphicsObject;
import de.ur.mi.oop.graphics.Line;
import de.ur.mi.oop.graphics.Point;

public class Triangle extends GraphicsObject {

    private Point alpha;
    private Point beta;
    private Point gamma;

    public Triangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        updatePoints();
    }

    private void updatePoints() {
        float currentXPos = getXPos();
        float currentYPos = getYPos();
        float currentWidth = getWidth();
        float currentHeight = getHeight();

        alpha = new Point(currentXPos - currentWidth / 2, currentYPos + currentHeight / 2);
        beta = new Point(currentXPos + currentWidth / 2, currentYPos + currentHeight / 2);
        gamma = new Point(currentXPos, currentYPos - currentHeight / 2);
    }


    @Override
    public void draw() {
        updatePoints();
        Line a = new Line(gamma, beta, getColor());
        Line b = new Line(gamma, alpha, getColor());
        Line c = new Line(alpha, beta, getColor());
        a.setBorderWeight(getBorderWeight());
        b.setBorderWeight(getBorderWeight());
        c.setBorderWeight(getBorderWeight());
        a.draw();
        b.draw();
        c.draw();
    }
}
