/*
 * $Id: DrawablePanel.java,v 1.3 2012/12/23 14:56:20 dds Exp $
 */
package gr.aueb.xmascard;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;


/**
 * The Christmas Card program main class.
 *
 * @author Georgios Zouganelis
 * Draw components from this object to reduce flickering.
 */
public class DrawablePanel extends JPanel {

    /** The DrawPanel this DrawablePanel is attached to **/
    private DrawPanel controller = null;

    /** Serial number of persistent  data.
     * Required, because JPanel implements serializable.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor to initialize the DrawablePanel with it's controller
     *
     */
    public DrawablePanel(DrawPanel panel){
        controller = panel;
    }

    /**
     * Perform all drawing operations
     * By overriding the JPanel method and initiating all the drawing
     * from this place we take advantage of JPanel's double-buffering
     * capability.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(DrawPanel.backgroundColor);

        // Ask our controller for a copy of items to draw
        Vector<Drawable>toPaint = controller.getDrawables();
        for (Drawable d : toPaint)
            d.draw(g);
    }
}
