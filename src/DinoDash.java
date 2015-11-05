
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brianwest
 */
public class DinoDash extends JFrame{

    MainMenuView mainView;
    MainMenuCntrl mainCtrl;
    
    public DinoDash() {
        super("Dino Dash!");
        
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mainView = new MainMenuView();
        mainCtrl = new MainMenuCntrl(mainView);
        
        add(mainView);
    }
    
    public static void main(String[] args) {
        DinoDash frame = new DinoDash();
        frame.setVisible(true);
    }
    
}
