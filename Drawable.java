/*
 * $Id: Drawable.java,v 1.4 2012/12/23 09:51:55 dds Exp $
 */
package gr.aueb.xmascard;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * An abstract representation of a self-drawable object.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 */
public abstract class Drawable {

    /**
     * The canvas to draw the object onto
     */
    protected Graphics2D canvas;

    /**
     * The canvas's bounds
     */
    protected Rectangle bounds;

    /**
     * Create drawable item
     *
     * @param panel The panel to draw the object onto
     */
    public Drawable(JPanel panel) {
        bounds = panel.getBounds();
        canvas = (Graphics2D)panel.getGraphics();
    }


    /**
     * Draws the object onto the canvas
     *
     */
    public abstract void draw(Graphics g);

    /**
     * Clears the object's bounding box (and thus the object);
     */
    public abstract void clear(Graphics g);
}
