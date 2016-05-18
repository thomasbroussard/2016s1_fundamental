package fr.tbr.geometry.datamodel;

public class Square implements Shape {

	private double side;
	
	/**
	 * @param side
	 */
	public Square(double side) {
		this.side = side;
	}
	
	/**
	 * @return the side
	 */
	public final double getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public final void setSide(double side) {
		this.side = side;
	}

	/**
	 * 
	 * @return the area of the current square
	 */
	public double calculateArea(){
		return this.side * this.side;
	}
	
	
	/**
	 * 
	 * @return the perimeter of the current square
	 */
	public double calculatePerimeter(){
		return this.side * 4 ;
	}
	
	
	
}
