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

package gr.aueb.card;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * A self-drawable 'snowflake' represented by a character. The move pattern and
 * character to be displayed is determined by subclasses.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 * @opt nodefillcolor white
 */
public abstract class SnowFlake extends Drawable {

    /** The snowflake's background color. */
    private static final Color WHITE = new Color(255, 255, 255);

    /**
     * The 'x' current coordinate of the snowflake.
     */
    protected int coordX;

    /**
     * The 'y' current coordinate of the snowflake.
     */
    protected int coordY;

    /**
     * The character to be displayed as a snowflake
     */
    protected char displayChar;

    /**
     * Create a snowflake represented by a point-like character.
     *
     * @param panel The panel to draw the object onto
     */
    public SnowFlake(JPanel panel) {
        super(panel);
        coordX = (int) (bounds.width * Math.random()) + bounds.x;
        coordY = 0;
    }

    /**
     * Draw the snowflake and wrap around.
     *
     * @param g The Graphics object on which we will paint
     */
    @Override
    public void draw(Graphics g) {
        // Go back to the top when hitting the bottom
        if (coordY >= bounds.height + bounds.y)
            coordY = 0;

        // Draw the character in white
        g.setColor(WHITE);
        g.drawString((Character.valueOf(displayChar)).toString(),
        coordX, coordY);
    }
}
