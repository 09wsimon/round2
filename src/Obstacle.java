
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brianwest
 */
public class Obstacle extends Rectangle{
    
    private final int obstacleSize = 30;
    private final int speed = 5;
    
    public Obstacle() {
        setBounds(800, 480 - obstacleSize, obstacleSize, obstacleSize);
    }
    
    public void draw(Graphics g) {
        update();
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }
    
    public void update() {
        x -= speed;
    }
}
