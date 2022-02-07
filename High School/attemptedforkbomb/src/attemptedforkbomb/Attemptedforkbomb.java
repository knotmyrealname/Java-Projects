package attemptedforkbomb;

import java.util.Random;
import javax.swing.JFrame;


public class Attemptedforkbomb {

    private static Random r = new Random();

    public static void main(String[] args) {
        long threads = 8;
        for(long i = 0; i<4; i++){
            ForkThread ft = new ForkThread();
            ft.run();
        }
        
        
    }
    private static class ForkThread extends Thread{
        public void run(){
            while(true){
                JFrame forkFrame = new JFrame("forks");
                forkFrame.setSize(r.nextInt(200), r.nextInt(200));
                forkFrame.setLocation(r.nextInt(1600), r.nextInt(800));
                forkFrame.setVisible(true);
            }
        }
    }
    
}
