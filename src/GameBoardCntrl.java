
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javafx.scene.input.KeyCode;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author brianwest
 */
public class GameBoardCntrl implements ActionListener, KeyListener {

    private final int SPACE = 32;

    private GameBoardView gameView;
    private Timer timer;

    public GameBoardCntrl(GameBoardView gameView) {
        this.gameView = gameView;
        timer = new Timer(50, this);

        timer.start();
        gameView.addKeyListener(this);
        gameView.requestFocus();
    }

    public int generateRandom() {
        double rn = Math.random();
        return (int)(rn * 50);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == SPACE) {
            if (!gameView.dino.isJumping()) {
                gameView.dino.jump();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (generateRandom() == 0) {
            gameView.getObstacles().add(new Obstacle());
        }
        
        gameView.repaint();
    }
}
