package team3;

public class Point extends java.awt.Point{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Point(int x, int y) {
		super(x, y);
	}//end of constructor
	
	@Override
	public String toString() {
		if(super.x < 0 && super.y < 0) {
			return "(never)";
		}//end of it
		else {
			return "(" + super.x + ", " + super.y + ")";
		}//end of else
	}//end of toString
}//end of Point
