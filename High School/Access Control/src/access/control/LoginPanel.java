package access.control;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginPanel {
    
    protected JPanel jp = new JPanel(); 
    protected JPanel jb = new JPanel();
    protected TextField usernameField, passwordField;
    
    public JPanel addLoginPanel(){
        
        jp.setLayout(new GridBagLayout());//creates a grid bag layout
        GridBagConstraints gridBag = new GridBagConstraints();
            gridBag.anchor = GridBagConstraints.CENTER;
            gridBag.gridx = 0;
            gridBag.gridy = 0;
        
            JLabel usernameLabel = new JLabel("Username:");//creates the ui for logging in
                jp.add(usernameLabel, gridBag);
            
            JLabel passwordLabel = new JLabel("Password:");
                gridBag.gridy = 1;
                jp.add(passwordLabel, gridBag);
            
            usernameField = new TextField(30);
                gridBag.gridx = 1;
                gridBag.gridy = 0;
                jp.add(usernameField, gridBag);
            
            passwordField = new TextField(30);
                passwordField.setEchoChar('✈');
                gridBag.gridy = 1;
                jp.add(passwordField, gridBag);
        
        return jp;
    }
    
    public JPanel addJButtons(){
        jb.setLayout(new GridBagLayout());
        GridBagConstraints gridBag = new GridBagConstraints();
            gridBag.anchor = GridBagConstraints.CENTER;
            
        
        
        
        return jb;
    }
    
    public String getUsername(){//returns the text entered into the username area
        return usernameField.getText();
    }
    
    public String getPassword(){//returns the text entered into the password area
        return passwordField.getText();
    }
    
}
