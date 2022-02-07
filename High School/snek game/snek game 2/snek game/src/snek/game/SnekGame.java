package snek.game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SnekGame {

    private static Timer timer;
    
    
    
    public static void main(String[] args) throws InterruptedException{
        Window window = new Window();
            window.createJFrame("snek", 720, 584);
            window.addInfoPanel();
            window.addGamePanel();
            window.init();
            
            

    }
    
}
