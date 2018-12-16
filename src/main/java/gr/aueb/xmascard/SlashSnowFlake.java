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
    @Override
    public void draw(Graphics g) {

        /* / on even lines, \ on odd lines */
        displayChar = ((coordY % 2) == 0) ? '/' : '\\';

        /* Move by 0 to 10 pixels down*/
        coordY += (int) (Math.random() * 10);

        // Draw it through the superclass
        super.draw(g);
    }
}
