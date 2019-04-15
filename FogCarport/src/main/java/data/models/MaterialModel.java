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
public class MaterialModel {
    private int ID;
    private String name;
    private String description;
    private int height;
    private int length;
    private int width;

    // på nuværende tidspunkt kan jeg ikke se pointen med interfaces
    // i datamodellerne. 
    
    public MaterialModel() {
    }

    public MaterialModel(int ID, String name, String description, int height, int length, int width) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
       
}
