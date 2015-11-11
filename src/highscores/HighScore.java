/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author natasha
 */
package highscores;

import java.io.Serializable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class HighScore extends JPanel implements ActionListener{
    private JLabel highScore;
    
    public HighScore(){
        
    
    highScore = new JLabel("high score");
    highScore.setBounds(475, 300, 100,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
    
