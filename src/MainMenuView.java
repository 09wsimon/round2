
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
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

    JButton b4;
    TextField nameField;
    Label name;
    Label HS;
    JTextArea textArea;

    // Radio buttons
    ButtonGroup difficultyButtons;
    JRadioButton easyButton;
    JRadioButton mediumButton;
    JRadioButton hardButton;
    
    private JTextField nameEnter = new JTextField("Enter name here");

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image myImage = Toolkit.getDefaultToolkit().getImage("src/images/BG.jpg");
        g.drawImage(myImage, 0, 0, this);
    }

    public MainMenuView() {
        setBackground(Color.WHITE);

        /*
         Adding the buttons Easy , Medium , Hard, Start, Enter Name and High Scores
         */
        
        difficultyButtons = new ButtonGroup();
        easyButton = new JRadioButton("Easy");
        mediumButton = new JRadioButton("Medium");
        hardButton = new JRadioButton("Hard");
        easyButton.setSelected(true);
        difficultyButtons.add(easyButton);
        difficultyButtons.add(mediumButton);
        difficultyButtons.add(hardButton);
        
        
        
        b4 = new JButton("Start Game");
        nameField = new TextField(15);
        Label name = new Label("Enter Name");
        Label HS = new Label("High Scores");
        //textArea = new JTextArea(5, 20);

        setLayout(null);

        add(b4);
        add(nameField);
        add(name);
        add(HS);
       // add(textArea);

        add(easyButton);
        add(mediumButton);
        add(hardButton);
        
        easyButton.setForeground(Color.WHITE);
        mediumButton.setForeground(Color.WHITE);
        hardButton.setForeground(Color.WHITE);
        
        easyButton.setBounds(130, 250, 90, 20);
        mediumButton.setBounds(130, 280, 90, 20);
        hardButton.setBounds(130, 310, 90, 20);
        b4.setBounds(250, 290, 90, 20);
        nameField.setBounds(150, 150, 90, 20);
        name.setBounds(150, 130, 90, 20);
        HS.setBounds(500, 130, 90, 20);
        //textArea.setBounds(600,140,900,220);

    }

    private JLabel newJLabel(String imagesbgjpg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
