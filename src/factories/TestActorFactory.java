package factories;

import org.junit.Test;

import actors.Actor;

import junit.framework.TestCase;


public class TestActorFactory extends TestCase {

	@Test
	public void testInitialize()
	{
		ActorFactory factory = new ActorFactory();
		
		assertEquals(0, factory.size());
		assertEquals(0, factory.getAlive());
		assertEquals(0, factory.getActors().length);
	}
	
	@Test
	public void testAddActor()
	{
		ActorFactory factory = new ActorFactory();
		Actor a;
		
		factory.make(null);
		a = factory.getActor(0);
		assertEquals(1, factory.size());
		assertEquals(1, factory.getAlive());
		assertEquals(a, factory.getActors()[0]);
		
	}
}
