package simplemoving;

import java.awt.BorderLayout;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class Simplemoving implements MouseListener {
    
    private static int duckx,ducky,downedBut;

    public static void main(String[] args) {
        JFrame testFrame = new JFrame("testanimation");
            testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            testFrame.setSize(720, 480);
            testFrame.setLocationRelativeTo(null);
            
        JLabel testLabel = new JLabel();
            
        Icon duck = new ImageIcon("images/r-duck.png");
            JButton duckBut = new JButton(duck);
                duckBut.setBorder(null);
                duckBut.setSize(32, 32);
                    duckx = 360; 
                    ducky = 240;
                duckBut.setLocation(duckx, ducky);
                duckBut.setPressedIcon(duck);
                    testLabel.add(duckBut);
        testFrame.isFocusable();
        testLabel.isFocusable();
        testFrame.setFocusable(true);
        testLabel.setFocusable(true);
            
        testFrame.addKeyListener(new KeyListener(){

            public void keyTyped(KeyEvent e) {
            }
            @SuppressWarnings("WaitWhileNotSynced")
            public void keyPressed(KeyEvent e) {
                
                int first_intPressed = e.getKeyCode();
                    if (first_intPressed == VK_UP){
                        int stuff = 0;
                        for(int x = 1; x != stuff;x++){
                        ducky++;
                        duckBut.setLocation(duckx, ducky);
                            try {
                                e.wait(33);
                                
                            } catch (InterruptedException ex) {
                                
                                Logger.getLogger(Simplemoving.class.getName()).log(Level.SEVERE, null, ex);
                                
                            }
                        
                        }
                    }
                    else if (first_intPressed == VK_DOWN) {
                        System.out.println("si");
                    }
                    else if (first_intPressed == VK_LEFT){
                        System.out.println("yo");
                    }
                    else if (first_intPressed == VK_RIGHT){
                        System.out.println("wee");
                    }
                    else {
                        System.out.println("N/A");
                    }
            }    
            public void keyReleased(KeyEvent e) {
                
            }});
        
        testLabel.addMouseListener(new MouseListener(){

            public void mouseClicked(MouseEvent e) {
                
                
                }
            public void mousePressed(MouseEvent e) {
                
                testFrame.requestFocus();
                System.out.println("click");
                }
            public void mouseReleased(MouseEvent e) {
                
            }
            public void mouseEntered(MouseEvent e) {
                
            }
            public void mouseExited(MouseEvent e) {
            
            }
            
        });
        
        testFrame.add(testLabel, BorderLayout.CENTER);
        testFrame.setVisible(true);
    }
    
    
}
