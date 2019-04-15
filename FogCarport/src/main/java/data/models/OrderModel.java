/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

/**
 *
 * @author Camilla
 */

// simpelt orderobject - skal udviddes i den avancerede algoritme til at tage 
// højde for kundens ønsker i forhold til materialvalg, taghældning, dimensioner
// på skur osv. 

public class OrderModel {
    private int height;
    private int length;
    private int width;
    private boolean shed;

    public OrderModel() {
    }

    public OrderModel(int height, int length, int width, boolean shed) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.shed = shed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isShed() {
        return shed;
    }

    public void setShed(boolean shed) {
        this.shed = shed;
    }
    
    
    
}
