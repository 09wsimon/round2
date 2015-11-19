/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brianwest
 */
public class User {
    
    private String username;
    private String difficulty;
    
    public User(String username, String difficulty) {
        this.username = username;
        this.difficulty = difficulty;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getDifficulty() {
        return difficulty;
    }
}
