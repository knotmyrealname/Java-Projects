package passwordmanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LoginScreen {
    
    private int screenWidth, screenHeight;
    private String screenTitle, userN, userP;
    private JFrame loginFrame;
    private JPanel j, buttonPanel;
    private String leText;
    private static TextField pwField;
    private static TextField textField;
    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 15);
    private Encryptor encryptor = new Encryptor();
    public LoginScreen(){
        //just initializes the class for the tester
    }
    
    public LoginScreen(String title, int height, int width) {
        //Initilizes the Screen
        screenWidth = width;
        screenHeight = height;
        screenTitle = title;
        
        
        loginFrame = new JFrame(screenTitle);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setSize(screenWidth, screenHeight);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setResizable(false);
            
    }
    
    public void createLoginPanel() {
        //creates the JPanel of which includes all the elements of the login screen
        j = new JPanel();
            j.setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
            gridBag.anchor = GridBagConstraints.NORTH;
            gridBag.gridx = 0;
            
                    //creates the title for the login screen
        JLabel loginLabel = new JLabel("Login");
            loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            gridBag.gridy++;
                j.add(loginLabel, gridBag);
                    //adds a space between the title and the username and pw entry areas
        JLabel spaceLabel = new JLabel(" ");
            gridBag.gridy++;
            j.add(spaceLabel, gridBag);
                    //creates the area of which the user is supposed to enter their username
        textField = new TextField(30);
            textField.setFont(defaultFont);
            textField.setText("Username              ");
            textField.addFocusListener(new FocusListener(){
                public void focusGained(FocusEvent e){
                    //makes the field blank when the field is selected
                    if ("Username              ".equals(textField.getText())){
                        textField.setText("");
                    }    
                }
                public void focusLost(FocusEvent e){
                    //renames the field if it was blank and it is deselected
                    if ("".equals(textField.getText())){
                        textField.setText("Username              ");
                    }
                }
            });
            
            gridBag.gridy++;
                j.add(textField, gridBag);
                    //creates the area of which the user enters their password
            
        pwField = new TextField(30);
            pwField.setFont(defaultFont);
            pwField.setText("Password              ");
            pwField.addFocusListener(new FocusListener(){
                public void focusGained(FocusEvent e){
                    //makes the field blank when the field is selected
                    if ("Password              ".equals(pwField.getText())){
                        pwField.setText("");
                        pwField.setEchoChar('*');
                    }    
                }
                public void focusLost(FocusEvent e){
                    //renames the field if it was blank and it is deselected
                    if ("".equals(pwField.getText())){
                        pwField.setText("Password              ");
                        pwField.setEchoChar((char)0);
                    }
                }
            });


            gridBag.gridy++;
                j.add(pwField, gridBag);
            
         
        j.add(loginLabel);
        loginFrame.add(j, BorderLayout.CENTER);
        
}
    
    @SuppressWarnings("Convert2Lambda")
    public void createLoginButtons() {
        buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
            gridBag.anchor = GridBagConstraints.SOUTH;
            gridBag.gridy = 0;
            
        JButton loginButton = new JButton("Login");
            loginButton.setPreferredSize(new Dimension(80, 20));
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    LoginTester test = new LoginTester();
                    try {
                        try {
                            boolean authenicated = test.loginTest("src/Users.txt");
                            if (authenicated == true){
                                System.out.println("validated");
                            }
                            else{
                                System.out.println("not validated");
                            }
                        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("something went wrong");
                        }
                    } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                        Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("something went wrong");
                    }
                }   
            });
            
            gridBag.gridx = 0;
            buttonPanel.add(loginButton, gridBag);
            
        JButton newUser = new JButton("New User");
            newUser.setPreferredSize(new Dimension(80, 20));
            newUser.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    newAccountFrame();
                }
            });
            
            gridBag.gridx = 1;
            buttonPanel.add(newUser, gridBag);
            
        JLabel botFillLabel = new JLabel(" ");
            gridBag.gridy = 1;
            buttonPanel.add(botFillLabel, gridBag);
            
        loginFrame.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void newAccountFrame(){
        JFrame f = new JFrame("New Account");
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setSize(300, 120);
            f.setLocationRelativeTo(null);
            f.setResizable(false);
            
        JPanel p = new JPanel();
            p.setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
            gridBag.anchor = GridBagConstraints.NORTH;
            gridBag.gridx = 0;
        
        TextField username = new TextField(30);
            username.setFont(defaultFont);
            username.setText("Username               ");
            username.addFocusListener(new FocusListener(){
                public void focusGained(FocusEvent e){
                    //makes the field blank when the field is selected
                    if ("Username               ".equals(username.getText())){
                        username.setText("");
                    }    
                }
                public void focusLost(FocusEvent e){
                    //renames the field if it was blank and it is deselected
                    if ("".equals(username.getText())){
                        username.setText("Username               ");
                    }
                }
            });
            gridBag.gridy++;
            p.add(username, gridBag);
            
        TextField password = new TextField(30);
            password.setFont(defaultFont);
            password.setText("Password              ");
            password.addFocusListener(new FocusListener(){
                public void focusGained(FocusEvent e){
                    //makes the field blank when the field is selected
                    if ("Password              ".equals(password.getText())){
                        password.setText("");
                        password.setEchoChar('*');
                    }    
                }
                public void focusLost(FocusEvent e){
                    //renames the field if it was blank and it is deselected
                    if ("".equals(password.getText())){
                        password.setText("Password              ");
                        password.setEchoChar((char)0);
                    }
                }
            });
            gridBag.gridy++;
            p.add(password, gridBag);
            
        JButton register = new JButton("Register");
            register.setPreferredSize(new Dimension(80, 20));
            register.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if (!"Username               ".equals(username.getText()) || !"Password              ".equals(password.getText())){
                        try {
                            TextStore t = new TextStore();
                            t.createTextDocument("src/Users.txt");
                            byte[] salt = encryptor.generateSalt();
                            byte[] encryptedPW = encryptor.Encrypt(password.getText(), salt);
                            t.addToTextDocument("src/Users.txt", username.getText(), encryptedPW, salt);
                            f.dispose();

                        } catch (FileNotFoundException | UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
                            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else{
                        
                    }
                }
            });
        JPanel jp2 = new JPanel();
            jp2.add(register);
            
        f.add(p, BorderLayout.CENTER);
        f.add(jp2, BorderLayout.SOUTH);
        f.setVisible(true);
                
        
    }
    
    public void init() {
        loginFrame.setVisible(true);
    }
    
    public String getUser(){
        return textField.getText();
    }
    public String getPass(){
        return pwField.getText();
    }
        
}
