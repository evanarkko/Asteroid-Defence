/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters.turretry;

import characters.GameCharacter;
import java.awt.Graphics;

/**
 *
 * @author eamiller
 */
public class Missile extends GameCharacter{
    private static final double defaultVelocity = 3;
    private static final int defaultWidth = 5;
    private static final int defaultHeight = 5;
    
    public Missile(){
        this.velocity = (int)defaultVelocity;
        this.width = defaultWidth;
        this.height = defaultHeight;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g); //To change body of generated methods, choose Tools | Templates.
        g.fillRect((int)positionVector.getI(), (int)positionVector.getJ(), width, height);
    }
    
    

    public static int getDefaultHeight() {
        return defaultHeight;
    }

    public static int getDefaultWidth() {
        return defaultWidth;
    }

    public static double getDefaultVelocity() {
        return defaultVelocity;
    }

    
    
    
    
    
    
    
}
