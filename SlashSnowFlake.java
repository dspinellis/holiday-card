/*
 * $Id: SlashSnowFlake.java,v 1.6 2006/12/07 08:08:47 dds Exp $
 */
package gr.aueb.xmascard;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

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
     */
    public void draw() {

        /* / on even lines, \ on odd lines */
        displayChar = ((coordY % 2) == 0) ? '/' : '\\';

        /* Move by 0 to 10 pixels down*/
        coordY += (int) (Math.random() * 10);

	// Draw it through the superclass
	super.draw();
    }

}
