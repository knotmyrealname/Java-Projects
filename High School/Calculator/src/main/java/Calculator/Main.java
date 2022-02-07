package Calculator;

import java.awt.BorderLayout;//imports all the libraries that I am going to use
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Main {

    private static Font functionsFont = new Font("Comic Sans", Font.PLAIN, 40 );//initializes some of the global values of which I will use
    private static JLabel inputLabel = new JLabel("");
    private static boolean error = false;
    private static int numOfChars;

    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {//creates the window of which the calculator operates in
        JFrame calculatorFrame = new JFrame("Calculator");
            calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            calculatorFrame.setSize(300, 500);
            calculatorFrame.setResizable(true);
            calculatorFrame.setLocationRelativeTo(null);
            
        JPanel functionsPanel = new JPanel();//creates the area of which the function buttons (ie. addition, subtraction, multiplication,
            functionsPanel.setBackground(new Color(174, 185, 201));//division, and enter) are housed
            functionsPanel.setLayout(new GridLayout(5,1));
            
            JButton additionButton = new JButton("+");//creates the function buttons and adds a string value consisting of the calue that was used
                additionButton.setFont(functionsFont);
                additionButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("+");
                    }
                });
                functionsPanel.add(additionButton);
                
            JButton subtractionButton = new JButton("-");
                subtractionButton.setFont(functionsFont);
                subtractionButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("-");
                    }
                });
                functionsPanel.add(subtractionButton);
                
            JButton multiplicationButton = new JButton("x");
                multiplicationButton.setFont(functionsFont);
                multiplicationButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("*");
                    }
                });
                functionsPanel.add(multiplicationButton);
                
            JButton divisionButton = new JButton("/");
                divisionButton.setFont(functionsFont);
                divisionButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("/");
                    }
                });
                functionsPanel.add(divisionButton);
                
            JButton enterButton = new JButton("=");
                enterButton.setFont(functionsFont);
                    enterButton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            try {
                                String equationString = inputLabel.getText();
                                ScriptEngineManager mgr = new ScriptEngineManager();
                                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                                    Object finalObject = engine.eval(equationString);
                                    String finalString = finalObject.toString();
                                    inputLabel.setText(finalString);
                            } catch (ScriptException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                inputLabel.setText("ERROR");
                                error = true;
                                
                            }
                            
                        }
                    });
                functionsPanel.add(enterButton);
            
            
            
        JPanel keysPanel = new JPanel();
            keysPanel.setBackground(new Color(162, 199, 255));
            keysPanel.setLayout(new GridLayout(5, 3));
            
            JButton clearButton = new JButton("AC");
                clearButton.setFont(functionsFont);
                    clearButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        inputLabel.setText("");
                        error = false;
                        numOfChars = 0;
                    }
                });
                keysPanel.add(clearButton);
                
            JButton leftParenthesesButton = new JButton("(");
                leftParenthesesButton.setFont(functionsFont);
                    leftParenthesesButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("(");
                    }
                });
                keysPanel.add(leftParenthesesButton);
                
            JButton rightParenthesesButton = new JButton(")");
                rightParenthesesButton.setFont(functionsFont);
                    rightParenthesesButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue(")");
                    }
                });
                keysPanel.add(rightParenthesesButton);
                
            JButton oneButton = new JButton("1");
                oneButton.setFont(functionsFont);
                    oneButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("1");
                    }
                });
                keysPanel.add(oneButton);
                
            JButton twoButton = new JButton("2");
                twoButton.setFont(functionsFont);
                    twoButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("2");
                    }
                });
                keysPanel.add(twoButton);
                
            JButton threeButton = new JButton("3");
                threeButton.setFont(functionsFont);
                    threeButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("3");
                    }
                });
                keysPanel.add(threeButton);
                
            JButton fourButton = new JButton("4");
                fourButton.setFont(functionsFont);
                    fourButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("4");
                    }
                });
                keysPanel.add(fourButton);
                
            JButton fiveButton = new JButton("5");
                fiveButton.setFont(functionsFont);
                    fiveButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("5");
                    }
                });
                keysPanel.add(fiveButton);
                
            JButton sixButton = new JButton("6");
                sixButton.setFont(functionsFont);
                    sixButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("6");
                    }
                });
                keysPanel.add(sixButton);
                
            JButton sevenButton = new JButton("7");
                sevenButton.setFont(functionsFont);
                    sevenButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("7");
                    }
                });
                keysPanel.add(sevenButton);
                
            JButton eightButton = new JButton("8");
                eightButton.setFont(functionsFont);
                    eightButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("8");
                    }
                });
                keysPanel.add(eightButton);
                
            JButton nineButton = new JButton("9");
                nineButton.setFont(functionsFont);
                    nineButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("9");
                    }
                });
                keysPanel.add(nineButton);
                
            JButton deleteButton = new JButton("Del");
                deleteButton.setFont(functionsFont);
                    deleteButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String deletionString = inputLabel.getText();
                        int deleteLength = deletionString.length();
                        deleteLength--;
                        inputLabel.setText(deletionString.substring(0, deleteLength));
                        if(numOfChars == 0){
                        }
                        else{
                            numOfChars--;
                        }
                        if(numOfChars < 12){
                        inputLabel.setFont(functionsFont);
                        }
                        else{   
                            inputLabel.setFont(new Font("Comic Sans", Font.PLAIN, 420/numOfChars));
                            }
                    }
                });
                keysPanel.add(deleteButton);
                
            JButton zeroButton = new JButton("0");
                zeroButton.setFont(functionsFont);
                    zeroButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue("3");
                    }
                });
                keysPanel.add(zeroButton);
                
            JButton periodButton = new JButton(".");
                periodButton.setFont(functionsFont);
                    periodButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AddValue av = new AddValue(".");
                    }
                });
                keysPanel.add(periodButton);
            
            
        JPanel numbersPanel = new JPanel();
            numbersPanel.setBackground(new Color(250, 250, 250));
                inputLabel.setPreferredSize(new Dimension(300, 70));
                inputLabel.setFont(new Font("Comic Sans", Font.PLAIN, 40));
                inputLabel.setHorizontalAlignment(SwingConstants.TRAILING);
                numbersPanel.add(inputLabel);
            
            calculatorFrame.add(numbersPanel, BorderLayout.NORTH);
            calculatorFrame.add(functionsPanel,BorderLayout.EAST);
            calculatorFrame.add(keysPanel,BorderLayout.CENTER);
            
            
        calculatorFrame.setVisible(true);
    }
    
    private static class AddValue{
        public AddValue(String key){
            if(error == false){
                String inputCopy;
                    inputCopy = inputLabel.getText();
                inputLabel.setText(inputCopy + key);
                numOfChars++;
                    if(numOfChars < 12){
                        inputLabel.setFont(functionsFont);
                    }
                    else{   
                        inputLabel.setFont(new Font("Comic Sans", Font.PLAIN, 420/numOfChars));
                    }
                }
            else{
                inputLabel.setText("");
                error = false;
                String inputCopy;
                    inputCopy = inputLabel.getText();
                inputLabel.setText(inputCopy + key); 
            }
        }
        
    }
    
}
