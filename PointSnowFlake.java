/*
 * $Id: PointSnowFlake.java,v 1.6 2005/12/19 10:36:18 dds Exp $
 */

package gr.aueb.xmascard;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * A class that animates a point-like character on a canvas.
 * The character can be e.g. a . or a * or an o.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 * @opt nodefillcolor white
 */
public class PointSnowFlake extends SnowFlake {

    /** The wieght of the snowflake. */
    int weight;

    /**
     * Create a snowflake represented by a point-like character.
     *
     * @param panel The panel to draw the object onto
     * @param c The character to draw
     * @param w The snowflake's weight
     */
    public PointSnowFlake(JPanel panel, char c, int w) {
	super(panel);
        displayChar = c;
	weight = w;
    }

    /**
     * Display the star onto the canvas. The star changes its 'x' coordinate,
     * depending on the 'y' coordinate.
     */
    public void draw() {

        // Move the snowflake left and right
        switch (coordY % 3) {
        case 1:
            coordX = coordX - 5;
            break;
        case 2:
            coordX = coordX + 5;
            break;
        default:
            break;
        }

        // Move down, based on the weight
        coordY += (int) (Math.random() * weight);

        // Go back to the top when hitting the bottom
        if (coordY >= bounds.width + bounds.y)
            coordY = 0;

        // Draw the character in white
        canvas.setColor(new Color(255, 255, 255));
        canvas.drawString((new Character(displayChar)).toString(),
	    coordX, coordY);
    }
}
