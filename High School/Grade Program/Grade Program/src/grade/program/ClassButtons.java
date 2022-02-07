package grade.program;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ClassButtons {
    
        //initializes the font
    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 20);
    private Frame f = new Frame();
    
    
    //creates the classPanel, of which contains JButtons of which, when pressed, opens the repective screen
    public JPanel classesPanel(){
        JPanel classPanel = new JPanel();
            classPanel.setLayout(new GridLayout(2,3));
            
            
            //creates the JButtons of which have a font selected and an ActionListener added to detect user input
        JButton programmingButton = new JButton("Programming");
            programmingButton.setFont(defaultFont);
            programmingButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    //creates the classframe and hides the introFrame
                    f.hideFrame();
                    ClassFrame cf = new ClassFrame();
                    cf.createClassFrame("Programming", cf.PROGRAMMING);
                    
                }
            });
        
            //creates the JButtons of which have a font selected and an ActionListener added to detect user input
        JButton artButton = new JButton("Art");
            artButton.setFont(defaultFont);
            artButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    //creates the classframe and hides the introFrame
                    f.hideFrame();
                    ClassFrame cf = new ClassFrame();
                    cf.createClassFrame("Art", cf.ART);
                    
                }
            });
        
            //creates the JButtons of which have a font selected and an ActionListener added to detect user input
        JButton scienceButton = new JButton("Science");
            scienceButton.setFont(defaultFont);
            scienceButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    //creates the classframe and hides the introFrame
                    f.hideFrame();
                    ClassFrame cf = new ClassFrame();
                    cf.createClassFrame("Science", cf.SCIENCE);
                }
            });
            
            //creates the JButtons of which have a font selected and an ActionListener added to detect user input
        JButton mathButton = new JButton("Math");
            mathButton.setFont(defaultFont);
            mathButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    //creates the classframe and hides the introFrame
                    f.hideFrame();
                    ClassFrame cf = new ClassFrame();
                    cf.createClassFrame("Math", cf.MATH);
                }
            });
        
            //creates the JButtons of which have a font selected and an ActionListener added to detect user input
        JButton historyButton = new JButton("History");
            historyButton.setFont(defaultFont);
            historyButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    //creates the classframe and hides the introFrame
                    f.hideFrame();
                    ClassFrame cf = new ClassFrame();
                    cf.createClassFrame("History", cf.HISTORY);
                }
            });
        
        JButton exitButton = new JButton("Exit");
            exitButton.setFont(defaultFont);
            exitButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
            
            //adds all of the buttons to the classPanel and returns it
        classPanel.add(programmingButton);
        classPanel.add(artButton);
        classPanel.add(scienceButton);
        classPanel.add(mathButton);
        classPanel.add(historyButton);
        classPanel.add(exitButton);
        
        return classPanel;
    }
    
    
}
