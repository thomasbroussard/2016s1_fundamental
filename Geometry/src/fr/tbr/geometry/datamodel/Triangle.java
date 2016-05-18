/**
 * 
 */
package fr.tbr.geometry.datamodel;

/**
 * @author tbrou
 *
 */
public class Triangle implements Shape{
	
	private double base;
	private double height;
	private double aSide;
	private double bSide;
	
	
	
	
	/**
	 * @param base
	 * @param height
	 * @param aSide
	 * @param bSide
	 */
	public Triangle(double base, double height, double aSide, double bSide) {
		this.base = base;
		this.height = height;
		this.aSide = aSide;
		this.bSide = bSide;
	}
	
	
	/**
	 * @return the base
	 */
	public final double getBase() {
		return base;
	}
	/**
	 * @param base the base to set
	 */
	public final void setBase(double base) {
		this.base = base;
	}
	/**
	 * @return the height
	 */
	public final double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public final void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return the aSide
	 */
	public final double getaSide() {
		return aSide;
	}
	/**
	 * @param aSide the aSide to set
	 */
	public final void setaSide(double aSide) {
		this.aSide = aSide;
	}
	/**
	 * @return the bSide
	 */
	public final double getbSide() {
		return bSide;
	}
	/**
	 * @param bSide the bSide to set
	 */
	public final void setbSide(double bSide) {
		this.bSide = bSide;
	}
	
	/**
	 * 
	 * @return the area of the current triangle
	 */
	public double calculateArea(){
		return this.base * this.height / 2;
	}
	
	
	/**
	 * 
	 * @return the perimeter of the current triangle
	 */
	public double calculatePerimeter(){
		return this.base + this.aSide + this.bSide;
	}
	
	

}
