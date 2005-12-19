/*
 * $Id: XmasCard.java,v 1.5 2005/12/19 09:26:40 dds Exp $
 */
package gr.aueb.xmascard;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The XmasCard program main class.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 */
public class XmasCard {

    public static void main(String[] args) {

        /* Create a window and the canvas to draw onto*/
        DrawPanel d = new DrawPanel();

        /* Create 6 randomly-positioned trees*/
        for (int i = 0; i < 6; i++) {

            Rectangle treeBox = new Rectangle(20 + (int) (Math.random() * 400),
                    50 + (int) (Math.random() * 250),
                    30 + (int) (Math.random() * 100),
                    100 + (int) (Math.random() * 100));

            Tree t = new Tree(treeBox, (Graphics2D) d.getCanvas().getGraphics(),
                    d.getCanvas().getBounds());

            d.addDrawObject(t);
        }

	// Start playing music
	MidiPlayer m = new MidiPlayer("jbelrock.mid");

        /* Create 350 snowflakes*/
        for (int i = 0; i < 350; i++) {
	    switch (i % 6) {
	    case 0:
	    case 1:
                d.addDrawObject(new PointSnowFlake(d.getCanvas(), '.', 15));
		break;
	    case 2:
                d.addDrawObject(new PointSnowFlake(d.getCanvas(), 'o', 10));
		break;
	    case 3:
                d.addDrawObject(new PointSnowFlake(d.getCanvas(), '*', 5));
		break;
	    case 4:
	    case 5:
                d.addDrawObject(new SlashSnowFlake(d.getCanvas()));
		break;
	    }
	    try {
		Thread.sleep(250);
	    } catch (InterruptedException e) {
	    }
        }
    }
}
