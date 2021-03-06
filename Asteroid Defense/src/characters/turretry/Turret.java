/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters.turretry;

import asteroid.defense.Game;
import characters.GameRigidBody;
import characters.asteroids.Asteroid;
import javax.imageio.ImageIO;
import physics.Vector;
import physics.VectorMath;
import ui.GameFrame;

/**
 *
 * @author eamiller
 */
public class Turret extends GameRigidBody{
    private Game game;
    private static final int defaultWidth = 40;
    private static final int defaultHeight = 25;
    private static final Vector defaultPosition = new Vector(GameFrame.gameDimension/2-defaultWidth/2,
                GameFrame.gameDimension/2-defaultHeight/2);
    private Missile missile;
    
    public Turret(Game game){
        this.game = game;
        setImage();
        width = defaultWidth;
        height = defaultHeight;
        positionVector = defaultPosition;
        setCM();
    }
    
    public boolean interceptionIsPossible(Vector asteroidCenterOfMAss, Vector asteroidVelocity){
        //NOT IMPLEMENTED
        return false;
    }
    
    public void shootAtAsteroid(Asteroid asteroid){
        missile = new Missile();
        double cmx = cmVector.getI();
        double cmy = cmVector.getJ();
        missile.setPosition(new Vector(cmx-Missile.getDefaultWidth()/2,
                cmy-Missile.getDefaultHeight()/2));//set missile in the middle of the 
        
        calculateMissileSpeedVector(asteroid.getCmVector(), asteroid.getSpeedVector());
        
        game.getMissiles().add(missile);
    }
    
    private void calculateMissileSpeedVector(Vector asteroidCenterOfMAss, Vector asteroidVelocity){
        double angleFromEarthToSpawningPoint  = VectorMath.angleDefinedByTwoPositions(missile.getCmVector(),
                asteroidCenterOfMAss);
        double gamma;
        //gamma + angleFromEarthToSpawningPoint = angle in which the missile intercepts the asteroid
        
        double alpha = calculateAlpha(asteroidCenterOfMAss, asteroidVelocity);
        
        gamma = calculateGamma(alpha);
        if(gamma == -1){
            //MISSILE IS UNABLE TO REACH ASTEROID AND WILL SHOOT FALSELY
        }
        
        this.angle = angleFromEarthToSpawningPoint + gamma;
        if(tangentFunctionFixNeeded(asteroidCenterOfMAss, asteroidVelocity)){
            this.angle = angleFromEarthToSpawningPoint-gamma;
        }
        
        missile.setSpeedVectorByAngle(angle);
    }
    
    //this will fix possible mistakes due to the tangent functions limitedness
    private boolean tangentFunctionFixNeeded(Vector asteroidCenterOfMAss, Vector asteroidVelocity){
        return VectorMath.CoordinateIsOnLeftHandSideOfLine(cmVector, asteroidCenterOfMAss, asteroidVelocity);
    }
    
    private double calculateGamma(double alpha){
        double missileVelocity = Missile.getDefaultVelocity();
        double asteroidVelocity = Asteroid.getDefaultVelocity();
        
        double ratio = asteroidVelocity / missileVelocity;
        
        if(Math.abs(ratio*Math.sin(alpha))>1){
            return -1;//code takes you here if you shoot away
                      //from the earth and missile can't catch up due to being slower.
                      //Fix for this not implemented.
        }
        
        return Math.asin(ratio*Math.sin(alpha));
    }
    
    
    /*Alpha is the angle between the asteroid trajectory
    and the line defined by earth's center of mass and the spawning
    coorinate of the asteroid. I use it to find the angle gamma*/
    private double calculateAlpha(Vector astroidCenterOfMass, Vector asteroidVelocity){
        double dx = this.cmVector.getI() - astroidCenterOfMass.getI();
        double dy = this.cmVector.getJ() - astroidCenterOfMass.getJ();
        
        return VectorMath.angleBetweenTwoSlopes(VectorMath.slope(dx, dy),
                asteroidVelocity.getSlope());
    }
    
    
    
    @Override
    protected void setImage(){
        try{
            image = ImageIO.read(getClass().getResource("/imageResources/turret.png"));
        }catch(Exception e){
            System.out.println("Exception in setting Earth's image");
        }
    }
    
}
