
package grape;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class Grape extends JFrame{

    public static void main(String[] args) {

         JFrame juego = new JFrame("Menu");
          M menu = new M();
     
        juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        juego.add(menu); 
        juego.setSize(400,560);
        juego.setBackground(Color.BLUE);
        juego.setVisible(true);
   
    }
}
 