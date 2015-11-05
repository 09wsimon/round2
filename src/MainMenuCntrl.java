
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brianwest
 */
public class MainMenuCntrl implements ActionListener{

    MainMenuView mainView;
    
    public MainMenuCntrl(MainMenuView mainView) {
        this.mainView = mainView;
        
        mainView.button.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        mainView.button.setText("World");
    }
    
}
