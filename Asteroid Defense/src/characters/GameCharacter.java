/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import interfaces.updateable;
import physics.Vector;
import physics.VectorMath;

/**
 *
 * @author eamiller
 */
public class GameCharacter extends GameRigidBody implements updateable{
    protected int velocity;
    protected Vector speedVector;

    @Override
    public void update() {
        move();
    }
    
    protected void move(){
        positionVector.dI(speedVector.getI());//d for derivaatta
        positionVector.dJ(speedVector.getJ());
        setCM();
    }
    
    public void setSpeedVectorByAngle(double angle){
        setAngle(angle);
        this.speedVector = VectorMath.angleAndVelocityToSpeedVector(angle, velocity);
    }

    public void setSpeedVector(Vector speedVector) {
        this.speedVector = speedVector;
    }

    public Vector getPositionVector() {
        return positionVector;
    }

    public Vector getCmVector() {
        return cmVector;
    }

    public Vector getSpeedVector() {
        return speedVector;
    }

    public int getVelocity() {
        return velocity;
    }
    
    
    
    
    
    
    
}
