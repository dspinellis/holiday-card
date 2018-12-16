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
 * A class that animates a point-like character on a canvas.
 * The character can be e.g. a . or a * or an o.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 * @opt nodefillcolor white
 */
public class PointSnowFlake extends SnowFlake {

    /** The wieght of the snowflake. */
    int weight;

    /**
     * Create a snowflake represented by a point-like character.
     *
     * @param panel The panel to draw the object onto
     * @param c The character to draw
     * @param w The snowflake's weight
     */
    public PointSnowFlake(JPanel panel, char c, int w) {
        super(panel);
        displayChar = c;
        weight = w;
    }

    /**
     * Display the star onto the canvas. The star changes its 'x' coordinate,
     * depending on the 'y' coordinate.
     *
     * @param g The Graphics object on which we will paint
     */
    @Override
    public void draw(Graphics g) {

        // Move the snowflake left and right
        switch (coordY % 3) {
        case 1:
            coordX = coordX - 5;
            break;
        case 2:
            coordX = coordX + 5;
            break;
        default:
            break;
        }

        // Move down, based on the weight
        coordY += (int)(Math.random() * weight);

        // Draw it through the superclass
        super.draw(g);
    }
}
