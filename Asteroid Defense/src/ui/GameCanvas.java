/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import asteroid.defense.Game;
import characters.asteroids.*;
import characters.turretry.Missile;
import java.awt.Canvas;
import java.awt.Graphics;

/**
 *
 * @author eamiller
 */
public class GameCanvas extends Canvas{
    private Game game;
    
        // TODO code application logic here
    @Override
    public void paint(Graphics g) {
        drawGame(g);
    }
    
    private void drawGame(Graphics g){
        g.drawLine(GameFrame.gameDimension/2, 0, GameFrame.gameDimension/2, GameFrame.gameDimension);
        g.drawLine(0, GameFrame.gameDimension/2, GameFrame.gameDimension, GameFrame.gameDimension/2);
        game.getEarth().draw(g);
        game.getTurret().draw(g);
        for(Asteroid a : game.getAsteroids()){
            a.draw(g);
        }
        for(Missile m : game.getMissiles()){
            m.draw(g);
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    
   
    
}
