/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author Laptop Shop
 */
public class Shelf {
    private int id; 
    private String genre; 
    private int width;

    public Shelf() {
    }
    
    

    public Shelf(int id, String genre, int width) {
        this.id = id;
        this.genre = genre;
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    
    
}
