package access.control;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class createJFrame {
    public JFrame jf;
    
    public createJFrame(String name, int width, int height){
        jf = new JFrame(name);
            jf.setSize(width, height);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLocationRelativeTo(null);
    }
    
    public void initJFrame(){
        jf.setVisible(true);
    }
    public void addLoginPanel(){
        LoginPanel log = new LoginPanel();
        jf.add(log.addLoginPanel(), BorderLayout.CENTER);
        jf.add(log.addJButtons(), BorderLayout.SOUTH);
        
    }
    
    
}
