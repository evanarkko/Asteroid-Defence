/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroid.defense;

import characters.earth.Earth;
import characters.asteroids.Asteroid;
import characters.turretry.*;
import interfaces.updateable;
import java.util.ArrayList;
import java.util.Collections;
import physics.Collider;
import physics.Vector;
import ui.*;

/**
 *
 * @author eamiller
 */
public class Game implements updateable {
    private GameCanvas canvas;
    private Collider collider;
    private Earth earth;
    private Turret turret;
    private ArrayList<Asteroid> asteroids = new ArrayList<>();
    private ArrayList<Missile> missiles = new ArrayList<>();
            
    
    public Game(GameCanvas canvas){
        this.canvas = canvas;
        this.canvas.setGame(this);
        this.collider = new Collider();
        
        this.earth = new Earth();
        this.turret = new Turret(this);
    }
    
    public void advance(){
        update();
        canvas.repaint();
    }
    
    @Override
    public void update() {
        manageGameCollisions();
        for(Asteroid a : asteroids){
            a.update();
        }
        for(Missile m: missiles){
            m.update();
        }
    }
    
    public void spawnNewAsteroid(Asteroid asteroid){
        asteroids.add(asteroid);
        if(Collider.trajectoryWithinSafetyZone(asteroid.getCmVector(), 
                asteroid.getSpeedVector())){
            turret.shootAtAsteroid(asteroid);
        }
    }
    
    private void manageGameCollisions(){
        ArrayList<Integer> asteroidIndexes = new ArrayList<>();
        ArrayList<Integer> missileIndexes = new ArrayList<>();
        int asteroidIndex = 0;
        for(Asteroid a : asteroids){
            int missileIndex = 0;
            for(Missile m : missiles){
                if(collider.collideTwoRectangles(a, m)){
                    asteroidIndexes.add(asteroidIndex);
                    missileIndexes.add(missileIndex);
                }
                missileIndex++;
            }
            asteroidIndex++;
        }
        Collections.reverse(asteroidIndexes);
        Collections.reverse(missileIndexes);
        
        for(int i : asteroidIndexes){
            asteroids.remove(i);
        }
        for(int i : missileIndexes){
            missiles.remove(i);
        }
    }

    public Earth getEarth() {
        return earth;
    }

    public Turret getTurret() {
        return turret;
    }

    public ArrayList<Asteroid> getAsteroids() {
        return asteroids;
    }

    public ArrayList<Missile> getMissiles() {
        return missiles;
    }
}
