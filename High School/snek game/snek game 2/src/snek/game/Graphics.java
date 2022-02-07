package snek.game;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.JLabel;

public class Graphics {
    //sets all the variables
    private static Images images = new Images();
    private static Random r = new Random();
    public int x, y;
    public static ArrayList<Integer> x_coords = new ArrayList<>();
    public static ArrayList<Integer> y_coords = new ArrayList<>();
    private static boolean cOCK;
    
    //generates a new set of coordinates for the apple
    public void newCoordinates(){
        y = r.nextInt(11) + 1;
        x = r.nextInt(15) + 1;
        System.out.println(x + "," + y);
    }
    
    //scales the coordinates for the x axis
    public int gridSystem_x(int coordinate){
        int x_coord = (coordinate * 45 - 45);
        return x_coord;
    }
    
    //scales the coordinates for the y axis
    public int gridSystem_y(int coordinate){
        int y_coord = (coordinate * 45 - 22);
        return y_coord;
    }
    
    //checks for the presence of the snake in the area of which the apple or the snake head will be, returns true if there is
    public boolean checkOccupiedCoordinateKangaroo(int x, int y){
        cOCK = false;
        for (int i = 0; i < x_coords.size(); i++){
            if(x_coords.get(i) == x && y_coords.get(i) == y){
                Graphics g = new Graphics();
                    g.cOCK_setTrue();
            }
        }
        System.out.println(cOCK);
        return cOCK;
    }
    
    /*adds a method to set the cOC value, of which is static, true, as I couldn't set it to true
    without it resetting back to false*/
    public void cOCK_setTrue(){
        cOCK = true;
    }
}
