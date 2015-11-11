
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
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
public class GameBoardView extends JPanel{
    
    public Dino dino;
    private ArrayList<Obstacle> obstacles;
    
    public GameBoardView() {
        obstacles = new ArrayList<>();
        dino = new Dino();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the screen
        g.clearRect(0, 0, getWidth(), getHeight());
        
        // Draw the map
        g.setColor(new Color(51, 204, 255));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.GREEN);
        g.fillRect(0, 400 + dino.height, getWidth(), getHeight() - (400 + dino.height));
        
        // Draw the obstacles
        for(Obstacle obstacle : obstacles) {
            obstacle.draw(g);
        }
        
        // Draw the dino
        dino.draw(g);
        
        // Check collisions
        for(Obstacle obstacle : obstacles) {
            if(dino.checkHit(obstacle)) {
                g.setColor(Color.RED);
                g.drawString("HIT!", 20, 20);
            }
        }
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
    
    public ArrayList getObstacles() {
        return obstacles;
    }
}
