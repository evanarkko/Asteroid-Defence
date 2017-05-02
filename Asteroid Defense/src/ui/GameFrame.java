/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author eamiller
 */
public class GameFrame extends JFrame{
    public static final int gameDimension = 700;
    private GameCanvas canvas;
    
    public GameFrame(GameCanvas canvas){
        this.canvas = canvas;
        setLayout(new BorderLayout());
        setSize(gameDimension, gameDimension);
        setTitle("Asteroid Defense");
        add("Center", canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //way to put frame in center
        setLocationRelativeTo(null);
        
        setVisible(true);
    }

    public GameCanvas getCanvas() {
        return canvas;
    }
    
    
    
}
