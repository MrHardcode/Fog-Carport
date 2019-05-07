/*
 *  
 */
package data.models;

/**
 *
 * @author 
 */
public class EmployeeModel
{
    // Fields
    private int id;
    private String name;
    private String role;
    private int id_role;
    
    public EmployeeModel()
    {
    }

    /**
     * Get the value of id_role
     *
     * @return the value of id_role
     */
    public int getId_role()
    {
        return id_role;
    }

    /**
     * Set the value of id_role
     *
     * @param id_role new value of id_role
     */
    public void setId_role(int id_role)
    {
        this.id_role = id_role;
    }

    /**
     * Get the value of role
     *
     * @return the value of role
     */
    public String getRole()
    {
        return role;
    }

    /**
     * Set the value of role
     *
     * @param role new value of role
     */
    public void setRole(String role)
    {
        this.role = role;
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
