package scenes.WorldScene.GUI;

import java.awt.Graphics;

import actors.Player;
import scenes.WorldScene.WorldSystem.WorldSystem;
import engine.ContentPanel;
import engine.Engine;
import engine.HUD;
import engine.Sprite;

/**
 * WorldHUD
 * @author nhydock
 *
 *	Graphics display for the world
 */
public class WorldHUD extends HUD
{
	Engine e;
	Sprite map;
	Sprite leader;		//party leader, his sprite gets drawn
	
	public WorldHUD(WorldSystem s)
	{
		parent = s;
		e = Engine.getInstance();
		map = s.getMap();
	}
	
	public void setLeader(Player p)
	{
		leader = p.getSprite();
	}
	
	public void paint(Graphics g)
	{
		if (map == null)
			return;
		
		g.translate(-((WorldSystem)parent).getX()*16 + (int)map.getWidth()/4, -((WorldSystem)parent).getY()*16  + (int)map.getHeight()/4);
		map.paint(g);
		leader.setX(((WorldSystem)parent).getX()*16-leader.getHeight()+16);
		leader.setY(((WorldSystem)parent).getY()*16-leader.getWidth()/2+8);
		leader.paint(g);
	}
}
