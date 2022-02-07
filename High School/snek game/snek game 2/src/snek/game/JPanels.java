package snek.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class JPanels {
    
//initializes the Elements I want to be accessible program-wide
    public JLabel score = new JLabel("   Score: " + 0),
              highscore = new JLabel("High Score: " + 0),
            appleLabel,imgLabel,headLabel,tailLabel;
    public JPanel infoPanel, gamePanel, applePanel;
    public static int highscore_int, snek_size = 3;
//initializes the Elements I want to be only accessible by this program
    private Font font = new Font("Comic Sans", Font.BOLD, 15 );
    private Graphics g = new Graphics();
    private Images i = new Images();
    private Snek s = new Snek();
    private int xcoords = g.gridSystem_x(g.x), ycoords = g.gridSystem_y(g.y);
    private static boolean in_game = true, just_scored = false;
    private Window w = new Window();
    private static Timer timer;
    
    
//Initializes the Info Panel so that it can be added to the JFrame
    public void initInfoPanel() throws NullPointerException{
        infoPanel = new JPanel();
            infoPanel.setLayout(new GridLayout(1,2));
    //sets the desired formatting for the scores
            score.setFont(font);
            score.setSize(100, 18);
            score.setForeground(Color.white);
                infoPanel.add(score);
                
            highscore.setFont(font);
            highscore.setSize(100, 18);
            highscore.setForeground(Color.white);
                infoPanel.add(highscore);
            
            infoPanel.setBounds(0, 0, 720, 22);
            infoPanel.setBackground(new Color(54, 199, 10));
    }
    
//updates the high score if a new high score is reached
    public void updateInfoPanel(int newScore){
        int actualNewScore = newScore - 3;
        score.setText("   Score: " + actualNewScore);
        if(highscore_int < actualNewScore){
            highscore_int = actualNewScore;
            highscore.setText("High Score: " + highscore_int);
        }
    }
//creates the Jpanel that contains the game elements
    public void initGamePanel() throws InterruptedException{
        gamePanel = new JPanel();
        appleLabel = new JLabel(i.apple);
            
        
    //adds the background image
        imgLabel = new JLabel(i.background);
            imgLabel.setBounds(0, 20, 720, 545);
            reset();
            
    //adds the elements to the gamePanel
        gamePanel.add(imgLabel);
        gamePanel.setLayout(null);
        
        
        
        gameLoop();
    }
    
//changes the position of the apple, whilst checking for the presence of the snake on that tile
    public void resetApple(){
        try {
        gamePanel.remove(appleLabel);
            }
        catch(NullPointerException e){
        }
        g.newCoordinates();
        while (g.checkOccupiedCoordinateKangaroo(g.x, g.y)){
            g.newCoordinates();
        }
            xcoords = g.gridSystem_x(g.x);
            ycoords = g.gridSystem_y(g.y);
            appleLabel.setBounds(xcoords, ycoords, 45, 45);
        gamePanel.add(appleLabel);
    }

//when this function is called, the snake should grow by 1 unit and updates the scores
    public void increaseSize(){
        snek_size++;
        updateInfoPanel(snek_size);
        resetApple();
    }

//resets the game
    public void reset() throws InterruptedException{
        snek_size = 3;
        updateInfoPanel(snek_size);
        
        Graphics.x_coords.clear();
            Graphics.x_coords.add(2);
            Graphics.x_coords.add(4);
            Graphics.x_coords.add(3);
        Graphics.y_coords.clear();
            Graphics.y_coords.add(6);
            Graphics.y_coords.add(6);
            Graphics.y_coords.add(6);
        
        drawSnek();
        resetApple();
        in_game = true;
        
    }
    
    @SuppressWarnings("Convert2Lambda")
    public void gameLoop(){
        timer = new Timer(300,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (in_game == true) {
                    int size = Graphics.x_coords.size();
                    
                    if (!just_scored){
                        Graphics.y_coords.set(0, Graphics.y_coords.get(size - 1));
                        Graphics.x_coords.set(0, Graphics.x_coords.get(size - 1));
                        
                        for (int b = 2; b < size; b++){
                            Graphics.x_coords.set(b, Graphics.x_coords.get(b - 1));
                            Graphics.y_coords.set(b, Graphics.y_coords.get(b - 1));
                            
                        }
                        System.out.println("snek moved");
                    }
                    else{
                        Graphics.x_coords.add(Graphics.x_coords.get(size - 1));
                        Graphics.y_coords.add(Graphics.y_coords.get(size - 1));
                        
                        for (int b = 2; b <= size; b++){
                            Graphics.x_coords.set(b, Graphics.x_coords.get(b - 1));
                            Graphics.y_coords.set(b, Graphics.y_coords.get(b - 1));
                        }
                        
                    }
                    
                    switch (Window.currentDirection){
                        case Snek.NORTH:
                            Graphics.y_coords.set(1, Graphics.y_coords.get(1) - 1);
                            break;
                        case Snek.EAST:
                            Graphics.x_coords.set(1, Graphics.x_coords.get(1) + 1);
                            break;
                        case Snek.SOUTH:
                            Graphics.y_coords.set(1, Graphics.y_coords.get(1) + 1);
                            break;
                        case Snek.WEST:
                            Graphics.x_coords.set(1, Graphics.x_coords.get(1) - 1);
                            break;
                        default:
                            break;
                    }
                    
                    
                }
                else {
                    
                }
                
                drawSnek();
                
            }
        });
        timer.start();
    }
    
    public void drawSnek(){
        
        for (int x = 0; x < snek_size; x++){
            switch (x) {
                case 0:
                    gamePanel.add(s.drawTail(Snek.EAST, Graphics.x_coords.get(x), Graphics.y_coords.get(x)));
                    break;
                case 1:
                    gamePanel.add(s.drawHead(Snek.EAST, Graphics.x_coords.get(x), Graphics.y_coords.get(x)));
                    break;
                default:
                    gamePanel.add(s.drawBody(Snek.EAST, Graphics.x_coords.get(x), Graphics.y_coords.get(x)));
                    break;
            }
            System.out.println(Graphics.x_coords.get(x) + ", " + Graphics.y_coords.get(x));
            
        }
        
    }
    
}
