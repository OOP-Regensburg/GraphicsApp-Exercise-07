package Shapes;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.GraphicsObject;
import de.ur.mi.oop.graphics.Line;
import de.ur.mi.oop.graphics.Point;

public class Hexagon extends GraphicsObject {

    private Point alpha;
    private Point beta;
    private Point gamma;
    private Point delta;
    private Point epsilon;
    private Point zeta;

    public Hexagon(float x, float y, float width, float height, Color color) {
        super(x, y, width, height, color);
    }

    private void updatePoints() {
        float currentXPos = getXPos();
        float currentYPos = getYPos();
        float currentWidth = getWidth();
        float currentHeight = getHeight();

        alpha = new Point(currentXPos - currentWidth / 4, currentYPos + currentHeight / 2);
        beta = new Point(currentXPos + currentWidth / 4, currentYPos + currentHeight / 2);
        gamma = new Point(currentXPos + currentWidth / 2, currentYPos);
        delta = new Point(currentXPos + currentWidth / 4, currentYPos - currentHeight / 2);
        epsilon = new Point(currentXPos - currentWidth / 4, currentYPos - currentHeight / 2);
        zeta = new Point(currentXPos - currentWidth / 2, currentYPos);
    }


    @Override
    public void draw() {
        updatePoints();
        Line a = new Line(gamma, beta, getColor());
        Line b = new Line(gamma, delta, getColor());
        Line c = new Line(delta, epsilon, getColor());
        Line d = new Line(epsilon, zeta, getColor());
        Line e = new Line(zeta, alpha, getColor());
        Line f = new Line(alpha, beta, getColor());
        a.setBorderWeight(getBorderWeight());
        b.setBorderWeight(getBorderWeight());
        c.setBorderWeight(getBorderWeight());
        d.setBorderWeight(getBorderWeight());
        e.setBorderWeight(getBorderWeight());
        f.setBorderWeight(getBorderWeight());
        a.draw();
        b.draw();
        c.draw();
        d.draw();
        e.draw();
        f.draw();
    }
}
