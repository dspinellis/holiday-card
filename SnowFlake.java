/*
 * Created on 6 Δεκ 2004
 */
package gr.aueb.xmascard;

import java.awt.FontMetrics;

/**
 * A self-drawable 'snowflake' represented by a character. The move pattern and
 * character to be displayed is determined by subclasses.
 * 
 * @author Giorgos Gousios
 */
public abstract class SnowFlake extends Drawable {

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
     * Clear the displayed character from the canvas. Gets the width and height
     * of the displayed character from the font metrics calculator for the
     * current font.
     */
    public void clear() {

        FontMetrics fm = canvas.getFontMetrics();
        canvas.clearRect(coordX, coordY, fm.charWidth(displayChar), 
                fm.getHeight());
        canvas.setColor(canvas.getBackground());
        canvas.fillRect(coordX, coordY, fm.charWidth(displayChar), 
                fm.getHeight());
    }

    public abstract void draw();
    
}