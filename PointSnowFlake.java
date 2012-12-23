/*
 * $Id: PointSnowFlake.java,v 1.8 2012/12/23 09:51:55 dds Exp $
 */

package gr.aueb.xmascard;

import java.awt.Graphics;
import javax.swing.JPanel;

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
     * 
     * @param g The Graphics object on which we will paint
     */
    public void draw(Graphics g) {

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
        coordY += (int)(Math.random() * weight);

        // Draw it through the superclass
        super.draw(g);
    }
}
