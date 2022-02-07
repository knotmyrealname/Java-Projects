package firstattempt;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("FieldMayBeFinal")

public abstract class Firstattempt extends JFrame implements ActionListener{

    private static JTextField hotDogNum, bratNum, burgerNum, friesNum,
            sodaNum, waterNum, errorText,companyField, infoText
            ;//stores the input areas and text areas
    private static int hotDogInt, bratInt, burgerInt, orderNum,
            friesInt, sodaInt, waterInt, errorNum, hotDogLoggedInt, bratLoggedInt, burgerLoggedInt, 
            friesLoggedInt, sodaLoggedInt, waterLoggedInt= 0;//stores the values for the number of items
    private static double hotDogDouble, bratDouble, burgerDouble, friesDouble,
            sodaDouble, waterDouble, totalsDouble, subtotalsDouble, taxTaken,
            hotDogLoggedDouble, bratLoggedDouble, burgerLoggedDouble, friesLoggedDouble, 
            sodaLoggedDouble, waterLoggedDouble;//prices after tax
    private static final double taxRate = 1.0675;
    private static final double hotDogPrice = 2.50;
    private static final double bratPrice = 3.50;
    private static final double burgerPrice = 5.00;
    private static final double friesPrice = 2.00;
    private static final double sodaPrice = 2.00;
    private static final double waterPrice = 0.00;
    private static JButton calculateButton, clearButton, logsButton,
            exitButton, totalsExitButton, totalsSaveButton;//stores the respecting buttons
    private static String[] errorList = {
        "Hot Dog", "Brat", "Burger", "Fries", "Soda", "Water"
    };
    private static String[] plural = {
        "", "s"
    };
    private static int hotDogPlural, bratPlural, burgerPlural, sodaPlural,
            waterPlural, rowsNum;
    private static JLabel hotDogField, bratField, burgerField, friesField, sodaField,
            waterField, hotDogPriceField, bratPriceField, burgerPriceField, friesPriceField,
            sodaPriceField, waterPriceField, totalsArea, subtotalsField, subtotalsPriceField,
            taxesField, taxesPriceField, totalsField, totalsPriceField, hotDogLoggedPriceField, 
            bratLoggedPriceField, burgerLoggedPriceField, friesLoggedPriceField, sodaLoggedPriceField, 
            waterLoggedPriceField, hotDogLoggedField, bratLoggedField, burgerLoggedField, friesLoggedField,
            sodaLoggedField, waterLoggedField;
    private static ArrayList<Integer> saveList = new ArrayList<>();
    private static int buttonNum = 1;
    
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        JFrame f = new JFrame("FirstAttempt");
        f.setSize(900, 450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//creates the main body
        f.setResizable(false);
        
        JPanel topPanel = new JPanel();//sets the top, where there is info about the project
            topPanel.setVisible(true);
            topPanel.setBackground(Color.CYAN);
            
            {
                infoText = new JTextField("420                                              "
                        + "                                            FirstAttempt"
                        + "                                                          "
                        + "                                     3210");
                infoText.setEditable(false);
                infoText.setBorder(null);
                infoText.setOpaque(false);
                
                topPanel.add(infoText);
            }
            
            
        JPanel midPanel = new JPanel();//creates the inputs
            midPanel.setVisible(true);
            midPanel.setBackground(Color.LIGHT_GRAY);
            midPanel.setLayout(new GridLayout(6, 1));
            
            {
                Font textInputFont = new Font("Times New Roman", Font.PLAIN, 30);
                hotDogNum = new JTextField(10);//creates the textfields,    
                    hotDogNum.setFont(textInputFont);
                    hotDogNum.addKeyListener(new KeyListener(){
                        
                        public void keyTyped(KeyEvent e) {
                            if (hotDogNum.getText().length() >= 5 ) // limit textfield to 3 characters
                            e.consume();
                        }
                        public void keyPressed(KeyEvent e) {
                        }
                        public void keyReleased(KeyEvent e) {
                        }});
                bratNum = new JTextField(10);//otherwise, the actual textboxes for inputs
                    bratNum.setFont(textInputFont);
                    bratNum.addKeyListener(new KeyListener(){
                        public void keyTyped(KeyEvent e) {
                            if (bratNum.getText().length() >= 5 ) // limit textfield to 3 characters
                            e.consume();
                        }
                        public void keyPressed(KeyEvent e) {
                        }
                        public void keyReleased(KeyEvent e) {
                        }});
                burgerNum = new JTextField(50);
                    burgerNum.setFont(textInputFont);
                    burgerNum.addKeyListener(new KeyListener(){
                        public void keyTyped(KeyEvent e) {
                            if (burgerNum.getText().length() >= 5 ) // limit textfield to 3 characters
                            e.consume();
                        }
                        public void keyPressed(KeyEvent e) {
                        }
                        public void keyReleased(KeyEvent e) {
                        }});
                friesNum = new JTextField(50);
                    friesNum.setFont(textInputFont);
                    friesNum.addKeyListener(new KeyListener(){
                        public void keyTyped(KeyEvent e) {
                            if (friesNum.getText().length() >= 5 ) // limit textfield to 3 characters
                            e.consume();
                        }
                        public void keyPressed(KeyEvent e) {
                        }
                        public void keyReleased(KeyEvent e) {
                        }});
                sodaNum = new JTextField(50);
                    sodaNum.setFont(textInputFont);
                    sodaNum.addKeyListener(new KeyListener(){
                        public void keyTyped(KeyEvent e) {
                            if (sodaNum.getText().length() >= 5 ) // limit textfield to 3 characters
                            e.consume();
                        }
                        public void keyPressed(KeyEvent e) {
                        }
                        public void keyReleased(KeyEvent e) {
                        }});
                waterNum = new JTextField(50);
                    waterNum.setFont(textInputFont);
                    waterNum.addKeyListener(new KeyListener(){
                        public void keyTyped(KeyEvent e) {
                            if (waterNum.getText().length() >= 5 ) // limit textfield to 3 characters
                            e.consume();
                        }
                        public void keyPressed(KeyEvent e) {
                        }
                        public void keyReleased(KeyEvent e) {
                        }});
                
                
                
                
                
                midPanel.add(hotDogNum); midPanel.add(bratNum); midPanel.add(burgerNum);
                midPanel.add(friesNum); midPanel.add(sodaNum); midPanel.add(waterNum);
                
            }
            
        
        JPanel eastPanel = new JPanel();//creates the east jpanel, which holds the output fields
            eastPanel.setVisible(true);
            Color eastPColor = new Color(123, 213, 38);
            eastPanel.setBackground(eastPColor);
            eastPanel.setLayout(new GridLayout(4, 1));
            {
                calculateButton = new JButton("Calculate");//sets the buttons
                clearButton = new JButton("Clear");
                exitButton = new JButton("Exit");
                logsButton = new JButton("Log");
                
                eastPanel.add(calculateButton);
                eastPanel.add(clearButton);
                eastPanel.add(logsButton);
                eastPanel.add(exitButton);
                
                calculateButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        try {
                            errorNum = 0;
                            orderNum++;
                            String hotDogInput = hotDogNum.getText();//gets the text and makes all
                                if (hotDogInput.equals("")||hotDogInput.equals(" ")||//null values 0
                                        hotDogInput.equals("  ")||hotDogInput.equals("   ")||
                                        hotDogInput.equals("    ")||hotDogInput.equals("     ")){
                                    hotDogInput = "0";
                                }   
                            String bratInput = bratNum.getText();
                                if (bratInput.equals("")||bratInput.equals(" ")||
                                        bratInput.equals("  ")||bratInput.equals("   ")||
                                        bratInput.equals("    ")||bratInput.equals("     ")){
                                    bratInput = "0";
                                }
                            String burgerInput = burgerNum.getText();
                                if (burgerInput.equals("")||burgerInput.equals(" ")||
                                        burgerInput.equals("  ")||burgerInput.equals("   ")||
                                        burgerInput.equals("    ")||burgerInput.equals("     ")){
                                    burgerInput = "0";
                                }
                            String friesInput = friesNum.getText();
                                if (friesInput.equals("")||friesInput.equals(" ")||
                                        friesInput.equals("  ")||friesInput.equals("   ")||
                                        friesInput.equals("    ")||friesInput.equals("     ")){
                                    friesInput = "0";
                                }
                            String sodaInput = sodaNum.getText();
                                if (sodaInput.equals("")||sodaInput.equals(" ")||
                                        sodaInput.equals("  ")||sodaInput.equals("   ")||
                                        sodaInput.equals("    ")||sodaInput.equals("     ")){
                                    sodaInput = "0";
                                }
                            String waterInput = waterNum.getText();
                                if (waterInput.equals("")||waterInput.equals(" ")||
                                        waterInput.equals("  ")||waterInput.equals("   ")||
                                        waterInput.equals("    ")||waterInput.equals("     ")){
                                    waterInput = "0";
                                }
                                
                            hotDogInt = Integer.parseInt(hotDogInput);//checks whether or not to
                                errorNum++;//make the word plural
                                if (hotDogInt != 1){
                                    hotDogPlural = 1;
                                }
                                else{
                                    hotDogPlural = 0;
                                }
                            bratInt = Integer.parseInt(bratInput);
                                errorNum++;
                                if (bratInt != 1){
                                    bratPlural = 1;
                                }
                                else{
                                    bratPlural = 0;
                                }
                            burgerInt = Integer.parseInt(burgerInput);
                                errorNum++;
                                if (burgerInt != 1){
                                    burgerPlural = 1;
                                }
                                else{
                                    burgerPlural = 0;
                                }
                            friesInt = Integer.parseInt(friesInput);
                                errorNum++;
                            sodaInt = Integer.parseInt(sodaInput);
                                errorNum++;
                                if (sodaInt != 1){
                                    sodaPlural = 1;
                                }
                                else{
                                    sodaPlural = 0;
                                }
                            waterInt = Integer.parseInt(waterInput);
                                errorNum++;
                                if (waterInt != 1){
                                    waterPlural = 1;
                                }
                                else{
                                    waterPlural = 0;
                                }
                            
                            hotDogDouble = hotDogInt * hotDogPrice;//does the math for the
                            bratDouble = bratInt * bratPrice;//subtotals price
                            burgerDouble = burgerInt * burgerPrice;
                            friesDouble = friesInt * friesPrice;
                            sodaDouble = sodaInt * sodaPrice;
                            waterDouble = waterInt * waterPrice;
                            
                            
                        JFrame calculationFrame = new JFrame("Totals");//creates the actual frame with the information
                            calculationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            calculationFrame.setSize(200, 300);
                            calculationFrame.setLocationRelativeTo(null);
                            
                            subtotalsDouble = hotDogDouble + bratDouble + friesDouble + 
                                    sodaDouble + waterDouble + burgerDouble;//rounds and does more math
                            totalsDouble = subtotalsDouble * taxRate;
                            subtotalsDouble = Math.round(subtotalsDouble * 100.0)/100.0;
                            totalsDouble = Math.round(totalsDouble * 100.0)/100.0;
                            taxTaken = Math.round((totalsDouble - subtotalsDouble) * 100.0)/100.0;
                        
                            
                        JPanel leftTotalsFrame = new JPanel();
                            leftTotalsFrame.setBackground(Color.white);//creates the two sides, one with 
                                                    //prices and the other with the name
                        JPanel rightTotalsFrame = new JPanel();
                            rightTotalsFrame.setBackground(Color.white);
                        
                        JPanel companyFrame = new JPanel();
                            companyField = new JTextField("Company Name");//creates the company name
                            companyField.setFont(new Font("Century Gothic", Font.BOLD, 16));
                            companyField.setHorizontalAlignment(SwingConstants.CENTER);
                            companyField.setEditable(false);
                            companyField.setBorder(null);
                            companyFrame.setBackground(Color.WHITE);
                            companyFrame.add(companyField);//adds the components to the calc frame
                                                        
                        totalsArea = new JLabel("Totals");//displays the logic
                            totalsArea.setBorder(null);
                            totalsArea.setBackground(Color.WHITE);
                            totalsArea.setVisible(true);
                            totalsArea.setHorizontalAlignment(SwingConstants.CENTER);
                            totalsArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                            companyFrame.add(totalsArea);
                        
                        
                        
                            if (hotDogInt != 0){//the actual text of the thing
                                hotDogField = new JLabel(hotDogInt + " Hot Dog" + plural[hotDogPlural]);
                                    hotDogField.setBorder(null);
                                hotDogPriceField = new JLabel("$" + hotDogDouble +"0 ");
                                    hotDogPriceField.setBorder(null);
                                    hotDogPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                leftTotalsFrame.add(hotDogField); rightTotalsFrame.add(hotDogPriceField);
                            }
                            
                            if (bratInt != 0){
                                bratField = new JLabel(bratInt + " Brat" + plural[bratPlural]);
                                    bratField.setBorder(null);
                                bratPriceField = new JLabel("$" + bratDouble +"0 ");
                                    bratPriceField.setBorder(null);
                                    bratPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                leftTotalsFrame.add(bratField); rightTotalsFrame.add(bratPriceField);
                            }
                        
                            if (burgerInt != 0)
                            {
                                burgerField = new JLabel(burgerInt + " Burger" + plural[burgerPlural]);
                                    burgerField.setBorder(null);
                                burgerPriceField = new JLabel("$" + burgerDouble +"0 ");
                                    burgerPriceField.setBorder(null);
                                    burgerPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                               leftTotalsFrame.add(burgerField); rightTotalsFrame.add(burgerPriceField);
                            }
                        
                            if (friesInt != 0)
                            {
                                friesField = new JLabel(friesInt + " Fries");
                                    friesField.setBorder(null);
                                friesPriceField = new JLabel("$" + friesDouble +"0 ");
                                    friesPriceField.setBorder(null);
                                    friesPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                leftTotalsFrame.add(friesField); rightTotalsFrame.add(friesPriceField);
                            }
                        
                            if (sodaInt != 0)
                            {
                                sodaField = new JLabel(sodaInt + " Soda" + plural[sodaPlural]);
                                    sodaField.setBorder(null);
                                sodaPriceField = new JLabel("$" + sodaDouble +"0 ");
                                    sodaPriceField.setBorder(null);
                                    sodaPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                leftTotalsFrame.add(sodaField); rightTotalsFrame.add(sodaPriceField);
                            }
                        
                            if (waterInt != 0)
                            {
                                waterField = new JLabel(waterInt + " Water" + plural[waterPlural]);
                                    waterField.setBorder(null);
                                waterPriceField = new JLabel("$" + waterDouble +"0 ");
                                    waterPriceField.setBorder(null);
                                    waterPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                leftTotalsFrame.add(waterField); rightTotalsFrame.add(waterPriceField);
                            }
                        
                        subtotalsField = new JLabel("Subtotals");
                            leftTotalsFrame.add(subtotalsField);
                        subtotalsPriceField = new JLabel("$" + subtotalsDouble + "0 ");
                            rightTotalsFrame.add(subtotalsPriceField);
                            subtotalsPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                            
                        taxesField = new JLabel("Taxes");
                            leftTotalsFrame.add(taxesField);
                            String taxesString = ("$" + taxTaken);
                        taxesPriceField = new JLabel();
                            rightTotalsFrame.add(taxesPriceField);
                            if (taxesString.endsWith(".1")||taxesString.endsWith(".2")||taxesString.endsWith(".3")
                              ||taxesString.endsWith(".4")||taxesString.endsWith(".5")||taxesString.endsWith(".6")
                              ||taxesString.endsWith(".7")||taxesString.endsWith(".8")||taxesString.endsWith(".9")){  
                                taxesPriceField.setText(taxesString + "0 ");
                            }
                            else if (taxesString.endsWith(".")){
                                taxesPriceField.setText(taxesString + "00 ");
                            }
                            else {
                                taxesPriceField.setText(taxesString + " ");
                            }
                            taxesPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                            
                        
                        totalsField = new JLabel("Totals");
                            leftTotalsFrame.add(totalsField);
                            String totalsString = ("$" + totalsDouble);
                        totalsPriceField = new JLabel();
                            rightTotalsFrame.add(totalsPriceField);
                            if (totalsString.endsWith(".1")||totalsString.endsWith(".2")||totalsString.endsWith(".3")
                              ||totalsString.endsWith(".4")||totalsString.endsWith(".5")||totalsString.endsWith(".6")
                              ||totalsString.endsWith(".7")||totalsString.endsWith(".8")||totalsString.endsWith(".9")){  
                                totalsPriceField.setText(totalsString + "0 ");
                            }
                            else if (taxesString.endsWith(".")){
                                totalsPriceField.setText(totalsString + "00 ");
                            }
                            else {
                                totalsPriceField.setText(totalsString + " ");
                            }
                            totalsPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                        
                        
                        leftTotalsFrame.setLayout(new GridLayout(10, 1));//sets the layout
                        rightTotalsFrame.setLayout(new GridLayout(10, 1));
                        companyFrame.setLayout(new GridLayout(2, 1));
                        
                        calculationFrame.add(companyFrame, BorderLayout.NORTH);
                        calculationFrame.add(leftTotalsFrame, BorderLayout.CENTER);
                        calculationFrame.add(rightTotalsFrame, BorderLayout.EAST);
                        
                        calculationFrame.setVisible(true);
                        calculationFrame.setResizable(false);
                        
                        
                        JPanel exitandsavePanel = new JPanel();//creates the bottom panel where the user
                            exitandsavePanel.setLayout(new GridLayout(1,2));//can decide whether to save the
                            exitandsavePanel.setBorder(null); //order or delete it
                            exitandsavePanel.setBackground(Color.white); 
                            totalsExitButton = new JButton("Close");
                                exitandsavePanel.add(totalsExitButton);
                                totalsExitButton.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        JFrame exitFrame =  new JFrame("Exit");//asks whether the user want to
                                            exitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                            exitFrame.setSize(150,70);//actually exit
                                            exitFrame.setLocationRelativeTo(null);
                                            exitFrame.setResizable(false);
                                            exitFrame.setVisible(true);
                                        JPanel exitButtonPanel = new JPanel();
                                            exitButtonPanel.setLayout(new GridLayout(1, 2, 0, 0));
                                            
                                        JLabel exitLabel = new JLabel("Are You Sure?");
                                            exitFrame.add(exitLabel, BorderLayout.NORTH);
                                            exitLabel.setBorder(null);
                                        JButton yesExitButton = new JButton("Exit");
                                            exitButtonPanel.add(yesExitButton);
                                            yesExitButton.addActionListener(new ActionListener(){
                                                public void actionPerformed(ActionEvent e) {//asks whether the user wants
                                                    JFrame exitandclearFrame = new JFrame("Clear the Order?");//the order cleared
                                                        exitandclearFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                        exitandclearFrame.setSize(140, 65);
                                                        exitandclearFrame.setLocationRelativeTo(null);
                                                        exitandclearFrame.setResizable(false);
                                                        exitandclearFrame.setVisible(true);
                                                    JPanel exitandclearPanel = new JPanel();
                                                            exitandclearPanel.setLayout(new GridLayout(1, 2));
                                                        JButton clearandExitButton = new JButton("Yes");
                                                        JButton donotclearButton = new JButton("No");
                                                            exitandclearPanel.add(clearandExitButton);
                                                            exitandclearPanel.add(donotclearButton);
                                                            exitandclearFrame.add(exitandclearPanel, BorderLayout.CENTER);
                                                        
                                                    clearandExitButton.addActionListener(new ActionListener(){
                                                        public void actionPerformed(ActionEvent e) {
                                                            exitFrame.dispose();
                                                            calculationFrame.dispose();
                                                            exitandclearFrame.dispose();
                                                            ClearStuffPlease csp = new ClearStuffPlease();
                                                        }});
                                                    
                                                    donotclearButton.addActionListener(new ActionListener(){
                                                        public void actionPerformed(ActionEvent e) {
                                                            exitFrame.dispose();
                                                            calculationFrame.dispose();
                                                            exitandclearFrame.dispose();
                                                        }});
                                                    
                                                    JLabel cleartheorderLabel = new JLabel("Clear the Order?");
                                                        cleartheorderLabel.setBorder(null);
                                                            exitandclearFrame.add(cleartheorderLabel, BorderLayout.NORTH);
                                                        
                                                        
                                            }});
                                        JButton noExitButton = new JButton("Return");//returns the user to the calculation
                                            exitButtonPanel.add(noExitButton);//panel
                                            noExitButton.addActionListener(new ActionListener(){
                                                public void actionPerformed(ActionEvent e){
                                                    exitFrame.dispose();
                                            }});
                                        
                                        exitFrame.add(exitButtonPanel, BorderLayout.CENTER);
                                }});
                                
                            totalsSaveButton = new JButton("Save Order");
                                exitandsavePanel.add(totalsSaveButton);
                                totalsSaveButton.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        for (;saveList.size()%11 != 0; saveList.add(0)){//checks whether the 
                                        }    //savelist is a multiple of 11
                                        saveList.add(hotDogInt);    saveList.add(bratInt);
                                        saveList.add(burgerInt);    saveList.add(friesInt);
                                        saveList.add(sodaInt);      saveList.add(waterInt);
                                        saveList.add(hotDogPlural); saveList.add(bratPlural);
                                        saveList.add(burgerPlural); saveList.add(sodaPlural);
                                        saveList.add(waterPlural);
                                        
                                        ClearStuffPlease csp = new ClearStuffPlease();
                                        calculationFrame.dispose();
                                    }});
                            calculationFrame.add(exitandsavePanel, BorderLayout.SOUTH);
                                
                        
                        }
                        catch(NumberFormatException ex){
                            ErrorButton errBut = new ErrorButton();//implements the ErrorButton
                        }}});
                
                clearButton.addActionListener(new ActionListener(){//clears every value
                    public void actionPerformed(ActionEvent e){
                        ClearStuffPlease csp = new ClearStuffPlease();
                }});
                
                exitButton.addActionListener(new ActionListener(){//closes the system
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                }});
                
                logsButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        if (saveList.size()/11 >= 7){
                            rowsNum = 0;
                        }
                        else{
                            rowsNum = 6;
                        }
                        JFrame logsFrame = new JFrame("LOGS");
                            logsFrame.setSize(400, 300);
                            logsFrame.setLocationRelativeTo(null);
                            logsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            logsFrame.setVisible(true);
                        JPanel logsPanel = new JPanel();
                            logsPanel.setBackground(Color.white);
                            logsPanel.setLayout(new GridLayout(rowsNum, 1));
                            logsFrame.add(logsPanel, BorderLayout.CENTER);
                        JScrollPane logsScroll = new JScrollPane(logsPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                                logsFrame.add(logsScroll);
                        JPanel logsFunctionsPanel = new JPanel();
                            logsFunctionsPanel.setBackground(Color.white);
                            logsFunctionsPanel.setLayout(new GridLayout(1, 4));
                            logsFrame.add(logsFunctionsPanel, BorderLayout.EAST);
                        
                            buttonNum = 0;
                        for(int x = saveList.size()/11; x > 0; x--){
                            buttonNum++;
                            int listNum = buttonNum;
                            String orderNum = ("Order #" + listNum);
                            JButton logs = new JButton(orderNum);
                            
                            logs.setPreferredSize(new Dimension(100, 45));
                            logsPanel.add(logs);
                            logs.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent f){
                                    JFrame loggedFrame = new JFrame(orderNum);
                                        loggedFrame.setSize(200, 300);
                                        loggedFrame.setLocationRelativeTo(null);
                                        loggedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    JPanel orderNumPanel = new JPanel();
                                        loggedFrame.add(orderNumPanel, BorderLayout.NORTH);
                                        orderNumPanel.setBackground(Color.white);
                                    JPanel leftorderLogPanel = new JPanel();
                                        loggedFrame.add(leftorderLogPanel, BorderLayout.CENTER);
                                        leftorderLogPanel.setLayout(new GridLayout(10, 1));
                                        leftorderLogPanel.setBackground(Color.white);
                                    JPanel rightorderLogPanel = new JPanel();
                                        loggedFrame.add(rightorderLogPanel, BorderLayout.EAST);
                                        rightorderLogPanel.setLayout(new GridLayout(10, 1));
                                        rightorderLogPanel.setBackground(Color.white);
                                    JPanel exitLogPanel = new JPanel();
                                        loggedFrame.add(exitLogPanel, BorderLayout.SOUTH);
                                        exitLogPanel.setBackground(Color.white);
                                        
                                    JLabel orderNumArea = new JLabel(orderNum);
                                        orderNumPanel.add(orderNumArea);
                                        orderNumArea.setFont(new Font("Calibri", Font.BOLD, 13));
                                        
                                    hotDogLoggedInt = saveList.get((listNum - 1) * 11);
                                    bratLoggedInt = saveList.get((listNum - 1) * 11 + 1);
                                    burgerLoggedInt = saveList.get((listNum - 1) * 11 + 2);
                                    friesLoggedInt = saveList.get((listNum - 1) * 11 + 3);
                                    sodaLoggedInt = saveList.get((listNum - 1) * 11 + 4);
                                    waterLoggedInt = saveList.get((listNum - 1) * 11 + 5);
                                    
                                    hotDogLoggedDouble = hotDogLoggedInt * hotDogPrice;
                                    bratLoggedDouble = bratLoggedInt * bratPrice;
                                    burgerLoggedDouble = burgerLoggedInt * burgerPrice;
                                    friesLoggedDouble = friesLoggedInt * friesPrice;
                                    sodaLoggedDouble = sodaLoggedInt * sodaPrice;
                                    waterLoggedDouble = waterLoggedInt * waterPrice;
                                    
                                        if (saveList.get((listNum - 1) * 11) != 0){//the actual text of the thing
                                    hotDogLoggedField = new JLabel(hotDogLoggedInt + " Hot Dog" + plural[saveList.get((listNum - 1) * 11 + 6)]);
                                        hotDogLoggedField.setBorder(null);
                                    hotDogLoggedPriceField = new JLabel("$" + hotDogLoggedDouble +"0 ");
                                        hotDogLoggedPriceField.setBorder(null);
                                        hotDogLoggedPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                    leftorderLogPanel.add(hotDogLoggedField); rightorderLogPanel.add(hotDogLoggedPriceField);
                                    }
                            
                                       if (saveList.get((listNum - 1) * 11 + 1) != 0){
                                    bratLoggedField = new JLabel(bratLoggedInt + " Brat" + plural[saveList.get((listNum - 1) * 11 + 7)]);
                                        bratLoggedField.setBorder(null);
                                    bratLoggedPriceField = new JLabel("$" + bratLoggedDouble +"0 ");
                                        bratPriceField.setBorder(null);
                                        bratPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                    leftorderLogPanel.add(bratLoggedField); rightorderLogPanel.add(bratLoggedPriceField);
                                }
                        
                                        if (saveList.get((listNum - 1) * 11 + 2) != 0)
                                {
                                    burgerLoggedField = new JLabel(burgerLoggedInt + " Burger" + plural[saveList.get((listNum - 1) * 11 + 8)]);
                                        burgerLoggedField.setBorder(null);
                                    burgerLoggedPriceField = new JLabel("$" + burgerLoggedDouble +"0 ");
                                        burgerLoggedPriceField.setBorder(null);
                                        burgerLoggedPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                    leftorderLogPanel.add(burgerLoggedField); rightorderLogPanel.add(burgerLoggedPriceField);
                                }
                        
                                        if (saveList.get((listNum - 1) * 11 + 3) != 0)
                                {
                                    friesLoggedField = new JLabel(friesLoggedInt + " Fries");
                                        friesLoggedField.setBorder(null);
                                    friesLoggedPriceField = new JLabel("$" + friesLoggedDouble +"0 ");
                                        friesLoggedPriceField.setBorder(null);
                                        friesLoggedPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                    leftorderLogPanel.add(friesLoggedField); rightorderLogPanel.add(friesLoggedPriceField);
                                }
                        
                                        if (saveList.get((listNum - 1) * 11 + 4) != 0)
                                {
                                    sodaLoggedField = new JLabel(sodaLoggedInt + " Soda" + plural[saveList.get((listNum - 1) * 11 + 9)]);
                                        sodaLoggedField.setBorder(null);
                                    sodaLoggedPriceField = new JLabel("$" + sodaLoggedDouble +"0 ");
                                        sodaLoggedPriceField.setBorder(null);
                                        sodaLoggedPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                    leftorderLogPanel.add(sodaLoggedField); rightorderLogPanel.add(sodaLoggedPriceField);
                                }
                        
                                        if (saveList.get((listNum - 1) * 11 + 5) != 0)
                                {
                                    waterLoggedField = new JLabel(waterLoggedInt + " Water" + plural[saveList.get((listNum - 1) * 11 + 10)]);
                                        waterLoggedField.setBorder(null);
                                    waterLoggedPriceField = new JLabel("$" + waterLoggedDouble +"0 ");
                                        waterLoggedPriceField.setBorder(null);
                                        waterLoggedPriceField.setHorizontalAlignment(SwingConstants.RIGHT);
                                    leftorderLogPanel.add(waterLoggedField); rightorderLogPanel.add(waterLoggedPriceField);
                                }
                                        
                                    loggedFrame.setVisible(true);
                            }});
                        }
                }});
            }
            
            
            
        
        JPanel westPanel = new JPanel();
            westPanel.setVisible(true);
            westPanel.setBackground(Color.lightGray);
            westPanel.setLayout(new GridLayout(6, 1));
        
            
            
            
            
            
            
            
        
        
        f.add(topPanel, BorderLayout.NORTH);
        f.add(midPanel, BorderLayout.CENTER);
        f.add(eastPanel, BorderLayout.EAST);
        f.add(westPanel, BorderLayout.WEST);
        f.setVisible(true);
    }

    private static class ErrorButton {//creates the errorbutton to be referenced

        @SuppressWarnings("Convert2Lambda")
        public ErrorButton() {
            JFrame stringError = new JFrame("Error");//creates the frame for the
            stringError.setSize(250, 100);//error message
            stringError.setLocationRelativeTo(null);
            stringError.setVisible(true);
            stringError.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                
        errorText = new JTextField(20);
            errorText.setEditable(false);
            errorText.setText("Error: Invalid Values used for " + errorList[errorNum]);
            errorText.setBorder(null);
            errorText.setHorizontalAlignment(JTextField.CENTER);
            stringError.add(errorText, BorderLayout.NORTH);
                                
        JButton errorButton = new JButton("OK");//creates a close button 
            stringError.add(errorButton, BorderLayout.CENTER);//to return to the 
            errorButton.addActionListener(new ActionListener(){//main program
                public void actionPerformed(ActionEvent e){
                    stringError.dispose();
                }});
        }
        
    }    
    
    private static class ClearStuffPlease {
        public ClearStuffPlease() {
            hotDogNum.setText("");  bratNum.setText("");    burgerNum.setText("");
            friesNum.setText("");   sodaNum.setText("");    waterNum.setText("");
            hotDogInt = 0;          bratInt = 0;            burgerInt = 0;
            friesInt = 0;           sodaInt = 0;            waterInt = 0;
        }
    }
}
