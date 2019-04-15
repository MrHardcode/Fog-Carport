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
public class MaterialModel
{

    private int ID;
    private String name;
    private String description;
    private String helptext; //Not in constructor. Maybe add it to it.
    private int length;
    private int width;
    private int height;
    private int quantity; //Not in constructor. Maybe add it to it.

    // på nuværende tidspunkt kan jeg ikke se pointen med interfaces
    // i datamodellerne. 
    public MaterialModel()
    {
    }

    public MaterialModel(int ID, String name, String description, int height, int length, int width)
    {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Get the value of helptext
     *
     * @return the value of helptext
     */
    public String getHelptext()
    {
        return helptext;
    }

    /**
     * Set the value of helptext
     *
     * @param helptext new value of helptext
     */
    public void setHelptext(String helptext)
    {
        this.helptext = helptext;
    }

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Get the value of height
     *
     * @return the value of height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * Set the value of height
     *
     * @param height new value of height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Get the value of width
     *
     * @return the value of width
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Set the value of width
     *
     * @param width new value of width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * Get the value of length
     *
     * @return the value of length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Set the value of length
     *
     * @param length new value of length
     */
    public void setLength(int length)
    {
        this.length = length;
    }

}
