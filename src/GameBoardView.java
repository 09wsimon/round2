
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
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
    private ArrayList<Obstacle> obstacles;

    public JButton showBoundsButton;
    public int distance;
    int x = 0;
    int y = 100;

    public GameBoardView() {
        obstacles = new ArrayList<>();
        dino = new Dino();
        distance = 0;

        showBoundsButton = new JButton("Show Bounds");
        showBoundsButton.setFocusable(false);
        add(showBoundsButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the screen
        g.clearRect(0, 0, getWidth(), getHeight());

        // Draw the map
        Image myImage = Toolkit.getDefaultToolkit().getImage("src/images/Scrollback.png");

        for (int i = 0; i < 10; i++) {
            g.drawImage(myImage, x + (i * 100), y, null);
        }
        
        /*
        g.drawImage(myImage, x, y, this);
        g.drawImage(myImage, x + 100, y, this);
        g.drawImage(myImage, x + 200, y, this);
        g.drawImage(myImage, x + 300, y, this);
        g.drawImage(myImage, x + 400, y, this);
        g.drawImage(myImage, x + 500, y, this);
        g.drawImage(myImage, x + 600, y, this);
        g.drawImage(myImage, x + 700, y, this);
        */

        g.setColor(Color.GREEN);
        g.fillRect(0, 400 + dino.height, getWidth(), getHeight() - (400 + dino.height));

        // Draw the distance
        g.setColor(Color.RED);
        g.drawString(Integer.toString(distance), getWidth() - 30, 20);

        // Draw the obstacles
        for (Obstacle obstacle : obstacles) {
            obstacle.draw(g);
        }

        // Draw the dino
        dino.draw(g);

        // Check collisions
        for (Obstacle obstacle : obstacles) {
            if (dino.checkHit(obstacle)) {
                g.setColor(Color.RED);
                g.drawString("HIT!", 20, 20);
                distance = 0;
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
