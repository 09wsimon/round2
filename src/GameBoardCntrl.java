
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
    private final int UP = 38;

    private GameBoardView gameView;
    private Timer timer;

    private int amountOfObstacles;
    
    public GameBoardCntrl(GameBoardView gameView) {
        this.gameView = gameView;
        timer = new Timer(50, this);

        if(gameView.user.getDifficulty().equalsIgnoreCase("easy")) {
            amountOfObstacles = 100;
        } else if(gameView.user.getDifficulty().equalsIgnoreCase("medium")) {
            amountOfObstacles = 50;
        } else if(gameView.user.getDifficulty().equalsIgnoreCase("hard")) {
            amountOfObstacles = 35;
        } else {
            amountOfObstacles = 0;
        }
        
        gameView.showBoundsButton.addActionListener(this);

        gameView.showBoundsButton.addActionListener(this);

        timer.start();
        gameView.addKeyListener(this);
        gameView.requestFocus();
    }

    public int generateRandom() {
        double rn = Math.random();
        return (int) (rn * amountOfObstacles);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == SPACE || key == UP) {
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
        Object o = e.getSource();

        if (generateRandom() == 0) {
            gameView.getObstacles().add(new Obstacle());
        }

        if (o == gameView.showBoundsButton) {
            if (DinoDash.showBounds) {
                DinoDash.showBounds = false;
            } else {
                DinoDash.showBounds = true;
            }
        }

        if (o == timer) {
            gameView.distance += 1;
            
            gameView.x -= 5;
            if (gameView.x <= -gameView.backgroundSize) {
                gameView.x = 0;
            }
            
            gameView.repaint();
        }
    }
}
