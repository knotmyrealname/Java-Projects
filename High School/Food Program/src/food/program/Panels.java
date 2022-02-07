package food.program;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panels {
    
    public final Font defaultFont = new Font("Times New Roman", Font.PLAIN, 25);
    private final Dimension buttonSize = new Dimension(150, 120);
    public static JTextField hotDogField, bratField, burgerField, friesField, sodaField, waterField;
    private final ButtonFunctions bf = new ButtonFunctions();
    
    
    //returns the banner at the top of the program;
    public JPanel topPanel(){
        JPanel topPanel = new JPanel();
        JLabel banner = new JLabel("Food Program");
        topPanel.add(banner, BorderLayout.CENTER);
        
        return topPanel; 
    }
    
    //adds text next to the text Fields, for context as to what they are referring to
    public JPanel leftPanel(){
        JPanel leftPanel = new JPanel();
            leftPanel.setBackground(Color.cyan);
            leftPanel.setLayout(new GridLayout(6,1));
            
        JLabel hotDogLabel = new JLabel(" Hot Dogs   ");
            hotDogLabel.setFont(defaultFont);
        JLabel bratLabel = new JLabel(" Brats");
            bratLabel.setFont(defaultFont);
        JLabel burgerLabel = new JLabel(" Burgers");
            burgerLabel.setFont(defaultFont);
        JLabel friesLabel = new JLabel(" Fries");
            friesLabel.setFont(defaultFont);
        JLabel sodaLabel = new JLabel(" Sodas");
            sodaLabel.setFont(defaultFont);
        JLabel waterLabel = new JLabel(" Waters");
            waterLabel.setFont(defaultFont);
        
        leftPanel.add(hotDogLabel);
        leftPanel.add(bratLabel);
        leftPanel.add(burgerLabel);
        leftPanel.add(friesLabel);
        leftPanel.add(sodaLabel);
        leftPanel.add(waterLabel);
        
        return leftPanel;
    }
    
    //creates and returns the midPanel, which contains the text input panels, only allowing for a maximum of 7 characters and numbers to be entered
    public JPanel midPanel(){
        JPanel midPanel = new JPanel();
            midPanel.setBackground(Color.cyan);
            midPanel.setLayout(new GridLayout(6,1));
                
               //initializes the hotDogField, adding a keyListener to limit the max number of keys to 7 and setting the font
            hotDogField = new JTextField("");
                hotDogField.setFont(defaultFont);
                hotDogField.addKeyListener(new KeyListener(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(hotDogField.getText().length() >= 7 || !Character.isDigit(e.getKeyChar())){
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                    } 
                });
                
            bratField = new JTextField("");
                bratField.setFont(defaultFont);
                bratField.addKeyListener(new KeyListener(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(bratField.getText().length() >= 7 || !Character.isDigit(e.getKeyChar())){
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                    } 
                });
            burgerField = new JTextField("");
                burgerField.setFont(defaultFont);
                burgerField.addKeyListener(new KeyListener(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(burgerField.getText().length() >= 7 || !Character.isDigit(e.getKeyChar())){
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                    } 
                });
            friesField = new JTextField("");
                friesField.setFont(defaultFont);
                friesField.addKeyListener(new KeyListener(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(friesField.getText().length() >= 7 || !Character.isDigit(e.getKeyChar())){
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                    } 
                });
            sodaField = new JTextField("");
                sodaField.setFont(defaultFont);
                sodaField.addKeyListener(new KeyListener(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(sodaField.getText().length() >= 7 || !Character.isDigit(e.getKeyChar())){
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                    } 
                });
            waterField = new JTextField("");
                waterField.setFont(defaultFont);
                waterField.addKeyListener(new KeyListener(){
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if(waterField.getText().length() >= 7 || !Character.isDigit(e.getKeyChar())){
                            e.consume();
                        }
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                    } 
                });
                
            midPanel.add(hotDogField);
            midPanel.add(bratField);
            midPanel.add(burgerField);
            midPanel.add(friesField);
            midPanel.add(sodaField);
            midPanel.add(waterField);
            
            return midPanel;
    }
    
    //creates and returns the buttonsPanel, which contain the JButtons of which contain the functionality of the project
    public JPanel buttonsPanel(){
        JPanel buttonsPanel = new JPanel();
            buttonsPanel.setBackground(Color.cyan);
            buttonsPanel.setLayout(new GridLayout(4,1));
            
        // creates the JButton of which does the computations and also creates the receipt
        JButton calculateButton = new JButton("Calculate");
            calculateButton.setPreferredSize(buttonSize);
            calculateButton.setFont(defaultFont);
            calculateButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    bf.calculate(hotDogField.getText(), bratField.getText(), burgerField.getText(), friesField.getText(), sodaField.getText(), waterField.getText());
                }
            });
        
        //creates the clearButton, of which clears the inputs
        JButton clearButton = new JButton("Clear");
            clearButton.setPreferredSize(buttonSize);
            clearButton.setFont(defaultFont);
            clearButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    clearFields();
                }
            });
            
        //creates the logsButton, of which opens another window, with previous saved orders
        JButton logsButton = new JButton("Logs");
            logsButton.setPreferredSize(buttonSize);
            logsButton.setFont(defaultFont);
            logsButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if (!Logs.historyList.isEmpty()){
                        Logs l = new Logs();
                        l.createLogFrame();
                    }
                }
            });
        
        //creates the exitButton, of which exits out of the Program
        JButton exitButton = new JButton("Exit");
            exitButton.setPreferredSize(buttonSize);
            exitButton.setFont(defaultFont);
            exitButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }  
            });
            
        //adds everything to the buttonsPanel
        buttonsPanel.add(calculateButton);
        buttonsPanel.add(logsButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(exitButton);
        
        return buttonsPanel;
    }
    
    public void clearFields(){
        hotDogField.setText("");
        bratField.setText("");
        burgerField.setText("");
        friesField.setText("");
        sodaField.setText("");
        waterField.setText("");
    }
}
