package snek.game;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Images {
    //adds all the pictures and scales them
    public ImageIcon background = imageIcon("Images/PNGs/board.png", 720, 540);
    public ImageIcon apple = imageIcon("Images/PNGs/apple.png", 45, 45);
    public ImageIcon body_east = imageIcon("Images/PNGs/body_east.png", 45, 45);
    public ImageIcon body_eastnorth = imageIcon("Images/PNGs/body_eastnorth.png", 45, 45);
    public ImageIcon body_eastsouth = imageIcon("Images/PNGs/body_eastsouth.png", 45, 45);
    public ImageIcon body_north = imageIcon("Images/PNGs/body_north.png", 45, 45);
    public ImageIcon body_northeast = imageIcon("Images/PNGs/body_northeast.png", 45, 45);
    public ImageIcon body_southeast = imageIcon("Images/PNGs/body_southeast.png", 45, 45);
    public ImageIcon head_down = imageIcon("Images/PNGs/snek_headdown.png", 45, 45);
    public ImageIcon head_left = imageIcon("Images/PNGs/snek_headleft.png", 45, 45);
    public ImageIcon head_right = imageIcon("Images/PNGs/snek_headright.png", 45, 45);
    public ImageIcon head_up = imageIcon("Images/PNGs/snek_headup.png", 45, 45);
    public ImageIcon tail_down = imageIcon("Images/PNGs/snek_taildown.png", 45, 45);
    public ImageIcon tail_left = imageIcon("Images/PNGs/snek_tailleft.png", 45, 45);
    public ImageIcon tail_right = imageIcon("Images/PNGs/snek_tailright.png", 45, 45);
    public ImageIcon tail_up = imageIcon("Images/PNGs/snek_tailup.png", 45, 45);
    
    //takes the image file and allows for its scaling
    private ImageIcon imageIcon(String link, int width, int height){
        ImageIcon image = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(width, height, Image.SCALE_FAST));
        return image;
    }
}
