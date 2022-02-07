package snek.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Window {
    
    public JFrame j;
    private Snek s = new Snek();
    public static int currentDirection = Snek.EAST;
    public final int keyWest = 37, keyNorth = 38, keyEast = 39, keySouth = 40;
    private Images i = new Images();
    private static Graphics2D g2;
    
    //creates the JFrame
    
    public void createJFrame(String name, int width, int height){
        j = new JFrame(name);
            j.setSize(width, height);
            j.setLocationRelativeTo(null);
            j.setResizable(false);
            j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            j.addKeyListener(new KeyListener(){
                public void keyPressed(KeyEvent e){
                    setSnekDirection(e.getKeyCode());
                }
                public void keyReleased(KeyEvent e){
            
                }
                public void keyTyped(KeyEvent e){
            
                }
            });
            
        
    }
    
    //adds the JPanel containing the scores to the JFrame
    public void addInfoPanel(){
        JPanels jp = new JPanels();
            jp.initInfoPanel();
        j.add(jp.infoPanel);
    }
    
    //adds the JPanel containing the game elements to the JFrame
    public void addGamePanel() throws InterruptedException{
        JPanels jp = new JPanels();
            jp.initGamePanel();
        j.add(jp.gamePanel);
        
    }
    
    
    
    //initializes the JFrame
    public void init(){
        j.setVisible(true);
    }
    
    
    private void setSnekDirection(int direction){
        switch(direction) {
            case keyWest: 
                if (currentDirection != Snek.EAST){
                    currentDirection = Snek.WEST;
                }
                break;
            case keyNorth:
                if (currentDirection != Snek.SOUTH){
                    currentDirection = Snek.NORTH;
                }
                break;
            case keyEast:
                if (currentDirection != Snek.WEST){
                    currentDirection = Snek.EAST;
                }
                break;
            case keySouth:
                if (currentDirection != Snek.NORTH){
                    currentDirection = Snek.SOUTH;
                }
                break;
            default: 
                break;
        }
    }
    
    public int snekDirection(){
        return currentDirection;
    }
    
    
}
