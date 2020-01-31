package edu.eci.cvds.patterns.shapes;
import edu.eci.cvds.patterns.shapes.concrete.*;


public class ShapeFactory {

    public static Shape create(RegularShapeType shapeType) {
		Shape figura; 
		switch(shapeType){
			case Triangle:
				figura = new Triangle();
				break;
				
			case Pentagon:
				figura = new Pentagon();
				break;
				
			case Hexagon:
				figura = new  Hexagon();
				break;
				
			case Quadrilateral:
				figura = new  Quadrilateral();
				break;
				
			default: 
				figura = null;
				break;
		}
		return figura;

    }

}