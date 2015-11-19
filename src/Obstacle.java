
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

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
    private int speed;
    
    private final ImageIcon image;
    
    public Obstacle(int speed) {
        this.speed = speed;
        
        setBounds(800, 480 - obstacleSize, obstacleSize, obstacleSize);
        
        image = new ImageIcon("src/images/rock_sm.png");
    }
    
    public void draw(Graphics g) {
        update();
        g.drawImage(image.getImage(), x, y, null);
        
        if(DinoDash.showBounds) {
            g.setColor(Color.RED);
            g.drawRect(x, y, width, height);
        }
    }
    
    public void update() {
        x -= speed;
    }

}
