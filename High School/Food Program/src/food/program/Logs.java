package food.program;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Logs {
    //preinitializes these variables because they are used in other classes
    public static ArrayList<Integer> historyList = new ArrayList<>();
    public static double totalPrice;
    Receipt r = new Receipt();
    
    //creates the logsFrame
    public void createLogFrame(){
        JFrame logFrame = new JFrame("Logs");
            logFrame.setSize(550, 300);
            logFrame.setLocationRelativeTo(null);
            logFrame.setResizable(false);
            logFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            //creates the jpanel for the orders and sets a layout
        JPanel gridLogs = new JPanel(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
            gridBag.anchor = GridBagConstraints.FIRST_LINE_START;
            gridBag.gridx = 0;
            gridBag.gridy = 0;
        
            
            //creates the buttons
        for(int x = 1; x <= (historyList.size() / 6); x++ ){
                //creates the button
            JButton logButton = new JButton("Order #" + x);
                logButton.setPreferredSize(new Dimension(110, 20));
                    //allow each individual button to know which button it was
                final int buttonNum = x;
                logButton.setEnabled(true);
                //logButton.setBackground(Color.red);
                    //creates the receipt when the button is clicked on
                logButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        r.createReceipt(historyList, buttonNum, true);
                    }
                });
                //sets the maximum number of columns that are allowed; it is 3+1 = 4
            gridLogs.add(logButton, gridBag);
            gridBag.gridx++;
            if (gridBag.gridx > 3){
                gridBag.gridx = 0;
                gridBag.gridy++;
            }
        }
        //adds a fill Label so that the buttons are not centeraligned whenever the program is not filled with buttons
        gridBag.gridx = 7;
        gridBag.gridy++;
        gridBag.weightx = 1;
        gridBag.weighty = 1;
        JLabel fillLabel = new JLabel("");
        gridLogs.add(fillLabel, gridBag);
        
            //creates the JScrollPane and allows it to function properly; allows for scrolling whenever there is an overflow
        JPanel mainLogs = new JPanel(new FlowLayout(FlowLayout.LEADING));
            mainLogs.add(gridLogs);
            logFrame.add(mainLogs);
        JScrollPane scroll = new JScrollPane(mainLogs);
            logFrame.getContentPane().add(scroll);
            
            
        JPanel functionLogs = new JPanel(new GridLayout(2,1));
        
            //creates the JButton of which will display the total profits for the day
        JButton totalsButton = new JButton("Totals");
            totalsButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    JFrame totalsFrame = new JFrame("Daily Totals");
                        totalsFrame.setLocationRelativeTo(null);
                        totalsFrame.setSize(200,100);
                        totalsFrame.setResizable(false);
                        totalsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    
                    JPanel totalsPanel = new JPanel(new GridLayout(2, 1));
                    
                        //displays the total profits
                    JLabel totalsLabel = new JLabel("Daily Totals: $" + String.format("%.2f", totalPrice));
                        totalsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                        totalsPanel.add(totalsLabel);
                        
                        //allows for easy exiting of the frame
                    JButton exitButton = new JButton("Exit");
                        exitButton.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                totalsFrame.dispose();
                            }
                        });
                        totalsPanel.add(exitButton);
                        
                    totalsFrame.add(totalsPanel);
                    totalsFrame.setVisible(true);
                }
            });
            functionLogs.add(totalsButton);
            
            //exits the program
        JButton exitButton = new JButton("Exit");
            exitButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    logFrame.dispose();
                }
            });
            functionLogs.add(exitButton);
        logFrame.add(functionLogs, BorderLayout.EAST);
        
        logFrame.setVisible(true);
    }
    
}
