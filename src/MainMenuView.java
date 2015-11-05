
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brianwest
 */
public class MainMenuView extends JPanel {
    
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    TextField nameField;
    Label name;
    Label HS; 
    JTextArea textArea;
   
    private JTextField nameEnter = new JTextField("Enter name here");
     public void paintComponent(Graphics g)
         {
             super.paintComponent(g);
             Image myImage = Toolkit.getDefaultToolkit().getImage("src/images/BG.jpg");
             g.drawImage(myImage, 0, 0, this);
         }
    
    public MainMenuView() {
        setBackground(Color.WHITE);
        
        /*
        Adding the buttons Easy , Medium , Hard, Start
        */
       
        
        b1 = new JButton("EASY");
        b2 = new JButton("MEDIUM");
        b3 = new JButton("HARD");
        b4 = new JButton("Start Game");
        nameField = new TextField (15);
        Label name = new Label ("Enter Name");
        Label HS = new Label ("High Scores");
        //textArea = new JTextArea(5, 20);
        
        setLayout(null);
  
    
    
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(nameField);
        add(name);
        add(HS);
       // add(textArea);
        
        b1.setBounds(150,250,50,20);
        b2.setBounds(130,280,90,20);
        b3.setBounds(130,310,90,20);
        b4.setBounds(250,290,90,20);
        nameField.setBounds(150,150,90,20);
        name.setBounds(150,130,90,20);
        HS.setBounds(500,130,90,20);
        //textArea.setBounds(600,140,900,220);
        
      
    }

    private JLabel newJLabel(String imagesbgjpg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
