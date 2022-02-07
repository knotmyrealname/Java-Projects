package grade.program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class ClassFrame{
    
    private JTextArea scoresArea;
    private JLabel averageLabel, highLabel, lowLabel;
    
    public static ArrayList<Double> programmingGrades = new ArrayList<>(), 
            artGrades = new ArrayList<>(),
            scienceGrades = new ArrayList<>(), 
            mathGrades = new ArrayList<>(),
            historyGrades = new ArrayList<>();
    
    
    public void createClassFrame(String class_name, ArrayList<Double> array){
        JFrame classFrame = new JFrame(class_name);
        classFrame.setSize(600, 400);
        classFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        classFrame.setResizable(false);
        classFrame.setLocationRelativeTo(null);
        
        JPanel  outputPanel = new JPanel(new GridBagLayout());
                
        JLabel className = new JLabel(class_name);
            className.setFont(new Font("Times New Roman", Font.BOLD, 25));
            className.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel scoresPanel = new JPanel();
        scoresArea = new JTextArea(11, 20);
            //scoresArea.setEditable(false); 
            scoresArea.setBackground(Color.WHITE);
            scoresArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            scoresPanel.add(scoresArea);
        JScrollPane scroll = new JScrollPane(scoresArea);
            scroll.setPreferredSize(new Dimension(400, 300));
            scoresPanel.add(scroll);
            
            
        
        JPanel calValuesPanel = new JPanel();
        averageLabel = new JLabel();
        highLabel = new JLabel();
        lowLabel = new JLabel();
            
        
        
        
        
        
        classFrame.addWindowListener(new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e) {
            }
            @Override
            public void windowClosing(WindowEvent e) {
            }
            @Override
            public void windowClosed(WindowEvent e) {
                Frame f = new Frame();
                f.showFrame();
            }
            @Override
            public void windowIconified(WindowEvent e) {
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
            }
            @Override
            public void windowActivated(WindowEvent e) {
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
            }
            
        });
        classFrame.add(outputPanel, BorderLayout.CENTER);
        classFrame.add(className, BorderLayout.NORTH);
        classFrame.add(scoresPanel, BorderLayout.WEST);
        classFrame.setVisible(true);
    }
    
}
