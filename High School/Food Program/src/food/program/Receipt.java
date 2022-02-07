package food.program;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Receipt {
    //sets the prices of everything
    private final double[] price = {2.5, 3.5, 5, 2, 2, 0};
    private final String[] item = {"Hot Dog", "Brat", "Burger", "Fries", "Soda", "Water"};
    private double totalDouble;
    //predeclares the other files so that I can call them without declaring them every time the function is called
    private final Panels p = new Panels();
    
    
    
    //creates the receipt frame, a receipt display, with all of the items that were ordered
    public void createReceipt(ArrayList<Integer> list, int orderNum, boolean isLog){
            //resets the totalsDouble to 0, for calculating the new totals
        totalDouble = 0;
            //sets up the receipt frame
        JFrame calFrame = new JFrame();
            calFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            calFrame.setSize(250, 400);
            calFrame.setLocationRelativeTo(null);
            calFrame.setResizable(false);
            //determines whether this is a totals receipt or a stored receipt, from the orderNum
        if (orderNum == 0){
            calFrame.setTitle("Totals");
        }
        else{
            calFrame.setTitle("Order: " + orderNum); 
        }
        
        
            //creates the topPanel, which contains the company name and the "Totals" word
        JPanel topPanel = new JPanel();
            topPanel.setLayout(new GridLayout(2,1));
            topPanel.setBackground(Color.WHITE);
            
            //creates the Label containing the company name, center-aligned
        JLabel companyLabel = new JLabel("Company Name");
            companyLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
            companyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            topPanel.add(companyLabel);
        
            //creates the Label containing the Label of "Totals", center-aligned
        JLabel totalsLabel = new JLabel("Totals");
            totalsLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            totalsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            topPanel.add(totalsLabel);
            
        JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new GridLayout(1,2));
            bottomPanel.setBackground(Color.WHITE);
        
        if (orderNum == 0){
                //creates the button of which just exits the program
            JButton exitButton = new JButton("Exit");
                exitButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        calFrame.dispose();
                    }
                });
                bottomPanel.add(exitButton);

                //creates the button of which exits and saves the order to the program
            JButton saveButton = new JButton("Save");
                saveButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        Logs.historyList.addAll(list);
                        p.clearFields();
                        calFrame.dispose();
                    }
                });
                bottomPanel.add(saveButton);
        }
        
        
            
        calFrame.add(topPanel, BorderLayout.NORTH);
        calFrame.add(totalsPanel(list, orderNum, isLog), BorderLayout.CENTER);
        calFrame.add(bottomPanel, BorderLayout.SOUTH);
        
        calFrame.setVisible(true);
    }
    
    //creates the totals Panel
    private JPanel totalsPanel(ArrayList<Integer> list, int orderNum, boolean isLog){
            //creates the JPanel of which contains the bulk of the receipt, with all of the order details
        JPanel totalsPanel = new JPanel();
            totalsPanel.setLayout(new GridBagLayout());
            totalsPanel.setBackground(Color.WHITE);
            GridBagConstraints gridBag = new GridBagConstraints();
            gridBag.anchor = GridBagConstraints.FIRST_LINE_START;
            gridBag.gridy = 0;
            gridBag.gridx = 0;
            
        if (orderNum != 0){
            orderNum--;
        }
            //takes the given Arraylist and uses it to display the receipt
        for(int x = 0; x < 6; x++){
            //gets the number of items from the ArrayList, ignoring it if it is 0, taking into account the orderNum, which is used to efficiently store the past history of orders
            int orderQuant = list.get(x + (6 * (orderNum)));
            if(orderQuant != 0){
                
                //crestes the label of which will display the quantity of an item that was ordered, pluralizing it if there are more than 1 item
                JLabel label = new JLabel("  " + orderQuant + " " + item[x] + pluralize(x, orderQuant));
                    label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                    totalsPanel.add(label, gridBag);
                    
                    //fills in the gaps between the two sides
                    gridBag.gridx++;
                    gridBag.weightx = 1;
                JLabel fillLabel = new JLabel("");
                totalsPanel.add(fillLabel, gridBag);
                
                    //calculates the price of the item, which already included the tax, and formatting the price decimal
                    gridBag.gridx++;
                    gridBag.weightx = 0;
                double itemPrice = orderQuant * price[x];
                totalDouble += itemPrice;
                JLabel priceLabel = new JLabel("$" + String.format("%.2f", itemPrice) + " ");
                    priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                    priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                    totalsPanel.add(priceLabel, gridBag);
                    
                    //goes to the next lower vertical spot in gridBagLayout
                    gridBag.gridx = 0;
                    gridBag.gridy++;
            }
        }
        //creates the Totals area, where the total cost is shown
        JLabel subTotalLabel = new JLabel("  Totals:");
            subTotalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
            totalsPanel.add(subTotalLabel, gridBag);
            
            //fills in the spot between the the totals declaration  and the total price
            gridBag.gridx++;
            gridBag.weightx = 1;
        JLabel fillLabel = new JLabel("");
        totalsPanel.add(fillLabel, gridBag);
            
            //displays the total price, formatted to two decimal places
            gridBag.gridx++;
            gridBag.weightx = 0;
        JLabel totalPriceLabel = new JLabel("$" + String.format("%.2f", totalDouble) + " ");
            totalPriceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
            totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            totalsPanel.add(totalPriceLabel, gridBag);
            
            //helps to calculate the total sales of the day
            if (!isLog) {
                Logs.totalPrice += totalDouble;
            }
            
            
            //fills the rest of the space with an empty JLabel
            gridBag.gridx = 0;
            gridBag.gridy++;
            gridBag.weighty = 1;
        JLabel yfillLabel = new JLabel("");
        totalsPanel.add(yfillLabel, gridBag);
        
        return totalsPanel;
    }
    
    
    
    
    private String pluralize(int itemNum, int quantity){
        String s = "";
        switch(quantity){
            case 1:
                break;
            default:
                s = "s";
        }
        if (itemNum == 3){
            s = "";
        }
        return s;
    }
}
