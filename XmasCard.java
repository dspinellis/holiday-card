/*
 * $Id: XmasCard.java,v 1.7 2005/12/19 10:08:47 dds Exp $
 */
package gr.aueb.xmascard;

import java.awt.Rectangle;

/**
 * The Christmas Card program main class.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 */
public class XmasCard {

    /** Number of trees */
    private static final int numTrees = 12;
    /** Number of snowflakes */
    private static final int numSnowFlakes = 500;
    /** Minimum tree width. */
    private static final int treeWidth = 30;
    /** Minimum tree height. */
    private static final int treeHeight = 100;
    /** Additional variation to tree height and width */
    private static final int treeWobble = 100;
    /** Song to play. */
    private static String musicFile = "jbelrock.mid";

    public static void main(String[] args) {

        // Create a window and the canvas to draw onto.
        DrawPanel d = new DrawPanel();

        // Create randomly-positioned trees.
        for (int i = 0; i < numTrees; i++) {
            Rectangle treeBox = new Rectangle(
		(int)(Math.random() * DrawPanel.WIDTH),
                (int)(Math.random() * DrawPanel.HEIGHT),
                treeWidth + (int)(Math.random() * treeWobble),
                treeHeight + (int)(Math.random() * treeWobble));

            Tree t = new Tree(d.getCanvas(), treeBox);
            d.addDrawObject(t);
        }

	// Start playing music
	MidiPlayer m = new MidiPlayer(musicFile);

        // Create the snowflakes.
        for (int i = 0; i < numSnowFlakes; i++) {
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
