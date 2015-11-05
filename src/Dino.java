
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
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
public class Dino extends Rectangle {

    private final int GRAVITY = 10;
    
    private boolean isJumping;
    private boolean dirUp;
    private int speed;
    private ImageIcon dinoImage;

    public Dino() {
        setBounds(10, 400, 50, 100);

        isJumping = false;
        dirUp = false;
        speed = 10;
        
        dinoImage = new ImageIcon("src/images/dino_sm.png");
    }

    public void draw(Graphics g) {
        if (!isJumping) {
            g.drawImage(dinoImage.getImage(), x, y, null);
        }else{
            updateJump();
            g.drawImage(dinoImage.getImage(), x, y, null);
        }
    }

    private void updateJump() {
        if (isJumping) {
            if (dirUp) {
                y -= speed;
                if (y < 350) {
                    dirUp = false;
                }
            }else{
                y += speed;
                if (y >= 400) {
                    isJumping = false;
                }
            }
        }      
    }
    
    public void jump() {
        isJumping = true;
        dirUp = true;
    }

    public boolean isJumping() {
        return isJumping;
    }
}
