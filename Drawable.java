/*
 * $Id: Drawable.java,v 1.2 2005/12/19 09:32:58 dds Exp $
 */
package gr.aueb.xmascard;

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
     * Draws the object onto the canvas
     *
     */
    public abstract void draw();

    /**
     * Clears the object's bounding box (and thus the object);
     */
    public abstract void clear();

}
