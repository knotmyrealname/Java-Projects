package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class Drawing {
    
    private static JPanel drawningPanel = new JPanel(); //initializes the variables that will be accessible from the rest of the
    private static Dimension ToolsSize = new Dimension(38, 38);//code in this program
    private static JButton moveTool, selectTool, textTool, eyedropTool, brushTool, erasorTool, lineTool, rectangleTool, circleTool;
    private static Icon moveIcon = new ImageIcon("images/moveTool.png");//all the JButton images that I am going to use and want to be
    private static Icon cursorIcon = new ImageIcon("images/selectionTool.png");//accessible by different parts of the entire program and static
    private static Icon textIcon = new ImageIcon("images/textTool.png");
    private static Icon eyedropIcon = new ImageIcon("images/eyedropper.png");
    private static Icon brushIcon = new ImageIcon("images/brushTool.png");
    private static Icon erasorIcon = new ImageIcon("images/erasorTool.png");
    private static Icon lineIcon = new ImageIcon("images/lineTool.png");
    private static Icon rectangleIcon = new ImageIcon("images/rectangleTool.png");
    private static Icon circleIcon = new ImageIcon("images/eclipseTool.png");
    private static Icon borderedMove = new ImageIcon("images/Bordered Images/borderedmove.png");
    private static Icon borderedCursor = new ImageIcon("images/Bordered Images/borderedcursor.png");
    private static Icon borderedText = new ImageIcon("images/Bordered Images/borderedtext.png");
    private static Icon borderedEyedrop = new ImageIcon("images/Bordered Images/borderedeyedropper.png");
    private static Icon borderedBrush = new ImageIcon("images/Bordered Images/borderedbrush.png");
    private static Icon borderedErasor = new ImageIcon("images/Bordered Images/borderederasor.png");
    private static Icon borderedLine = new ImageIcon("images/Bordered Images/borderedline.png");
    private static Icon borderedRectangle = new ImageIcon("images/Bordered Images/borderedrectangle.png");
    private static Icon borderedEclipse = new ImageIcon("images/Bordered Images/borderedeclipse.png");
    private static int prevButton = -1; //used to determine the previous button pressed; set to -1 so that it doesn't invoke any methods
    private static JFrame mainFrame;
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static Point cursorPoint = new Point(0,0);
    private static int erasorCircle = 8;
    private static int brushCircle = 10;
    
    
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
            //creates the frame of which this program runs in
        mainFrame = new JFrame("Le Draw"); 
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mainFrame.setLocationRelativeTo(null);
            
            
            //creates the JPanel of which holds all the buttons
        JPanel toolsPanel = new JPanel();
            toolsPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            toolsPanel.setBackground(new Color(155,155,155));
            toolsPanel.setLayout(new GridBagLayout());
                GridBagConstraints toolsGrid = new GridBagConstraints();//initilizes the tool of which I am going to use to format this
                    toolsGrid.anchor = GridBagConstraints.FIRST_LINE_START;
                    toolsGrid.gridx = 0;
                    
                
                    
                    //creates the JButtons of which are going to be the main function tools
                moveTool = new JButton(moveIcon);
                    moveTool.setPreferredSize(ToolsSize);
                        moveTool.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SetJButton SJB = new SetJButton(0);//calls the method of which affects the look of the button
                                
                            }
                        });
                        toolsGrid.gridy = 0;
                    toolsPanel.add(moveTool, toolsGrid);
                    
                selectTool = new JButton(cursorIcon);
                    selectTool.setPreferredSize(ToolsSize);
                        selectTool.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SetJButton SJB = new SetJButton(1);//calls the method of which affects the look of the button
                                
                            }
                        });
                        toolsGrid.gridy++;
                    toolsPanel.add(selectTool, toolsGrid);
                    
                textTool = new JButton(textIcon);
                    textTool.setPreferredSize(ToolsSize);
                        textTool.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SetJButton SJB = new SetJButton(2);//calls the method of which affects the look of the button
                                
                            }
                        });
                        toolsGrid.gridy++;
                    toolsPanel.add(textTool, toolsGrid);
                    
                eyedropTool = new JButton(eyedropIcon);
                    eyedropTool.setPreferredSize(ToolsSize);
                        eyedropTool.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SetJButton SJB = new SetJButton(3);//calls the method of which affects the look of the button
                                
                            }
                        });
                        toolsGrid.gridy++;
                    toolsPanel.add(eyedropTool, toolsGrid);
                        
                brushTool = new JButton(brushIcon);
                    brushTool.setPreferredSize(ToolsSize);
                        brushTool.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SetJButton SJB = new SetJButton(4);//calls the method of which affects the look of the button
                                
                            }
                        });
                        toolsGrid.gridy++;
                    toolsPanel.add(brushTool, toolsGrid);
                    
                erasorTool = new JButton(erasorIcon);
                    erasorTool.setPreferredSize(ToolsSize);
                        erasorTool.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SetJButton SJB = new SetJButton(5);//calls the method of which affects the look of the button
                                
                            }
                        });
                        toolsGrid.gridy++;
                    toolsPanel.add(erasorTool, toolsGrid);
                    
                lineTool = new JButton(lineIcon);
                    lineTool.setPreferredSize(ToolsSize);
                        lineTool.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SetJButton SJB = new SetJButton(6);//calls the method of which affects the look of the button
                                
                            }
                        });
                        toolsGrid.gridy++;
                    toolsPanel.add(lineTool, toolsGrid);
                        
                rectangleTool = new JButton(rectangleIcon);
                    rectangleTool.setPreferredSize(ToolsSize);
                        rectangleTool.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SetJButton SJB = new SetJButton(7);//calls the method of which affects the look of the button
                                
                            }
                        });
                        toolsGrid.gridy++;
                    toolsPanel.add(rectangleTool, toolsGrid);
                    
                circleTool = new JButton(circleIcon);
                    circleTool.setPreferredSize(ToolsSize);
                        circleTool.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                SetJButton SJB = new SetJButton(8);//calls the method of which affects the look of the button
                                
                            }
                        });
                        toolsGrid.gridy++;
                    toolsPanel.add(circleTool, toolsGrid);
                    
                    //this empty JLabel is necessary in order to have everything top aligned, it's designed to take up all the empty space
                JLabel fillToolsLabel = new JLabel();
                        toolsGrid.gridy++;
                        toolsGrid.weighty = 1;
                    toolsPanel.add(fillToolsLabel, toolsGrid);
                    
                    
                    
                        
        
        
        
        
            
            mainFrame.add(toolsPanel, BorderLayout.WEST);
        mainFrame.setVisible(true);
    }
    
    public static class SetJButton {
        
        public BufferedImage RoundCursor(int CircleSize) {
            
            BufferedImage circleImg = new BufferedImage(CircleSize + 4, CircleSize + 4, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = circleImg.createGraphics();
                g2d.drawOval(0, 0, CircleSize + 2, CircleSize + 2);
                g2d.dispose();
                return circleImg;
        }
        
        public SetJButton(int JButtonNumber){
            switch(JButtonNumber){//sets the currently selected button to a modified image
                case 0:
                    moveTool.setIcon(borderedMove);
                    ImageIcon moveImageIcon = new ImageIcon("images/CursorImages/moveCursor.png");
                    Image moveImage = moveImageIcon.getImage();
                        
                    Cursor moveCursor = toolkit.createCustomCursor(moveImage, cursorPoint, "moveCursor");
                    
                    mainFrame.setCursor(moveCursor);
                    break;
                case 1:
                    selectTool.setIcon(borderedCursor);
                    mainFrame.setCursor(Cursor.DEFAULT_CURSOR);
                    break;
                case 2:
                    textTool.setIcon(borderedText);
                    mainFrame.setCursor(toolkit.createCustomCursor(new ImageIcon("images/CursorImages/textCursor.png").getImage(), cursorPoint, "text"));
                    break;
                case 3:
                    eyedropTool.setIcon(borderedEyedrop);
                    mainFrame.setCursor(toolkit.createCustomCursor(new ImageIcon("images/CursorImages/eyedropCursor.png").getImage(), cursorPoint, "eyedrop"));
                    break;
                case 4:
                    brushTool.setIcon(borderedBrush);
                    mainFrame.setCursor(toolkit.createCustomCursor(RoundCursor(brushCircle), cursorPoint, "brushCursor"));
                    break;
                case 5:
                    erasorTool.setIcon(borderedErasor);
                    mainFrame.setCursor(toolkit.createCustomCursor(RoundCursor(erasorCircle), cursorPoint, "erasorCursor"));
                    break;
                case 6:
                    lineTool.setIcon(borderedLine);
                    mainFrame.setCursor(Cursor.CROSSHAIR_CURSOR);
                    break;
                case 7:
                    rectangleTool.setIcon(borderedRectangle);
                    mainFrame.setCursor(Cursor.CROSSHAIR_CURSOR);
                    break;
                case 8: 
                    circleTool.setIcon(borderedEclipse);
                    mainFrame.setCursor(Cursor.CROSSHAIR_CURSOR);
                    break;
                default:
                    break;
            }
            switch(prevButton){ //sets the previous button to it's normal state
                case 0:
                    moveTool.setIcon(moveIcon);
                    break;
                case 1:
                    selectTool.setIcon(cursorIcon);
                    break;
                case 2:
                    textTool.setIcon(textIcon);
                    break;
                case 3:
                    eyedropTool.setIcon(eyedropIcon);
                    break;
                case 4:
                    brushTool.setIcon(brushIcon);
                    break;
                case 5:
                    erasorTool.setIcon(erasorIcon);
                    break;
                case 6:
                    lineTool.setIcon(lineIcon);
                    break;
                case 7:
                    rectangleTool.setIcon(rectangleIcon);
                    break;
                case 8: 
                    circleTool.setIcon(circleIcon);
                    break;
                default:
                    break;
            }
            if (prevButton == JButtonNumber){//effectively resets the method if the program gets the same input twice in a row
                prevButton = -1;
                mainFrame.setCursor(Cursor.DEFAULT_CURSOR);
            }
            else {
                prevButton = JButtonNumber;//keeps a track of the previous input
            }
            
        }
        
       
}
    
            
        
        
    
        
        
    
}
