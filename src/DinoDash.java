
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author brianwest
 */
public class DinoDash extends JFrame {

    public static boolean showBounds;

    //MainMenuView mainView;
    //MainMenuCntrl mainCtrl;
    GameBoardView gameView;
    GameBoardCntrl gameCtrl;
    HighscoreManager hm;

    String difficulty;

    public DinoDash() {
        super("Dino Dash!");

        showBounds = false;

        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MainMenuView mainView = new MainMenuView();
        MainMenuCntrl mainCtrl = new MainMenuCntrl(mainView);
        //gameView = new GameBoardView();
        //gameCtrl = new GameBoardCntrl(gameView);

        enterGame(mainView);

        add(mainView);
    }

    public void restart(String user, int score) {
        hm = new HighscoreManager();
        hm.addScore(user, score);
        MainMenuView mn = new MainMenuView();
        MainMenuCntrl mc = new MainMenuCntrl(mn);
        remove(gameView);
        add(mn);
        revalidate();
        repaint();
        enterGame(mn);
        
    }
        private void enterGame(MainMenuView mn){
            mn.b4.addActionListener((ActionEvent e) -> {
            if (!mn.nameField.getText().equalsIgnoreCase("")) {
                remove(mn);
                if (mn.easyButton.isSelected()) {
                    difficulty = mn.easyButton.getText();
                }
                if (mn.mediumButton.isSelected()) {
                    difficulty = mn.mediumButton.getText();
                }
                if (mn.hardButton.isSelected()) {
                    difficulty = mn.hardButton.getText();
                }
                gameView = new GameBoardView(new User(mn.nameField.getText(), difficulty));
                gameCtrl = new GameBoardCntrl(gameView);
                add(gameView);
                revalidate();
                repaint();
            }
        });
        }

    public static void main(String[] args) {
        DinoDash frame = new DinoDash();
        frame.setVisible(true);
    }

}
