/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters.earth;

import characters.GameRigidBody;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import physics.Vector;
import ui.GameFrame;

/**
 *
 * @author eamiller
 */
public class Earth extends GameRigidBody{
    private static final int defaultDiameter = 100;
    private static final int safetyZoneRadius = 120; //radius of safety zone 
    private static final Vector defaultPosition = new Vector(GameFrame.gameDimension/2-defaultDiameter/2,
                GameFrame.gameDimension/2-defaultDiameter/2);
    
    public Earth(){
        setImage();
        width = defaultDiameter;
        height = defaultDiameter;
        positionVector = defaultPosition;
        setCM();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        drawSafetyZone(g);
    }
    
    private void drawSafetyZone(Graphics g){
        int x = (int)(cmVector.getI()-safetyZoneRadius);
        int y = (int)(cmVector.getJ()-safetyZoneRadius);
        g.drawString("SAFETY ZONE", x, y);
        g.drawOval(x, y,
                safetyZoneRadius*2, safetyZoneRadius*2);
    }

    @Override
    protected void setImage(){
        try{
            image = ImageIO.read(getClass().getResource("/imageResources/earth.png"));
        }catch(Exception e){
            System.out.println("Exception in setting Earth's image");
        }
    }

    public static int getSafetyZoneRadius() {
        return safetyZoneRadius;
    }

    public static Vector getDefaultCenterOfMass() {
        return new Vector(defaultPosition.getI()+defaultDiameter/2,
                defaultPosition.getJ()+defaultDiameter/2);
    }

    public static int getDefaultDiameter() {
        return defaultDiameter;
    }
    
    
    
    
    
    
}
