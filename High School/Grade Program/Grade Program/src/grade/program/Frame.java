package grade.program;

import javax.swing.JFrame;

public class Frame {
    
        public static JFrame initialFrame;
    
    //sets up the initialFrame, determines its size and location, for class selection
    public void createIntroductoryFrame(){
        initialFrame = new JFrame("Grade Program");
            initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            initialFrame.setSize(500, 300);
            initialFrame.setLocationRelativeTo(null);
            initialFrame.setResizable(false);
            
            
            
        
    }
    
    //adds all of the elements to the initialFrame
    public void initFrame(){
        ClassButtons cb = new ClassButtons();
        initialFrame.add(cb.classesPanel());
        initialFrame.setVisible(true);
    }
    
    //makes the JFrame visible
    public void showFrame(){
        initialFrame.setVisible(true);
    }
    
    //makes the JFrame invisible
    public void hideFrame(){
        initialFrame.setVisible(false);
    }
}
