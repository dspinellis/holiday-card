/*
 * $Id: SnowFlake.java,v 1.3 2005/12/19 09:18:18 dds Exp $
 */
package gr.aueb.xmascard;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.FontMetrics;

/**
 * A self-drawable 'snowflake' represented by a character. The move pattern and
 * character to be displayed is determined by subclasses.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 */
public abstract class SnowFlake extends Drawable {

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
	bounds = panel.getBounds();
        canvas = (Graphics2D)panel.getGraphics();
        coordX = (int) (bounds.width * Math.random()) + bounds.x;
        coordY = 0;
    }

    /**
     * Clear the displayed character from the canvas. Gets the width and height
     * of the displayed character from the font metrics calculator for the
     * current font.
     */
    public void clear() {
        FontMetrics fm = canvas.getFontMetrics();
        canvas.clearRect(coordX, coordY, fm.charWidth(displayChar),
                fm.getHeight());
        canvas.setColor(canvas.getBackground());
        canvas.fillRect(coordX, coordY, fm.charWidth(displayChar),
                fm.getHeight());
    }

    public abstract void draw();

}
