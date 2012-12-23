/*
 * $Id: SnowFlake.java,v 1.8 2012/12/23 14:58:41 dds Exp $
 */
package gr.aueb.xmascard;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * A self-drawable 'snowflake' represented by a character. The move pattern and
 * character to be displayed is determined by subclasses.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 * @opt nodefillcolor white
 */
public abstract class SnowFlake extends Drawable {

    /** The snowflake's background color. */
    private static final Color white = new Color(255, 255, 255);

    /**
     * The 'x' current coordinate of the snowflake.
     */
    protected int coordX;

    /**
     * The 'y' current coordinate of the snowflake.
     */
    protected int coordY;

    /**
     * The character to be displayed as a snowflake
     */
    protected char displayChar;

    /**
     * Create a snowflake represented by a point-like character.
     *
     * @param panel The panel to draw the object onto
     */
    public SnowFlake(JPanel panel) {
        super(panel);
        coordX = (int) (bounds.width * Math.random()) + bounds.x;
        coordY = 0;
    }

    /** 
     * Draw the snowflake and wrap around.
     *  
     * @param g The Graphics object on which we will paint
     */
    public void draw(Graphics g) {
        // Go back to the top when hitting the bottom
        if (coordY >= bounds.width + bounds.y)
            coordY = 0;

        // Draw the character in white
        g.setColor(white);
        g.drawString((new Character(displayChar)).toString(),
        coordX, coordY);
    }
}
