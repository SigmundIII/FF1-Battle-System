package map;

import graphics.Sprite;

import java.awt.Graphics;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * TileSet
 * @author nhydock
 *
 * Special sprite class for tile set handling
 */
public class TileSet extends Sprite{
	public final static int TILE_DIMENSION = 32;			//drawn size
	public final static int ORIGINAL_DIMENSIONS = 16; 		//tile size on the original tileset
	
	/*
	 * Collision mapping values
	 */
	public final static char PASSABLE = 'p';
	public final static char OVERLAY = 'o';
	public final static char IMPASSABLE = 'i';
	
	boolean[][][] passability;
	
	char[][] originalSet;
	
	/**
	 * Loads a tileset
	 * @param s
	 */
	public TileSet(String s)
	{
		super("tilemaps/" + s);
		name = s.substring(0, s.indexOf('.'));
		xFrames = image.getWidth()/ORIGINAL_DIMENSIONS;
		yFrames = image.getHeight()/ORIGINAL_DIMENSIONS;
		passability = new boolean[xFrames][yFrames][];
		originalSet = new char[xFrames][yFrames];
		try
		{
			Scanner reader = new Scanner(new FileInputStream("data/tilemaps/" + name + ".txt"));
			for (int i = 0; i < yFrames; i++)
			{
				String line = reader.nextLine();
				for (int n = 0; n < xFrames; n++)
				{
					char c = line.charAt(n);
					
					originalSet[n][i] = c;
					
					if (c == PASSABLE)
						passability[n][i] = new boolean[]{true, true, true, true, false};
					else if (c == OVERLAY)
						passability[n][i] = new boolean[]{true, true, true, true, true};
					else
						passability[n][i] = new boolean[5];
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			for (int i = 0; i < xFrames; i++)
				for (int n = 0; n < yFrames; n++)
					passability[i][n] = new boolean[]{true, true, true, true, false};
		}
	}
	
	/**
	 * Tile width of the tile set
	 */
	@Override
	public double getWidth()
	{
		return xFrames;
	}
	
	/**
	 * Tile height of the tile set
	 */
	@Override
	public double getHeight()
	{
		return yFrames;
	}
	
	/**
	 * Gets the passability value of a tile in the tile set by its
	 * x and y position in the tile set
	 */
	public boolean[] getPassability(int x, int y)
	{
		return passability[x][y];
	}
	
	/**
	 * Gets the passability value of a tile by its tile id
	 */
	public boolean[] getPassability(int i) {
		return passability[i%xFrames][i/xFrames];
	}
	
	public char[][] getOriginalSet() {
		return originalSet;
	}
	
	/**
	 * Gets the entire passability set for the tile set
	 */
	public boolean[][][] getPassabilitySet()
	{
		return passability;
	}
	
	/**
	 * Draw a specific tile
	 * @param g			Graphics to draw to
	 * @param x			x pos on the graphics
	 * @param y			y pos
	 * @param tileX		horizontal tile choice
	 * @param tileY		vertical tile
	 * @return
	 */
	public void drawTile(Graphics g, int x, int y, int tileX, int tileY)
	{
		if (g != null)
			g.drawImage(image, x, y, x+ORIGINAL_DIMENSIONS, y+ORIGINAL_DIMENSIONS, 
				 tileX*ORIGINAL_DIMENSIONS, tileY*ORIGINAL_DIMENSIONS, tileX*ORIGINAL_DIMENSIONS+ORIGINAL_DIMENSIONS, tileY*ORIGINAL_DIMENSIONS+ORIGINAL_DIMENSIONS, null);
	}
	
	/**
	 * Draw a specific tile scaled for the editor tool kit
	 * @param g			Graphics to draw to
	 * @param x			x pos on the graphics
	 * @param y			y pos
	 * @param tileX		horizontal tile choice
	 * @param tileY		vertical tile
	 * @return
	 */
	public void drawEditorTile(Graphics g, int x, int y, int tileX, int tileY)
	{
		if (g != null)
			g.drawImage(image, x, y, x+TILE_DIMENSION, y+TILE_DIMENSION, 
				 tileX*ORIGINAL_DIMENSIONS, tileY*ORIGINAL_DIMENSIONS, tileX*ORIGINAL_DIMENSIONS+ORIGINAL_DIMENSIONS, tileY*ORIGINAL_DIMENSIONS+ORIGINAL_DIMENSIONS, null);
	}

}
