/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

/**
 *
 * @author eamiller
 */
public class VectorMath {
    //distance between coordinate and line defined by vectors position and direction
    public static double distanceBetweenCoordinateAndLine(Vector coordinate, Vector position, Vector direction){
        double distance;
        
        double x = position.getI();
        double y = position.getJ();
        double k = direction.getSlope();
        //muunnetaan vektorit kertoimiksi suoran yhtälöstä Ax + By + C =  0
                
        double A = k;
        double B = -1;
        double C = y - k*x;
        
        double x0 = coordinate.getI();
        double y0 = coordinate.getJ();
        
        //pisteen etäisyys suorasta yhtälöllä d = |Ax+By+C|/√(A²+B²)
        distance = Math.abs(A*x0+B*y0+C)/Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));
        
        return distance;
    }
    
    public static int distanceBetweenCoordinates(int x1, int y1, int x2, int y2){
        return (int)(Math.sqrt(Math.pow(Math.abs(x1-x2), 2)+Math.pow(Math.abs(y1-y2), 2)));
    }
    
    public static double angleDefinedByTwoPositions(Vector vector1, Vector vector2){
        double dx = vector2.getI()-vector1.getI();
        double dy = vector2.getJ()-vector1.getJ();

        double radians = Math.atan(dy/dx);
        if(vector1.getI()>vector2.getI())radians+=Math.PI;//Tärkeä, koska tangenttifunktio on vajukki
        
        return radians;
    }
    
    public static double angleBetweenTwoSlopes(double slope1, double slope2){
        double angle = Math.atan(Math.abs((slope2-slope1)/(1+slope1*slope2)));
        return angle;
    }

    public static Vector angleAndVelocityToSpeedVector(double radians, double velocity){
        double dx = Math.cos(radians)*velocity;
        double dy = Math.sin(radians)*velocity;
        return new Vector(dx, dy);
    }
    
    public static double slope(double dx, double dy){
        return dy / dx;
    }
    
    public static Vector toVector(){
        return null;
    }
    
    public static boolean CoordinateIsOnLeftHandSideOfLine(Vector coordinate, Vector position, Vector direction){
        //d=(x−x1)(y2−y1)−(y−y1)(x2−x1) is the equation I use
        double x = coordinate.getI();
        double y = coordinate.getJ();
        
        double x1 = position.getI();
        double y1 = position.getJ();
        double x2 = position.getI() + direction.getI();
        double y2 = position.getJ() + direction.getJ();
        
        double d = (x-x1)*(y2-y1)-(y-y1)*(x2-x1);
        
        return d >= 0;
    }
}
