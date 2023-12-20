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
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;


/**
 * The Holiday Card program main class.
 *
 * @author Georgios Zouganelis
 * Draw components from this object to reduce flickering.
 */
public class DrawablePanel extends JPanel {

    /** The DrawPanel this DrawablePanel is attached to **/
    private DrawPanel controller = null;

    /** Serial number of persistent  data.
     * Required, because JPanel implements serializable.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor to initialize the DrawablePanel with it's controller
     *
     */
    public DrawablePanel(DrawPanel panel) {
        controller = panel;
    }

    /**
     * Perform all drawing operations
     * By overriding the JPanel method and initiating all the drawing
     * from this place we take advantage of JPanel's double-buffering
     * capability.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(DrawPanel.backgroundColor);

        // Ask our controller for a copy of items to draw
        Vector<Drawable> toPaint = controller.getDrawables();
        for (Drawable d : toPaint)
            d.draw(g);
    }
}
