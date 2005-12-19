/*
 * $Id: PointSnowFlake.java,v 1.3 2005/12/19 09:14:06 dds Exp $
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
 */
public class PointSnowFlake extends SnowFlake {

    /**
     * Create a snowflake represented by a point-like character.
     *
     * @param panel
     *            The panel to draw the object onto
     */
    public PointSnowFlake(JPanel panel) {
        displayChar = '*';
	bounds = panel.getBounds();
        canvas = (Graphics2D)panel.getGraphics();
        coordX = (int) (bounds.width * Math.random()) + bounds.x;
        coordY = 0;

    }

    /**
     * Display the star onto the canvas. The star changes its 'x' coordinate,
     * depending on the 'y' coordinate.
     */
    public void draw() {

        /* Clumpsy animation effort*/
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

        /* Move by 0 to 10 pixels down*/
        coordY += (int) (Math.random() * 10);

        /* Go back to the top when hitting the bottom*/
        if (coordY >= bounds.width + bounds.y)
            coordY = 0;

        /* Draw the star in white*/
        canvas.setColor(new Color(255, 255, 255));
        canvas.drawString((new Character(displayChar)).toString(), coordX,
                coordY);
    }
}
