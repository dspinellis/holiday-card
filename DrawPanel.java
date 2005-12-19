/*
 * $Id: DrawPanel.java,v 1.3 2005/12/19 01:41:17 dds Exp $
 */
package gr.aueb.xmascard;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

/**
 * The program's main window.
 * Extends JFrame to display the window where the
 * trees and snow are drawn. Implements the {@link java.lang.Runnable Runnable}
 * interface so as to create a thread that repeatedly calls the
 * {@link gr.aueb.xmascard.Drawable#draw() draw}method.
 *
 * @author Giorgos Gousios, Diomidis Spinellis
 */
public class DrawPanel extends JFrame implements Runnable {

    /* A table that holds the objects to be drawn */
    private Vector<Drawable> drawObjects = null;

    /* The drawing thread */
    private Thread thread;

    /* The canvas to draw onto */
    private JPanel canvas = null;

    /**
     * The window's width
     */
    public static final int WIDTH = 640;

    /**
     * The window's height
     */
    public static final int HEIGHT = 480;

    /** Serial number of persistant  data.
     * Required, because JFrame implements serializable.
     */
    static final long serialVersionUID = 1L;

    /**
     * This method initializes and displays the window and starts the
     * animations.
     *
     */
    public DrawPanel() {
        super("Christmas Card");
        initialize();
        drawObjects = new Vector<Drawable>();
        start();
    }

    /**
     * This method initializes the main window.
     */
    private void initialize() {
	// Make our window look nice
        JFrame.setDefaultLookAndFeelDecorated(true);
        setContentPane(getCanvas());
        setDefaultCloseOperation(
                javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT); //The initial size

	// Exit when the window is closed
	addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Force the parent window to expand the canvas to all available space
        pack();
	//Display the window
        setVisible(true);
    }

    /**
     * Redraws the drawing canvas
     *
     */
    private void paint() {
        canvas.setBackground(new Color(0, 153, 204));
        canvas.repaint();
        for (Drawable d : drawObjects)
            d.draw();
    }

    /**
     * Adds a component to be drawn.
     *
     */
    public void addDrawObject(Drawable drawObject) {
        drawObjects.add(drawObject);
    }

    /**
     * The method to be executed by the running thread. Executes the
     * {@link DrawPanel#paint()}method periodically.
     */
    public void run() {
        Thread me = Thread.currentThread();

        while (thread == me) {
            paint();
            try {
                thread.sleep(250);
            } catch (InterruptedException e) {
            }
        }
        thread = null;
    }

    /**
     * Start the execution of the drawing thread.
     *
     */
    private void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.setPriority(Thread.MIN_PRIORITY);
            thread.start();
        }
    }

    /**
     * This method initializes canvas
     *
     * @return javax.swing.JPanel
     */
    public JPanel getCanvas() {
        if (canvas == null) {
            canvas = new JPanel();
            canvas.setBackground(new java.awt.Color(0, 153, 204));
            canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        }
        return canvas;
    }
}
