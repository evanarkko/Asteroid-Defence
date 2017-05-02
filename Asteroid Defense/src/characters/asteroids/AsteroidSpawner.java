/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters.asteroids;

import asteroid.defense.Game;
import physics.Collider;
import physics.Vector;
import physics.VectorMath;

/**
 *
 * @author eamiller
 */
public class AsteroidSpawner {
    private Game game;
    private Asteroid spawningAsteroid;

    public AsteroidSpawner(Game game){
        this.game = game;
    }
    
    public void setSpawnPositionVector(Vector vector){
        this.spawningAsteroid = new Asteroid();
        spawningAsteroid.setPosition(vector);
    }
    
    public void setSpawningAsteroidsSpeedVector(Vector mouseReleaseVector){
        double asteroidsDirectionAngle = 
                VectorMath.angleDefinedByTwoPositions(spawningAsteroid.getPositionVector() 
                        ,mouseReleaseVector);
        Vector speed = VectorMath.angleAndVelocityToSpeedVector(asteroidsDirectionAngle, Asteroid.getDefaultVelocity());
        this.spawningAsteroid.setSpeedVector(speed);
    }
    
    public void spawnAsteroid(){
        Asteroid spawn = spawningAsteroid;
        this.game.spawnNewAsteroid(spawn);
    }

    public Asteroid getSpawningAsteroid() {
        return spawningAsteroid;
    }
    
    
    
}
