/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import interfaces.drawable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import physics.Vector;

/**
 *
 * @author eamiller
 */
public class GameRigidBody implements drawable{
    protected Image image;
    protected Vector positionVector;
    protected Vector cmVector; //coordinates at center of mass
    protected int width, height;
    protected double angle;

    @Override
    public void draw(Graphics g) {//http://stackoverflow.com/questions/10685016/rotating-an-image-in-java
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(angle, cmVector.getI(), cmVector.getJ());
        g2d.drawImage(image, (int)positionVector.getI(), (int)positionVector.getJ(), width, height, null);
        g2d.rotate(-angle, cmVector.getI(), cmVector.getJ());
    }

    protected void setImage() {
        
    }
    
    protected void setCM(){
        cmVector = new Vector(positionVector.getI() + width/2, positionVector.getJ() + height/2);
    }
    
    public void setPosition(Vector positionVector) {
        this.positionVector = positionVector;
        setCM();
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Vector getPositionVector() {
        return positionVector;
    }
    
    
    
    
    
    
}
