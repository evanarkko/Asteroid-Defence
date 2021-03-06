/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters.asteroids;

import characters.GameCharacter;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author eamiller
 */
public class Asteroid extends GameCharacter{
    private static final double defaultVelocity = 5;
    private static final int diameter = 10;

    public Asteroid() {
        this.velocity = (int)defaultVelocity;
        width = diameter;
        height = diameter;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g); //To change body of generated methods, choose Tools | Templates.
        g.fillOval((int)positionVector.getI(), (int)positionVector.getJ(), width, height);
    }

    @Override
    public void update() {
        super.update(); //To change body of generated methods, choose Tools | Templates.
    }

    public static int getDiameter() {
        return diameter;
    }
    
    public static double getDefaultVelocity(){
        return defaultVelocity;
    }
    
    
    
    
    
    
    
    
}
