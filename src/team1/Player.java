package team1;

public class Player
{
	
	private int health;
	private int[] position;
	
	public Player()
	{
		health = 50;
		position = new int[2];
	}
	
	public void attack()
	{
		
	}

	public void move()
	{
		
	}
	
	public void pass()
	{
		
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int[] getPosition()
	{
		return position;
	}
	
	public void setHealth(int newHealth)
	{
		health = newHealth;
	}
	
	public void setPosition(int[] newPosition)
	{
		position = newPosition;
	}
	
}
