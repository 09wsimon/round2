
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
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
public class GameBoardView extends JPanel {

    public Dino dino;
    public User user;
    private ArrayList<Obstacle> obstacles;
    private Image background;
    private Image topBar;
    private ImageIcon gameOver;

    public boolean endGame;

    public JButton showBoundsButton;
    public JButton endGameButton;
    public int distance;
    public int x = 0;
    public int y = 100;
    public final int backgroundSize = 139;

    public GameBoardView(User user) {
        this.user = user;

        setLayout(null);

        obstacles = new ArrayList<>();
        dino = new Dino();
        distance = 0;
        endGame = false;

        background = Toolkit.getDefaultToolkit().getImage("src/images/Scrollback.png");
        topBar = Toolkit.getDefaultToolkit().getImage("src/images/topband.png");
        gameOver = new ImageIcon("src/images/game_over.png");

        showBoundsButton = new JButton("Show Bounds");
        showBoundsButton.setFocusable(false);
        endGameButton = new JButton();
        //add(showBoundsButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the screen
        g.clearRect(0, 0, getWidth(), getHeight());

        // Draw the map
        g.drawImage(topBar, 0, 0, null);
        for (int i = 0; i < 10; i++) {
            g.drawImage(background, x + (i * backgroundSize), y, null);
        }
        g.setColor(Color.GREEN);
        g.fillRect(0, 400 + dino.height, getWidth(), getHeight() - (400 + dino.height));

        // Draw GameOver
        if (endGame) {
            g.drawImage(gameOver.getImage(), (getWidth() / 2) - 100, (getHeight() / 2) - 100, null);
        }

        // Draw the username
        g.setColor(Color.RED);
        g.drawString(user.getUsername(), getWidth() - 50, 20);

        // Draw the distance
        if (!endGame) {
            g.setColor(Color.RED);
            g.drawString(Integer.toString(distance), getWidth() - 50, 40);
            
        }

        // Draw the obstacles
        for (Obstacle obstacle : obstacles) {
            obstacle.draw(g);
        }

        // Draw the dino
        dino.draw(g);

        // Check collisions
        for (Obstacle obstacle : obstacles) {
            if (dino.checkHit(obstacle)) {
                //g.setColor(Color.RED);
                //g.drawString("HIT!", 20, 20);
                //distance = 0;
                endGame = true;
            }
        }
    }

    // For some reason we need this to gain window focus
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    // Getters and setters
    public ArrayList getObstacles() {
        return obstacles;
    }
}
