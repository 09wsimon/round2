
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brianwest
 */
public class MainMenuView extends JPanel{
    
    JButton button;
    
    public MainMenuView() {
        setBackground(Color.WHITE);
        
        button = new JButton("Hello");
        add(button);
    }
}
