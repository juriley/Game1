package tetrisclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
/**
 *
 * @author justinriley
 */
public class Board extends Canvas implements Runnable {

    public static final int WIDTH = 500, HEIGHT = 675;
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("tetris clone");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        Board tm= new Board();
        frame.add(tm);
        frame.setVisible(true);
        tm.start();
        
    }
   
    public void start(){
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }
  
    public void run(){
        boolean running = true;
        while(running){
            update();
            BufferStrategy bstrat = getBufferStrategy();
            if(bstrat == null){
                createBufferStrategy(3);
                continue; 
            }
            Graphics2D g = (Graphics2D) bstrat.getDrawGraphics();
            render(g);
            bstrat.show();
        }
    }

    public void update(){
        
    }
    
    public void render(Graphics2D g){
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
    }
   

}
