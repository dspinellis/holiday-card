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

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * An abstract representation of a self-drawable object.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 */
public abstract class Drawable {

    /**
     * The canvas to draw the object onto
     */
    protected Graphics2D canvas;

    /**
     * The canvas's bounds
     */
    protected Rectangle bounds;

    /**
     * Create drawable item
     *
     * @param panel The panel to draw the object onto
     */
    public Drawable(JPanel panel) {
        bounds = panel.getBounds();
        canvas = (Graphics2D)panel.getGraphics();
    }

    /**
     * Draws the object onto the canvas
     *
     */
    public abstract void draw(Graphics g);
}
