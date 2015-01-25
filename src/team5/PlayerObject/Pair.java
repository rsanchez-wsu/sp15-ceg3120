/*
 * License tbd
 * @author hitchens6
 */
package team5.PlayerObject;

public class Pair {

	private int xPos;
	private int yPos;

	public Pair() {

	}

	public Pair(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	@Override
	public String toString() {
		return "(" + getxPos() + ", " + getyPos() + ")";
	}
}
