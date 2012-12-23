/*
 * $Id: SlashSnowFlake.java,v 1.7 2012/12/23 09:51:55 dds Exp $
 */
package gr.aueb.xmascard;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * A class that animates a slash on a canvas.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 * @opt nodefillcolor white
 */
public class SlashSnowFlake extends SnowFlake {

    /**
     * Create a snowflake represented by a slash.
     *
     * @param panel The panel to draw the object onto
     */
    public SlashSnowFlake(JPanel panel) {
        super(panel);
        displayChar = '/';
    }

    /**
     * Display the slash on the drawing canvas. The slash alternates between
     * forward slash and backslash depending on the current 'y' coordinate.
     * 
     * @param g The Graphics object on which we will paint
     */
    public void draw(Graphics g) {

        /* / on even lines, \ on odd lines */
        displayChar = ((coordY % 2) == 0) ? '/' : '\\';

        /* Move by 0 to 10 pixels down*/
        coordY += (int) (Math.random() * 10);

        // Draw it through the superclass
        super.draw(g);
    }

}
