/*
 * $Id: PointSnowFlake.java,v 1.2 2005/12/19 08:55:55 dds Exp $
 */

package gr.aueb.xmascard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * A class that animates a star (*) on a canvas.
 *
 * @author Giorgos Gousios
 */
public class StarSnowFlake extends SnowFlake {

    /**
     * Create a snowflake represented by a star.
     *
     * @param canvas
     *            The canvas to draw the object onto
     * @param bounds
     *            The canvas's bounds
     */
    public StarSnowFlake(Graphics2D canvas, Rectangle bounds) {
        this.displayChar = '*';
        this.coordX = (int) (bounds.width * Math.random()) + bounds.x;
        this.coordY = 0;

        this.canvas = canvas;
        this.bounds = bounds;
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
