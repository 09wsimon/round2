
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingUtilities;
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
    private final int RIGHT = 39;
    private final int LEFT = 37;

    private final GameBoardView gameView;
    private final Timer timer;

    private final int amountOfObstacles;
    private int speed;

    public GameBoardCntrl(GameBoardView gameView) {
        this.gameView = gameView;
        timer = new Timer(50, this);

        if (gameView.user.getDifficulty().equalsIgnoreCase("easy")) {
            amountOfObstacles = 100;
        } else if (gameView.user.getDifficulty().equalsIgnoreCase("medium")) {
            amountOfObstacles = 50;
        } else if (gameView.user.getDifficulty().equalsIgnoreCase("hard")) {
            amountOfObstacles = 35;
        } else {
            amountOfObstacles = 0;
        }

        speed = 5;
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
        if(key == RIGHT) {
            gameView.dino.x += 10;
        }
        if(key == LEFT) {
            gameView.dino.x -= 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (generateRandom() == 0) {
            gameView.getObstacles().add(new Obstacle(speed));
        }

        if (o == gameView.showBoundsButton) {
            if (DinoDash.showBounds) {
                DinoDash.showBounds = false;
            } else {
                DinoDash.showBounds = true;
            }
        }

        if (o == timer) {
            // Check endgame
            if (gameView.endGame) {
                gameView.endGameButton.setText("Score: " + gameView.distance + " | Play Again?");
                gameView.add(gameView.endGameButton);
                gameView.endGameButton.setBounds((gameView.getWidth() / 2) - 100, (gameView.getHeight() / 2) - 50, 200, 50);
                gameView.endGameButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        DinoDash frame = (DinoDash) SwingUtilities.getWindowAncestor(gameView);
                        frame.restart();
                        //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                        
                    }
                });
                gameView.revalidate();
                gameView.repaint();
                timer.stop();
            }

            // Distance updating
            gameView.distance += 1;
            if (gameView.distance % 100 == 0) {
                speed++;
            }

            // Making the background scrollable
            gameView.x -= 5;
            if (gameView.x <= -gameView.backgroundSize) {
                gameView.x = 0;
            }

            // Repainting
            gameView.repaint();
        }
    }
}
