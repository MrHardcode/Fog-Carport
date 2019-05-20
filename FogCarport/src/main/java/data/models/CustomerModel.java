/*
 *  
 */
package data.models;

/**
 *
 * @author
 */
public class CustomerModel
{

    // Fields
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

    /**
     * Get the value of registered
     *
     * @return the value of registered
     */
    public boolean isRegistered()
    {
        return registered;
    }

    /**
     * Set the value of registered
     *
     * @param registered new value of registered
     */
    public void setRegistered(boolean registered)
    {
        this.registered = registered;
    }

    
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Get the value of zip
     *
     * @return the value of zip
     */
    public int getZip()
    {
        return zip;
    }

    /**
     * Set the value of zip
     *
     * @param zip new value of zip
     */
    public void setZip(int zip)
    {
        this.zip = zip;
    }

    /**
     * Get the value of adress
     *
     * @return the value of adress
     */
    public String getAdress()
    {
        return adress;
    }

    /**
     * Set the value of adress
     *
     * @param adress new value of adress
     */
    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Get the value of phone
     *
     * @return the value of phone
     */
    public int getPhone()
    {
        return phone;
    }

    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
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

}
