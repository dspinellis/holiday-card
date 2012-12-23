/*
 * $Id: DrawablePanel.java,v 1.2 2012/12/23 10:50:06 dds Exp $
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
     * Override the paintComponent method of JPanel and
     * perform all the drawings here
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(new Color(0, 153, 204));

        // Ask our controller for a copy of items to draw
        Vector<Drawable>toPaint = controller.getDrawables();
        for (Drawable d : toPaint)
            d.draw(g);
    }
}
