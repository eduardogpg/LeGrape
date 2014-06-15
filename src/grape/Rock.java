
package grape;
import javax.swing.ImageIcon;
import java.awt.*;

public class Rock {
    
    static int score;
    int x,y = 50;
    float vel = 6;
    boolean visible = true;
    ImageIcon i = new ImageIcon("rock.png");
    Image display;
    
    public Rock(int posX){
        x = posX;
        display = i.getImage();
        visible = true;
    }
    
    public void fall(){
        y += vel;
    }
    
    public Image getImage(){
        return display;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean getVisible(boolean b){
       
        if(y > 740){
            visible = false;
        if(!b)
            score ++;
        else{}
        }       
        return visible;
    }
    
    public static int getScore(){
        return score;
    }
    public void stop(){
        
    y = 635;
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
