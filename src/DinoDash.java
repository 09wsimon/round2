
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public static boolean showBounds;
    
    MainMenuView mainView;
    MainMenuCntrl mainCtrl;
    GameBoardView gameView;
    GameBoardCntrl gameCtrl;
    
    String difficulty;
    
    public DinoDash() {
        super("Dino Dash!");
        
        showBounds = false;
        
        showBounds = false;
        
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mainView = new MainMenuView();
        mainCtrl = new MainMenuCntrl(mainView);
        //gameView = new GameBoardView();
        //gameCtrl = new GameBoardCntrl(gameView);
        
        mainView.b4.addActionListener((ActionEvent e) -> {
            remove(mainView);
            if(mainView.easyButton.isSelected()) {
                difficulty = mainView.easyButton.getText();
            }
            if(mainView.mediumButton.isSelected()) {
                difficulty = mainView.mediumButton.getText();
            }
            if(mainView.hardButton.isSelected()) {
                difficulty = mainView.hardButton.getText();
            }
            gameView = new GameBoardView(new User(mainView.nameField.getText(), difficulty));
            gameCtrl = new GameBoardCntrl(gameView);
            add(gameView);
            revalidate();
            repaint();
        });
        
        add(mainView);
    }
    
    public static void main(String[] args) {
        DinoDash frame = new DinoDash();
        frame.setVisible(true);
    }
    
}
