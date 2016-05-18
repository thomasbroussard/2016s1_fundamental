package fr.tbr.geometry.datamodel;

public class Circle implements Shape{

	private double radius;
	
	//useless, but to show how to define a constant
	private static final double PI = Math.PI;
	
	/**
	 * @param radius
	 */
	public Circle(double radius) {
		this.radius = radius;
	}

	/**
	 * @return the radius
	 */
	public final double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public final void setRadius(double radius) {
		this.radius = radius;
	}
	
	/**
	 * 
	 * @return the area of the current circle
	 */
	public double calculateArea(){
		return this.radius * this.radius * Math.PI;
	}
	
	
	/**
	 * 
	 * @return the perimeter of the current circle
	 */
	public double calculatePerimeter(){
		return this.radius * 2 * Math.PI;
	}
	
}
