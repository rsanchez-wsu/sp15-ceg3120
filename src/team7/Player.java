package team7;

public class Player {
	String name;
	int maxHealth = 50;
	int dmgTaken = 0;
	int posX;
	int posY;
	int state = 1; // 1: active, 2: wait, 3: dead
	
	public Player(String name, int x, int y)
	{
		this.name = name;
		this.posX = x;
		this.posY = y;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public int getDmgTaken()
	{
		return dmgTaken;
	}

	public void takeDmg(int dmgTaken)
	{
		this.dmgTaken += dmgTaken;
	}

	public int getPosX()
	{
		return posX;
	}

	public void setPosX(int posX)
	{
		this.posX = posX;
	}

	public int getPosY()
	{
		return posY;
	}

	public void setPosY(int posY)
	{
		this.posY = posY;
	}

	public int getState()
	{
		return state;
	}

	public void setState(int state)
	{
		this.state = state;
	}

}
