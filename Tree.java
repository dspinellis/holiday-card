/*
 * $Id: Tree.java,v 1.5 2005/12/19 10:36:18 dds Exp $
 */
package gr.aueb.xmascard;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 * A self-drawable tree. Uses a box to specify the tree's bounds (the dimensions
 * constructor parameter). The trunk is placed in the middle of the bottom side
 * of the box, having a width equal to the 8% of the total width of the tree and
 * a height equal to the 20% of the total height of the bounding box. The main
 * body is represented as an isosceles triangle with a height of 80% of the
 * height of the bounding box.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 * @opt nodefillcolor green
 */
public class Tree extends Drawable {

    /** Tree trunk width as % of the bounding rectangle width */
    private final double trunkWidthFactor = 0.08;
    /** Tree trunk height as % of the bounding rectangle height */
    private final double trunkHeightFactor = 0.2;
    /** Tree body height as % of the bounding rectangle height */
    private final double bodyHeightFactor = 0.8;
    /** Trunk's color (RGB) */
    private final Color brown = new Color(204, 102, 0);
    /** Body's color (RGB) */
    private final Color green = new Color(0, 254, 0);

    /** The tree's bounding rectangle */
    private Rectangle dimensions;

    /**
     * Creates a tree from the specified bounding box
     *
     * @param panel The panel to draw the object onto
     * @param dimensions The bounding box dimensions.
     */
    public Tree(JPanel panel, Rectangle dimensions) {
	super(panel);
        this.dimensions = dimensions;
    }

    /**
     * Clear the displayed tree by filling its bounding box with the background
     * color
     */
    public void clear() {
        canvas.setColor(canvas.getBackground());
        canvas.fillRect(dimensions.x, dimensions.y, dimensions.width,
                dimensions.height);
    }

    /**
     * Draws the tree.
     */
    public void draw() {
        drawTrunk();
        drawBody();
    }

    /**
     * Draws the trunk. For details on how the lengths are calculated
     *
     * @see gr.aueb.Tree the class description.
     */
    private void drawTrunk() {
        /* Calculate the trunk rectangle first */
        Rectangle r = new Rectangle();

        r.x = (int) (dimensions.x + (dimensions.width - dimensions.width * trunkWidthFactor) / 2);
        r.y = (int) (dimensions.y + dimensions.height * bodyHeightFactor);
        r.width = (int) (dimensions.width * trunkWidthFactor);
        r.height = (int) (dimensions.height * trunkHeightFactor);

        /* Draw it! */
        canvas.draw(r);

        /* Fill it with brown color */
        Color c = canvas.getColor();
        canvas.setColor(brown);
        canvas.fill(r);
        canvas.setColor(c); //Revert paint color to default
    }

    /**
     * Draws the body. For details on how the lengths are calculated
     *
     * @see gr.aueb.Tree the class description.
     */
    private void drawBody() {
        /* Create the polygon (triangle) to draw */
        Polygon p = new Polygon();
        p.addPoint(dimensions.x + dimensions.width / 2, dimensions.y);
        p.addPoint(dimensions.x,
                (int) (dimensions.y + dimensions.height * bodyHeightFactor));
        p.addPoint(dimensions.x + dimensions.width,
                (int) (dimensions.y + dimensions.height * bodyHeightFactor));
        /* Draw the body */
        canvas.draw(p);

        /* Fill it with green color */
        Color c = canvas.getColor();
        canvas.setColor(green);
        canvas.fill(p);
        canvas.setColor(c); //Revert paint color to default
    }
}
