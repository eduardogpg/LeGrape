
package grape;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class M extends JPanel{
private JButton jugar;
private JButton creditos;
Image img_fondo;
private JButton salir;
int y=490;

    //Constructor
    public M(){
        
    ImageIcon i = new ImageIcon("Fondo.png");
    img_fondo = i.getImage();
    
    setLayout(null);  //ayuda al acomo de los botones
     
  
    jugar = new JButton("JUGAR");
    add(jugar);
    jugar.setBackground(Color.GREEN);
    jugar.setBounds(10,y,100,30);
    creditos = new JButton("CREDITOS");
    add(creditos);
    creditos.setBackground(Color.GREEN);
    creditos.setBounds(130,490,100,30);
    salir = new JButton("Salir");
    salir.setBackground(Color.red);
    salir.setBounds(255,490,100,30);
    add(salir);
    
    //evento de precionar el boton jugar
    jugar.addActionListener( new ActionListener(){
    public void actionPerformed(ActionEvent evento){
  
        
        JFrame f = new JFrame();
        Screen s = new Screen();
        f.add(s);
        f.setSize(500,730);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       if(Screen.lost == false){
        f.setVisible(true);              
       }
       
       }
     });
     
    //evento de creditos
    creditos.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent evento){
   
    JOptionPane.showMessageDialog(null,"Desarrollador : Eduardo Ismael Garica Perez"
            + "113015");

      
    }
    });
    salir.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent evento){
        
    System.exit(0);            
    }
    });
    
    }
   
         
public void paint(Graphics g){  //Dibuja el fondo
    super.paint(g);
     g.drawImage(img_fondo, 0,0, this);
}
}


