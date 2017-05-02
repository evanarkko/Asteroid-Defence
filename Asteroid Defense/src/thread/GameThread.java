/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import asteroid.defense.Game;

/**
 *
 * @author eamiller
 */
public class GameThread {
    private Game game;
    private boolean running;
    private int FPS = 30;
    private double averageFPS;

    public GameThread(Game game) {
        this.game = game;
    }
    
    public void run(){
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000/FPS;
        
        while(running){
            startTime = System.nanoTime();
            
            game.advance();
            
            timeMillis = (System.nanoTime() - startTime)/1000000;
            waitTime = targetTime - timeMillis;

            try{
                Thread.sleep(waitTime);
            }catch(Exception e){}
            
            totalTime += System.nanoTime() - startTime;
            frameCount++;
            
            if(frameCount == FPS){
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
    }
    
    
    public void setRunning(boolean running) {
        this.running = running;
    }
    
    
    
    
}
