/*
 * $Id: DrawPanel.java,v 1.8 2012/12/23 09:51:55 dds Exp $
 */
package gr.aueb.xmascard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The program's main window.
 * Extends JFrame to display the window where the
 * trees and snow are drawn. Implements the {@link java.lang.Runnable Runnable}
 * interface so as to create a thread that repeatedly calls the
 * {@link gr.aueb.xmascard.Drawable#draw() draw}method.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 * @opt nodefillcolor lightblue
 */
public class DrawPanel extends JFrame implements Runnable {

    /** The window's width. */
    public static final int WIDTH = 1024;
    /** The window's height. */
    public static final int HEIGHT = 768;

    /** The window's background color. */
    private static final Color blue = new Color(0, 153, 204);

    /* A table that holds the objects to be drawn */
    private Vector<Drawable> drawObjects = null;

    /* The drawing thread */
    private Thread thread;

    /* The canvas to draw onto */
    private DrawablePanel drawablePanel = null;

    /** Serial number of persistant  data.
     * Required, because JFrame implements serializable.
     */
    static final long serialVersionUID = 1L;

    /**
     * Constructor to initialize and display the window and starts the
     * animation.
     *
     */
    public DrawPanel() {
        super("Christmas Card");
        drawObjects = new Vector<Drawable>();
        initializeGraphics();
        initializeThread();
    }

    /** Initialize the main window. */
    private void initializeGraphics() {
        // Make our window look nice
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create our drawing canvas
        drawablePanel = new DrawablePanel(this);
        drawablePanel.setBackground(blue);
        drawablePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setContentPane(drawablePanel);

        // Handle termination
        setDefaultCloseOperation(
                javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Exit when the window is closed
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Our size
        setSize(WIDTH, HEIGHT);

        // Force the parent window to expand the canvas to all available space
        pack();

        //Display the window
        setVisible(true);
    }

    /** Start the execution of the drawing thread. */
    private void initializeThread() {
        if (thread == null) {
            thread = new Thread(this);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        }
    }

    /** Add a component to be drawn. */
    public void addDrawObject(Drawable drawObject) {
        drawObjects.add(drawObject);
    }

    /** Return a copy of the component list to be drawn */
    public Vector<Drawable> getDrawables() {
        return new Vector<Drawable>(drawObjects);
    }

    /**
     * The method to be executed by the running thread. Executes the
     * {@link DrawablePanel#repaint()}method periodically.
     */
    public void run() {
        Thread me = Thread.currentThread();

        // Allow termination by setting thread to null
        while (thread == me) {
            // tell drawablePanel to repaint it's contents
            drawablePanel.repaint();
            try {
                thread.sleep(250);
            } catch (InterruptedException e) {
            }
        }
        thread = null;
    }

    /**
     * Get the canvas's drawing panel
     *
     * @return javax.swing.JPanel
     */
    public JPanel getCanvas(){
        return drawablePanel;
    }

}


