/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package highscores;

/**
 *
 * @author nbhave
 */

import java.util.*;
import java.io.*;

public class HighScoreSystem {
    private ArrayList<Score> scores;
    
    private static final String HIGHSCORE_FILE = " ";
    
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    public HighScoreSystem()
    {
        scores = new ArrayList <Score>();
    }
    
    public ArrayList<Score> getScores()
    {
        loadScoreFile();
        sort();
        return scores;
    }
    
    private void sort()
    {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
        
    }
    
    public void addScore(String name, int score)
    {
        loadScoreFile();
        scores.add(new Score(name, score));
        updateScoreFile();
    }
    
    public void loadScoreFile()
    {
        try{
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        }
        catch (FileNotFoundException e)
        {
            System.out.println();
        }
    }

public void updateScoreFile()
{
        try{
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
           }
        catch (FileNotFoundException e)
        {
            System.out.println(hs.getHighScore);
        }
}
}
