package snek.game;

import javax.swing.JLabel;

public class Snek {
    /* sets the names for integers so that they would be easier to understand, and also initializes the Images class 
    so that I only have to initialize it once */
    private Images i = new Images();
    public static final int NORTH = 0, SOUTH = 1, WEST = 2, EAST = 3,
            EAST_TO_NORTH = 4, SOUTH_TO_WEST = 4,
            EAST_TO_SOUTH = 5, NORTH_TO_WEST = 5,
            WEST_TO_SOUTH = 6, NORTH_TO_EAST = 6,
            WEST_TO_NORTH = 7, SOUTH_TO_EAST = 7;
    private Graphics gr = new Graphics();
    
    
    //creates the drawHead function, of which, when given a direction and coordinates, returns a specified JLabel
    public JLabel drawHead(int direction, int x, int y){
        JLabel headLabel = new JLabel();
        switch (direction) {
            case 0: 
                headLabel.setIcon(i.head_up);
                break;
            case 1:
                headLabel.setIcon(i.head_down);
                break;
            case 2: 
                headLabel.setIcon(i.head_left);
                break;
            case 3:
                headLabel.setIcon(i.head_right);
                break;
            default: 
                break;
        }
        headLabel.setBounds(gr.gridSystem_x(x), gr.gridSystem_y(y), 45, 45);
        return headLabel;
    }
    
    //creates the drawBody funciton, of which, when given a direction and coordinates, returns a specified JLabel
    public JLabel drawBody(int direction, int x, int y){
        JLabel bodyLabel = new JLabel();
        switch (direction){
            case 0: case 1:
                bodyLabel.setIcon(i.body_north);
                break;
            case 2: case 3:
                bodyLabel.setIcon(i.body_east);
                break;
            case 4:
                bodyLabel.setIcon(i.body_eastnorth);
                break;
            case 5:
                bodyLabel.setIcon(i.body_eastsouth);
                break;
            case 6:
                bodyLabel.setIcon(i.body_eastnorth);
                break;
            case 7:
                bodyLabel.setIcon(i.body_eastsouth);
                break;
            default:
                break;
        }
        bodyLabel.setBounds(gr.gridSystem_x(x), gr.gridSystem_y(y), 45, 45);
        return bodyLabel;
    }
    
    //creates the drawTail funciton, of which, when given a direction and coordinates, returns a specified JLabel
    public JLabel drawTail(int direction, int x, int y){
        JLabel tailLabel = new JLabel();
        switch (direction){
            case 0: 
                tailLabel.setIcon(i.tail_up);
                break;
            case 1: 
                tailLabel.setIcon(i.tail_down);
                break;
            case 2: 
                tailLabel.setIcon(i.tail_left);
                break;
            case 3: 
                tailLabel.setIcon(i.tail_right);
                break;
            default: 
                break;
        }
        tailLabel.setBounds(gr.gridSystem_x(x), gr.gridSystem_y(y), 45, 45);
        return tailLabel;
    }
    
    
    
}
