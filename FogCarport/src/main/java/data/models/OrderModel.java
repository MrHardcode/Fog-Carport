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

    /*
    Fields
     */
    private int height;
    private int length;
    private int width;
    private boolean shed;
    private int id;
    private int id_customer;
    private int id_employee;
    private String build_adress;
    private int build_zipcode;
    private int incline;
    private String status;

    public OrderModel()
    {
    }

    public OrderModel(int height, int length, int width, boolean shed)
    {
        this.length = length;
        this.width = width;
        this.shed = shed;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
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
     * Get the value of status
     *
     * @return the value of status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(String status)
    {
        this.status = status;
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

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Get the value of incline
     *
     * @return the value of incline
     */
    public int getIncline()
    {
        return incline;
    }

    /**
     * Set the value of incline
     *
     * @param incline new value of incline
     */
    public void setIncline(int incline)
    {
        this.incline = incline;
    }

    /**
     * Get the value of build_zipcode
     *
     * @return the value of build_zipcode
     */
    public int getBuild_zipcode()
    {
        return build_zipcode;
    }

    /**
     * Set the value of build_zipcode
     *
     * @param build_zipcode new value of build_zipcode
     */
    public void setBuild_zipcode(int build_zipcode)
    {
        this.build_zipcode = build_zipcode;
    }

    /**
     * Get the value of build_adress
     *
     * @return the value of build_adress
     */
    public String getBuild_adress()
    {
        return build_adress;
    }

    /**
     * Set the value of build_adress
     *
     * @param build_adress new value of build_adress
     */
    public void setBuild_adress(String build_adress)
    {
        this.build_adress = build_adress;
    }

    /**
     * Get the value of id_employee
     *
     * @return the value of id_employee
     */
    public int getId_employee()
    {
        return id_employee;
    }

    /**
     * Set the value of id_employee
     *
     * @param id_employee new value of id_employee
     */
    public void setId_employee(int id_employee)
    {
        this.id_employee = id_employee;
    }

    /**
     * Get the value of id_customer
     *
     * @return the value of id_customer
     */
    public int getId_customer()
    {
        return id_customer;
    }

    /**
     * Set the value of id_customer
     *
     * @param id_customer new value of id_customer
     */
    public void setId_customer(int id_customer)
    {
        this.id_customer = id_customer;
    }
    // </editor-fold>
}
