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
public class Vector {
    private double i, j;

    public Vector() {
    }

    public Vector(double i, double j) {
        this.i = i;
        this.j = j;
    }

    public double getI() {
        return i;
    }

    public double getJ() {
        return j;
    }
    
    public double getSlope(){
        return j/i;
    }
    
    public void dI(double di){
        i += di;
    }
    
    public void dJ(double dj){
        j += dj;
    }
    
    
}
