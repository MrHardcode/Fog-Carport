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

    public CustomerModel()
    {
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
    public String getCustomer_name()
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
