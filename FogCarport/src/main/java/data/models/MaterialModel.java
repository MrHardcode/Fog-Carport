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
    private int price;    
    private String unit; //Not in constructor. Enhed. "Pakke, stk, sæt etc"

    // på nuværende tidspunkt kan jeg ikke se pointen med interfaces
    // i datamodellerne. 
    public MaterialModel()
    {
    }

    /**
     * 
     * Constructor for a material to be used in construction of the carport.
     * 
     * @param ID Item ID
     * @param name Item name
     * @param description Item description
     * @param height Item height
     * @param length Item length
     * @param width Item width
     */
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
     * Get the value of price
     *
     * @return the value of price
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(int price)
    {
        this.price = price;
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
     * Get the value of unit
     *
     * @return the value of unit
     */
    public String getUnit()
    {
        return unit;
    }

    /**
     * Set the value of unit
     *
     * @param unit new value of unit
     */
    public void setUnit(String unit)
    {
        this.unit = unit;
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
