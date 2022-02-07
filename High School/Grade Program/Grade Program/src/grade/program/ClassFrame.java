package grade.program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ClassFrame{
    
    //preinitializes the JTextAreas, JLabels, and JTextFields, and they will be called very often from different classes in the program
    private JTextArea scoresArea;
    private JLabel averageLabel, highLabel, lowLabel;
    private JTextField inputField;
    
    //creates the arraylists, of which will serve as the storage for the program
    public static ArrayList<Double> programmingGrades = new ArrayList<>(), 
            artGrades = new ArrayList<>(),
            scienceGrades = new ArrayList<>(), 
            mathGrades = new ArrayList<>(),
            historyGrades = new ArrayList<>();
    
    //sets the final values, of which are to be referenced for convenience and better reading of code
    private final Font defaultFont = new Font("Times New Roman", Font.PLAIN, 20);
    public final int PROGRAMMING  = 0, ART = 1, SCIENCE = 2, MATH = 3, HISTORY = 4;
    
    //creates the classFrame
    public void createClassFrame(String class_name, int type){
        JFrame classFrame = new JFrame(class_name);
        classFrame.setSize(600, 300);
        classFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        classFrame.setResizable(false);
        classFrame.setLocationRelativeTo(null);
        
            //creates the JLabel with the name of the class
        JLabel className = new JLabel(class_name);
            className.setFont(new Font("Times New Roman", Font.BOLD, 25));
            className.setHorizontalAlignment(SwingConstants.CENTER);
        
            //creates the scoresPanel, of which contains 
        JPanel scoresPanel = new JPanel();
        scoresArea = new JTextArea(5, 15);
            scoresArea.setEditable(false); 
            scoresArea.setBackground(Color.WHITE);
            scoresArea.setFont(defaultFont);
            scoresPanel.add(scoresArea);
        JScrollPane scroll = new JScrollPane(scoresArea);
            scroll.setPreferredSize(new Dimension(250, 240));
            scoresPanel.add(scroll);
            
        switch(type){
            case PROGRAMMING:
                createScores(programmingGrades);
                System.out.println("programming");
                break;
            case ART:
                createScores(artGrades);
                System.out.println("art");
                break;
            case SCIENCE:
                createScores(scienceGrades);
                System.out.println("science");
                break;
            case MATH:
                createScores(mathGrades);
                System.out.println("math");
                break;
            case HISTORY:
                createScores(historyGrades);
                System.out.println("history");
                break;
            default:
                break;
        }
            
            
        JPanel eastPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
        gridBag.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBag.gridx = 0;
        gridBag.gridy = 0;
        gridBag.weightx = 1;
            
        JPanel calValuesPanel = new JPanel(new GridLayout(3,1));
        averageLabel = new JLabel("Average: ");
            averageLabel.setFont(defaultFont);
            averageLabel.setHorizontalAlignment(SwingConstants.LEADING);
            calValuesPanel.add(averageLabel);
        highLabel = new JLabel("High: ");
            highLabel.setFont(defaultFont);
            highLabel.setHorizontalAlignment(SwingConstants.LEADING);
            calValuesPanel.add(highLabel);
        lowLabel = new JLabel("Low: ");
            lowLabel.setFont(defaultFont);
            lowLabel.setHorizontalAlignment(SwingConstants.LEADING);
            calValuesPanel.add(lowLabel);
            eastPanel.add(calValuesPanel, gridBag);
            
        inputField = new JTextField(20);
            inputField.setFont(defaultFont);
            inputField.addKeyListener(new KeyListener(){
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == KeyEvent.VK_PERIOD) {
                        if(inputField.getText().contains(".")){
                            e.consume();
                        }
                    }
                    else if (!Character.isDigit(e.getKeyChar()) || inputField.getText().length() >= 20){
                        e.consume();
                    }
                }
                @Override
                public void keyPressed(KeyEvent e) {
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    String input = inputField.getText();
                    double inputDouble = Double.parseDouble(input);
                    if(inputDouble > 100){
                        inputField.setText("100.0");
                    }
                }
                
            });
            inputField.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    double inputDouble = Double.parseDouble(inputField.getText());
                    switch (type){
                        case PROGRAMMING:
                            programmingGrades.add(inputDouble);
                            break;
                        case ART:
                            artGrades.add(inputDouble);
                            break;
                        case SCIENCE:
                            scienceGrades.add(inputDouble);
                            break;
                        case MATH:
                            mathGrades.add(inputDouble);
                            break;
                        case HISTORY:
                            historyGrades.add(inputDouble);
                            break;
                        default: 
                            break;
                    }
                    scoresArea.append(inputDouble + "\n");
                    inputField.setText("");
                }
            });
            gridBag.gridy++;
            eastPanel.add(inputField, gridBag); 
            
            
        JPanel buttonsPanel = new JPanel(new GridLayout(1,3));
        JButton calculateButton = new JButton("Calculate");
            calculateButton.setFont(defaultFont);
            calculateButton.setPreferredSize(new Dimension(110, 110));
            calculateButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    calculate(type);
                }
            });
            buttonsPanel.add(calculateButton);
            
        JButton clearButton = new JButton("Clear");
            clearButton.setFont(defaultFont);
            clearButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    inputField.setText("");
                }
            });
            buttonsPanel.add(clearButton);
        
        JButton exitButton = new JButton("Exit");
            exitButton.setFont(defaultFont);
            exitButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    classFrame.dispose();
                }
            });
            buttonsPanel.add(exitButton);
            gridBag.gridy++;
            gridBag.weighty = 1;
            eastPanel.add(buttonsPanel, gridBag);
        
        
        
        
        
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
        classFrame.add(className, BorderLayout.NORTH);
        classFrame.add(scoresPanel, BorderLayout.WEST);
        classFrame.add(eastPanel, BorderLayout.CENTER);
        classFrame.setVisible(true);
    }
    
    
    private void calculate(int type){
        ArraySort as = new ArraySort();
        switch (type){
            case PROGRAMMING:
                averageLabel.setText("Average: " + as.average(programmingGrades));
                highLabel.setText("High: " + as.getMax(programmingGrades));
                lowLabel.setText("Low: " + as.getMin(programmingGrades));
                break;
            case ART:
                averageLabel.setText("Average: " + as.average(artGrades));
                highLabel.setText("High: " + as.getMax(artGrades));
                lowLabel.setText("Low: " + as.getMin(artGrades));
                break;
            case SCIENCE:
                averageLabel.setText("Average: " + as.average(scienceGrades));
                highLabel.setText("High: " + as.getMax(scienceGrades));
                lowLabel.setText("Low: " + as.getMin(scienceGrades));
                break;
            case MATH:
                averageLabel.setText("Average: " + as.average(mathGrades));
                highLabel.setText("High: " + as.getMax(mathGrades));
                lowLabel.setText("Low: " + as.getMin(mathGrades));
                break;
            case HISTORY:
                averageLabel.setText("Average: " + as.average(historyGrades));
                highLabel.setText("High: " + as.getMax(historyGrades));
                lowLabel.setText("Low: " + as.getMin(historyGrades));
                break;
            default:
                break;
        }
        
    }
    
    private void createScores(ArrayList<Double> list){
        scoresArea.setText("");
        for(int x = 0; x < list.size(); x++){
            scoresArea.append(list.get(x) + "\n");
        }
    }
    
    
}
