/*-
 * Copyright 2005-2018 Diomidis Spinellis
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package gr.aueb.card;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JPanel;

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
    /** Tree balls' color (RGB) */
    private final Color red = new Color(250, 0, 0);

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
     * Draws the tree.
     *
     * @param g The Graphics object on which we will paint
     */
    @Override
    public void draw(Graphics g) {
	drawTrunk(g);
	drawBody(g);
    }

    /**
     * Draws the trunk. For details on how the lengths are calculated
     *
     * @param g The Graphics object on which we will paint
     * @see gr.aueb.Tree the class description.
     */
    private void drawTrunk(Graphics g) {
	/* Calculate the trunk rectangle first */
	Rectangle r = new Rectangle();

	r.x = (int) (dimensions.x + (dimensions.width
                    - dimensions.width * trunkWidthFactor) / 2);
	r.y = (int) (dimensions.y + dimensions.height * bodyHeightFactor);
	r.width = (int) (dimensions.width * trunkWidthFactor);
	r.height = (int) (dimensions.height * trunkHeightFactor);

	/* Draw it! */
	g.drawRect(r.x, r.y, r.width, r.height);

	/* Fill it with brown color */
	Color c = g.getColor();
	g.setColor(brown);
	g.fillRect(r.x, r.y, r.width, r.height);
	g.setColor(c); //Revert paint color to default
    }

    /**
     * Draws the body. For details on how the lengths are calculated
     *
     * @param g The Graphics object on which we will paint
     * @see gr.aueb.Tree the class description.
     */
    private void drawBody(Graphics g) {
        /* Create the polygon (triangle) to draw */
        Polygon p = new Polygon();
        p.addPoint(dimensions.x + dimensions.width / 2, dimensions.y);
        p.addPoint(dimensions.x,
                (int) (dimensions.y + dimensions.height * bodyHeightFactor));
        p.addPoint(dimensions.x + dimensions.width,
                (int) (dimensions.y + dimensions.height * bodyHeightFactor));
        /* Draw the body */
        g.drawPolygon(p);

        /* Fill it with green color */
        Color c = g.getColor();
        g.setColor(green);
        g.fillPolygon(p);
        g.setColor(c); // Revert paint color to default

        /* Set Ornaments to the body. */
        drawTreeOrnaments(g);
    }

    /**
     * Draws the ornaments of the tree.
     * @param g The Graphics object on which we will paint
     * @param x The Abscissa of the part of the body to draw the ornament
     * @param y The Ordinate of the part of the body to draw the ornament
     */
    private void addTreeOrnament(Graphics g, int x, int y) {
        /* Draw Tree Ornament. */
        g.drawOval(x, y, 10, 10);
        /* Set color to Red. */
        g.setColor(red);
        /* Fill Tree Ornament with color. */
        g.fillOval(x, y, 10, 10);
    }

    /**
     * Calls addTreeOrnament for specific locations on
     * the tree body.
     * @param g The Graphics object on which we will paint
     */
    private void drawTreeOrnaments(Graphics g) {
        /* yAxis of the body. */
        int yAxis = (int) (dimensions.y + dimensions.height * bodyHeightFactor);
        /* Add ornament to down left. */
        addTreeOrnament(g, dimensions.x - 2, yAxis - 2);
        /* Add ornament to down right. */
        addTreeOrnament(g, dimensions.x + dimensions.width - 1, yAxis - 1);
        /* Add ornament to up left. */
        addTreeOrnament(g, dimensions.x + dimensions.width / 2 - 5 - 20, yAxis - 25);
        /* Add ornament to up right. */
        addTreeOrnament(g, dimensions.x + dimensions.width / 2 - 5 + 20,  yAxis - 25);
        /* Add ornament to middle. */
        addTreeOrnament(g,dimensions.x + dimensions.width / 2 - 5, yAxis - 65);
    }
}
