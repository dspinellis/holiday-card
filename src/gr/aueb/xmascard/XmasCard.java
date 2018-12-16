/*-
 * Copyright 2005-2018 Diomidis Spinellis
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package gr.aueb.xmascard;

import java.awt.Rectangle;

/**
 * The Christmas Card program main class.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 * @depend - - - gr.aueb.xmascard.DrawPanel
 * @depend - <instantiate> - gr.aueb.xmascard.MidiPlayer
 * @depend - - - gr.aueb.xmascard.Tree
 * @depend - - - gr.aueb.xmascard.PointSnowFlake
 * @depend - - - gr.aueb.xmascard.SlashSnowFlake
 */
public class XmasCard {

    /** Number of trees */
    private static final int numTrees = 30;
    /** Number of snowflakes */
    private static final int numSnowFlakes = 1500;
    /** Minimum tree width. */
    private static final int treeWidth = 30;
    /** Minimum tree height. */
    private static final int treeHeight = 100;
    /** Additional variation to tree height and width */
    private static final int treeWobble = 100;
    /** Song to play. */
    private static String musicFile = "/Jingle_Bells_full_Ab.mid";

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
		// Allow existing snowflakes to fall a bit, before adding more
		Thread.sleep(100);
	    } catch (InterruptedException e) {
	    }
        }
    }
}
