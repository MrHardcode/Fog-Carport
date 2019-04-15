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
public class OrderModel
{

    private int height;
    private int length;
    private int width;
    private boolean shed;

    public OrderModel()
    {
    }

    public OrderModel(int height, int length, int width, boolean shed)
    {
        this.height = height;
        this.length = length;
        this.width = width;
        this.shed = shed;
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
     * Get the value of shed
     *
     * @return the value of shed
     */
    public boolean isShed()
    {
        return shed;
    }

    /**
     * Set the value of shed
     *
     * @param shed new value of shed
     */
    public void setShed(boolean shed)
    {
        this.shed = shed;
    }

}
