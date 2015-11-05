
import java.awt.Color;
import java.awt.Graphics;
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
    
    Dino dino;
    
    public GameBoardView() {
        setBackground(new Color(51, 204, 255));
        
        dino = new Dino();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw the map
        g.setColor(Color.GREEN);
        g.fillRect(0, 400, getWidth(), getHeight() - 400);
        
        // Draw the dino
        dino.draw(g);
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
