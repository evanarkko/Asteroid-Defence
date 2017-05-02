/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroid.defense;

import inputListeners.GameMouseListener;
import thread.GameThread;
import ui.GameCanvas;
import ui.GameFrame;

/**
 * MAIN CLASS
 * @author eamiller
 */
public class AsteroidDefense {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameCanvas canvas = new GameCanvas();
        Game game = new Game(canvas);
        
        canvas.addMouseListener(new GameMouseListener(game));
        GameFrame gf = new GameFrame(canvas);
        
        
        GameThread gt = new GameThread(game);
        
        gt.setRunning(true);
        gt.run();
    }
}
