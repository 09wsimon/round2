
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
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
    private final int dinoWidth = 75;
    private final int dinoHeight = 80;

    private boolean isJumping;
    private boolean dirUp;
    private int speed;
    private ImageIcon dinoImage;

    // Border variables
    Polygon border;
    int[] xpoints;
    int[] ypoints;
    int npoints;

    public Dino() {
        setBounds(10, 400, dinoWidth, dinoHeight);

        border = createBorder();

        isJumping = false;
        dirUp = false;
        speed = 10;

        dinoImage = new ImageIcon("src/images/dino_sm.png");
    }

    public void draw(Graphics g) {
        border = createBorder();
        
        if (!isJumping) {
            g.drawImage(dinoImage.getImage(), x, y, null);
        } else {
            updateJump();
            g.drawImage(dinoImage.getImage(), x, y, null);
        }

        if (DinoDash.showBounds) {
            g.setColor(Color.RED);
            //g.drawRect(x, y, width, height);
            g.drawPolygon(border);
        }

    }

    private void updateJump() {
        if (isJumping) {
            if (dirUp) {
                y -= speed;
                if (y < 250) {
                    dirUp = false;
                }
            } else {
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

    public boolean checkHit(Rectangle r) {
        return border.intersects(r);
    }

    private Polygon createBorder() {
        xpoints = new int[]{x, x + width, x + width, x + (width / 2), x + (width / 2) / 2, x};
        ypoints = new int[]{y, y, y + (height / 2), y + height, y + height, y + (height / 2) + (height / 4)};
        npoints = xpoints.length;
        return new Polygon(xpoints, ypoints, npoints);
    }
    
}
