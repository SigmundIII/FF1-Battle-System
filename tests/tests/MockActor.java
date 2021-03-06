package tests;

import actors.Actor;
import graphics.Sprite;

public class MockActor extends Actor{

	public MockActor(String n)
	{
		name = n.substring(0,4);	//char limit of 4
		hp = 10;
		maxhp = 10;
		str = 10;
		def = 10;
		spd = 10;
		evd = 10;
		vit = 10;
		acc = 10;
		itl = 10;
		loadSprites();
	}

	@Override
	protected void loadSprites() {
		sprites = new Sprite[1];
		sprites[0] = new Sprite("data/actors/jobs/base.png");
	}

	@Override
	public Sprite getSprite() {
		return sprites[0];
	}
	
}
