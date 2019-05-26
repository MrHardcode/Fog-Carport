/*
 *  
 */
package data.models;

/**
 * Model of the customer data
 * @author
 */
public class CustomerModel
{

    private int id;
    private String name;
    private int phone;
    private String email;
    private String adress;
    private int zip;
    private String password;
    private boolean registered;
    
    public CustomerModel()
    {
    }

    //<editor-fold defaultstate="collapsed" desc="isRegistered">
    /**
     * Get the value of registered
     *
     * @return the value of registered
     */
    public boolean isRegistered()
    {
        return registered;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setRegistered">
    /**
     * Set the value of registered
     *
     * @param registered new value of registered
     */
    public void setRegistered(boolean registered)
    {
        this.registered = registered;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getPassword">
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword()
    {
        return password;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setPassword">
    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getZip">
    /**
     * Get the value of zip
     *
     * @return the value of zip
     */
    public int getZip()
    {
        return zip;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setZip">
    /**
     * Set the value of zip
     *
     * @param zip new value of zip
     */
    public void setZip(int zip)
    {
        this.zip = zip;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getAdress">
    /**
     * Get the value of adress
     *
     * @return the value of adress
     */
    public String getAdress()
    {
        return adress;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setAdress">
    /**
     * Set the value of adress
     *
     * @param adress new value of adress
     */
    public void setAdress(String adress)
    {
        this.adress = adress;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getEmail">
    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail()
    {
        return email;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setEmail">
    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getPhone">
    /**
     * Get the value of phone
     *
     * @return the value of phone
     */
    public int getPhone()
    {
        return phone;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setPhone">
    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(int phone)
    {
        this.phone = phone;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getName">
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setName">
    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getId">
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setId">
    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    //</editor-fold>

}
