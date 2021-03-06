package scenes;

import java.awt.Graphics;


/**
 * Scene.java
 * @author nhydock
 *
 *	Scene class to encapsulate logic and display
 */

public class Scene{
	
    protected GameSystem system;      //logic system of the scene
    protected HUD display;            //display system of the scene
    
	/**
	 * Starts the scene
	 */
	public void start(){}
	
	/**
	 * Stops the scene
	 */
	public void stop(){}
	
	/**
	 * Mathematical computation run portion
	 */
	public void update()
	{
	    system.update();
	    
	    //forces system to be updated before the display can be drawn
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }	    
        
        display.update();
	}
	
	/**
	 * Key pressed is the only kind of input acceptable
	 * @param keyCode the key code of the key press
	 */
	public void keyPressed(int keyCode)
	{
	    system.keyPressed(keyCode);
	}
	
	/**
	 * Main rendering method call for the scene
	 * @param g
	 */
	public void render(Graphics g)
	{
		if (display != null)
			display.paint(g);
	}
	
	/*
	 * Systems and displays should not be set at any time other than
	 * start, but they can be fetched
	 */
	
	/**
	 * Gets the logic system
	 * @return
	 */
	public GameSystem getSystem()
	{
	    return system;
	}
	
	/**
	 * Gets the graphical display
	 * @return
	 */
	public HUD getDisplay()
	{
	    return display;
	}
}
