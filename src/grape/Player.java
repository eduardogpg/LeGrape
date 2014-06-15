
package grape;
import java.awt.*;
import javax.swing.ImageIcon;


public class Player {

   
    int x, y, K = 8,w = 490, h = 740,d = 80,vel;
    ImageIcon g = new ImageIcon("grape3.png");
    ImageIcon r = new ImageIcon("grape.png");
    ImageIcon l = new ImageIcon("grape2.png");
    ImageIcon dead = new ImageIcon("dead.png");
    Image display;
   
    
    public Player(){
        display = g.getImage();
        x = 100;
        y = 600;
        
    }
    
    public Image getImage(boolean b){
        if(b){
          display = dead.getImage();
          y = 630;
          }
        else{}
        return display;
    }
    public int getX(){
        return x;
    }    
    public int getY(){
        return y;
    }
    public void movement(boolean b){
        if(!b){
        x += vel;
        if(x < 20){
            x = 21;
            display = g.getImage();
        }
        if(x > w - d){
            x = w-d-1;
            display = g.getImage();
        }
       }else{}
      }
    
    public void right(){
        vel = K;
        display = r.getImage();
        
    }
    public void left(){
        vel = -K;     
        display = l.getImage();
    }
    
    public void stop(){
        vel = 0;
    }
    
    public Rectangle bounds(){
        int imageWidth;
        int imageHeight;
        
        imageHeight = display.getHeight(null);
        imageWidth =  display.getWidth(null);
        
        return new Rectangle(x,y,imageHeight,imageWidth);
    }
    
}
