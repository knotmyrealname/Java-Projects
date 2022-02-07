package snek.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Graph gr = new Graph();
    private Images i = new Images();
    private Snek s = new Snek();
    private int xcoords = gr.gridSystem_x(gr.x), ycoords = gr.gridSystem_y(gr.y);
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
        reset();
        gamePanel = new JPanel() {
            public void paint(Graphics g){
                super.paint(g);
                appleLabel = new JLabel(i.apple);
                //adds the background image
                    imgLabel = new JLabel(i.background);
                        imgLabel.setBounds(0, 20, 720, 545);
                //adds the elements to the gamePanel
                    gamePanel.add(imgLabel);
                    gamePanel.setLayout(null);
                    
                timer = new Timer(300, new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        for (int x = 0; x < JPanels.snek_size; x++){
                            switch (x) {
                                case 0:
                                    g.drawImage(i.tail_left.getImage(), Graph.x_coords.get(x), Graph.y_coords.get(x), gamePanel);
                                    break;
                                case 1:
                                    g.drawImage(i.head_left.getImage(), Graph.x_coords.get(x), Graph.y_coords.get(x), gamePanel);
                                    break;
                                default:
                                    g.drawImage(i.body_east.getImage(), Graph.x_coords.get(x), Graph.y_coords.get(x), gamePanel);
                                    break;
                            }
                    System.out.println(Graph.x_coords.get(x) + ", " + Graph.y_coords.get(x));

                        } 
                        gameLoop();
                    }
                    
                });
                timer.start();
                
            }
        };
        
    }
    
//changes the position of the apple, whilst checking for the presence of the snake on that tile
    public void resetApple(){
        try {
        gamePanel.remove(appleLabel);
            }
        catch(NullPointerException e){
        }
        gr.newCoordinates();
        while (gr.checkOccupiedCoordinateKangaroo(gr.x, gr.y)){
            gr.newCoordinates();
        }
            xcoords = gr.gridSystem_x(gr.x);
            ycoords = gr.gridSystem_y(gr.y);
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
        
        Graph.x_coords.clear();
            Graph.x_coords.add(2);
            Graph.x_coords.add(4);
            Graph.x_coords.add(3);
        Graph.y_coords.clear();
            Graph.y_coords.add(6);
            Graph.y_coords.add(6);
            Graph.y_coords.add(6);
        
        
        resetApple();
        in_game = true;
        
    }
    
    @SuppressWarnings("Convert2Lambda")
    public void gameLoop(){
        
        if (in_game == true) {
            int size = Graph.x_coords.size();

            if (!just_scored){
                Graph.y_coords.set(0, Graph.y_coords.get(size - 1));
                Graph.x_coords.set(0, Graph.x_coords.get(size - 1));

                for (int b = 2; b < size; b++){
                    Graph.x_coords.set(b, Graph.x_coords.get(b - 1));
                    Graph.y_coords.set(b, Graph.y_coords.get(b - 1));

                }
                System.out.println("snek moved");
            }
            else{
                Graph.x_coords.add(Graph.x_coords.get(size - 1));
                Graph.y_coords.add(Graph.y_coords.get(size - 1));

                for (int b = 2; b <= size; b++){
                    Graph.x_coords.set(b, Graph.x_coords.get(b - 1));
                    Graph.y_coords.set(b, Graph.y_coords.get(b - 1));
                }   
            }

            switch (Window.currentDirection){
                case Snek.NORTH:
                    Graph.y_coords.set(1, Graph.y_coords.get(1) - 1);
                    break;
                case Snek.EAST:
                    Graph.x_coords.set(1, Graph.x_coords.get(1) + 1);
                    break;
                case Snek.SOUTH:
                    Graph.y_coords.set(1, Graph.y_coords.get(1) + 1);
                    break;
                case Snek.WEST:
                    Graph.x_coords.set(1, Graph.x_coords.get(1) - 1);
                    break;
                default:
                    break;
            }
        }
        else {   
        }
    }
    
    
    
}
