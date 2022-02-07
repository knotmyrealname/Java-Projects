package notgermanbuttonword;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public abstract class Notgermanbuttonword extends JFrame implements ActionListener{
    
    @SuppressWarnings("FieldMayBeFinal")
    private static int whenJb1a, whenJb1b, whenJb2a, whenJb2b, whenJb3a, whenJb3b, whenJb4a,
                       whenJb4b, whenJb5a, whenJb5b, whenJb6a, whenJb6b, whenJb7a, whenJb7b;
    @SuppressWarnings("FieldMayBeFinal")
    private static boolean bolJb1, bolJb2, bolJb3, bolJb4, bolJb5, bolJb6, bolJb7 = false;
    @SuppressWarnings("FieldMayBeFinal")
    private static boolean bolJb1r, bolJb2r, bolJb3r, bolJb4r, bolJb5r, bolJb6r, bolJb7r = true;
    @SuppressWarnings("FieldMayBeFinal")
    private static int txtt_len = 1;
    @SuppressWarnings({"FieldMayBeFinal", "StaticNonFinalUsedInInitialization"})
    private static ArrayList txtt = new ArrayList();
    private static int txttx = 0;
    private static JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;
    
    
    @SuppressWarnings("Convert2Lambda")
    
    public static void main(String[] args) {
        
        JFrame f = new JFrame("Schaltfläche");
        f.setBounds(0, 0, 400, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        {//creates the buttons
            JPanel jp1 = new JPanel();
        GridLayout grid = new GridLayout(2, 4);
        
            jp1.setLayout(grid);
            
                jb1 = new JButton("1");
                    jb1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                    jb1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        whenJb1a++;
                        whenJb1b++;
                        bolJb1 = (!bolJb1);
                    }});
                    jp1.add(jb1);
                    
                jb2 = new JButton("2");
                    jb2.setFont(new Font("Calibri", Font.ITALIC, 17));
                    jb2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        whenJb2a++;
                        whenJb2b++;
                        bolJb2 = (!bolJb2);
                    }});
                    jp1.add(jb2);
                    
                jb3 = new JButton("3");
                    jb3.setFont(new Font("WingDings", Font.ITALIC, 17));
                    jb3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        whenJb3a++;
                        whenJb3b++;
                        bolJb3 = (!bolJb3);
                    }});
                    jp1.add(jb3);
                jb4 = new JButton("4");
                    jb4.setFont(new Font("Calibri", Font.ITALIC, 17));
                    jb4.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        whenJb2a++;
                        whenJb2b++;
                        bolJb4 = (!bolJb4);
                    }});
                    jp1.add(jb4);
                jb5 = new JButton("5");
                    jb5.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        whenJb5a++;
                        whenJb5b++;
                        bolJb5 = (!bolJb5);
                    }});
                    jp1.add(jb5);
                jb6 = new JButton("6");
                    jb6.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        whenJb6a++;
                        whenJb6b++;
                        bolJb6 = (!bolJb6);
                    }});
                    jp1.add(jb6);
                jb7 = new JButton("7");
                    jb7.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        whenJb7a++;
                        whenJb7b++;
                        bolJb7 = (!bolJb7);
                    }});
                    jp1.add(jb7);
                    
            JTextArea txtArea = new JTextArea(4, 20);
            JScrollPane scrollPane = new JScrollPane(txtArea);
                txtArea.setEditable(false);
                txtArea.setLineWrap(true);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setPreferredSize(new Dimension(250, 250));
                    
            JTextField txt = new JTextField(20);//creates that area where 
            txt.addActionListener(new ActionListener() {//u can type 
                public void actionPerformed(ActionEvent e) {//stuff into
                    String txttext = txt.getText();
                    txtt_len++;
                    System.out.println(txttext);
                    txtt.add(txttext);
                    txtArea.append((String) txtt.get(txttx));
                    txtArea.append("\n");
                    txttx++;
                    txt.setText("");
                }});
            //clearbutton
            JButton clearButton = new JButton("Clear");
                    clearButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        whenJb1a=0; whenJb1b=0; whenJb2a=0; whenJb2b=0; whenJb3a=0;
                        whenJb3b=0; whenJb4a=0; whenJb4b=0; whenJb5a=0; whenJb5b=0;
                        whenJb6a=0; whenJb6b=0; whenJb7a=0; whenJb7b=0; txt.setText("");
                        txtt.clear(); txtArea.setText(null);
                    }});
                    jp1.add(clearButton);
                    
            f.add(jp1, BorderLayout.CENTER);
            f.add(txt, BorderLayout.NORTH);
            f.add(txtArea, BorderLayout.SOUTH);
            
        }
        f.setVisible(true);
    }
    
    
    
}
