/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import asteroid.defense.Game;
import characters.GameRigidBody;
import characters.earth.Earth;
import characters.asteroids.Asteroid;

/**
 *
 * @author eamiller
 */
public class Collider {

    public Collider() {
    }
    
    public static boolean trajectoryWithinSafetyZone(Vector asteroidCenterOfMass, Vector asteroidVelocity){
        int r, d; 
        
        r = Earth.getSafetyZoneRadius();
        d = (int) VectorMath.distanceBetweenCoordinateAndLine(Earth.getDefaultCenterOfMass(),
                asteroidCenterOfMass, asteroidVelocity);
        return d < r + Asteroid.getDiameter()/2;
    }
    
    public boolean collideTwoRectangles(GameRigidBody grb1, GameRigidBody grb2){//works for non-rotating rectangles only
        return collideByWidth(grb1, grb2) & collideByHeight(grb1, grb2);
    }

    private boolean collideByWidth(GameRigidBody gc1, GameRigidBody gc2){
        GameRigidBody onLeft;
        GameRigidBody onRight;
        if(gc1.getPositionVector().getI()<gc2.getPositionVector().getI()){
            onLeft = gc1;
            onRight = gc2;
        }else{
            onLeft = gc2;
            onRight = gc1;
        }
        if(onRight.getPositionVector().getI()<onLeft.getPositionVector().getI()+onLeft.getWidth()){
            return true;
        }
        return false;
    }

    private boolean collideByHeight(GameRigidBody gc1, GameRigidBody gc2){
        GameRigidBody onTop;
        GameRigidBody onBottom;
        if(gc1.getPositionVector().getJ()<gc2.getPositionVector().getJ()){
            onTop = gc1;
            onBottom = gc2;
        }else{
            onTop = gc2;
            onBottom = gc1;
        }
        if(onBottom.getPositionVector().getJ()<onTop.getPositionVector().getJ()+onTop.getHeight()){
            return true;
        }
        return false;
    }
    
    
    
}
