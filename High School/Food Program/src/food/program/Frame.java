package food.program;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Frame {
    
    public JFrame window;
    private Panels p = new Panels();
    
    //initializes the JFrame
    public Frame(String name, int x_coordinate, int y_coordinate){
        window = new JFrame(name);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(x_coordinate, y_coordinate);
            window.setLocationRelativeTo(null);
            window.setResizable(false);
    }
    
    //initilizes the program by adding all of the elements and setting the JFrame to be visible
    public void init(){
        window.add(p.topPanel(), BorderLayout.NORTH);
        window.add(p.leftPanel(), BorderLayout.WEST);
        window.add(p.midPanel(), BorderLayout.CENTER);
        window.add(p.buttonsPanel(), BorderLayout.EAST);
        window.setVisible(true);
    }
}
