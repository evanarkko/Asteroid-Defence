/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputListeners;

import asteroid.defense.Game;
import characters.asteroids.AsteroidSpawner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import physics.Collider;
import physics.Vector;
import physics.VectorMath;

/**
 *
 * @author eamiller
 */
public class GameMouseListener implements MouseListener{
    private AsteroidSpawner asteroidSpawner;
    
    public GameMouseListener(Game game){
        this.asteroidSpawner = new AsteroidSpawner(game);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
       asteroidSpawner.initializeSpawnPositionVector(new Vector(e.getX(), e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        int x1 = (int)asteroidSpawner.getSpawningAsteroid().getPositionVector().getI();
        int y1 = (int)asteroidSpawner.getSpawningAsteroid().getPositionVector().getJ();
        int x2 = (int)e.getX();
        int y2 = (int)e.getY();
        if(VectorMath.distanceBetweenCoordinates(x1, y1, x2, y2) > 2){
            asteroidSpawner.setSpawningAsteroidsSpeedVector(new Vector(e.getX(), e.getY()));
            asteroidSpawner.spawnAsteroid();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
