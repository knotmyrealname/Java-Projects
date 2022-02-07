/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author TheAccount
 */
public class Counter {

    private static int numClicks = 0;
    
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame f = new JFrame("Counter");
            f.setSize(500, 300);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            
        JPanel p = new JPanel();
        
            JButton clickdetect = new JButton("click");
                clickdetect.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent e){
                        numClicks++;
                        System.out.println(numClicks);
                    }
                    
                });
            p.add(clickdetect);
            f.add(p);
            f.setVisible(true);
    }
    
}
