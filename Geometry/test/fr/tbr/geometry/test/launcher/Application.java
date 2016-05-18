/**
 * 
 */
package fr.tbr.geometry.test.launcher;

import fr.tbr.geometry.datamodel.Circle;
import fr.tbr.geometry.datamodel.Shape;
import fr.tbr.geometry.datamodel.Square;
import fr.tbr.geometry.datamodel.Triangle;

/**
 * @author tbrou
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Triangle triangle = new Triangle(10, 5, 7, 8);
		
		Circle circle = new Circle(10.5);
		
		Square square = new Square(5);
		
		
		Shape[] shapes = {triangle, circle, square};
		double totalArea = 0.0;
		for (Shape shape : shapes){
			totalArea += shape.calculateArea();
		}
		//double totalArea = triangle.calculateArea() + circle.calculateArea() + square.calculateArea();
		System.out.println(totalArea);
		
	}

}
