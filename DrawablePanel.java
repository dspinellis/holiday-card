/**
 * 
 */
package gr.aueb.xmascard;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class DrawablePanel extends JPanel {
    
    /** The DrawPanel this DrawablePanel is attached to **/
    private DrawPanel controller = null;

    /** Serial number of persistant  data.
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
     * 
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
