package algorithms.mazeGenerators;

/**
 * <h1> Position Class </h1>
 * this class describe a point in our 3D maze by x,y,z and pai(father).
 * @author GalMalca
 * @since 2015-11-07
 * @version 1.0
 */

public class Position {

	private int x, y, z;
	private Position pai;
	
	/**
	 * override to equals by object.
	 * @param object
	 * @return true/false
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(this.equals((Position)obj))
			return true;
		return false;
	}
	
	/**
	 * equals by position.
	 * @param position
	 * @return true/false
	 */
	public boolean equals(Position p)
	{
		if(x==p.getX()&&y==p.getY()&&z==p.getZ())
			return true;
		return false;
	}
	/**
	 * copy constructor 
	 * @param position
	 */
	public Position(Position p) {
		this.x = p.getX();
		this.y = p.getY();
		this.z = p.getZ();
	}
	/**
	 * return a copy of position.
	 * @return position
	 */
	public Position getCopy(){
		return (new Position(this));
	}
	/**
	 * set the father of position.
	 * @param position
	 */
	public void setPai(Position p) {
		this.pai = new Position(p);
	}
	/**
	 * return the father of position.
	 * @return position
	 */
	public Position getPai() {
		return pai;
	}
	/**
	 * override of to string, (to print the position)
	 */
	@Override
	public String toString() {
		return "[" + this.z + "," + this.y + "," + this.x + "]";
	}
	/**
	 * Constructor by x,y,z(integers).
	 * @param x,y,z
	 */
	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * print a position
	 */
	public void print() {
		System.out.println("[" + this.z + "]" + "[" + this.y + "]" + "[" + this.x + "]");
	}
	/**
	 * return a value of the z point in the position
	 * @return z
	 */
	public int getZ() {
		return z;
	}
	/**
	 * set the z point of the position
	 * @param z
	 */
	public void setZ(int z) {
		this.z = z;
	}
	/**
	 * return a value of the y point in the position
	 * @return y
	 */
	public int getY() {
		return y;
	}
	/**
	 * set the y point of the position
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * return a value of the x point in the position
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * set the x point of the position
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

}
