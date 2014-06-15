
package grape;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


public class Screen extends JPanel implements ActionListener, KeyListener{
   
    
    Timer t = new Timer(5,this);
    int clock = 1000,clock2 = 400;
    Player p;
    Font font = new Font("SansSerif",Font.BOLD,24);
    ImageIcon background = new ImageIcon("back.png");
    Image img;
    static boolean lost = false;
    static ArrayList rocks;
    
    public Screen(){
       
        p = new Player();
        img = background.getImage();
        rocks = new ArrayList();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        t.start();       
         
      
        setSize(p.w,p.h);
        setVisible(true);
        
    }
    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
    
        g2.drawImage(img,0,0,null);
        clock -= 5;
        clock2 -= 5;
       Trigger();
       Trigger2();
       g2.drawImage(p.getImage(lost),p.x,p.y,null);
        
        ArrayList rocks2 = getRocks();
            for(int r = 0;r < rocks2.size();r++){
            Rock rock = (Rock)rocks2.get(r);
            g2.drawImage(rock.getImage(),rock.getX(),rock.getY(),null);
        }
        
        
            g2.setFont(font);
            g2.setColor(Color.pink);
            g2.drawString("SCORE: " + Rock.getScore(),160,40);
        
         detectCollision();    
        if(lost){
          p.stop(); 
          g2.setFont(font);
          g2.setColor(Color.RED);
          g2.drawString("GAME OVER",160,370);
          this.removeAll();
          
        }
    }
    
    public static boolean alive(){
        return lost;
    }
    public void Trigger(){
        if(clock < 0){
            createRock();
            clock = 700;
        }
   }
    public void Trigger2(){
        if(clock2 < 0){
            createRock();
            clock2 = 250;
        }   
    }
   
    public ArrayList getRocks(){
        return rocks;
    }   
    public void createRock(){
        Random rnd = new Random();
               
        int spawn = 1+rnd.nextInt(399);
        Rock x = new Rock(spawn);
        rocks.add(x);
    }
    
    public void actionPerformed(ActionEvent event){
         ArrayList rocks2 = getRocks();
         for(int r = 0;r < rocks2.size();r++){
            Rock rock = (Rock)rocks2.get(r);
            if(rock.getVisible(lost) == true)
            rock.fall();
            else
            rocks.remove(r);
            
        }
        p.movement(lost);
        repaint();
        
    }
    public void keyPressed(KeyEvent event){
        int code = event.getKeyCode();
        if(!lost){
        if(code == event.VK_D){
            p.right();
            
        }if(code == event.VK_A){
            p.left();
             
        }
      }else{}
    }
    public void keyTyped(KeyEvent e){        
    }
    public void keyReleased(KeyEvent e){
        
    }
    
    public void detectCollision(){
        Rectangle p1;
        if(!lost){
        p1 = p.bounds();
        ArrayList rocks2 = getRocks();
        for(int r = 0;r < rocks2.size();r++){
            Rock rock = (Rock)rocks2.get(r);
            Rectangle x = rock.bounds();
            if(p1.intersectsLine(x.getMinX()+60,x.getMaxY()-45,x.getMaxX(), x.getMaxY()-35)){
                lost = true;
                p.x = p.x - 40;
                rock.stop();
           
                
            }
            
        }        
      
        }
    }

   
   
    
}
