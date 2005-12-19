/*
 * Created on 12 Δεκ 2004
 */
package gr.aueb.xmascard;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * The XmasCard program main class.
 * 
 * @author Giorgos Gousios
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
        
        /* Create 35 snowflakes*/
        for (int i = 0; i < 35; i++) {
            if ((i % 5 == 0))
                d.addDrawObject(new SlashSnowFlake(
                        (Graphics2D) d.getCanvas().getGraphics(), 
                        d.getCanvas().getBounds()));
            else
                d.addDrawObject(new StarSnowFlake(
                        (Graphics2D) d.getCanvas().getGraphics(), 
                        d.getCanvas().getBounds()));
        }
    }
}